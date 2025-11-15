package com.infinityfortress.actions.guard;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.TemporaryEffect;

public class Protect {
    public void execute(NCharacter user, NCharacter target) {
        TemporaryEffect protectEffect = new TemporaryEffect(1, target) {
            @Override
            public void apply() {
                this.target.setDefense(this.target.getDefense() + 4);
            }

            @Override
            public void remove() {
                this.target.setDefense(this.target.getDefense() - 4);
            }

            @Override
            public String getName() {
                return "Protect";
            }
        };

        // If the user target themselves, this flag is not set.
        if (user == target) {
            protectEffect.setJustApplied(false);
        }

        protectEffect.apply();
        target.addTemporaryEffect(protectEffect);
    }
}
