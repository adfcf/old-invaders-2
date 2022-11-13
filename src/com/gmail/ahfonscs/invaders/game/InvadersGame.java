package com.gmail.ahfonscs.invaders.game;

import java.awt.Graphics2D;

import com.gmail.ahfonscs.invaders.core.Game;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import com.gmail.ahfonscs.invaders.game.states.GameOverState;
import com.gmail.ahfonscs.invaders.game.states.GameState;
import com.gmail.ahfonscs.invaders.game.states.State;


public final class InvadersGame
  extends Game
{
  private GameState gameState;
  private GameOverState gameOverState;
  
  public InvadersGame() {
    Handler.setGame(this);
    
    Assets.init();
  }



  
  protected void onLoad() {
    this.gameState = new GameState();
    this.gameOverState = new GameOverState(this.gameState.getSpace());
    
    State.setCurrentState((State)this.gameState);
  }



  
  protected void onUpdate() {
    if (State.getCurrentState() != null) {
      State.getCurrentState().update();
    }
  }



  
  protected void onRender(Graphics2D graphics) {
    if (State.getCurrentState() != null) {
      State.getCurrentState().render(graphics);
    }
  }


  
  protected void onUnload() {}


  
  public GameState getGameState() {
    return this.gameState;
  }
  public GameOverState getGameOverState() {
    return this.gameOverState;
  }
}
