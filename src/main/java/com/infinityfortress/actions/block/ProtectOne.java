package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.TemporaryEffect;

public class ProtectOne implements Action {
    public String getName() {
        return "Protect One";
    }

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
