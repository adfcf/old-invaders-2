package com.gmail.ahfonscs.invaders.core;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;













public class Stabilizer
  implements ActionListener
{
  protected static final int NANOS_IN_ONE_SECOND = 1000000000;
  protected static final int ESTIMATED_TICKS_PER_SECOND = 50;
  protected static final int INTERVAL_PER_TICK = 20000000;
  private Timer timer = new Timer(1000, this); private int renderings;
  private int updates;
  
  protected void start() {
    this.timer.start();
  }
  private int fps; private int tps;
  public void countTick() {
    this.updates++;
  }
  public void countRendering() {
    this.renderings++;
  }

  
  public void show(Graphics2D graphics) {
    graphics.setColor(Color.BLACK);
    
    graphics.drawString("Invaders! v1.4", 10, 30);
    graphics.drawString("FPS: " + this.fps, 10, 60);
    graphics.drawString("TPS: " + this.tps, 10, 90);
  }



  
  public void actionPerformed(ActionEvent e) {
    this.fps = this.renderings;
    this.tps = this.updates;
    
    this.updates = 0;
    this.renderings = 0;
  }
}
