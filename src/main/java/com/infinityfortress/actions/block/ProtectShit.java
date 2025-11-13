package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;

public class ProtectShit implements Action {

    private int hitCount;

    public String getName() {
        return "Protect Shit";
    }

    public ProtectShit() {
        this.hitCount = 0;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getManaCost() {
        return 0;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getActionType() {
        return "Protection";
    };

    public String getStatDescription() {
        return "Shitty Protection";
    };

    public String getBattleDescription() {
        return "This shitty protection spell will shit the X";
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public void execute(NCharacter user, NCharacter target) {
        // WHY WOULD YOU PROTECT AN ENEMY???
        ProtectOne protectOne = new ProtectOne();
        protectOne.execute(user, target);
    };
}
