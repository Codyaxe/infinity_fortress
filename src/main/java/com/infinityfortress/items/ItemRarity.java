package com.infinityfortress.items;


public enum ItemRarity {
  FORGED(1, "\u001B[38;2;246;178;107m"),      //#f6b26b
  ENCHANTED(2, "\u001B[38;2;109;158;235m"),   //#6d9eeb
  MYSTIC(3, "\u001B[38;2;142;124;195m"),      //#8e7cc3
  ETHEREAL(4, "\u001B[38;2;241;194;50m"),     //#f1c232
  ASC(5, "\u001B[38;2;255;0;0m"),             //#ff0000
  NONE(0, "\u001B[0m");

  private final int rarityLevel;
  private final String colorCode;
  private static final String RESET = "\u001B[0m";

  ItemRarity(int r, String c) {
    this.rarityLevel = r;
    this.colorCode = c;
  }

  public int getRarityLevel() {
    return rarityLevel;
  }

  public String getColorCode() {
    return colorCode;
  }

  public String coloredName() {
    return colorCode + name() + RESET;
  }

  public int getSize() {
    return coloredName().length();
  }
}
