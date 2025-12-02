package com.infinityfortress.pools;

import java.util.ArrayList;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterFactory;
import com.infinityfortress.characters.NCharacterType;
import java.util.Random;
//! Most of these Utility methods won't be used, but they're here juse in case

public class CharacterPool {
    private static final NCharacterFactory factory = new NCharacterFactory();
    
    /**
     * Returns all available characters
     * @return ArrayList of all characters
     */
    public static ArrayList<NCharacter> getAllCharacters() {
        ArrayList<NCharacter> characters = new ArrayList<>();
        
        // Beastkin characters
        characters.add(factory.createBeastkinWarrior(NCharacterType.ALLY));
        characters.add(factory.createBeastkinArcher(NCharacterType.ALLY));
        characters.add(factory.createBeastkinMage(NCharacterType.ALLY));
        characters.add(factory.createBeastkinTank(NCharacterType.ALLY));
        characters.add(factory.createBeastkinRogue(NCharacterType.ALLY));
        characters.add(factory.createBeastkinHealer(NCharacterType.ALLY));
        characters.add(factory.createBeastkinSummoner(NCharacterType.ALLY));
        characters.add(factory.createBeastkinCleric(NCharacterType.ALLY));
        characters.add(factory.createBeastkinWarlock(NCharacterType.ALLY));
        
        // Demon characters
        characters.add(factory.createDemonWarrior(NCharacterType.ALLY));
        characters.add(factory.createDemonArcher(NCharacterType.ALLY));
        characters.add(factory.createDemonMage(NCharacterType.ALLY));
        characters.add(factory.createDemonTank(NCharacterType.ALLY));
        characters.add(factory.createDemonRogue(NCharacterType.ALLY));
        characters.add(factory.createDemonHealer(NCharacterType.ALLY));
        characters.add(factory.createDemonSummoner(NCharacterType.ALLY));
        characters.add(factory.createDemonCleric(NCharacterType.ALLY));
        characters.add(factory.createDemonWarlock(NCharacterType.ALLY));
        
        // Dragonborn characters
        characters.add(factory.createDragonbornWarrior(NCharacterType.ALLY));
        characters.add(factory.createDragonbornArcher(NCharacterType.ALLY));
        characters.add(factory.createDragonbornMage(NCharacterType.ALLY));
        characters.add(factory.createDragonbornTank(NCharacterType.ALLY));
        characters.add(factory.createDragonbornRogue(NCharacterType.ALLY));
        characters.add(factory.createDragonbornHealer(NCharacterType.ALLY));
        characters.add(factory.createDragonbornSummoner(NCharacterType.ALLY));
        characters.add(factory.createDragonbornCleric(NCharacterType.ALLY));
        characters.add(factory.createDragonbornWarlock(NCharacterType.ALLY));
        
        // Dwarf characters
        characters.add(factory.createDwarfWarrior(NCharacterType.ALLY));
        characters.add(factory.createDwarfArcher(NCharacterType.ALLY));
        characters.add(factory.createDwarfMage(NCharacterType.ALLY));
        characters.add(factory.createDwarfTank(NCharacterType.ALLY));
        characters.add(factory.createDwarfRogue(NCharacterType.ALLY));
        characters.add(factory.createDwarfHealer(NCharacterType.ALLY));
        characters.add(factory.createDwarfSummoner(NCharacterType.ALLY));
        characters.add(factory.createDwarfCleric(NCharacterType.ALLY));
        characters.add(factory.createDwarfWarlock(NCharacterType.ALLY));
        
        // Elf characters
        characters.add(factory.createElfWarrior(NCharacterType.ALLY));
        characters.add(factory.createElfArcher(NCharacterType.ALLY));
        characters.add(factory.createElfMage(NCharacterType.ALLY));
        characters.add(factory.createElfTank(NCharacterType.ALLY));
        characters.add(factory.createElfRogue(NCharacterType.ALLY));
        characters.add(factory.createElfHealer(NCharacterType.ALLY));
        characters.add(factory.createElfSummoner(NCharacterType.ALLY));
        characters.add(factory.createElfCleric(NCharacterType.ALLY));
        characters.add(factory.createElfWarlock(NCharacterType.ALLY));
        
        // Human characters
        characters.add(factory.createHumanWarrior(NCharacterType.ALLY));
        characters.add(factory.createHumanArcher(NCharacterType.ALLY));
        characters.add(factory.createHumanMage(NCharacterType.ALLY));
        characters.add(factory.createHumanTank(NCharacterType.ALLY));
        characters.add(factory.createHumanRogue(NCharacterType.ALLY));
        characters.add(factory.createHumanHealer(NCharacterType.ALLY));
        characters.add(factory.createHumanSummoner(NCharacterType.ALLY));
        characters.add(factory.createHumanCleric(NCharacterType.ALLY));
        characters.add(factory.createHumanWarlock(NCharacterType.ALLY));
        
        // Nephilim characters
        characters.add(factory.createNephilimWarrior(NCharacterType.ALLY));
        characters.add(factory.createNephilimArcher(NCharacterType.ALLY));
        characters.add(factory.createNephilimMage(NCharacterType.ALLY));
        characters.add(factory.createNephilimTank(NCharacterType.ALLY));
        characters.add(factory.createNephilimRogue(NCharacterType.ALLY));
        characters.add(factory.createNephilimHealer(NCharacterType.ALLY));
        characters.add(factory.createNephilimSummoner(NCharacterType.ALLY));
        characters.add(factory.createNephilimCleric(NCharacterType.ALLY));
        characters.add(factory.createNephilimWarlock(NCharacterType.ALLY));
        
        // Orc characters
        characters.add(factory.createOrcWarrior(NCharacterType.ALLY));
        characters.add(factory.createOrcArcher(NCharacterType.ALLY));
        characters.add(factory.createOrcMage(NCharacterType.ALLY));
        characters.add(factory.createOrcTank(NCharacterType.ALLY));
        characters.add(factory.createOrcRogue(NCharacterType.ALLY));
        characters.add(factory.createOrcHealer(NCharacterType.ALLY));
        characters.add(factory.createOrcSummoner(NCharacterType.ALLY));
        characters.add(factory.createOrcCleric(NCharacterType.ALLY));
        characters.add(factory.createOrcWarlock(NCharacterType.ALLY));
        
        // Spiritborn characters
        characters.add(factory.createSpiritbornWarrior(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornArcher(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornMage(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornTank(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornRogue(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornHealer(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornSummoner(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornCleric(NCharacterType.ALLY));
        characters.add(factory.createSpiritbornWarlock(NCharacterType.ALLY));
        
        return characters;
    }

    /**
     * Creates a random character
     * @param type The character type (ALLY, ENEMY)
     * @return A randomly generated NCharacter
     */
    public static NCharacter createRandomCharacter(NCharacterType type) {
        ArrayList<NCharacter> allChars = getAllCharacters();
        if (allChars.isEmpty()) {
            System.out.println("No characters available in pool.");
            return null;
        }
        Random random = new Random();
        return allChars.get(random.nextInt(allChars.size()));
    }

    public static ArrayList<NCharacter> getSpecializedCharacters() {
      return new ArrayList<>(getAllCharacters().stream().filter(c -> c.isSpecialized()).toList());
    }
    
    public static ArrayList<NCharacter> getNonSpecializedCharacters() {
        return new ArrayList<>(getAllCharacters().stream().filter(c -> !c.isSpecialized()).toList());
    }

    public static NCharacter getRandomSpecializedCharacters() {
        ArrayList<NCharacter> allChars = getSpecializedCharacters();
        Random random = new Random();
        return allChars.get(random.nextInt(allChars.size()));
    }

    public static NCharacter getRandomNonSpecializedCharacters() {
        ArrayList<NCharacter> allChars = getNonSpecializedCharacters();
        Random random = new Random();
        return allChars.get(random.nextInt(allChars.size()));
    }
  }
