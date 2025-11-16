package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class CurseEffect extends TemporaryEffect {

    public CurseEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setDefense(this.target.getDefense() - 5);
    }

    @Override
    public void remove() {
        this.target.setDefense(this.target.getDefense() + 5);
    }

    @Override
    public String getName() {
        return "Cursed";
    }

    @Override
    public TemporaryEffectType getType() {
        return TemporaryEffectType.DEBUFF;
    }
}
