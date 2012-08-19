/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.image.listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Base for all manager mouse listeners.
 * @author Jakub D.
 */
public abstract class ManagerMouseListener implements MouseListener {

    protected boolean inside;
    
    @Override
    public void mouseClicked(MouseEvent e) {  
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inside = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inside = false;
    }
    
}
