package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public class RestAction implements Action {

    public String getName() {
        return "Rest";
    }

    public RestAction() {
    }

    public int getHitCount() {
        return 0;
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
        return "Block Stat Description";
    };

    public String getBattleDescription() {
        return "Block Battle Description";
    };

    public TargetingType getTargetingType() {
        return TargetingType.SELF;
    }

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(NCharacter user, NCharacter target) {
        // End Turn Restore MP?
    };
}
