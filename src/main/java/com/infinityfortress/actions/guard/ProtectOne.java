package com.infinityfortress.actions.guard;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Protect;

public class ProtectOne implements Action {

    private String message;

    public String getName() {
        return "Protect One";
    }

    public ProtectOne() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 3;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getStatDescription() {
        return "Just a Protection. Fill me STAT";
    };

    public String getBattleDescription() {
        return "Just a Protection. Fill me BATTLE";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public ActionType getActionType() {
        return ActionType.PROTECTION;
    };

    public void execute(NCharacter user, NCharacter target) {
        Protect protect = new Protect();
        protect.execute(user, target);
        if (user == target) {
            message = "Protection is applied to himself.";
        } else {
            message = String.format("Protection is applied to %s.", target.getName());
        }

    };
}
