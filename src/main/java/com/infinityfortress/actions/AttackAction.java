package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public class AttackAction implements Action {
    private String message;

    public String getName() {
        return "Attack";
    }

    public AttackAction() {
    }

    public int getHitCount() {
        return 1;
    }

    public int getManaCost() {
        return 0;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getStatDescription() {
        return "Attack Stat Description";
    };

    public String getBattleDescription() {
        return "Attack Battle Description";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.GENERIC;
    };

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(NCharacter user, NCharacter target) {
        // Deal normal damage to a target
    };
}
