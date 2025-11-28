package com.infinityfortress.items.consumables;

public enum ConsumableTier {
  LESSER(0.5),
  STANDARD(1),
  GREATER(1.6),
  UNIQUE(1),
  ASC(1.5);

  double intensityLevel;

  ConsumableTier(double iL) {
    this.intensityLevel=iL;
  }

  public double getIntensityLevel() {
    return intensityLevel;
  }
}
