package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class RageEffect extends TemporaryEffect {

    public RageEffect() {
        super(0, null);
    }

    public RageEffect(int duration, NCharacter target) {
        super(duration, target);
    }

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

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.BUFF;
    }
}
