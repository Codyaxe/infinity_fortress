package com.infinityfortress.actions.heal;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Heal;

public class HealOne implements Action {

    private String message;

    public String getName() {
        return "Heal One";
    }

    public HealOne() {
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
        return "Heals an injured ally for a good amount. Not effective at healing dead allies.";
    };

    public String getBattleDescription() {
        return "Heals an ally for a good amount.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public ActionType getActionType() {
        return ActionType.HEAL;
    };

    public void execute(NCharacter user, NCharacter target) {
        Heal heal = new Heal();
        heal.execute(user, target);
        message = String.format("%s heals %s by amount %s.", user.getName(), target.getName(), 10);
    };
}
