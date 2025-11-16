package com.infinityfortress.actions.range;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class RapidShot implements Action {
    private String message;

    public String getName() {
        return "Rapid Shot";
    }

    public RapidShot() {
    }

    public int getHitCount() {
        return 3;
    }

    public int getManaCost() {
        return 5;
    }

    public int getBaseDamage() {
        return 4;
    }

    public String getStatDescription() {
        return "Fires 3 rapid arrows, each dealing 4 base damage.";
    }

    public String getBattleDescription() {
        return "Unleashes a flurry of arrows.";
    }

    public String getBattleMessage() {
        return message;
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.DAMAGE;
    }

    public void execute(NCharacter user, NCharacter target) {
        StringBuilder msg = new StringBuilder();
        for (int i = 0; i < getHitCount(); i++) {
            int damage = getBaseDamage() + (user.getStrength());
            msg.append(Utils.processDamage(user, target, damage));
            if (i < getHitCount() - 1)
                msg.append(" ");
        }
        message = msg.toString();
    }
}
