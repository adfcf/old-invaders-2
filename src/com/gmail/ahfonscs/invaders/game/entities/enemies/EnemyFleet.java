package com.gmail.ahfonscs.invaders.game.entities.enemies;

import com.gmail.ahfonscs.invaders.game.Handler;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;



public class EnemyFleet
{
  private List<Enemy> enemies;
  private Random random;
  
  public EnemyFleet() {
    this.enemies = new ArrayList<>();
    create();
  }


  
  private void create() {
    this.random = new Random();
    
    for (int c = 0; c < 6; c++) {
      this.enemies.add(new SmallInvader(this.random.nextInt(Handler.getWindow().getHeight() - 64), -this.random.nextInt(200)));
    }
  }


  
  public void update() {
    Iterator<Enemy> i = this.enemies.iterator();
    
    while (i.hasNext()) {
      
      Enemy e = i.next();
      
      if (e.isActive()) {
        e.update(); continue;
      } 
      i.remove();
    } 


    
    if (!Handler.isVictory()) {
      
      if (this.random.nextInt(10) == this.random.nextInt(45)) {
        this.enemies.add(new SmallInvader(this.random.nextInt(Handler.getWindow().getHeight() + 128), -this.random.nextInt(200)));
      }
      if (this.random.nextInt(10) == this.random.nextInt(250)) {
        this.enemies.add(new Meteorite(this.random.nextInt(Handler.getWindow().getHeight() + 128), -90.0F));
      }
      if (this.random.nextInt(10) == this.random.nextInt(200)) {
        this.enemies.add(new EmployeeInvader(this.random.nextInt(Handler.getWindow().getHeight() + 128), -90.0F));
      }
    }
    else {
      
      if (this.random.nextInt(10) == this.random.nextInt(45)) {
        this.enemies.add(new SmallInvader(this.random.nextInt(Handler.getWindow().getHeight() + 128), (Handler.getWindow().getHeight() + 128)));
      }
      if (this.random.nextInt(10) == this.random.nextInt(250)) {
        this.enemies.add(new Meteorite(this.random.nextInt(Handler.getWindow().getHeight() + 128), (Handler.getWindow().getHeight() + 128)));
      }
      if (this.random.nextInt(10) == this.random.nextInt(200)) {
        this.enemies.add(new EmployeeInvader(this.random.nextInt(Handler.getWindow().getHeight() + 128), (Handler.getWindow().getHeight() + 128)));
      }
    } 
  }


  
  public void render(Graphics2D graphics) {
    for (Enemy enemy : this.enemies) {
      enemy.render(graphics);
    }
  }
  
  public void add(Enemy enemy) {
    this.enemies.add(enemy);
  }
  
  public List<Enemy> getEnemies() {
    return this.enemies;
  }
}
