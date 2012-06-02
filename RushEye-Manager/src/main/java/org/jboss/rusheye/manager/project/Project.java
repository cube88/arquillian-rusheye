/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.project;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jboss.rusheye.manager.exception.ManagerException;
import org.jboss.rusheye.suite.ResultConclusion;

/**
 *
 * @author hcube
 */
public class Project {

    private TestCase root;
    private TestCase currentCase;
    private String patternPath;
    private String samplesPath;

    public Project() {
        root = new TestCase();
    }

    public Project(String patternPath, String samplesPath) {
        this();
        this.patternPath = patternPath;
        this.samplesPath = samplesPath;
        try {
            this.parseDirs();
        } catch (ManagerException ex) {
            ex.printStackTrace();
        }
    }

    public String getPatternPath() {
        return patternPath;
    }

    public void setPatternPath(String patternPath) {
        this.patternPath = patternPath;
    }

    public String getSamplesPath() {
        return samplesPath;
    }

    public void setSamplesPath(String samplesPath) {
        this.samplesPath = samplesPath;
    }
    
    public TestCase getRoot() {
        return root;
    }

    public void parseDirs() throws ManagerException {
        root = new TestCase();
        root.setAllowsChildren(true);
        root.setName("Test Cases");
        
        ArrayList<String> patternList = parseDir(patternPath);
        ArrayList<String> samplesList = parseDir(samplesPath);

        if (patternList.size() != samplesList.size()) {
            throw new ManagerException("Not the same file number in pattern and samples");
        }

        String lastCase = "";
        TestCase tmp = null;

        for (int i = 0; i < patternList.size(); ++i) {
            if (patternList.get(i).equals(samplesList.get(i))) {
                String parts[] = patternList.get(i).split("[.]");
                if (parts.length == 3) {//[case].[test].[extension]
                    
                    if (parts[0].equals(lastCase) == false) {//if we get new case :
                        if (tmp != null) {
                            tmp.setParent(root);
                            tmp.setAllowsChildren(true);
                            root.addChild(tmp);//add last case
                        }

                        tmp = new TestCase();//create new case
                        tmp.setName(parts[0]);
                        lastCase = parts[0];
                    }
                    
                    TestCase tmpTest = new TestCase();
                    tmpTest.setName(parts[1]);
                    tmpTest.setFilename(patternList.get(i));
                    tmpTest.setConclusion(ResultConclusion.NOT_TESTED);
                    tmpTest.setParent(tmp);
                    tmp.addChild(tmpTest);
                }
            } else {
                throw new ManagerException("Pattern and sample name do not match");
            }
        }

        System.out.println(root.toString());

    }

    private ArrayList<String> parseDir(String path) {
        File folder = new File(path);
        File[] files = folder.listFiles();

        ArrayList<String> names = new ArrayList<String>();
        for (int i = 0; i < files.length; ++i) {
            names.add(files[i].getName());
        }
        Collections.sort(names);
        return names;
    }

    public TestCase getCurrentCase() {
        return currentCase;
    }

    public void setCurrentCase(TestCase currentCase) {
        this.currentCase = currentCase;
    }

    public TestCase findTest(String name){
        return root.findTest(name);
    }
    
}