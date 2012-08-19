/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jboss.rusheye.core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Collection;
import org.jboss.rusheye.comparison.ImageComparator;
import org.jboss.rusheye.manager.Main;
import org.jboss.rusheye.manager.gui.view.image.ImagePool;
import org.jboss.rusheye.suite.Area;
import org.jboss.rusheye.suite.ComparisonResult;
import org.jboss.rusheye.suite.HorizontalAlign;
import org.jboss.rusheye.suite.Mask;
import org.jboss.rusheye.suite.MaskType;
import org.jboss.rusheye.suite.Perception;
import org.jboss.rusheye.suite.Rectangle;
import org.jboss.rusheye.suite.VerticalAlign;

/**
 * Manager version of ImageComparator class. Used in ad hoc comparison
 * @author Jakub D.
 */
public class ManagerImageComparator implements ImageComparator {

    private static final int BOUNDARY_SIZE = 5;
    private static final Color BOUNDARY_COLOR = new Color(0, 128, 255);
    private static final Color DIFF_COLOR_UNDER_TRESSHOLD = new Color(0, 0, 255);
    private static final Color DIFF_COLOR_ABOVE_TRESHOLD = new Color(255, 0, 255);
    private static final Color DIFF_COLOR_PERCEPTIBLE = new Color(255, 0, 0);
    private ImagePool maskPool = new ImagePool();

    private void updateBoundary(Point min, Point max, int x, int y) {
        min.x = Math.min(min.x, x);
        min.y = Math.min(min.y, y);
        max.x = Math.max(max.x, x);
        max.y = Math.max(max.y, y);
    }

    private void drawRectangleAroundDifferentPixels(Point min, Point max, int width, int height, BufferedImage diffImage) {
        int x1 = Math.max(0, min.x - BOUNDARY_SIZE);
        int y1 = Math.max(0, min.y - BOUNDARY_SIZE);
        int x2 = Math.min(width - 1, max.x + BOUNDARY_SIZE);
        int y2 = Math.min(height - 1, max.y + BOUNDARY_SIZE);
        Graphics g = diffImage.createGraphics();
        g.setColor(BOUNDARY_COLOR);
        g.drawRect(x1, y1, x2 - x1, y2 - y1);
        g.dispose();
    }

    private boolean isMaskedPixel(BufferedImage image, Collection<Mask> masks, int x, int y) {
        for (Mask mask : masks) {
            if (MaskType.SELECTIVE_ALPHA.equals(mask.getType())) {
                if (isPixelMasked(mask, image, x, y)) {

                    return true;
                }
            }
        }
        return false;
    }

    public boolean isPixelMasked(Mask mask, BufferedImage pattern, int x, int y) {
        BufferedImage maskImage = maskPool.get(mask.getId());

        int patternWidth = pattern.getWidth();
        int patternHeight = pattern.getHeight();
        int maskWidth = maskImage.getWidth();
        int maskHeight = maskImage.getHeight();

        int maskX = mask.getHorizontalAlign() == HorizontalAlign.LEFT ? x : x - (patternWidth - maskWidth);
        int maskY = mask.getVerticalAlign() == VerticalAlign.TOP ? y : y - (patternHeight - maskHeight);

        // we are outside the mask
        if (maskX < 0 || maskX >= maskWidth || maskY < 0 || maskY >= maskHeight) {
            return false;
        }

        return (maskImage.getRGB(maskX, maskY) & 0xFF000000) != 0;
    }

    private Color getMaskedPixelColor(Color color) {
        int blue = (int) Math.round(color.getBlue() * 0.8);
        int green = Math.min(0xff, (int) Math.round(color.getGreen() * 1.2));
        int red = (int) Math.round(color.getRed() * 0.8);
        return new Color(red, green, blue);
    }

    public ComparisonResult compare(BufferedImage patternImage, BufferedImage sampleImage, Perception perception,
            Collection<Mask> masks) {
        for (Mask mask : masks) {
            maskPool.put(mask.getId(), Main.mainProject.getMaskPath() + "/" + mask.getSource());
        }
        final ColorDistance colorDistance = new ColorDistanceLAB();

        Point min = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point max = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int width = Math.min(patternImage.getWidth(), sampleImage.getWidth());
        int height = Math.min(patternImage.getHeight(), sampleImage.getHeight());
        int totalPixels = 0;
        int maskedPixels = 0;
        int perceptibleDiffs = 0;
        int differentPixels = 0;
        int smallDifferences = 0;
        int equalPixels = 0;
        BufferedImage diffImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                totalPixels++;
                float distance = colorDistance.getDistance(patternImage.getRGB(i, j), sampleImage.getRGB(i, j));
                Color color = ColorModelRGBA.rgb2grayscale(patternImage.getRGB(i, j));
                if (isMaskedPixel(patternImage, masks, i, j)) {
                    maskedPixels++;
                    color = getMaskedPixelColor(color);
                } else if (distance > perception.getOnePixelTreshold()) {
                    perceptibleDiffs++;
                    updateBoundary(min, max, i, j);
                    color = DIFF_COLOR_PERCEPTIBLE;
                } else if (distance > perception.getGlobalDifferenceTreshold()) {
                    differentPixels++;
                    updateBoundary(min, max, i, j);
                    color = DIFF_COLOR_ABOVE_TRESHOLD;
                } else if (distance > 0) {
                    smallDifferences++;
                    updateBoundary(min, max, i, j);
                    color = DIFF_COLOR_UNDER_TRESSHOLD;
                } else {
                    equalPixels++;
                }
                diffImage.setRGB(i, j, color.getRGB());
            }
        }

        boolean equalImages = min.x == Integer.MAX_VALUE;
        if (!equalImages) {
            drawRectangleAroundDifferentPixels(min, max, width, height, diffImage);
        } else {
            min = new Point(-1, -1);
            max = new Point(-1, -1);
        }

        ComparisonResult result = new ComparisonResult();
        result.setEqualsImages(equalImages);
        result.setDiffImage(diffImage);
        result.setArea(new Area());
        result.getArea().setWidth(width);
        result.getArea().setHeight(height);
        result.setTotalPixels(totalPixels);
        result.setMaskedPixels(maskedPixels);
        result.setPerceptibleDiffs(perceptibleDiffs);
        result.setDifferentPixels(differentPixels);
        result.setSmallDifferences(smallDifferences);
        result.setEqualPixels(equalPixels);

        if (max.x > 0 && max.y > 0) {
            Rectangle rectangle = new Rectangle();
            rectangle.setMin(min);
            rectangle.setMax(max);
            result.getRectangles().add(rectangle);
        }

        return result;
    }
}
