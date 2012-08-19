/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.mask;

import java.awt.Graphics;

/**
 * Shape interface for drawing masks in manager.
 *
 * @author Jakub D.
 */
public interface Shape {

    public void draw(Graphics g, double scale);
}
