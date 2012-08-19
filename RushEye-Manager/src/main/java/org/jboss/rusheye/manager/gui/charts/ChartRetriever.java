/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.charts;

import java.awt.Image;

/**
 * Interface for charts generation.
 *
 * @author Jakub D.
 */
public interface ChartRetriever {
    
    /**
     * Method that generates chart as Image.
     */
    public Image generateChart();

    public void setStatistics(RushEyeStatistics stats);
}
