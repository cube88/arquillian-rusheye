/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.frames;

import java.awt.Dimension;
import java.awt.Graphics;
import org.jboss.rusheye.manager.gui.charts.StatisticsPanel;
import org.jboss.rusheye.manager.project.Project;

/**
 * Frame where statistics chart is rendered.
 *
 * @author Jakub D.
 */
public class StatisticsFrame extends javax.swing.JFrame {

    private StatisticsPanel statisticsPanel;

    /**
     * Creates new form StatFrame
     */
    public StatisticsFrame() {
        statisticsPanel = new StatisticsPanel();
        setSize(new Dimension(600, 470));
        setResizable(false);
    }

    public void update(Project project) {
        statisticsPanel.update(project.getStatistics());
        this.repaint();
        this.validate();

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(statisticsPanel.getImage(), 0, 20, this);
    }
}
