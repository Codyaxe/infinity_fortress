package com.infinityfortress.actions.power;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class DeepCut implements Action {

    private String message;

    public String getName() {
        return "Deep Cut";
    }

    public DeepCut() {
    }

    public int getHitCount() {
        return 1;
    }

    public int getManaCost() {
        return 7;
    };

    public int getBaseDamage() {
        return 5;
    };

    public String getStatDescription() {
        return "A great technique that inflicts good damage to your foe.";
    };

    public String getBattleDescription() {
        return "A good damaging attack.";
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
        int totalDamage = (int) (this.getBaseDamage() + user.getStrength() * 1.5);
        message = Utils.processDamage(user, target, totalDamage);
    };
}
