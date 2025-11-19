package com.infinityfortress.actions.buff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Restoration;

public class Restore implements Action {

    private String message;

    public String getName() {
        return "Restore";
    }

    public Restore() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 5;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getStatDescription() {
        return "Gives an ally more MP, meaning more special spam.";
    };

    public String getBattleDescription() {
        return "Gives an ally 10 MP.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public ActionType getActionType() {
        return ActionType.RESTORATION;
    };

    public void execute(NCharacter user, NCharacter target) {
        Restoration restoration = new Restoration();
        int manaRestored = restoration.execute(user, target);
        message = String.format("%s's mana is restored by an amount %s", target.getName(), manaRestored);
    };
}
