package com.gmail.ahfonscs.invaders.game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;





public abstract class Entity
{
  private Rectangle bounds;
  private float x;
  private float y;
  private int width;
  private int height;
  private boolean active;
  
  protected Entity(float x, float y, int width, int height, boolean active) {
    this.bounds = new Rectangle((int)x, (int)y, width, height);
    
    this.x = x;
    this.y = y;
    
    this.width = width;
    this.height = height;
    
    this.active = active;
  }

  
  public abstract void update();
  
  public abstract void render(Graphics2D paramGraphics2D);
  
  public Rectangle getBounds() {
    return this.bounds;
  }
  
  protected float getX() {
    return this.x;
  }
  protected void setX(float x) {
    this.bounds.x = (int)x;
    this.x = x;
  }
  
  protected float getY() {
    return this.y;
  }
  protected void setY(float y) {
    this.bounds.y = (int)y;
    this.y = y;
  }
  
  public int getWidth() {
    return this.width;
  }
  public int getHeight() {
    return this.height;
  }
  
  public boolean isActive() {
    return this.active;
  }
  protected void setActive(boolean active) {
    this.active = active;
  }
}
