package com.infinityfortress.characters;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.infinityfortress.actions.Action;
import com.infinityfortress.effects.summoneffect.SummonEffect;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffect;
import com.infinityfortress.items.equipments.Equipment;
import com.infinityfortress.items.equipments.EquippedSlots;
import com.infinityfortress.races.Race;
import com.infinityfortress.roles.Role;

public class NCharacter {
    private String name;
    private NCharacterType type;
    private int maxHealth;
    private int health;
    private int maxMana;
    private int mana;
    private int exp;
    private int lvl = 0;
    private int defense;
    private int strength;
    private int speed;
    private int critChance;
    private int critStrength;
    private int luck;
    private Role role;
    private Race race;
    private Set<TemporaryEffect> condition;
    private Set<SummonEffect> summons;
    private boolean isEmpty;
    private boolean isDead;
    private boolean hasTakenTurn;
    private Runnable isSpeedChanged;

    // Temp
    private EquippedSlots equipment = new EquippedSlots();

    public EquippedSlots getEquipment() {
        return equipment;
    }

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
        this.isDead = false;
        this.hasTakenTurn = false;
        this.luck = 2;
        this.role = c;
        this.race = r;
        this.condition = new HashSet<>();
        this.summons = new HashSet<>();

        this.isSpeedChanged = null;

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
        this.lvl = exp;
        this.defense = defense;
        this.strength = strength;
        this.speed = speed;
        this.critChance = critChance;
        this.critStrength = critStrength;
        this.luck = luck;
        this.role = role;
        this.race = race;
        this.isEmpty = false;
        this.hasTakenTurn = false;
        this.condition = new HashSet<>();
        this.summons = new HashSet<>();

        this.isSpeedChanged = null;
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

    public int getLvl() {
        return lvl;
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

    public boolean isDead() {
        return isDead;
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

    public void setLvl(int lvl) {
        this.lvl = lvl;
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

    public void setIsDead(boolean x) {
        this.isDead = x;
    }

    public boolean hasTakenTurn() {
        return hasTakenTurn;
    }

    public void setHasTakenTurn(boolean hasTakenTurn) {
        this.hasTakenTurn = hasTakenTurn;
    }

    // Conditions Manipulation

    public void addTemporaryEffect(TemporaryEffect effect) {
        condition.add(effect);
    }

    public void removeTemporaryEffect(TemporaryEffect effect) {
        condition.remove(effect);
    }

    public Set<TemporaryEffect> getAllTemporaryEffect() {
        return condition;
    }

    // Summons Manipulation

    public void addSummonEffect(SummonEffect summon) {
        summons.add(summon);
    }

    public void removeSummonEffect(SummonEffect summon) {
        summons.remove(summon);
    }

    public Set<SummonEffect> getAllSummonsEffect() {
        return summons;
    }

    // Action Helper Methods for UI

    public Action getBasicAction() {
        List<Action> actions = role.getActions();
        return actions.isEmpty() ? null : actions.get(0);
    }

    public Action getSpecialAction() {
        List<Action> actions = role.getActions();
        return actions.size() > 1 ? actions.get(1) : null;
    }

    public Action getBlockAction() {
        List<Action> actions = role.getActions();
        return actions.size() > 1 ? actions.get(2) : null;
    }

    public Action getRestAction() {
        List<Action> actions = role.getActions();
        return actions.size() > 1 ? actions.get(3) : null;
    }

    public Action getActionByName(String actionName) {
        return role.getActions().stream()
                .filter(action -> action.getName().equals(actionName))
                .findFirst()
                .orElse(null);
    }

    public Action getActionByIndex(int index) {
        List<Action> actions = role.getActions();
        if (index >= 0 && index < actions.size()) {
            return actions.get(index);
        }
        return null;
    }

    public List<Action> getAllActions() {
        return role.getActions();
    }

    public int getActionCount() {
        return role.getActions().size();
    }

    // Update Stats From Equipment

    public void updateStatFromEquipment(Equipment equipment) {
        this.maxHealth += equipment.getHealth();
        this.health += equipment.getHealth();
        this.maxMana += equipment.getMana();
        this.mana += equipment.getHealth();

        this.defense += equipment.getDefense();
        this.strength += equipment.getStrength();

        this.critChance += equipment.getCritChance();
        this.critStrength += equipment.getCritStrength();

        this.luck += equipment.getLuck();
        if (equipment.getSpeed() != 0) {
            this.speed -= equipment.getSpeed();
            notifySpeedChange();
        }

    }

    public void removeStatsFromEquipment(Equipment equipment) {
        this.maxHealth -= equipment.getHealth();
        this.health -= equipment.getHealth();
        this.maxMana -= equipment.getMana();
        this.mana -= equipment.getHealth();

        this.defense -= equipment.getDefense();
        this.strength -= equipment.getStrength();

        this.critChance -= equipment.getCritChance();
        this.critStrength -= equipment.getCritStrength();

        this.luck -= equipment.getLuck();
        if (equipment.getSpeed() != 0) {
            this.speed -= equipment.getSpeed();
            notifySpeedChange();
        }

    }

    // Speed Change

    public void setSpeedChange(Runnable speedChange) {
        this.isSpeedChanged = speedChange;
    }

    public void notifySpeedChange() {
        if (isSpeedChanged != null) {
            isSpeedChanged.run();
        }
    }

}