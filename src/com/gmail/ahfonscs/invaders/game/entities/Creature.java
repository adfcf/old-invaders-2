package com.gmail.ahfonscs.invaders.game.entities;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.managers.FontManager;




public abstract class Creature
  extends Entity
{
  public static final int MAX_HEALTH = 75;
  public static final int DEFAULT_HEALTH = 25;
  public static final float DEFAULT_ACCELERATION = 0.42F;
  private int health;
  protected float speedX;
  protected float speedY;
  protected float acceleration;
  private int maxSpeedX;
  private int maxSpeedY;
  
  protected Creature(float x, float y, int width, int height) {
    super(x, y, width, height, true);
    
    this.health = 25;
    this.acceleration = 0.42F;
  }


  
  protected void move() {
    if (this.speedX >= this.maxSpeedX) {
      this.speedX = this.maxSpeedX;
    } else if (this.speedX <= -this.maxSpeedX) {
      this.speedX = -this.maxSpeedX;
    } 
    
    if (this.speedY >= this.maxSpeedY) {
      this.speedY = this.maxSpeedY;
    } else if (this.speedY <= -this.maxSpeedY) {
      this.speedY = -this.maxSpeedY;
    } 
    
    moveX();
    moveY();
  }


  
  private void moveX() {
    float px = getX() + this.speedX;
    
    if (px < 0.0F) {
      px = 0.0F; this.speedX = 1.0F;
    } else if (px + getWidth() >= Handler.getWindow().getWidth()) {
      px = (Handler.getWindow().getWidth() - getWidth()); this.speedX = -1.0F;
    } 
    
    setX(px);
  }


  
  private void moveY() {
    float py = getY() + this.speedY;
    
    if (py < 0.0F) {
      py = 0.0F; this.speedY = 1.0F;
    } else if (py + getHeight() >= Handler.getWindow().getHeight()) {
      py = (Handler.getWindow().getHeight() - getHeight()); this.speedY = -1.0F;
    } 
    
    setY(py);
  }

  
  public abstract void die();

  
  public void hurt(int damage) {
    this.health -= damage;
    
    if (this.health <= 0) {
      die();
    }
  }

  
  public void heal(int amount) {
    if (this.health + amount > 75)
      return;  
    this.health += amount;
    FontManager.updateEnergyColor(this.health);
  }
  
  protected int getHealth() {
    return this.health;
  }
  protected void setHealth(int health) {
    this.health = health;
  }
  
  protected int getMaxSpeedX() {
    return this.maxSpeedX;
  }
  protected void setMaxSpeedX(int maxSpeedX) {
    this.maxSpeedX = maxSpeedX;
  }
  
  protected int getMaxSpeedY() {
    return this.maxSpeedY;
  }
  protected void setMaxSpeedY(int maxSpeedY) {
    this.maxSpeedY = maxSpeedY;
  }
}
