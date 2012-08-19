/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.parser;

import org.jboss.rusheye.internal.Instantiator;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.project.TestCase;
import org.jboss.rusheye.result.ResultCollectorAdapter;
import org.jboss.rusheye.result.ResultEvaluator;
import org.jboss.rusheye.result.ResultStatistics;
import org.jboss.rusheye.result.ResultStorage;
import org.jboss.rusheye.result.writer.ResultWriter;
import org.jboss.rusheye.suite.Case;
import org.jboss.rusheye.suite.ComparisonResult;
import org.jboss.rusheye.suite.Pattern;
import org.jboss.rusheye.suite.Properties;
import org.jboss.rusheye.suite.ResultConclusion;
import org.jboss.rusheye.suite.Test;
import org.jboss.rusheye.suite.VisualSuite;

/**
 * Manager result collector that takes into account changes we made in project
 * manager tree.
 *
 * @author Jakub D.
 */
public class ManagerResultCollector extends ResultCollectorAdapter {

    Properties properties;
    ResultStorage storage;
    ResultEvaluator evaluator;
    ResultWriter writer;
    ResultStatistics statistics;

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void onConfigurationReady(VisualSuite visualSuite) {
        String storageClass = (String) properties.getProperty("result-storage");
        storage = new Instantiator<ResultStorage>().getInstance(storageClass);
        storage.setProperties(properties);

        String writerClass = (String) properties.getProperty("result-writer");
        writer = new Instantiator<ResultWriter>().getInstance(writerClass);
        writer.setProperties(properties);

        String statisticsClass = (String) properties.getProperty("result-statistics");
        statistics = new Instantiator<ResultStatistics>().getInstance(statisticsClass);
        statistics.setProperties(properties);

        evaluator = new ResultEvaluator();

    }

    @Override
    public void onPatternCompleted(Test test, Pattern pattern, ComparisonResult comparisonResult) {
        ResultConclusion conclusion = evaluator.evaluate(test.getPerception(), comparisonResult);

        if (conclusion == ResultConclusion.DIFFER || conclusion == ResultConclusion.PERCEPTUALLY_SAME) {
            String location = storage.store(test, pattern, comparisonResult.getDiffImage());
            pattern.setOutput(location);
        }

        pattern.setComparisonResult(comparisonResult);
        pattern.setConclusion(conclusion);

        System.out.println(conclusion);
        TestCase managerTest = Main.mainProject.findTest(Main.mainProject.getCurrentSuiteCase().getName(), test.getName(), pattern.getName());
        if (managerTest.getConclusion() != null && managerTest.getConclusion() != ResultConclusion.NOT_TESTED)
            pattern.setConclusion(managerTest.getConclusion());
        else {
            pattern.setConclusion(conclusion);
            managerTest.setConclusion(conclusion);
        }

        Main.mainProject.getParser().getStatistics().addValue(pattern.getConclusion(), 1);
        Main.mainProject.getParser().notifyObservers();

        Main.mainProject.setCurrentCase(managerTest);
        Main.interfaceFrame.getProjectFrame().updateIcons();

        if (comparisonResult.getDiffImage() != null) {
            comparisonResult.getDiffImage().flush();
        }

        statistics.onPatternCompleted(pattern);
    }

    @Override
    public void onTestCompleted(Test test) {
        statistics.onTestCompleted(test);
    }

    @Override
    public void onCaseCompleted(Case case1) {
        writer.write(case1);
        statistics.onCaseCompleted(case1);
    }

    @Override
    public void onSuiteCompleted(VisualSuite visualSuite) {
        writer.close();
        statistics.onSuiteCompleted();
        storage.end();
    }
}
