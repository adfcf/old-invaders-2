package com.gmail.ahfonscs.invaders.game.states;

import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.Space;
import com.gmail.ahfonscs.invaders.game.entities.enemies.Enemy;
import com.gmail.ahfonscs.invaders.game.managers.FontManager;
import java.awt.Color;
import java.awt.Graphics2D;


public class VictoryState
  extends State
{
  private Space space;
  
  public VictoryState(Space space) {
    this.space = space;
    
    for (Enemy enemy : this.space.getFleet().getEnemies()) {
      enemy.die();
    }
    
    Handler.setVictory(true);
  }


  
  public void update() {
    this.space.update();
  }


  
  public void render(Graphics2D graphics) {
    this.space.render(graphics);
    
    graphics.setFont(FontManager.getInfoFont());
    graphics.setColor(Color.WHITE);
    graphics.drawString("Miss\u00E3o Conclu\u00EDda!", 200, Handler.getWindow().getHeight() / 2 + 40);
  }
}
