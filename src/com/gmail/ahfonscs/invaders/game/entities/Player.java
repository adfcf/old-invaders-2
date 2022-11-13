package com.gmail.ahfonscs.invaders.game.entities;

import com.gmail.ahfonscs.invaders.core.input.KeyInput;
import com.gmail.ahfonscs.invaders.game.Handler;
import com.gmail.ahfonscs.invaders.game.entities.enemies.Enemy;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.BulletContext;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Laser;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.PlasmaSphere;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Projectile;
import com.gmail.ahfonscs.invaders.game.entities.projectiles.Trigger;
import com.gmail.ahfonscs.invaders.game.gfx.Assets;
import com.gmail.ahfonscs.invaders.game.managers.FontManager;
import com.gmail.ahfonscs.invaders.game.states.GameState;
import com.gmail.ahfonscs.invaders.game.states.State;
import java.awt.Color;
import java.awt.Graphics2D;



public class Player
  extends Spaceship
{

  private static final KeyInput INPUT = KeyInput.getInstance();
  
  private BulletContext bulletContext;
  
  private Trigger trigger;
  
  private int score;
  private boolean bolado;
  
  public Player(float x, float y) {
    super(x, y, 124, 124);
    
    this.bulletContext = new BulletContext((Projectile)new Laser(0.0F, 0.0F, 80), getBounds());
    this.trigger = new Trigger(this.bulletContext);
    
    setMaxSpeedX(11);
    setMaxSpeedY(9);
    
    setHealth(super.MAX_HEALTH);
  }



  
  public void update() {
    this.trigger.update();
    
    if (INPUT.isPressed(32) && isActive()) {
      this.trigger.fire();
    }
    
    if (INPUT.isPressed(80)) {
      this.bulletContext.setType((Projectile)new PlasmaSphere(0.0F, 0.0F));
    } else if (INPUT.isPressed(76)) {
      this.bulletContext.setType((Projectile)new Laser(0.0F, 0.0F));
    } 
    
    if (INPUT.isPressed(66)) {
      this.bolado = !this.bolado;
    }
    
    if (INPUT.isGoingToUp()) {
      this.speedY += -this.acceleration;
    }
    if (INPUT.isGoingToDown()) {
      this.speedY += this.acceleration;
    }
    if (INPUT.isGoingToLeft()) {
      this.speedX += -this.acceleration;
    }
    if (INPUT.isGoingToRight()) {
      this.speedX += this.acceleration;
    }
    
    for (Enemy enemy : Handler.getSpace().getFleet().getEnemies()) {
      
      if (getBounds().intersects(enemy.getBounds()) && isActive()) {
        
        if (this.bolado) {
          enemy.die();
          
          return;
        } 
        FontManager.updateEnergyColor(getHealth());
        
        if (enemy instanceof com.gmail.ahfonscs.invaders.game.entities.enemies.BossInvader) {
          hurt(1);
          
          return;
        } 
        enemy.die();
        hurt(1);
      } 
    } 

    
    if (Handler.isVictory()) {
      this.bolado = true;
    }
    
    move();
  }


  
  public void render(Graphics2D g) {
    if (isActive()) {
      
      Graphics2D graphics = (Graphics2D)g.create();
      
      graphics.drawImage(Assets.player_spaceship, (int)getX(), (int)getY(), getWidth(), getHeight(), null);
      
      graphics.setColor(FontManager.getEnergyColor());
      graphics.fillRect(25, Handler.getWindow().getHeight() - 75, getHealth() * 5, 25);
      graphics.setColor(Color.WHITE);
      graphics.drawRect(25 - 1, Handler.getWindow().getHeight() - 75 - 1, super.MAX_HEALTH * 5 + 1, 25 + 1);
      
      graphics.setColor(Color.WHITE);
      graphics.setFont(FontManager.getTextFont());
      graphics.drawString("Nave", 30, Handler.getWindow().getHeight() - 55);
      
      graphics.drawString("Derrotados: " + this.score + "/" + GameState.SCORE_TO_WIN, Handler.getWindow().getWidth() - 250, Handler.getWindow().getHeight() - 55);
      
      this.trigger.render(graphics);
      
      graphics.dispose();
    } 
  }


  
  public void die() {
    setActive(false);
    State.setCurrentState((State)Handler.getGame().getGameOverState());
  }
  
  public Trigger getTrigger() {
    return this.trigger;
  }
  
  public int getScore() {
    return this.score;
  }
  public void score() {
    this.score++;
  }
  
  public boolean isBolado() {
    return this.bolado;
  }
}
