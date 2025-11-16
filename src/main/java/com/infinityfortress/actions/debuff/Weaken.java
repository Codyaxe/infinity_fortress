package com.infinityfortress.actions.debuff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.WeakenEffect;

public class Weaken implements Action {
    private String message;

    public String getName() {
        return "Weaken";
    }

    public Weaken() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 5;
    }

    public int getBaseDamage() {
        return 0;
    }

    public String getStatDescription() {
        return "Reduces the target's strength by 4 for 5 turns.";
    }

    public String getBattleDescription() {
        return "Weakens the target's physical power.";
    }

    public String getBattleMessage() {
        return message;
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.UTILITY;
    }

    public void execute(NCharacter user, NCharacter target) {
        WeakenEffect weakenEffect = new WeakenEffect(5, target);

        weakenEffect.apply();
        target.addTemporaryEffect(weakenEffect);
        message = String.format("%s is weakened!", target.getName());
    }
}
