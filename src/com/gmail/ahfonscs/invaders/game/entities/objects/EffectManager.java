package com.gmail.ahfonscs.invaders.game.entities.objects;

import com.gmail.ahfonscs.invaders.game.entities.Entity;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class EffectManager
{
  private List<Entity> effects = new ArrayList<>();


  
  public void update() {
    Iterator<Entity> i = this.effects.iterator();
    
    while (i.hasNext()) {
      
      Entity entity = i.next();
      
      if (entity.isActive()) {
        entity.update(); continue;
      } 
      i.remove();
    } 
  }


  
  public void render(Graphics2D graphics) {
    for (Entity object : this.effects) {
      object.render(graphics);
    }
  }
  
  public void add(Entity effect) {
    this.effects.add(effect);
  }
  
  public List<Entity> getObjects() {
    return this.effects;
  }
}
