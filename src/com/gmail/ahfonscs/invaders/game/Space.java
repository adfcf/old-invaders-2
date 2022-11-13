package com.gmail.ahfonscs.invaders.game;

import com.gmail.ahfonscs.invaders.game.entities.Player;
import com.gmail.ahfonscs.invaders.game.entities.enemies.Enemy;
import com.gmail.ahfonscs.invaders.game.entities.enemies.EnemyFleet;
import com.gmail.ahfonscs.invaders.game.entities.enemies.SmallInvader;
import com.gmail.ahfonscs.invaders.game.entities.objects.EffectManager;
import com.gmail.ahfonscs.invaders.game.entities.objects.ObjectManager;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;




public class Space
{
  private BufferedImage background;
  private ObjectManager objectManager;
  private EffectManager effectManager;
  private EnemyFleet fleet;
  private Player player;
  
  public Space() {
    Handler.setSpace(this);
    
    this.background = Assets.background;
    
    this.player = new Player(400.0F, 500.0F);
    this.fleet = new EnemyFleet();
    
    this.objectManager = new ObjectManager();
    this.effectManager = new EffectManager();
    
    this.fleet.add((Enemy)new SmallInvader(100.0F, -64.0F));
  }


  
  public void update() {
    this.player.update();
    
    this.objectManager.update();
    this.effectManager.update();
    this.fleet.update();
  }


  
  public void render(Graphics2D graphics) {
    graphics.drawImage(this.background, 0, 0, Handler.getWindow().getWidth(), Handler.getWindow().getHeight(), null);
    
    this.player.render(graphics);
    this.fleet.render(graphics);
    this.objectManager.render(graphics);
    this.effectManager.render(graphics);
  }

  
  public EnemyFleet getFleet() {
    return this.fleet;
  }
  
  public ObjectManager getObjectManager() {
    return this.objectManager;
  }
  
  public Player getPlayer() {
    return this.player;
  }
  
  public EffectManager getEffectManager() {
    return this.effectManager;
  }
}
