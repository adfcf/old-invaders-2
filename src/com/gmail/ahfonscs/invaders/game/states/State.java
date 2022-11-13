package com.gmail.ahfonscs.invaders.game.states;

import java.awt.Graphics2D;

public abstract class State
{
  private static State currentState;
  
  public static State getCurrentState() {
    return currentState;
  }
  public static void setCurrentState(State currentState) {
    State.currentState = currentState;
  }
  
  public abstract void update();
  
  public abstract void render(Graphics2D paramGraphics2D);
}
