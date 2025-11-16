package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class WeakenEffect extends TemporaryEffect {

    public WeakenEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setStrength(this.target.getStrength() - 4);
    }

    @Override
    public void remove() {
        this.target.setStrength(this.target.getStrength() + 4);
    }

    @Override
    public String getName() {
        return "Weakened";
    }

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.DEBUFF;
    }
}
