package com.gmail.ahfonscs.invaders.game.entities.objects;

import com.gmail.ahfonscs.invaders.game.entities.Entity;
import com.gmail.ahfonscs.invaders.game.gfx.Animation;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import java.awt.Graphics2D;

public class Explosion
  extends Entity
{
  private Animation animation;
  
  public Explosion(float x, float y) {
    super(x, y, 64, 64, true);
    this.animation = new Animation(Assets.explosion, 8);
  }


  
  public void update() {
    this.animation.tick();
    
    if (this.animation.oneTime()) {
      setActive(false);
    }
  }


  
  public void render(Graphics2D graphics) {
    if (isActive())
      graphics.drawImage(this.animation.getCurrentSprite(), (int)getX(), (int)getY(), 64, 64, null); 
  }
}
