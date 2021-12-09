package com.dream.tank;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * @Author : huzejun
 * @Date: 2021/12/8-19:58
 */
public class ImageUtil {


    public static BufferedImage rotateImage(final BufferedImage bufferedImage, final int degree) {

        final int w = bufferedImage.getWidth();
        final int h = bufferedImage.getHeight();
        final int type = bufferedImage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2D;
        (graphics2D = (img = new BufferedImage(w,h,type))
                .createGraphics()).setRenderingHint(
                        RenderingHints.KEY_INTERPOLATION,
                        RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.rotate(Math.toRadians(degree),w / 2,h / 2);
        graphics2D.drawImage(bufferedImage,0,0,null);
        graphics2D.dispose();
        return img;
    }
}
