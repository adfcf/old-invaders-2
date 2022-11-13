package com.gmail.ahfonscs.invaders.game.gfx;

import java.awt.image.BufferedImage;





public class Animation
{
  private BufferedImage[] images;
  private boolean finishedOneTime;
  private long timer;
  private long lastTime;
  private int index;
  private int delay;
  
  public Animation(BufferedImage[] images, int delay) {
    this.images = images;
    this.delay = delay;
  }


  
  public void tick() {
    this.timer += System.currentTimeMillis() - this.lastTime;
    this.lastTime = System.currentTimeMillis();
    
    if (this.timer >= this.delay) {
      
      this.index++;
      this.timer = 0L;
      
      if (this.index >= this.images.length) {
        this.finishedOneTime = true;
        this.index = 0;
      } 
    } 
  }


  
  public boolean oneTime() {
    return this.finishedOneTime;
  }
  
  public void setDelay(int newDelay) {
    this.delay = newDelay;
  }
  
  public BufferedImage getCurrentSprite() {
    return this.images[this.index];
  }
}
