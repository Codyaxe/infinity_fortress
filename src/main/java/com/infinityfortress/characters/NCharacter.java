package com.infinityfortress.characters;

import java.util.ArrayList;

import com.infinityfortress.races.Race;
import com.infinityfortress.roles.Role;
import com.infinityfortress.effects.TemporaryEffect;

public class NCharacter {
    private String name;
    private int health;
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

    // Default Constructor
    // Role and Race class will have default values which will extend the base
    // attributes. For now placeholder values are included.
    public NCharacter(Role c, Race r) {
        this.name = r.getName() + " " + c.getName();
        this.health = 10;
        this.mana = 10;
        this.exp = 0;
        this.defense = 0;
        this.strength = 10;
        this.speed = 10;
        this.critChance = 10;
        this.critStrength = 2;
        this.luck = 2;
        this.role = c;
        this.race = r;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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

    // Setters
    public void setHealth(int health) {
        this.health = health;
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

    // Conditions Manipulation

    public void addTemporaryEffect(TemporaryEffect effect) {
        condition.addLast(effect);
    }

    public void removeTemporaryEffect(TemporaryEffect effect) {
        condition.remove(effect);
    }

}