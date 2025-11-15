package com.infinityfortress.actions.heal;

import com.infinityfortress.characters.NCharacter;

public class Heal {
    public void execute(NCharacter user, NCharacter target) {
        int healValue = 10;
        if (healValue <= user.getMaxHealth()) {
            user.setMana(healValue);
        } else {
            user.setMana(user.getMaxHealth());
        }
        target.setHealth(target.getHealth() - healValue);
    };
}
