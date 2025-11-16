package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.ProtectEffect;

public class Protect {
    public void execute(NCharacter user, NCharacter target) {
        ProtectEffect protectEffect = new ProtectEffect(1, target);

        // If the user target themselves, this flag is not set.
        if (user == target) {
            protectEffect.setJustApplied(false);
        }

        protectEffect.apply();
        target.addTemporaryEffect(protectEffect);
    }
}
