package com.infinityfortress.equipments;

public class Equipment {
    String name;
    String type;
    String role;
    int value;
    int mana;
    int defense;
    int strength;
    int critChance;
    int critStrength;
    int luck;
    String description;
    EquipmentRarity equipmentRarity;

    Equipment() {
        this.name = "";
        this.type = "";
        this.role = "";
        this.value = 0;
        this.mana = 0;
        this.defense = 0;
        this.strength = 0;
        this.critChance = 0;
        this.critStrength = 0;
        this.luck = 0;
        this.description = "";
        this.equipmentRarity = EquipmentRarity.NONE;
    }

    Equipment(String name, String type, String role, int value, int mana, int defense, int strength, int critChance,
            int critStrength, int luck,
            String description, EquipmentRarity rarity) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.value = value;
        this.mana = mana;
        this.defense = defense;
        this.strength = strength;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.luck = luck;
        this.description = description;
        this.equipmentRarity = rarity;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getRole() {
        return role;
    }

    public int getValue() {
        return value;
    }

    public int getMana() {
        return mana;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getCritChance() {
        return critChance;
    }

    public int getCritStrength() {
        return critStrength;
    }

    public int getLuck() {
        return luck;
    }

    public String getDescription() {
        return description;
    }

    public EquipmentRarity getEquipmentRarity() {
        return equipmentRarity;
    }
}
