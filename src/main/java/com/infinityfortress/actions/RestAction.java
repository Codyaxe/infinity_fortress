package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public class RestAction implements Action {
    private String message;

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

    public String getStatDescription() {
        return "Block Stat Description";
    };

    public String getBattleDescription() {
        return "Block Battle Description";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SELF;
    }

    public ActionType getActionType() {
        return ActionType.GENERIC;
    };

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(NCharacter user, NCharacter target) {
        int manaValue = user.getMana() + 5;
        if (manaValue <= user.getMaxMana()) {
            user.setMana(manaValue);
        } else {
            user.setMana(user.getMaxMana());
        }

        message = String.format("%s rested.", user.getName());
    };
}
