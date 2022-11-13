package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.BulletContext;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Laser;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Projectile;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Trigger;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import java.awt.Graphics2D;

public class EmployeeInvader
  extends Enemy {
  private Trigger trigger;
  
  protected EmployeeInvader(float x, float y) {
    super(x, y, 32, 32);
    this.trigger = new Trigger(new BulletContext((Projectile)new Laser(0.0F, 0.0F, 9), getBounds()));
    setHealth(1);
  }


  
  public void update() {
    if (Handler.isVictory()) {
      setY(getY() - 4.0F);
      if (getY() < (0 - getHeight())) {
        setActive(false);
      }
      
      return;
    } 
    this.trigger.fire((int)getX() + getWidth() / 2 - Assets.laser.getWidth(), (int)getY() + getHeight());
    this.trigger.update();
    
    setY(getY() + 4.0F);
    if (getY() > (Handler.getWindow().getHeight() + getHeight())) {
      setActive(false);
    }
  }


  
  public void render(Graphics2D graphics) {
    if (isActive()) {
      graphics.drawImage(Assets.employee_invader, (int)getX(), (int)getY(), getWidth(), getHeight(), null);
      this.trigger.render(graphics);
    } 
  }
}
