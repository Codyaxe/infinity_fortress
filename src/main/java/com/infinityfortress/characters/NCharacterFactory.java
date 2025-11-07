package com.infinityfortress.characters;

import com.infinityfortress.roles.Mage;
import com.infinityfortress.races.Human;;

public class NCharacterFactory {
    public NCharacter createHumanMage() {
        return new NCharacter(new Mage(), new Human());
    }
}
