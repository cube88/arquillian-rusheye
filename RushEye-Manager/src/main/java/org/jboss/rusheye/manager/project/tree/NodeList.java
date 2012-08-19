/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.project.tree;

import java.util.ArrayList;
import java.util.Enumeration;

/**
 * Collection forced by TreeNode interface. Iterator replaced Enumeration, but
 * here it is still necessary.
 *
 * @author Jakub D.
 */
public class NodeList extends ArrayList<TreeNodeImpl> implements Enumeration<TreeNodeImpl> {

    @Override
    public boolean hasMoreElements() {
        return this.iterator().hasNext();
    }

    @Override
    public TreeNodeImpl nextElement() {
        return this.iterator().next();
    }
}
