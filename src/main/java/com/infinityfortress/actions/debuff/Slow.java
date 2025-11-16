package com.infinityfortress.actions.debuff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.SlowEffect;

public class Slow implements Action {
    private String message;

    public String getName() {
        return "Slow";
    }

    public Slow() {
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
        return "Reduces the target's speed by 3 for 5 turns.";
    }

    public String getBattleDescription() {
        return "Slows down the target.";
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
        SlowEffect slowEffect = new SlowEffect(5, target);

        slowEffect.apply();
        target.addTemporaryEffect(slowEffect);
        message = String.format("%s is slowed!", target.getName());
    }
}
