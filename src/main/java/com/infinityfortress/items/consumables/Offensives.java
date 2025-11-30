package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Offensives {
    public Consumables createIronburstGrenade() {
        return new Consumables("Ironburst Grenade", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals low DMG to a target and 2 adjacent enemies.",
                "A compact metal charge packed with condensed force. Detonates with a sharp burst that ripples through nearby enemies.",
                ItemRarity.FORGED);
    }

    public Consumables createBlazeflareBomb() {
        return new Consumables("Blazeflare Bomb", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate initial DMG. 25% chance to inflict SCORCH to 3 enemies (2 turns).",
                "A volatile ember core wrapped in enchanted casing. Its fiery burst scorches enemies and sometimes sparks lingering flames.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createThunderstoneCharge() {
        return new Consumables("Thunderstone Charge", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate DMG to all enemies. 55% chance to STUN all enemies (1 turn).",
                "A mystic stone that hums with trapped storm energy. When shattered, it unleashes a wave of lightning capable of stunning all foes.",
                ItemRarity.MYSTIC);
    }

    public Consumables createEmberOrb() {
        return new Consumables("Ember Orb", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals low DMG to a target. 15% chance to inflict SCORCH (2 turns).",
                "A tiny ember sealed in glass, waiting for the slightest breath to ignite fury.",
                ItemRarity.FORGED);
    }

    public Consumables createFrostOrb() {
        return new Consumables("Frost Orb", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate DMG to a target. 15% chance to inflict FREEZE (1 turns).",
                "Cold enough to still a heartbeat, yet calm as drifting winter air.",
                ItemRarity.FORGED);
    }

    public Consumables createOrbOfLightning() {
        return new Consumables("Orb of Lightning", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate DMG to a target. 15% chance to inflict SHOCK (3 turns).",
                "A restless spark pulses within, eager to leap into anything that lives.",
                ItemRarity.FORGED);
    }

    public Consumables createTerraOrb() {
        return new Consumables("Terra Orb", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate DMG to all enemies. 25% chance to inflict SLOW to 1 enemy (2 turns).",
                "Soil, stone, and spirit compressed into a single pulse of ancient weight.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createAquaOrb() {
        return new Consumables("Aqua Orb", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals moderate DMG to all enemies. 25% chance to inflict SOAK to 2 enemies (2 turns).",
                "Its core ripples without touch, carrying the quiet relentlessness of deep waters.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createOrbOfCataclysm() {
        return new Consumables("Orb of Cataclysm", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals heavy DMG to all enemies. 35% chance to inflict SCORCH & SLOW on 1 enemy (3 turns).",
                "A fractured world in miniature, trembling with unspent ruin.",
                ItemRarity.MYSTIC);
    }

    public Consumables createOrbOfTempest() {
        return new Consumables("Orb of Tempest", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals heavy DMG to all enemies. 35% chance to inflict SHOCK & SOAK on 3 enemy (2 turns).",
                "Wind, rain, and thunder coil within as if trapped mid-storm.",
                ItemRarity.MYSTIC);
    }

    public Consumables createOrbOfNullflare() {
        return new Consumables("Orb of Nullflare", "Offensive", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Deals heavy DMG to all enemies. 30% chance to inflict WEAKEN on 1 enemy (2 turns).",
                "Light swallowed whole, leaving only an echo of power that erases what it touches.",
                ItemRarity.FORGED);
    }
}