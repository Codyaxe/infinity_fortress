package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;

public class TemporaryEffectsFactory {
    public static FactoryEffect createCursed(int duration, NCharacter target) {
        return new FactoryEffect("Cursed", duration, target, 0, 0, -5, 0, 0, 0, 0, 0, TemporaryEffectType.DEBUFF);
    }

    public static FactoryEffect createProtect(int duration, NCharacter target) {
        return new FactoryEffect("Protect", duration, target, 0, 0, 4, 0, 0, 0, 0, 0, TemporaryEffectType.BUFF);
    }

    public static FactoryEffect createRage(int duration, NCharacter target) {
        return new FactoryEffect("Rage", duration, target, 0, 0, 0, 5, 0, 0, 0, 0, TemporaryEffectType.BUFF);
    }

    public static FactoryEffect createSlowed(int duration, NCharacter target) {
        return new FactoryEffect("Slowed", duration, target, 0, 0, 0, 0, 0, 0, 0, -3, TemporaryEffectType.DEBUFF);
    }

    public static FactoryEffect createWeakened(int duration, NCharacter target) {
        return new FactoryEffect("Weakened", duration, target, 0, 0, 0, -4, 0, 0, 0, 0, TemporaryEffectType.DEBUFF);
    }

    public static FactoryEffect createSavage(int duration, NCharacter target) {
        return new FactoryEffect("Savage", duration, target, 0, 0, 0, 0, 5, 10, 0, 0, TemporaryEffectType.BUFF);
    }

    public static FactoryEffect createHaste(int duration, NCharacter target) {
        return new FactoryEffect("Haste", duration, target, 0, 0, 0, 0, 0, 0, 0, 5, TemporaryEffectType.BUFF);
    }
}
