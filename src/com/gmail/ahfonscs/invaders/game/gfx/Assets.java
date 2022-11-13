package com.gmail.ahfonscs.invaders.game.gfx;

import java.awt.image.BufferedImage;



public final class Assets
{
  public static BufferedImage background;
  public static BufferedImage player_spaceship;
  public static BufferedImage[] plasma;
  public static BufferedImage laser;
  public static BufferedImage small_invader;
  public static BufferedImage employee_invader;
  public static BufferedImage meteorite;
  public static BufferedImage[] explosion;
  public static BufferedImage repair_item;
  
  public static void init() {
	  
    initBackground();
    initPlayer();
    initProjectiles();
    initEnemies();
    initObjects();
    
    repair_item = ImageLoader.loadImage("/textures/objects/repair_item.png");
    
  }


  
  private static void initBackground() {
    background = ImageLoader.loadImage("/textures/background/background.png");
  }


  
  private static void initPlayer() {
    player_spaceship = ImageLoader.loadImage("/textures/spaceships/player_spaceship.png");
  }


  
  private static void initProjectiles() {
    laser = ImageLoader.loadImage("/textures/projectiles/laser.png");
    
    plasma = new BufferedImage[4];
    
    BufferedImage sprite = ImageLoader.loadImage("/textures/projectiles/plasma.png");
    
    final int width = 7;
    final int height = 7;
    
    plasma[0] = sprite.getSubimage(width * 0, 0, width, height);
    plasma[1] = sprite.getSubimage(width * 1, 0, width, height);
    plasma[2] = sprite.getSubimage(width * 2, 0, width, height);
    plasma[3] = sprite.getSubimage(width * 3, 0, width, height);
    
  }



  
  private static void initEnemies() {
    small_invader = ImageLoader.loadImage("/textures/spaceships/small_invader.png");
    employee_invader = ImageLoader.loadImage("/textures/spaceships/employee_invader.png");
  }


  
  private static void initObjects() {
    meteorite = ImageLoader.loadImage("/textures/objects/meteorite.png");
    
    explosion = new BufferedImage[4];
    
    BufferedImage sprite = ImageLoader.loadImage("/textures/objects/explosion.png");
    
    final int width = 16;
    final int height = 15;
    
    explosion[0] = sprite.getSubimage(width * 0, 0, width, height);
    explosion[1] = sprite.getSubimage(width * 1, 0, width, height);
    explosion[2] = sprite.getSubimage(width * 2, 0, width, height);
    explosion[3] = sprite.getSubimage(width * 3, 0, width, height);

  }
}
