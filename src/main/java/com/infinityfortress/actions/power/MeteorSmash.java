package com.infinityfortress.actions.power;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;

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
        return 100;
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
        int damageValue = this.getBaseDamage() + 2 * user.getStrength();
        target.setHealth(target.getHealth() - damageValue);
        message = String.format("%s dealt %s damage to %s.", user.getName(), damageValue, target.getName());
    };
}
