package com.infinityfortress.actions.range;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class Barrage implements Action {
    private String message;

    public String getName() {
        return "Barrage";
    }

    public Barrage() {
    }

    public int getHitCount() {
        return 5;
    }

    public int getManaCost() {
        return 8;
    }

    public int getBaseDamage() {
        return 3;
    }

    public String getStatDescription() {
        return "Unleashes a barrage of 5 arrows, each dealing 3 base damage.";
    }

    public String getBattleDescription() {
        return "Overwhelms the enemy with a storm of arrows.";
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
