package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.TemporaryEffect;

public class ProtectOne implements Action {

    private int hitCount;

    public String getName() {
        return "Protect One";
    }

    public ProtectOne() {
        this.hitCount = 0;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getManaCost() {
        return 0;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getActionType() {
        return "Protection";
    };

    public String getDescription() {
        return "Just a Protection";
    };

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public void execute(NCharacter user, NCharacter target) {

        TemporaryEffect protectEffect = new TemporaryEffect(5, target) {
            @Override
            public void apply() {
                this.target.setDefense(this.target.getDefense() + 50);
            }

            @Override
            public void remove() {
                this.target.setDefense(this.target.getDefense() - 50);
            }

            @Override
            public String getName() {
                return "Protect";
            }
        };

        protectEffect.apply();
        target.addTemporaryEffect(protectEffect);
    };
}
