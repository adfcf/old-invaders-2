package com.gmail.ahfonscs.invaders.game.entities.objects;

import com.gmail.ahfonscs.invaders.game.entities.Entity;

public abstract class Item
  extends Entity {
  public Item(float x, float y) {
    super(x, y, 32, 32, true);
  }
}
