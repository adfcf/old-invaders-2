package com.gmail.ahfonscs.invaders.game.entities.objects;

import com.gmail.ahfonscs.invaders.game.entities.Entity;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;







public class ObjectManager
{
  private List<Entity> objects = new ArrayList<>();
  private Random random = new Random();


  
  public void update() {
    Iterator<Entity> i = this.objects.iterator();
    
    while (i.hasNext()) {
      
      Entity entity = i.next();
      
      if (entity.isActive()) {
        entity.update(); continue;
      } 
      i.remove();
    } 
  }



  
  public void render(Graphics2D graphics) {
    for (Entity object : this.objects) {
      object.render(graphics);
    }
  }
  
  public void add(Entity object) {
    this.objects.add(object);
  }
  
  public List<Entity> getObjects() {
    return this.objects;
  }
}
