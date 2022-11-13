package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.Entity;
import com.gmail.ahfonscs.invaders.game.entities.objects.Explosion;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import java.awt.Graphics2D;

public class Meteorite
  extends Enemy {
  public Meteorite(float x, float y) {
    super(x, y, 64, 64);
    setHealth(100);
  }


  
  public void update() {
    setY(getY() + 2.0F);
    
    if (getY() > Handler.getWindow().getHeight()) {
      setActive(false);
    }
  }


  
  public void render(Graphics2D graphics) {
    if (isActive()) {
      graphics.drawImage(Assets.meteorite, (int)getX(), (int)getY(), 64, 64, null);
    }
  }

  
  public void die() {
    setActive(false);
    Handler.getSpace().getObjectManager().add((Entity)new Explosion(getX(), getY()));
  }
}
