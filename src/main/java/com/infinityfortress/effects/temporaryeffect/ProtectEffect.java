package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class ProtectEffect extends TemporaryEffect {

    public ProtectEffect() {
        super(0, null);
    }

    public ProtectEffect(int duration, NCharacter target) {
        super(duration, target);
    }

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

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.BUFF;
    }
}
