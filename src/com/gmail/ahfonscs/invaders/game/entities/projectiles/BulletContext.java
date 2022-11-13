package com.gmail.ahfonscs.invaders.game.entities.projectiles;

import java.awt.Rectangle;


public class BulletContext
{
  private Projectile type;
  private Rectangle bounds;
  
  public BulletContext(Projectile type, Rectangle bounds) {
    this.type = type;
    this.bounds = bounds;
  }

  
  public Projectile createProjectile() {
    return this.type.create(getProjectileX(), getProjectileY());
  }
  
  public void setType(Projectile type) {
    this.type = type;
  }
  public Projectile getType() {
    return this.type;
  }
  
  private int getProjectileX() {
    return this.bounds.x + this.bounds.width / 2 - this.type.getWidth() / 2;
  }
  
  private int getProjectileY() {
    return this.bounds.y;
  }
}
