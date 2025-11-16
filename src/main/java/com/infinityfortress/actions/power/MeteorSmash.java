package com.infinityfortress.actions.power;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class MeteorSmash implements Action {

    private String message;

    public String getName() {
        return "Meteor Smash";
    }

    public MeteorSmash() {
    }

    public int getHitCount() {
        return 1;
    }

    public int getManaCost() {
        return 15;
    };

    public int getBaseDamage() {
        return 10;
    };

    public String getStatDescription() {
        return "A expensive attack but a powerful one.";
    };

    public String getBattleDescription() {
        return "A very damaging attack.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.DAMAGE;
    };

    public void execute(NCharacter user, NCharacter target) {
        int totalDamage = this.getBaseDamage() + 2 * user.getStrength();
        message = Utils.processDamage(user, target, totalDamage);
    };
}
