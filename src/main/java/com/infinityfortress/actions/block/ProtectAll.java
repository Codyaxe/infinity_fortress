package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;;

public class ProtectAll implements Action {

    private int hitCount;

    public String getName() {
        return "Protect All";
    }

    public ProtectAll() {
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

    public String getDescription() {
        return "Just a Protection";
    };

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ALLIES;
    }

    public void execute(NCharacter user, NCharacter target) {
        ProtectOne protectOne = new ProtectOne();
        protectOne.execute(user, target);
    };
}
