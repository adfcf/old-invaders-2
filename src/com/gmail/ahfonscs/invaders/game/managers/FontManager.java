package com.gmail.ahfonscs.invaders.game.managers;

import java.awt.Color;
import java.awt.Font;

public class FontManager
{
  private static Color energy_color = new Color(0, 135, 0);
  
  private static final Font FORM_1 = new Font("Calibri", 0, 80);
  
  private static final Font FORM_2 = new Font("Calibri", 0, 25);
  
  public static Font getInfoFont() {
    return FORM_1;
  }
  
  public static Font getTextFont() {
    return FORM_2;
  }
  
  public static Color getEnergyColor() {
    return energy_color;
  }

  
  public static void updateEnergyColor(int health) {
    int red = -10 * health + 255;
    
    if (red > 255) {
      red = 255;
    } else if (red < 0) {
      red = 0;
    } 
    
    int green = 135 - red / 3;
    
    if (green < 0) {
      green = 0;
    } else if (green > 255) {
      green = 255;
    } 
    
    energy_color = new Color(red, green, 0);
  }
}
