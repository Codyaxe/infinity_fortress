package com.infinityfortress.characters;

import java.util.ArrayList;

import com.infinityfortress.races.Race;
import com.infinityfortress.roles.Role;
import com.infinityfortress.effects.TemporaryEffect;

public class NCharacter {
    private String name;
    private NCharacterType type;
    private int maxHealth;
    private int health;
    private int maxMana;
    private int mana;
    private int exp;
    private int defense;
    private int strength;
    private int speed;
    private int critChance;
    private int critStrength;
    private int luck;
    private Role role;
    private Race race;
    private ArrayList<TemporaryEffect> condition;
    private boolean isEmpty;

    // Default Constructor
    // Role and Race class will have default values which will extend the base
    // attributes. For now placeholder values are included.
    public NCharacter(Role c, Race r) {
        this.name = r.getName() + " " + c.getName();
        this.type = NCharacterType.ALLY;
        this.health = 10;
        this.mana = 10;
        this.exp = 0;
        this.defense = 0;
        this.strength = 10;
        this.speed = 10;
        this.critChance = 10;
        this.critStrength = 2;
        this.isEmpty = false;
        this.luck = 2;
        this.role = c;
        this.race = r;
        this.condition = new ArrayList<>();
    }

    public NCharacter(NCharacterType type, int health, int mana, int exp, int defense,
            int strength, int speed, int critStrength, int critChance,
            int luck, Role role, Race race) {
        this.name = race.getName() + " " + role.getName();
        this.type = type;
        this.maxHealth = health;
        this.health = health;
        this.maxMana = mana;
        this.mana = mana;
        this.exp = exp;
        this.defense = defense;
        this.strength = strength;
        this.speed = speed;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.luck = luck;
        this.role = role;
        this.race = race;
        this.isEmpty = false;
        this.condition = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public NCharacterType getType() {
        return type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMana() {
        return mana;
    }

    public int getExp() {
        return exp;
    }

    public int getDefense() {
        return defense;
    }

    public int getStrength() {
        return strength;
    }

    public int getSpeed() {
        return speed;
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

    public Role getRole() {
        return role;
    }

    public Race getRace() {
        return race;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    // Setters

    public void setType(NCharacterType type) {
        this.type = type;
    }

    public void setMaxHealth(int health) {
        this.maxHealth = health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxMana(int mana) {
        this.maxMana = mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public void setCritStrength(int critStrength) {
        this.critStrength = critStrength;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void setIsEmpty(boolean x) {
        this.isEmpty = x;
    }

    // Conditions Manipulation

    public void addTemporaryEffect(TemporaryEffect effect) {
        condition.addLast(effect);
    }

    public void removeTemporaryEffect(TemporaryEffect effect) {
        condition.remove(effect);
    }

}