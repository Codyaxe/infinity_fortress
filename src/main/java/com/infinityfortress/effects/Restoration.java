package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;

public class Restoration {
    public int execute(NCharacter user, NCharacter target) {
        int manaRestoreValue = target.getMana() + 10;

        if (manaRestoreValue <= target.getMaxMana()) {
            target.setMana(manaRestoreValue);
        } else {
            target.setMana(target.getMaxMana());
        }

        return 10;
    }
}
