package com.infinityfortress.characters;

import com.infinityfortress.roles.Mage;
import com.infinityfortress.races.Human;;

public class CharacterFactory {
    public Character createHumanMage() {
        return new Character(new Mage(), new Human());
    }
}
