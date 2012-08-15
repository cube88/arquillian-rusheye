/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.mask;

import org.jboss.rusheye.manager.gui.view.mask.ManagerMaskType;
import org.jboss.rusheye.manager.gui.view.mask.Shape;
import org.jboss.rusheye.manager.project.tree.TreeNodeImpl;

/**
 *
 * @author Jakub D.
 */
public class MaskCase extends TreeNodeImpl {

    private Shape shape;
    private ManagerMaskType type;

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public ManagerMaskType getType() {
        return type;
    }

    public void setType(ManagerMaskType type) {
        this.type = type;
    }
    
    public String getInfo(){
        String result ="";
        result += this.getName() + "\n";
        result += type + "\n";
        
        return result;
    }
    
}
