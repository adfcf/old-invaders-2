package com.gmail.ahfonscs.invaders.core.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public final class KeyInput
  extends KeyAdapter
{
  private static KeyInput instance;
  private final boolean[] keys = new boolean[128];


  
  public static KeyInput getInstance() {
    if (instance == null) {
      instance = new KeyInput();
    }
    
    return instance;
  }

  
  public boolean isPressed(int code) {
    if (code >= this.keys.length) return false; 
    return this.keys[code];
  }
  
  public boolean isGoingToUp() {
    return this.keys[38];
  }
  public boolean isGoingToDown() {
    return this.keys[40];
  }
  public boolean isGoingToLeft() {
    return this.keys[37];
  }
  public boolean isGoingToRight() {
    return this.keys[39];
  }

  
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() >= this.keys.length)
      return;  this.keys[e.getKeyCode()] = true;
  }

  
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() >= this.keys.length)
      return;  this.keys[e.getKeyCode()] = false;
  }
}
