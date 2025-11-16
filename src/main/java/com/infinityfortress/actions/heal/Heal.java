package com.infinityfortress.actions.heal;

import com.infinityfortress.characters.NCharacter;

public class Heal {
    public void execute(NCharacter user, NCharacter target) {
        int healValue = target.getHealth() + 10;
        if (healValue <= user.getMaxHealth()) {
            target.setHealth(healValue);
        } else {
            target.setHealth(target.getMaxHealth());
        }

    };
}
