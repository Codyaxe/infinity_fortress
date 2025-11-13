package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public class AttackAction implements Action {
    private int hitCount;

    public String getName() {
        return "Attack";
    }

    public AttackAction() {
        this.hitCount = 1;
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
        return "Generic";
    };

    public String getStatDescription() {
        return "Generic Stat Description";
    };

    public String getBattleDescription() {
        return "Generic Battle Description";
    };

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
