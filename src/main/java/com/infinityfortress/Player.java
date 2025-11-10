package com.infinityfortress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Player {
    ArrayList<Character> characters = new ArrayList<>(Arrays.asList(null, null, null, null, null));

    public Player() {
        // Generate random number of characters (1-5)
        Random rand = new Random();
        int numCharacters = 1 + rand.nextInt(5); // 1-5 characters
        
        for (int i = 0; i < numCharacters; i++) {
            characters.set(i, new Character("Ally"));
        } 
    }
}