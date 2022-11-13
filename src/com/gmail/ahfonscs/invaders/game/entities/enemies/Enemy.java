package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.Creature;
import com.gmail.ahfonscs.invaders.game.entities.Entity;
import com.gmail.ahfonscs.invaders.game.entities.objects.Explosion;

public abstract class Enemy extends Creature {
  protected Enemy(float x, float y, int width, int height) {
    super(x, y, width, height);
  }


  
  public void die() {
    setActive(false);
    
    Handler.getSpace().getEffectManager().add((Entity)new Explosion(getX(), getY()));
    Handler.getSpace().getPlayer().score();
  }
}
