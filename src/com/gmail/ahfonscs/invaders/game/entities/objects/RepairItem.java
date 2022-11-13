package com.gmail.ahfonscs.invaders.game.entities.objects;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import java.awt.Graphics2D;

public class RepairItem
  extends Item
{
  public RepairItem(float x, float y) {
    super(x, y);
  }

  
  public void update() {
    if (getBounds().intersects(Handler.getSpace().getPlayer().getBounds())) {
      Handler.getSpace().getPlayer().heal(10);
      setActive(false);
    } 
  }

  
  public void render(Graphics2D graphics) {
    if (isActive())
      graphics.drawImage(Assets.repair_item, (int)getX(), (int)getY(), 64, 64, null); 
  }
}
