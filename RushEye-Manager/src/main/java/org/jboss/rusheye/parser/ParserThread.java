/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.parser;

import java.io.File;
import javax.swing.JOptionPane;
import org.jboss.rusheye.manager.Main;

/**
 * Thread where we run parser instance. Parsing is slow, so we don't want to
 * lock all gui while doing it.
 *
 * @author Jakub D.
 */
public class ParserThread implements Runnable {

    private ManagerParser parser;

    public ParserThread(ManagerParser p) {
        this.parser = p;
    }

    @Override
    public void run() {
        ManagerSaver saver = new ManagerSaver(Main.mainProject.getSuiteDescriptor());
        saver.save();
        
        parser.parseSuiteFile(new File("tmp.xml"),false);
        
        JOptionPane.showMessageDialog(Main.interfaceFrame, "Parsing done", "Parse", JOptionPane.INFORMATION_MESSAGE);

        Main.mainProject.loadResultAsString();
    }
    
    public ManagerParser getParser(){
        return parser;
    }
}
