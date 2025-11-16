package com.infinityfortress.actions.heal;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Heal;

public class HealAll implements Action {

    public String getName() {
        return "Heal All";
    }

    public HealAll() {
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
        return "Healing for everyone!!!";
    };

    public String getBattleDescription() {
        return "Heals all allies by a good amount.";
    };

    public String getBattleMessage() {
        return "All allies were healed by a good amount.";
    };

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ALLIES;
    }

    public ActionType getActionType() {
        return ActionType.HEAL;
    };

    public void execute(NCharacter user, NCharacter target) {
        Heal heal = new Heal();
        heal.execute(user, target);
    };
}
