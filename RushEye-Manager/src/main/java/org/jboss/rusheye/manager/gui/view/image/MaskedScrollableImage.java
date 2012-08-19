/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.image;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.gui.view.mask.MaskCase;

/**
 * Image displayed in manager view. It is able to draw specific masks.
 *
 * @author Jakub D.
 */
public class MaskedScrollableImage extends ScrollableImage {

    private double scale = 1;

    public MaskedScrollableImage(ImageIcon icon, int m, double scale) {
        super(icon, m);

        this.scale = scale;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        MaskCase mask = Main.mainProject.getMaskManager().getCurrentMask();
        if (mask != null) {
            for (int i = 0; i < mask.getChildCount(); ++i) {
                ((MaskCase) mask.getChildAt(i)).getShape().draw(g, scale);
            }
        }
    }

    public double getScale() {
        return scale;
    }
}
