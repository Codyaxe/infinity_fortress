package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;

public class Heal {
    public void execute(NCharacter user, NCharacter target) {
        int healValue = target.getHealth() + 10;
        if (healValue <= target.getMaxHealth()) {
            target.setHealth(healValue);
        } else {
            target.setHealth(target.getMaxHealth());
        }

    };
}
