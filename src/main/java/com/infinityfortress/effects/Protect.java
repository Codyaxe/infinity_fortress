package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.FactoryEffect;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffectsFactory;

public class Protect {
    public void execute(NCharacter user, NCharacter target) {
        FactoryEffect protectEffect = TemporaryEffectsFactory.createProtect(1, target);

        // If the user target themselves, this flag is not set.
        if (user == target) {
            protectEffect.setJustApplied(false);
        }

        protectEffect.apply();
        target.addTemporaryEffect(protectEffect);
    }
}
