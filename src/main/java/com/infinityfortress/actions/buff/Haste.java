package com.infinityfortress.actions.buff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.HasteEffect;

public class Haste implements Action {

    private String message;

    public String getName() {
        return "Haste";
    }

    public Haste() {
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
        return "Increases the user speed and moving them up the queue.";
    };

    public String getBattleDescription() {
        return "Gives a user speed.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public ActionType getActionType() {
        return ActionType.SPEED;
    };

    public void execute(NCharacter user, NCharacter target) {
        HasteEffect hasteEffect = new HasteEffect(5, target);

        hasteEffect.apply();
        target.addTemporaryEffect(hasteEffect);
        if (user == target) {
            message = "Haste is applied to himself.";
            hasteEffect.setJustApplied(false);
        } else {
            message = String.format("Haste is applied to %s.", target.getName());
        }

    };
}
