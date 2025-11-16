package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class SlowEffect extends TemporaryEffect {

    public SlowEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setSpeed(this.target.getSpeed() - 3);
        notifySpeedChange();
    }

    @Override
    public void remove() {
        this.target.setSpeed(this.target.getSpeed() + 3);
        notifySpeedChange();
    }

    @Override
    public String getName() {
        return "Slowed";
    }

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.DEBUFF;
    }
}
