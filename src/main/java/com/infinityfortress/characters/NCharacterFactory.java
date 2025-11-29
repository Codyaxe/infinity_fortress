package com.infinityfortress.characters;

import com.infinityfortress.roles.*;
import com.infinityfortress.races.*;
import java.util.Random;
import java.lang.reflect.Method;


public class NCharacterFactory {

    private static final Random random = new Random();

    // Based to sa stats dun sa ating table

    public NCharacter createBeastkinWarrior(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 3, 7, 3,
                20, 5, 6, new Warrior(), new Beastkin());
    }

    public NCharacter createBeastkinArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Beastkin());
    }

    public NCharacter createBeastkinMage(NCharacterType type) {
        return new NCharacter(type, 20, 100, 0, 1, 5, 2,
                20, 5, 5, new Mage(), new Beastkin());
    }

    public NCharacter createBeastkinTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Beastkin());
    }

    public NCharacter createBeastkinRogue(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 3, 5, 5,
                20, 5, 15, new Rogue(), new Beastkin());
    }

    public NCharacter createBeastkinHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Beastkin());
    }

    public NCharacter createBeastkinSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 3, 5, 4,
                20, 5, 10, new Summoner(), new Beastkin());
    }

    public NCharacter createBeastkinCleric(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Cleric(), new Beastkin());
    }

    public NCharacter createBeastkinWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Beastkin());
    }

    public NCharacter createDemonWarrior(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 3, 7, 3,
                20, 5, 6, new Warrior(), new Demon());
    }

    public NCharacter createDemonArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Demon());
    }

    public NCharacter createDemonMage(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 2, 10, 3,
                20, 7, 5, new Mage(), new Demon());
    }

    public NCharacter createDemonTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Demon());
    }

    public NCharacter createDemonRogue(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 3, 5, 5,
                20, 5, 15, new Rogue(), new Demon());
    }

    public NCharacter createDemonHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Demon());
    }

    public NCharacter createDemonSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Demon());
    }

    public NCharacter createDemonCleric(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Cleric(), new Demon());
    }

    public NCharacter createDemonWarlock(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Warlock(), new Demon());
    }

    public NCharacter createDragonbornWarrior(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 5, 8, 5,
                20, 7, 7, new Warrior(), new Dragonborn());
    }

    public NCharacter createDragonbornArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Dragonborn());
    }

    public NCharacter createDragonbornMage(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 2, 10, 3,
                20, 7, 5, new Mage(), new Dragonborn());
    }

    public NCharacter createDragonbornTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Dragonborn());
    }

    public NCharacter createDragonbornRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Dragonborn());
    }

    public NCharacter createDragonbornHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Dragonborn());
    }

    public NCharacter createDragonbornSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 3, 5, 4,
                20, 5, 10, new Summoner(), new Dragonborn());
    }

    public NCharacter createDragonbornCleric(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Cleric(), new Dragonborn());
    }

    public NCharacter createDragonbornWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Dragonborn());
    }

    public NCharacter createDwarfWarrior(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 5, 8, 5,
                20, 7, 7, new Warrior(), new Dwarf());
    }

    public NCharacter createDwarfArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Dwarf());
    }

    public NCharacter createDwarfMage(NCharacterType type) {
        return new NCharacter(type, 20, 100, 0, 1, 5, 2,
                20, 5, 5, new Mage(), new Dwarf());
    }

    public NCharacter createDwarfTank(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 15, 3, 4,
                20, 5, 5, new Tank(), new Dwarf());
    }

    public NCharacter createDwarfRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Dwarf());
    }

    public NCharacter createDwarfHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Dwarf());
    }

    public NCharacter createDwarfSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Dwarf());
    }

    public NCharacter createDwarfCleric(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Cleric(), new Dwarf());
    }

    public NCharacter createDwarfWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Dwarf());
    }

    public NCharacter createElfWarrior(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 3, 7, 3,
                20, 5, 6, new Warrior(), new Elf());
    }

    public NCharacter createElfArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 3, 5, 5,
                25, 10, 7, new Archer(), new Elf());
    }

    public NCharacter createElfMage(NCharacterType type) {
        return new NCharacter(type, 20, 100, 0, 1, 5, 2,
                20, 5, 5, new Mage(), new Elf());
    }

    public NCharacter createElfTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Elf());
    }

    public NCharacter createElfRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Elf());
    }

    public NCharacter createElfHealer(NCharacterType type) {
        return new NCharacter(type, 40, 60, 0, 2, 10, 3,
                15, 5, 15, new Healer(), new Elf());
    }

    public NCharacter createElfSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Elf());
    }

    public NCharacter createElfCleric(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Cleric(), new Elf());
    }

    public NCharacter createElfWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Elf());
    }

    public NCharacter createHumanWarrior(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 5, 8, 5,
                20, 7, 7, new Warrior(), new Human());
    }

    public NCharacter createHumanArcher(NCharacterType type) {
        return new NCharacter(type, 30, 20, 0, 3, 5, 5,
                25, 10, 7, new Archer(), new Human());
    }

    public NCharacter createHumanMage(NCharacterType type) {
        return new NCharacter(type, 20, 100, 0, 1, 5, 2,
                20, 5, 5, new Mage(), new Human());
    }

    public NCharacter createHumanTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Human());
    }

    public NCharacter createHumanRogue(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 3, 5, 5,
                20, 5, 15, new Rogue(), new Human());
    }

    public NCharacter createHumanHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Human());
    }

    public NCharacter createHumanSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Human());
    }

    public NCharacter createHumanCleric(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Cleric(), new Human());
    }

    public NCharacter createHumanWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Human());
    }

    public NCharacter createNephilimWarrior(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 3, 7, 3,
                20, 5, 6, new Warrior(), new Nephilim());
    }

    public NCharacter createNephilimArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Nephilim());
    }

    public NCharacter createNephilimMage(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 2, 10, 3,
                20, 7, 5, new Mage(), new Nephilim());
    }

    public NCharacter createNephilimTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Nephilim());
    }

    public NCharacter createNephilimRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Nephilim());
    }

    public NCharacter createNephilimHealer(NCharacterType type) {
        return new NCharacter(type, 40, 60, 0, 2, 10, 3,
                15, 5, 15, new Healer(), new Nephilim());
    }

    public NCharacter createNephilimSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Nephilim());
    }

    public NCharacter createNephilimCleric(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Cleric(), new Nephilim());
    }

    public NCharacter createNephilimWarlock(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Warlock(), new Nephilim());
    }

    public NCharacter createOrcWarrior(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 5, 8, 5,
                20, 7, 7, new Warrior(), new Orc());
    }

    public NCharacter createOrcArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Orc());
    }

    public NCharacter createOrcMage(NCharacterType type) {
        return new NCharacter(type, 20, 100, 0, 1, 5, 2,
                20, 5, 5, new Mage(), new Orc());
    }

    public NCharacter createOrcTank(NCharacterType type) {
        return new NCharacter(type, 50, 30, 0, 15, 3, 4,
                20, 5, 5, new Tank(), new Orc());
    }

    public NCharacter createOrcRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Orc());
    }

    public NCharacter createOrcHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Orc());
    }

    public NCharacter createOrcSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Orc());
    }

    public NCharacter createOrcCleric(NCharacterType type) {
        return new NCharacter(type, 20, 40, 0, 2, 5, 2,
                20, 5, 10, new Cleric(), new Orc());
    }

    public NCharacter createOrcWarlock(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Warlock(), new Orc());
    }

    public NCharacter createSpiritbornWarrior(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 3, 7, 3,
                20, 5, 6, new Warrior(), new Spiritborn());
    }

    public NCharacter createSpiritbornArcher(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 5, 3,
                25, 5, 5, new Archer(), new Spiritborn());
    }

    public NCharacter createSpiritbornMage(NCharacterType type) {
        return new NCharacter(type, 30, 100, 0, 2, 10, 3,
                20, 7, 5, new Mage(), new Spiritborn());
    }

    public NCharacter createSpiritbornTank(NCharacterType type) {
        return new NCharacter(type, 30, 30, 0, 10, 2, 2,
                20, 5, 5, new Tank(), new Spiritborn());
    }

    public NCharacter createSpiritbornRogue(NCharacterType type) {
        return new NCharacter(type, 20, 30, 0, 2, 3, 5,
                20, 5, 10, new Rogue(), new Spiritborn());
    }

    public NCharacter createSpiritbornHealer(NCharacterType type) {
        return new NCharacter(type, 30, 40, 0, 1, 10, 2,
                15, 5, 10, new Healer(), new Spiritborn());
    }

    public NCharacter createSpiritbornSummoner(NCharacterType type) {
        return new NCharacter(type, 30, 50, 0, 3, 3, 4,
                20, 5, 7, new Summoner(), new Spiritborn());
    }

    public NCharacter createSpiritbornCleric(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Cleric(), new Spiritborn());
    }

    public NCharacter createSpiritbornWarlock(NCharacterType type) {
        return new NCharacter(type, 40, 50, 0, 2, 5, 4,
                20, 5, 15, new Warlock(), new Spiritborn());
    }

    /**
     * Creates a random character with a random race and role combination
     * @param type The character type (PLAYER, ENEMY, NPC, etc.)
     * @return A randomly generated NCharacter
     */
    public NCharacter createRandomCharacter(NCharacterType type) {
        // All available races
        String[] races = {"Beastkin", "Demon", "Dragonborn", "Dwarf", "Elf", "Human", "Nephilim", "Orc", "Spiritborn"};
        
        // All available roles
        String[] roles = {"Warrior", "Archer", "Mage", "Tank", "Rogue", "Healer", "Summoner", "Cleric", "Warlock"};
        
        // Pick random race and role
        String randomRace = races[random.nextInt(races.length)];
        String randomRole = roles[random.nextInt(roles.length)];
        
        // Create method name and invoke the corresponding creation method
        String methodName = "create" + randomRace + randomRole;
        
        try {
            // Use reflection to call the appropriate method
            Method method = this.getClass().getMethod(methodName, NCharacterType.class);
            return (NCharacter) method.invoke(this, type);
        } catch (Exception e) {
            // Fallback to a default character if reflection fails
            System.out.println("Error creating random character: " + e.getMessage());
            return createHumanWarrior(type);
        }
    }
}