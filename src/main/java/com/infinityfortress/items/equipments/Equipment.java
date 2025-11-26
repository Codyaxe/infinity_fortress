package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;
import com.infinityfortress.items.Items;
import com.infinityfortress.items.Visitor;

public class Equipment implements Items {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String name;
    String type;
    String role;
    int value;
    int health;
    int mana;
    int defense;
    int strength;
    int critChance;
    int critStrength;
    int speed;
    int luck;
    String description;
    String flavorText;
    ItemRarity rarity;

    Equipment() {
        this.name = "";
        this.type = "";
        this.role = "";
        this.value = 0;
        this.health = 0;
        this.mana = 0;
        this.defense = 0;
        this.strength = 0;
        this.critChance = 0;
        this.critStrength = 0;
        this.speed = 0;
        this.luck = 0;
        this.description = "";
        this.flavorText = "";
        this.rarity = ItemRarity.NONE;
    }

    Equipment(String name, String type, String role, int value, int mana, int defense, int strength, int critChance,
            int critStrength, int luck,
            String description, String flavorText, ItemRarity rarity) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.value = value;
        this.health = 0;
        this.mana = mana;
        this.defense = defense;
        this.strength = strength;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.speed = 0;
        this.luck = luck;
        this.description = description;
        this.flavorText = flavorText;
        this.rarity = rarity;
    }

    Equipment(String name, String type, String role, int value, int mana, int defense, int strength, int critChance,
            int critStrength, int luck,
            String description, ItemRarity rarity) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.value = value;
        this.health = 0;
        this.mana = mana;
        this.defense = defense;
        this.strength = strength;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.speed = 0;
        this.luck = luck;
        this.description = description;
        this.flavorText = "";
        this.rarity = rarity;
    }

    // Getters

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getCritChance() {
        return critChance;
    }

    @Override
    public int getCritStrength() {
        return critStrength;
    }

    @Override
    public int getLuck() {
        return luck;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getFlavorText() {
        return flavorText;
    }

    @Override
    public ItemRarity getRarity() {
        return rarity;
    }
}
