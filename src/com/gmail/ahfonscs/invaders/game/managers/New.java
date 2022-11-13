package com.gmail.ahfonscs.invaders.game.managers;

import java.util.Random;

public class New
{
  private static final Random RANDOM = new Random();
  
  public static int number() {
    return RANDOM.nextInt(100000000);
  }
  
  public static int number(int max) {
    return RANDOM.nextInt(max);
  }
  
  public static int number(int min, int max) {
    return min + RANDOM.nextInt(max - min);
  }
  
  public static int numberFrom(int... numbers) {
    int index = RANDOM.nextInt(numbers.length);
    return numbers[index];
  }
}
