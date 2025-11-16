package com.infinityfortress;

import java.util.ArrayList;
import java.util.Arrays;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterFactory;
import com.infinityfortress.characters.NCharacterType;

public class Player {
    public ArrayList<NCharacter> characters = new ArrayList<>(Arrays.asList(null, null, null, null, null));

    public Player() {
        // Generate random number of characters (1-5)

        // Random rand = new Random();
        // int numCharacters = 1 + rand.nextInt(5); // 1-5 characters

        NCharacterFactory factory = new NCharacterFactory();

        characters.set(0, factory.createDemonWarlock(NCharacterType.ALLY));
        characters.set(1, factory.createHumanCleric(NCharacterType.ALLY));
        characters.set(2, factory.createDragonbornMage(NCharacterType.ALLY));
        characters.set(3, factory.createBeastkinArcher(NCharacterType.ALLY));
        characters.set(4, factory.createBeastkinSummoner(NCharacterType.ALLY));

    }
}