package org.jboss.rusheye.manager;

import org.jboss.rusheye.manager.gui.frames.InterfaceFrame;
import org.jboss.rusheye.manager.project.Project;

/**
 * Main class. Loading and storing main frames and project.
 *
 * @author Jakub D.
 */
public class Main 
{
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                interfaceFrame=new InterfaceFrame();                

                mainProject = Project.emptyProject();
                
            }
        });
        
    }
    
    public static InterfaceFrame interfaceFrame;
    public static Project mainProject;
    
}
