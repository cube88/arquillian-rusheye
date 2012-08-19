/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.mask.converters;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.jboss.rusheye.manager.gui.view.mask.MaskCase;

/**
 * Converter that saves managers mask as png image with proper name.
 * @author Jakub D.
 */
public class MaskToImageConverter extends MaskConverter {

    public MaskToImageConverter(MaskCase m) {
        super(m);
    }

    @Override
    public void save(File file) {
        BufferedImage image =
                new BufferedImage(2000, 2000, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2 = image.createGraphics();
        for (int i = 0; i < mask.getChildCount(); ++i) {
            MaskCase m = (MaskCase) mask.getChildAt(i);
            m.getShape().draw(g2,1);
        }

        try {
            ImageIO.write(image, "png", file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
