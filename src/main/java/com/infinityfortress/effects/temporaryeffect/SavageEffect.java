package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class SavageEffect extends TemporaryEffect {

    public SavageEffect() {
        super(0, null);
    }

    public SavageEffect(int duration, NCharacter target) {
        super(duration, target);
    }

    @Override
    public void apply() {
        this.target.setCritStrength(this.target.getCritStrength() + 10);
        this.target.setCritChance(this.target.getCritChance() + 5);
    }

    @Override
    public void remove() {
        this.target.setCritStrength(this.target.getCritStrength() - 10);
        this.target.setCritChance(this.target.getCritChance() - 5);
    }

    @Override
    public String getName() {
        return "Savage";
    }
}
