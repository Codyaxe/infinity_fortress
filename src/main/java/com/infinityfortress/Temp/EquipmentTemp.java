package com.infinityfortress.Temp;

import com.infinityfortress.Temp.Types.*;

public class EquipmentTemp {
  private String name;
  private BaseStat stats;
  private RarityType rarity;
  private EquipmentType type;
  private String flavorText;
  private String description;

  public EquipmentTemp(String name, BaseStat stats, RarityType rarity, EquipmentType type, String flavorText, String description) {
    this.name = name;
    this.stats = stats;
    this.rarity = rarity;
    this.type = type;
    this.flavorText = flavorText;
    this.description = description;
  }

  // Getters
  public String getName() {
    return name;
  }

  public BaseStat getStats() {
    return stats;
  }

  public RarityType getRarity() {
    return rarity;
  }

  public EquipmentType getType() {
    return type;
  }

  public String getFlavorText() {
    return flavorText;
  }

  public String getDescription() {
    return description;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setStats(BaseStat stats) {
    this.stats = stats;
  }

  public void setRarity(RarityType rarity) {
    this.rarity = rarity;
  }

  public void setType(EquipmentType type) {
    this.type = type;
  }

  public void setFlavorText(String flavorText) {
    this.flavorText = flavorText;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return String.format("%s [%s] - %s: %s", name, rarity, type, flavorText);
  }
}