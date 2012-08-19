/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.manager.gui.view.image.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.gui.view.image.ImageView;
import org.jboss.rusheye.manager.gui.view.image.MaskedScrollableImage;
import org.jboss.rusheye.manager.gui.view.mask.MaskCase;
import org.jboss.rusheye.manager.gui.view.mask.Rect;

/**
 * Mouse listener that allows to draw rectangles (masks).
 *
 * @author Jakub D.
 */
public class MaskZoomListener extends ZoomListener implements MouseMotionListener {

    private boolean drawing;
    private MaskedScrollableImage pic;
    private Point start;
    private Point stop;
    private MaskCase currentMask;

    public MaskZoomListener(ImageView imgView) {
        super(imgView);
        pic = (MaskedScrollableImage) imgView.getPicture();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Set mask params
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (inside) {
            drawing = true;

            start = new Point((int) (e.getX() / pic.getScale()), (int) (e.getY() / pic.getScale()));

            currentMask = new MaskCase();
            currentMask.setShape(new Rect(start, start));
            currentMask.setName(Main.mainProject.getMaskManager().getCurrentMask().getName() + ".Rect " + (Main.mainProject.getMaskManager().getCurrentMask().getChildCount() + 1));
            Main.mainProject.getMaskManager().getCurrentMask().addChild(currentMask);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        drawing = false;

        stop = new Point((int) (e.getX() / pic.getScale()), (int) (e.getY() / pic.getScale()));

        currentMask.setShape(calculateRect());

        Main.interfaceFrame.getProjectFrame().updateMaskTreeModel();
        System.out.println(stop);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (drawing) {

            stop = new Point((int) (e.getX() / pic.getScale()), (int) (e.getY() / pic.getScale()));

            currentMask.setShape(calculateRect());

            pic.repaint();
        }
    }

    public Rect calculateRect() {
        if (stop.x - start.x >= 0 && stop.y - start.y >= 0) {
            //4
            return new Rect(start, stop);
        } else if (stop.x - start.x >= 0 && stop.y - start.y < 0) {
            //1
            return new Rect(new Point(start.x, stop.y), new Point(stop.x, start.y));
        } else if (stop.x - start.x < 0 && stop.y - start.y < 0) {
            //2
            return new Rect(stop, start);
        } else if (stop.x - start.x < 0 && stop.y - start.y >= 0) {
            //3
            return new Rect(new Point(stop.x, start.y), new Point(start.x, stop.y));
        }
        return null;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
