package com.infinityfortress.characters;

import java.util.ArrayList;

//TEMPEMPEP
import java.util.concurrent.ThreadLocalRandom;

import com.infinityfortress.actions.Action;
import com.infinityfortress.effects.TemporaryEffect;
import com.infinityfortress.races.Race;
import com.infinityfortress.roles.Role;
import com.infinityfortress.Temp.*;

public class BackUpCharacter {
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

    // Default Constructor
    // Role and Race class will have default values which will extend the base
    // attributes. For now placeholder values are included.
    public BackUpCharacter(Role c, Race r) {
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

    //TEMP
    String roleTemp;
    String raceTemp;

    // Temporary UI skill attributes
    public enum SkillType { DAMAGE, HEAL, BUFF, DEBUFF, SUMMON, OTHER }
    public enum HitType { SINGLE, MULTI, AREA }
    
    // Basic skill attributes
    private String basicSkillName;
    private int basicSkillDamage;
    private int basicManaCost;
    private SkillType basicSkillType;
    private HitType basicHitType;
    private String basicSkillDescription;
    
    // Special skill attributes  
    private String specialSkillName;
    private int specialSkillDamage;
    private int specialManaCost;
    private SkillType specialSkillType;
    private HitType specialHitType;
    private String specialSkillDescription;
    private double specialSuccessRate; // 0.0 - 1.0

    // Temporary equipment slots
    private EquipmentTemp weapon;
    private EquipmentTemp armor;
    private EquipmentTemp accessory1;
    private EquipmentTemp accessory2;

    
    public BackUpCharacter(NCharacterType type, int health, int mana, int exp, int defense, int strength, int speed, int critStrength, int critChance, int luck, Role role, Race race) {
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

        // --- Random temporary skill generation for UI ---
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        String[] basicNames = {"Slash", "Strike", "Heal", "Block", "Focus", "Guard"};
        String[] specialNames = {"Fireball", "Shadow Strike", "Whirlwind", "Arcane Bolt", "Summon Wolf", "Siphon"};
        String[] basicDesc = {
                "A quick basic attack.",
                "A simple physical strike.",
                "Restores a small amount of health.",
                "A defensive maneuver.",
                "Increases concentration.",
                "Protective stance."
        };
        String[] specialDesc = {
                "A burst of flame that scorches enemies.",
                "A precise strike that may deal extra damage.",
                "Hits multiple nearby enemies.",
                "A focused magical projectile.",
                "Summons a friendly beast to fight.",
                "Life-stealing attack that heals the user."
        };

        // Basic skill initialization
        this.basicSkillName = basicNames[rnd.nextInt(basicNames.length)];
        this.basicSkillDescription = basicDesc[rnd.nextInt(basicDesc.length)];
        this.basicSkillDamage = rnd.nextInt(Math.max(1, this.strength / 3), Math.max(2, this.strength + 2));
        this.basicManaCost = rnd.nextInt(1, Math.max(2, this.mana / 3 + 1));

        // Special skill initialization  
        this.specialSkillName = specialNames[rnd.nextInt(specialNames.length)];
        this.specialSkillDescription = specialDesc[rnd.nextInt(specialDesc.length)];
        this.specialSkillDamage = rnd.nextInt(Math.max(2, this.strength + 1), Math.max(4, this.strength + 8));
        this.specialManaCost = rnd.nextInt(Math.max(2, this.mana / 2), Math.max(3, this.mana + 2));
        this.specialSuccessRate = Math.round((rnd.nextDouble(0.50, 0.85)) * 100.0) / 100.0;

        // pick random types and hit types
        SkillType[] st = SkillType.values();
        HitType[] ht = HitType.values();
        this.basicSkillType = st[rnd.nextInt(st.length)];
        this.basicHitType = ht[rnd.nextInt(ht.length)];
        this.specialSkillType = st[rnd.nextInt(st.length)];
        this.specialHitType = ht[rnd.nextInt(ht.length)];

        // --- Random equipment generation ---
        // Generate random equipment based on role
        this.weapon = EquipmentFactory.createRandomWeapon(role.getName().toLowerCase());
        this.armor = EquipmentFactory.createRandomArmor();
        this.accessory1 = EquipmentFactory.createRandomAccessory();
        this.accessory2 = EquipmentFactory.createRandomAccessory();
        // --- end equipment generation ---
        
        // --- end temporary skill generation ---
    }
    
    public BackUpCharacter(String c, String r) {

        this.name = c + " " + r;
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
        this.roleTemp = r;
        this.raceTemp = c;
        this.condition = new ArrayList<>();
    }


    public String getRoleTemp() {
        return roleTemp;
    }
    public String getRaceTemp() {
        return raceTemp;
    }
        // Temporary skill attribute getters - Basic Skills
    public String getBasicSkillName() {
        return basicSkillName;
    }

    public int getBasicSkillDamage() {
        return basicSkillDamage;
    }

    public int getBasicManaCost() {
        return basicManaCost;
    }

    public SkillType getBasicSkillType() {
        return basicSkillType;
    }

    public HitType getBasicHitType() {
        return basicHitType;
    }

    public String getBasicSkillDescription() {
        return basicSkillDescription;
    }

    // Temporary skill attribute getters - Special Skills
    public String getSpecialSkillName() {
        return specialSkillName;
    }

    public int getSpecialSkillDamage() {
        return specialSkillDamage;
    }

    public int getSpecialManaCost() {
        return specialManaCost;
    }

    public SkillType getSpecialSkillType() {
        return specialSkillType;
    }

    public HitType getSpecialHitType() {
        return specialHitType;
    }

    public String getSpecialSkillDescription() {
        return specialSkillDescription;
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






    // public NCharacter(NCharacterType type, int health, int mana, int exp, int defense,
    //         int strength, int speed, int critStrength, int critChance,
    //         int luck, Role role, Race race) {
    //     this.name = race.getName() + " " + role.getName();
    //     this.type = type;
    //     this.maxHealth = health;
    //     this.health = health;
    //     this.maxMana = mana;
    //     this.mana = mana;
    //     this.exp = exp;
    //     this.lvl = exp;
    //     this.defense = defense;
    //     this.strength = strength;
    //     this.speed = speed;
    //     this.critChance = critChance;
    //     this.critStrength = critStrength;
    //     this.luck = luck;
    //     this.role = role;
    //     this.race = race;
    //     this.isEmpty = false;
    //     this.condition = new ArrayList<>();
    // }

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
        condition.add(effect);
    }

    public void removeTemporaryEffect(TemporaryEffect effect) {
        condition.remove(effect);
    }

    // Action Helper Methods for UI

    public Action getBasicAction() {
        ArrayList<Action> actions = role.getActions();
        return actions.isEmpty() ? null : actions.get(0);
    }

    public Action getSpecialAction() {
        ArrayList<Action> actions = role.getActions();
        return actions.size() > 1 ? actions.get(1) : null;
    }

    public Action getActionByName(String actionName) {
        return role.getActions().stream()
                .filter(action -> action.getName().equals(actionName))
                .findFirst()
                .orElse(null);
    }

    public Action getActionByIndex(int index) {
        ArrayList<Action> actions = role.getActions();
        if (index >= 0 && index < actions.size()) {
            return actions.get(index);
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