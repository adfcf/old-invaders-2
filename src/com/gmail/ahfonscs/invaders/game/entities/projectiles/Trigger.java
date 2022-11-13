package com.gmail.ahfonscs.invaders.game.entities.projectiles;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;






public final class Trigger
{
  private List<Projectile> projectiles;
  private BulletContext context;
  private int cooldown;
  private int max;
  private long lastTime;
  private long timer;
  private boolean allowed;
  
  public Trigger(BulletContext context) {
    this.context = context;
    
    this.cooldown = context.getType().getCooldown();
    this.max = context.getType().getMax();
    
    this.projectiles = new ArrayList<>();
  }


  
  public void update() {
    this.cooldown = this.context.getType().getCooldown();
    this.max = this.context.getType().getMax();
    
    Iterator<Projectile> i = this.projectiles.iterator();
    
    while (i.hasNext()) {
      
      Projectile p = i.next();
      
      if (p.isActive()) {
        p.update(); continue;
      } 
      i.remove();
    } 


    
    this.timer += System.currentTimeMillis() - this.lastTime;
    this.lastTime = System.currentTimeMillis();
    
    if (this.timer >= this.cooldown) {
      this.allowed = true;
      this.timer = 0L;
    } 
  }

  
  public void render(Graphics2D graphics) {
    for (Projectile p : this.projectiles) {
      p.render(graphics);
    }
  }
  
  public void fire() {
    if (this.allowed && this.projectiles.size() < this.max) {
      this.projectiles.add(this.context.createProjectile());
      this.allowed = false;
    } 
  }
  
  public void fire(int x, int y) {
    if (this.allowed && this.projectiles.size() < this.max) {
      this.projectiles.add(this.context.getType().create(x, y, -this.context.getType().getConstant_speed()));
      this.allowed = false;
    } 
  }
  
  public List<Projectile> getProjectiles() {
    return this.projectiles;
  }
}
