package com.gmail.ahfonscs.invaders.game.gfx;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;



public final class ImageLoader
{
  public static BufferedImage loadImage(String path) {
    BufferedImage image = null;

    
    try {
      image = ImageIO.read(ImageLoader.class.getResource(path));
    }
    catch (Exception e1) {
      e1.printStackTrace();
      System.exit(0);
    } 
    
    return image;
  }
}
