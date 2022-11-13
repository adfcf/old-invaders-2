package com.gmail.ahfonscs.invaders.game.entities.projectiles;

import java.awt.Graphics2D;

import com.gmail.ahfonscs.invaders.game.gfx.Assets;

public class Laser
  extends Projectile
{
  public Laser(float x, float y) {
    super(x, y, 16, 16, 38);
  }
  
  public Laser(float x, float y, int speed) {
    super(x, y, 8, 8, speed);
  }

  
  public void render(Graphics2D graphics) {
    if (isActive()) {
      graphics.drawImage(Assets.laser, (int)getX(), (int)getY(), getWidth(), getHeight(), null);
    }
  }

  
  public int getCooldown() {
    return 100;
  }

  
  public int getMax() {
    return 8;
  }

  
  public Projectile create(int x, int y) {
    return new Laser(x, y);
  }

  
  public Projectile create(int x, int y, int speed) {
    return new Laser(x, y, speed);
  }
}
