package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class HasteEffect extends TemporaryEffect {

    public HasteEffect() {
        super(0, null);
    }

    public HasteEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setSpeed(this.target.getSpeed() + 5);
        notifySpeedChange();
    }

    @Override
    public void remove() {
        this.target.setSpeed(this.target.getSpeed() - 5);
        notifySpeedChange();
    }

    @Override
    public String getName() {
        return "Savage";
    }

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.BUFF;
    }
}
