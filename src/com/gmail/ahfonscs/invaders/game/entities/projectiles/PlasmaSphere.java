package com.gmail.ahfonscs.invaders.game.entities.projectiles;

import java.awt.Graphics2D;

import com.gmail.ahfonscs.invaders.game.gfx.Animation;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;

public class PlasmaSphere
  extends Projectile
{
  private Animation animation;
  
  public PlasmaSphere(float x, float y) {
    super(x, y, 28, 28, 4);
    this.animation = new Animation(Assets.plasma, 100);
  }
  
  public PlasmaSphere(float x, float y, int speed) {
    super(x, y, 28, 28, speed);
    this.animation = new Animation(Assets.plasma, 100);
  }

  
  public Projectile create(int x, int y) {
    return new PlasmaSphere(x, y);
  }

  
  public int getDamage() {
    return 40;
  }
  
  public int getCooldown() {
    return 400;
  }
  
  public int getMax() {
    return 10;
  }

  
  public void update() {
    super.update();
    this.animation.tick();
  }

  
  public void render(Graphics2D graphics) {
    if (isActive()) {
      graphics.drawImage(this.animation.getCurrentSprite(), (int)getX(), (int)getY(), getWidth(), getHeight(), null);
    }
  }

  
  public Projectile create(int x, int y, int speed) {
    return new PlasmaSphere(x, y, speed);
  }
}
