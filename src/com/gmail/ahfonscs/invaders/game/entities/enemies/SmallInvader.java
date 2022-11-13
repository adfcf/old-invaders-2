package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.Entity;
import com.gmail.ahfonscs.invaders.game.entities.objects.RepairItem;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import com.gmail.ahfonscs.invaders.game.managers.New;
import java.awt.Graphics2D;

public class SmallInvader
  extends Enemy {
  public SmallInvader(float x, float y) {
    super(x, y, 64, 64);
    setHealth(5);
  }


  
  public void update() {
    if (Handler.isVictory()) {
      setY(getY() - 4.0F);
      if (getY() < (0 - getHeight())) {
        setActive(false);
      }
      
      return;
    } 
    setY(getY() + 2.0F);
    
    if (getY() > (Handler.getWindow().getHeight() + getHeight())) {
      setActive(false);
    }
  }


  
  public void render(Graphics2D graphics) {
    if (isActive()) {
      graphics.drawImage(Assets.small_invader, (int)getX(), (int)getY(), getWidth(), getHeight(), null);
    }
  }

  
  public void die() {
    super.die();
    
    if (New.number(10) == New.number(25) && !Handler.isVictory())
      Handler.getSpace().getObjectManager().add((Entity)new RepairItem((int)getX(), (int)getY())); 
  }
}
