package com.infinityfortress;

import java.util.Random;
// Will be removed

public class Character {

    public enum Type {
        ALLY, ENEMY
    };

    public boolean isEmpty = false;
    public String role;
    public String race;
    public Type type;
    final private Equipment equipment;
    final private Attack BasicAttack;
    final private Attack SpecialAttack;
    public int maxHp;
    public int maxMp;
    public int expCap;
    public int lvl = 0;
    public int hp;
    public int mp;
    public int exp = 0;
    public int defense;
    public int strength;
    public int speed;
    public int critChance;
    public int critDamage;
    public int luck;

    public String getWeapon() {
        return this.equipment.weapon;
    }

    public String getArmor() {
        return this.equipment.armor;
    }

    public String getAccessory1() {
        return this.equipment.accessory1;
    }

    public String getAccessory2() {
        return this.equipment.accessory2;
    }

    public String getAttackDesc() {
        return this.BasicAttack.description;
    }

    public String getAttackDMG() {
        return "" + this.BasicAttack.damge;
    }

    public String getAttackCost() {
        return "" + this.BasicAttack.mpCost;
    }

    public String getAttackType() {
        return "" + this.BasicAttack.type;
    }

    public String getAttackHitCount() {
        return "" + this.BasicAttack.hitCount;
    }

    public String getSpecialDesc() {
        return this.SpecialAttack.description;
    }

    public String getSpecialDMG() {
        return "" + this.SpecialAttack.damge;
    }

    public String getSpecialCost() {
        return "" + this.SpecialAttack.mpCost;
    }

    public String getSpecialType() {
        return "" + this.SpecialAttack.type;
    }

    public String getSpecialHitCount() {
        return "" + this.SpecialAttack.hitCount;
    }

    // Equipment arrays for randomization
    private static final String[] WEAPONS = {
            "Iron Sword", "Steel Blade", "Mystic Staff", "War Hammer", "Elven Bow",
            "Dagger", "Crossbow", "Magic Wand", "Battle Axe", "Holy Mace"
    };

    private static final String[] ARMOR = {
            "Leather Armor", "Chain Mail", "Plate Armor", "Robes", "Scale Mail",
            "Studded Leather", "Ring Mail", "Splint Armor", "Hide Armor", "Padded Armor"
    };

    private static final String[] ACCESSORIES = {
            "Ring of Power", "Amulet of Health", "Cloak of Protection", "Belt of Strength",
            "Boots of Speed", "Gloves of Dexterity", "Crown of Wisdom", "Shield of Faith",
            "Bracers of Defense", "Necklace of Magic", "Ring of Luck", "Charm of Fortune"
    };

    private static final String[] ROLES = {
            "Mage", "Warlock", "Cleric", "Summoner", "Rogue", "Archer", "Healer", "Tank", "Warrior"
    };

    private static final String[] RACES = {
            "Beastkin", "Demon", "Dragonborn", "Dwarf", "Elf", "Human", "Nephilim", "Orc", "Spiritborn"
    };

    public Character(String type) {
        Random rand = new Random();
        this.hp = this.maxHp = 50 + rand.nextInt(200); // 50-249
        this.mp = this.maxMp = 30 + rand.nextInt(170); // 30-199
        this.expCap = rand.nextInt(100); // 0-99
        this.defense = 10 + rand.nextInt(90); // 10-99
        this.strength = 15 + rand.nextInt(85); // 15-99
        this.speed = 10 + rand.nextInt(90); // 10-99
        this.critChance = 5 + rand.nextInt(45); // 5-49
        this.critDamage = 10 + rand.nextInt(40); // 10-49
        this.luck = 1 + rand.nextInt(99); // 1-99

        this.type = type.equals("Ally") ? Type.ALLY : Type.ENEMY;
        // Randomized role and race (ignore parameters, randomize instead)
        this.role = ROLES[rand.nextInt(ROLES.length)];
        this.race = RACES[rand.nextInt(RACES.length)];

        // Randomized equipment
        String randomWeapon = WEAPONS[rand.nextInt(WEAPONS.length)];
        String randomArmor = ARMOR[rand.nextInt(ARMOR.length)];
        String randomAcc1 = ACCESSORIES[rand.nextInt(ACCESSORIES.length)];
        String randomAcc2 = ACCESSORIES[rand.nextInt(ACCESSORIES.length)];

        // Ensure accessories are different
        while (randomAcc2.equals(randomAcc1)) {
            randomAcc2 = ACCESSORIES[rand.nextInt(ACCESSORIES.length)];
        }

        this.equipment = new Equipment(randomWeapon, randomArmor, randomAcc1, randomAcc2);
        this.BasicAttack = new Attack("A standard attack dealing normal damage.");
        this.SpecialAttack = new Attack("A powerful attack dealing increased damage.");

    }
}

class Attack {

    public enum SkillType {
        Damage, Heal, Buff, Debuff, Block
    };

    public enum HitType {
        Single, Split, Multi, All,
    };

    int damge;
    int mpCost;
    SkillType type;
    HitType hitCount;

    String description;

    Attack(String d) {
        this.description = d;
        Random rand = new Random();
        this.damge = (1 + rand.nextInt(20));
        this.mpCost = (1 + rand.nextInt(20));
        SkillType[] types = SkillType.values();
        this.type = types[rand.nextInt(types.length)];

        HitType[] hits = HitType.values();
        this.hitCount = hits[rand.nextInt(hits.length)];
    }
}

class Equipment {

    String weapon;
    String armor;
    String accessory1;
    String accessory2;

    Equipment(String w, String a, String ac1, String ac2) {
        this.weapon = w;
        this.armor = a;
        this.accessory1 = ac1;
        this.accessory2 = ac2;
    }
}
