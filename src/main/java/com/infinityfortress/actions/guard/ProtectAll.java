package com.infinityfortress.actions.guard;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;;

public class ProtectAll implements Action {

    public String getName() {
        return "Protect All";
    }

    public ProtectAll() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 15;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getStatDescription() {
        return "ALL PROTECTION. Fill me STAT";
    };

    public String getBattleDescription() {
        return "ALL DESCRIPTION Fill me BATTLE";
    };

    public String getBattleMessage() {
        return "Protection is applied to all allies.";
    };

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ALLIES;
    }

    public ActionType getActionType() {
        return ActionType.PROTECTION;
    };

    public void execute(NCharacter user, NCharacter target) {
        Protect protect = new Protect();
        protect.execute(user, target);
    };
}
