package com.gmail.ahfonscs.invaders.game.entities.projectiles;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.Entity;
import com.gmail.ahfonscs.invaders.game.entities.enemies.Enemy;

public abstract class Projectile
  extends Entity {
  private final int constant_speed;
  
  protected Projectile(float x, float y, int width, int height, int const_speed) {
    super(x, y, width, height, true);
    this.constant_speed = const_speed;
  }


  
  public void update() {
    setY(getY() - this.constant_speed);
    
    if (getY() < -10.0F) {
      setActive(false);
    }
    
    for (Enemy e : Handler.getSpace().getFleet().getEnemies()) {
      if (e.getBounds().intersects(getBounds()))
      {
        if (Handler.getSpace().getPlayer().getTrigger().getProjectiles().contains(this)) {
          
          setActive(false);
          e.hurt(getDamage());

          
          break;
        } 
      }
    } 

    
    if (Handler.getSpace().getPlayer().getBounds().intersects(getBounds())) {
      
      if (Handler.getSpace().getPlayer().isBolado())
        return; 
      if (Handler.getSpace().getPlayer().getTrigger().getProjectiles().contains(this)) {
        return;
      }
      
      setActive(false);
      
      Handler.getSpace().getPlayer().hurt(getDamage());
    } 
  }

  
  public abstract Projectile create(int paramInt1, int paramInt2);

  
  public abstract Projectile create(int paramInt1, int paramInt2, int paramInt3);
  
  public int getConstant_speed() {
    return this.constant_speed;
  }
  
  public int getDamage() {
    return 1;
  }
  public int getCooldown() {
    return 100;
  }
  public int getMax() {
    return 5;
  }
}
