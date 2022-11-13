package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import com.gmail.ahfonscs.invaders.game.managers.New;
import java.awt.Graphics2D;

public class BossInvader
  extends Enemy
{
  protected BossInvader() {
    super(New.number(Handler.getWindow().getWidth() - 128), -256.0F, 128, 128);
    setHealth(125);
  }


  
  public void update() {
    if (Handler.isVictory()) {
      setY(getY() - 4.0F);
      if (getY() < (0 - getHeight())) {
        setActive(false);
      }
      
      return;
    } 
    setY(getY() + 0.75F);
    
    if (getY() >= (Handler.getWindow().getHeight() + getHeight() + 10)) {
      Handler.getSpace().getPlayer().die();
    }
  }


  
  public void render(Graphics2D graphics) {

  }
}
