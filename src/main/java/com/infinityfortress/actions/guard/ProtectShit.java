package com.infinityfortress.actions.guard;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Protect;

public class ProtectShit implements Action {

    private String message;

    public String getName() {
        return "Protect Shit";
    }

    public ProtectShit() {
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
        return "Shitty Protection";
    };

    public String getBattleDescription() {
        return "This shitty protection spell will shit the X";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.PROTECTION;
    };

    public void execute(NCharacter user, NCharacter target) {
        // WHY WOULD YOU PROTECT AN ENEMY???
        Protect protect = new Protect();
        protect.execute(user, target);
        message = String.format("Protection is applied to %s.", target.getName());
    };
}
