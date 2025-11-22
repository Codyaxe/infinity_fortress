package com.infinityfortress;

import java.util.ArrayList;
import java.util.Arrays;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterFactory;
import com.infinityfortress.characters.NCharacterType;

public class Enemy {
    public ArrayList<NCharacter> characters = new ArrayList<>(Arrays.asList(null, null, null, null, null));

    public Enemy() {
        // Generate random number of characters (1-5)

        // Random rand = new Random();
        // int numCharacters = 1 + rand.nextInt(5); // 1-5 characters

        NCharacterFactory factory = new NCharacterFactory();

        characters.set(0, factory.createDwarfTank(NCharacterType.ENEMY));
        characters.set(1, factory.createBeastkinRogue(NCharacterType.ENEMY));
        characters.set(2, factory.createDragonbornSummoner(NCharacterType.ENEMY));
        characters.set(3, factory.createDwarfWarrior(NCharacterType.ENEMY));
        characters.set(4, factory.createOrcWarlock(NCharacterType.ENEMY));
    }

}