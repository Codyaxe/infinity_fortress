package com.infinityfortress.characters;

import java.util.ArrayList;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.BasicAction;
import com.infinityfortress.actions.SpecialAction;
import com.infinityfortress.effects.TemporaryEffect;
import com.infinityfortress.races.Race;
import com.infinityfortress.roles.Role;
import com.infinityfortress.Temp.*;
import com.infinityfortress.actions.MainAction;

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
    private ArrayList<TemporaryEffect> condition;
    private boolean isEmpty;

    //TEMP
    // Temporary UI skill attributes
    
    public ArrayList<MainAction> actions = new ArrayList<>();

    // Temporary equipment slots
    private EquipmentTemp weapon;
    private EquipmentTemp armor;
    private EquipmentTemp accessory1;
    private EquipmentTemp accessory2;
    
    public NCharacter(NCharacterType type, int health, int mana, int exp, int defense, int strength, int speed, int critStrength, int critChance, int luck, Role role, Race race) {
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
        this.condition = new ArrayList<>();

        // --- Random temporary action generation for UI ---
        // Create ArrayList with BasicAction and SpecialAction
        actions.add(new BasicAction());
        actions.add(new SpecialAction());

        // --- Random equipment generation ---
        // Generate random equipment based on role
        this.weapon = EquipmentFactory.createRandomWeapon(role.getName().toLowerCase());
        this.armor = EquipmentFactory.createRandomArmor();
        this.accessory1 = EquipmentFactory.createRandomAccessory();
        this.accessory2 = EquipmentFactory.createRandomAccessory();
        // --- end equipment generation ---
        
        // --- end temporary skill generation ---
    }
    
    // Action getters using single actions ArrayList

    public MainAction getBasicSkillAction() {
        return !actions.isEmpty() ? actions.get(0) : null;
    }

    public MainAction getSpecialSkillAction() {
        return actions.size() > 1 ? actions.get(1) : null;
    }

    // Get all actions
    public ArrayList<MainAction> getActions() {
        return actions;
    }

    // Temporary equipment getters
    public EquipmentTemp getWeapon() {
        return weapon;
    }

    public EquipmentTemp getArmor() {
        return armor;
    }

    public EquipmentTemp getAccessory1() {
        return accessory1;
    }

    public EquipmentTemp getAccessory2() {
        return accessory2;
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

    // Conditions Manipulation

    public void addTemporaryEffect(TemporaryEffect effect) {
        condition.addLast(effect);
    }

    public void removeTemporaryEffect(TemporaryEffect effect) {
        condition.remove(effect);
    }

    // Action Helper Methods for UI

    // public Action getBasicAction() {
    //     ArrayList<Action> roleActions = role.getActions();
    //     return roleActions.isEmpty() ? null : roleActions.get(0);
    // }

    // public Action getSpecialAction() {
    //     ArrayList<Action> roleActions = role.getActions();
    //     return roleActions.size() > 1 ? roleActions.get(1) : null;
    // }

    public Action getActionByName(String actionName) {
        return role.getActions().stream()
                .filter(action -> action.getName().equals(actionName))
                .findFirst()
                .orElse(null);
    }

    public Action getActionByIndex(int index) {
        ArrayList<Action> roleActions = role.getActions();
        if (index >= 0 && index < roleActions.size()) {
            return roleActions.get(index);
        }
        return null;
    }

    public ArrayList<Action> getAllActions() {
        return role.getActions();
    }

    public int getActionCount() {
        return role.getActions().size();
    }
}