package com.metao.java8.designpatterns.dp.lazyloading;

public class HolderThreadSafe {

  private Heavy heavy;

  /**
   * Constructor.
   */
  public HolderThreadSafe() {
    System.out.println("HolderThreadSafe created");
  }

  /**
   * Get heavy object.
   */
  public synchronized Heavy getHeavy() {
    if (heavy == null) {
      heavy = new Heavy();
    }
    return heavy;
  }
}