package com.infinityfortress.actions.buff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.SavageEffect;

public class Savage implements Action {

    private String message;

    public String getName() {
        return "Savage";
    }

    public Savage() {
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
        return "Makes your ally feral, increasing their critical hit chance and critical strength.";
    };

    public String getBattleDescription() {
        return "Increases an ally critical hit chance and critical strength.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public ActionType getActionType() {
        return ActionType.CRITICAL;
    };

    public void execute(NCharacter user, NCharacter target) {
        SavageEffect savageEffect = new SavageEffect(5, target);

        savageEffect.apply();
        target.addTemporaryEffect(savageEffect);
        if (user == target) {
            message = "Savage is applied to himself.";
            savageEffect.setJustApplied(false);
        } else {
            message = String.format("Savage is applied to %s.", target.getName());
        }

    };
}
