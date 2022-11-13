package com.gmail.ahfonscs.invaders.core;

import com.gmail.ahfonscs.invaders.core.input.KeyInput;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public final class GameWindow
  extends JFrame
{
  private static final long serialVersionUID = 286936879598017546L;
  private Canvas canvas;
  
  protected GameWindow() {
    configure();
  }

  
  private void configure() {
    this.canvas = new Canvas();
    this.canvas.addKeyListener((KeyListener)KeyInput.getInstance());
    
    Dimension dimension = new Dimension(960, 638);
    
    this.canvas.setPreferredSize(dimension);
    this.canvas.setMinimumSize(dimension);
    this.canvas.setMaximumSize(dimension);
    
    add(this.canvas);
    pack();
    
    setTitle("Invasores 2! v1.4");
    setLocationRelativeTo((Component)null);
    setDefaultCloseOperation(3);
    setResizable(false);
    setIgnoreRepaint(true);
    
    addKeyListener((KeyListener)KeyInput.getInstance());
  }


  
  protected BufferStrategy getProperBufferStrategy() {
    if (this.canvas.getBufferStrategy() == null) {
      this.canvas.createBufferStrategy(2);
    }
    
    return this.canvas.getBufferStrategy();
  }
}
