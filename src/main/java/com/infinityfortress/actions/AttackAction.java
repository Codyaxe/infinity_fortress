package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public class AttackAction implements Action {
    private int hitCount;

    public AttackAction() {
        this.hitCount = 1;
    }

    public int getHitCount() {
        return hitCount;
    }

    public String getName() {
        return "Attack";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(NCharacter user, NCharacter target) {
        // Deal normal damage to a target
    };
}
