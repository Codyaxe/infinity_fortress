package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;
import com.infinityfortress.items.Items;
import com.infinityfortress.items.Visitor;

public class Consumables implements Items {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    private String name;
    private String type;
    private String role;
    private int value;
    private int duration;
    private int health;
    private int mana;
    private int defense;
    private int strength;
    private int critChance;
    private int critStrength;
    private int luck;
    private int speed;
    private String description;
    private String flavorText;
    private ItemRarity rarity;
    private ConsumableTier tier;

    Consumables() {
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
        this.tier = ConsumableTier.STANDARD;
    }

    Consumables(String name, String type, String role, int value, int mana, int defense, int strength, int critChance,
            int critStrength, int luck,
            String description, String flavorText, ItemRarity rarity, ConsumableTier tier) {
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
        this.tier = tier;
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

    public int getDuration() {
        return duration;
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

    public ConsumableTier getTier() {
        return tier;
    }
}
