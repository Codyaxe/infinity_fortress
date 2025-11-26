package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

// Factory Effects for consumables

public class FactoryEffect extends TemporaryEffect {
    private String name;
    private int health;
    private int mana;
    private int defense;
    private int strength;
    private int critChance;
    private int critStrength;
    private int luck;
    private int speed;

    public FactoryEffect(String name, int duration, NCharacter target, int health, int mana, int defense, int strength,
            int critChance, int critStrength, int luck, int speed) {
        super(duration, target);
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.defense = defense;
        this.strength = strength;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.luck = luck;
        this.speed = speed;
    }

    public FactoryEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setMaxHealth((this.target.getMaxHealth() + health));
        this.target.setMaxMana((this.target.getMaxMana() + mana));
        this.target.setDefense((this.target.getDefense() + defense));
        this.target.setStrength((this.target.getStrength() + strength));
        this.target.setCritChance((this.target.getCritChance() + critChance));
        this.target.setCritStrength((this.target.getCritStrength() + critStrength));
        this.target.setLuck((this.target.getLuck() + luck));
        if (speed != 0) {
            this.target.setSpeed((this.target.getSpeed() + speed));
            notifySpeedChange();
        }

    }

    @Override
    public void remove() {
        this.target.setMaxHealth((this.target.getMaxHealth() - health));
        this.target.setMaxMana((this.target.getMaxMana() - mana));
        this.target.setDefense((this.target.getDefense() - defense));
        this.target.setStrength((this.target.getStrength() - strength));
        this.target.setCritChance((this.target.getCritChance() - critChance));
        this.target.setCritStrength((this.target.getCritStrength() - critStrength));
        this.target.setLuck((this.target.getLuck() - luck));
        if (speed != 0) {
            this.target.setSpeed((this.target.getSpeed() - speed));
            notifySpeedChange();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.DEBUFF;
    }
}
