/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.project;

import org.jboss.rusheye.manager.gui.view.mask.ManagerMaskType;
import org.jboss.rusheye.manager.gui.view.mask.MaskCase;

/**
 * MaskManager that holds or masks displayed in mask management tree. Those
 * masks can be converted to RushEye masks (specific bitmaps).
 *
 * @author Jakub D.
 */
public class MaskManager {

    private MaskCase root;
    private MaskCase currentMask;

    public MaskManager() {
        root = new MaskCase();
        root.setName("Masks root");

        MaskCase newCase = new MaskCase();
        newCase.setName("mask-" + (root.getChildCount() + 1));
        newCase.setType(ManagerMaskType.SELECTIVE_ALPHA);

        root.addChild(newCase);

        currentMask = newCase;
    }

    public MaskCase getRoot() {
        return root;
    }

    public void setRoot(MaskCase root) {
        this.root = root;
    }

    public MaskCase getCurrentMask() {
        return currentMask;
    }

    public void setCurrentMask(MaskCase currentMask) {
        this.currentMask = currentMask;
    }
}
