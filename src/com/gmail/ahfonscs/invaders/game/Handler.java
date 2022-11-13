package com.gmail.ahfonscs.invaders.game;

import com.gmail.ahfonscs.invaders.core.GameWindow;


public final class Handler
{
  private static InvadersGame game;
  private static Space space;
  private static GameWindow window;
  private static boolean victory;
  
  public static InvadersGame getGame() {
    return game;
  }
  public static void setGame(InvadersGame game) {
    Handler.game = game;
  }
  
  public static GameWindow getWindow() {
    return window;
  }
  public static void setWindow(GameWindow window) {
    Handler.window = window;
  }
  
  public static Space getSpace() {
    return space;
  }
  public static void setSpace(Space space) {
    Handler.space = space;
  }
  
  public static boolean isVictory() {
    return victory;
  }
  public static void setVictory(boolean victory) {
    Handler.victory = victory;
  }
}
