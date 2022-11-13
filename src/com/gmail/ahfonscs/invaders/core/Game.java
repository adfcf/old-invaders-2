package com.gmail.ahfonscs.invaders.core;

import com.gmail.ahfonscs.invaders.game.Handler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;





public abstract class Game
{
  public static final String VERSION = "v1.4";
  private GameWindow mainWindow;
  private BufferStrategy bufferSt;
  private Stabilizer stabilizer;
  private Graphics2D graphics;
  private boolean running;
  
  private void load() {
    this.stabilizer = new Stabilizer();
    this.mainWindow = new GameWindow();
    
    Handler.setWindow(this.mainWindow);
    
    onLoad();
    
    this.mainWindow.setVisible(true);
    this.stabilizer.start();
  }

  
  private void update() {
    this.stabilizer.countTick();
    onUpdate();
  }


  
  private void render() {
    try {
      this.bufferSt = this.mainWindow.getProperBufferStrategy();
      this.graphics = (Graphics2D)this.bufferSt.getDrawGraphics();
    }
    catch (Exception e1) {
      e1.printStackTrace();
      
      return;
    } 
    this.graphics.setColor(Color.WHITE);
    this.graphics.fillRect(0, 0, this.mainWindow.getWidth(), this.mainWindow.getHeight());
    
    this.stabilizer.show(this.graphics);
    
    onRender(this.graphics);
    
    if (!this.bufferSt.contentsLost()) {
      this.bufferSt.show();
      this.stabilizer.countRendering();
    } else {
      System.out.println("Lost Frame!");
    } 
    
    this.graphics.dispose();
  }


  
  private void unload() {
    onUnload();
    
    this.bufferSt.dispose();
    this.mainWindow.dispose();
  }

  
  public void run() {
    this.running = true;
    load();
    long nanoTime = System.nanoTime();
    while (this.running) {
      while (System.nanoTime() > nanoTime) {
        update();
        nanoTime += 20000000L;
      } 
      render();
    } 
    unload();
  }
  
  protected abstract void onLoad();
  
  protected abstract void onUpdate();
  
  protected abstract void onRender(Graphics2D paramGraphics2D);
  
  protected abstract void onUnload();
}
