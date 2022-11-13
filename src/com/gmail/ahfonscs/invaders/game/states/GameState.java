package com.gmail.ahfonscs.invaders.game.states;

import java.awt.Color;
import java.awt.Graphics2D;

import com.gmail.ahfonscs.invaders.game.Space;
import com.gmail.ahfonscs.invaders.game.managers.FontManager;

public class GameState
  extends State
{
  public static final int SCORE_TO_WIN = 250;
  private Space space;
  
  public GameState() {
    this.space = new Space();
  }


  
  public void update() {
    this.space.update();
    
    if (this.space.getPlayer().getScore() >= 250) {
      State.setCurrentState(new VictoryState(this.space));
    }
  }


  
  public void render(Graphics2D graphics) {
    this.space.render(graphics);
    
    graphics.setColor(Color.WHITE);
    graphics.setFont(FontManager.getTextFont());
  }

  
  public Space getSpace() {
    return this.space;
  }
}
