package com.infinityfortress.actions.power;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.TemporaryEffect;

public class Enrage implements Action {

    private String message;

    public String getName() {
        return "Enrage";
    }

    public Enrage() {
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
        return "A utility tool that enhances its user's strength by 5.";
    };

    public String getBattleDescription() {
        return "Raises the user's strength by 5.";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SELF;
    }

    public ActionType getActionType() {
        return ActionType.UTILITY;
    };

    public void execute(NCharacter user, NCharacter target) {
        TemporaryEffect protectEffect = new TemporaryEffect(5, target) {
            @Override
            public void apply() {
                this.target.setStrength(this.target.getStrength() + 5);
            }

            @Override
            public void remove() {
                this.target.setStrength(this.target.getStrength() - 5);
            }

            @Override
            public String getName() {
                return "Rage";
            }
        };

        if (user == target) {
            protectEffect.setJustApplied(false);
        }

        protectEffect.apply();
        target.addTemporaryEffect(protectEffect);
        message = String.format("%s gains Rage.", user.getName());
    };
}
