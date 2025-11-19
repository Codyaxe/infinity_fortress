package com.infinityfortress.actions.range;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class Multishot implements Action {
    private String message;

    public String getName() {
        return "Multishot";
    }

    public Multishot() {
    }

    public int getHitCount() {
        return 2;
    }

    public int getManaCost() {
        return 4;
    }

    public int getBaseDamage() {
        return 6;
    }

    public String getStatDescription() {
        return "Shoots 2 arrows at once, each dealing 6 base damage.";
    }

    public String getBattleDescription() {
        return "Fires multiple arrows simultaneously.";
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
