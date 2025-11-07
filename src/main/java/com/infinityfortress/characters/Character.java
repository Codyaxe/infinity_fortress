package com.infinityfortress.characters;

import com.infinityfortress.classes.CharacterClass;
import com.infinityfortress.races.Race;

public class Character {
    // Addtional attibutes
    private CharacterClass characterClass;
    private Race race;

    public Character(CharacterClass c, Race r) {
        // Additional attibutes
        this.characterClass = c;
        this.race = r;

    }
}
