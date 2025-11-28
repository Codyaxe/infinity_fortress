package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class ArcherWeaponFactory {
    Equipment createThornstrikeBow() {
        return new Equipment("Thornstrike Bow", "Weapon", "Archer", 7, 0, 0, 4, 1, 2, 0,
                "Crafted from bramblewood, its arrows tear through armor like wild thorns through flesh.",
                ItemRarity.FORGED);
    }

    Equipment createWindwhisperSlingshot() {
        return new Equipment("Windwhisper Slingshot", "Weapon", "Archer", 9, 0, 0, 1, 4, 4, 0,
                "Its light frame bends air itself, sending pebbles swift and silent as a breeze.",
                ItemRarity.FORGED);
    }

    Equipment createEmberrootShortbow() {
        return new Equipment("Emberroot Shortbow", "Weapon", "Archer", 12, 0, 0, 5, 3, 4, 0,
                "Flames pulse beneath its bark, each shot leaving trails of burning cinders.",
                ItemRarity.FORGED);
    }

    Equipment createMoonveilLongbow() {
        return new Equipment("Moonveil Longbow", "Weapon", "Archer", 15, 0, 0, 4, 7, 4, 0,
                "Strung with lunar silk, its arrows shimmer with calm precision under moonlight.",
                ItemRarity.ENCHANTED);
    }

    Equipment createStormpiercerComposite() {
        return new Equipment("Stormpiercer Composite", "Weapon", "Archer", 18, 0, 0, 6, 6, 6, 0,
                "Sparks crackle along its limbs, channeling thunder through every piercing release.",
                ItemRarity.ENCHANTED);
    }

    Equipment createFalconsPride() {
        return new Equipment("Falcon's Pride", "Weapon", "Archer", 20, 0, 0, 7, 8, 5, 0,
                "A hunter’s companion bound by spirit, its aim never wavers even at impossible range.",
                ItemRarity.ENCHANTED);
    }

    Equipment createSunflareHarbinger() {
        return new Equipment("Sunflare Harbinger", "Weapon", "Archer", 23, 0, 0, 9, 8, 6, 0,
                "Forged in dawnfire, it unleashes arrows blazing bright enough to blind the unworthy.",
                ItemRarity.MYSTIC);
    }

    Equipment createAetherstringVanguard() {
        return new Equipment("Aetherstring Vanguard", "Weapon", "Archer", 26, 0, 0, 8, 10, 7, 0,
                "Its ethereal string hums with power drawn from unseen winds and astral currents.",
                ItemRarity.MYSTIC);
    }

    Equipment createSoulpiercerArbalest() {
        return new Equipment("Soulpiercer Arbalest", "Weapon", "Archer", 30, 0, 0, 15, 5, 10, 0,
                "Each arrow carries immense spiritual weight; slower draw, deadlier impact.", ItemRarity.ETHEREAL);
    }

    Equipment createBloodmoonReaver() {
        return new Equipment("Bloodmoon Reaver", "Weapon", "Archer", 30, 0, 0, 10, 10, 10, 0,
                "Under the crimson moon, its bolts feast upon the life force of its prey.", ItemRarity.ETHEREAL);
    }

    Equipment createAscAvarinPinaka() {
        return new Equipment("Asc Avarin Pinaka", "Weapon", "Archer", 40, 0, 5, 10, 5, 10, 10,
                "Each arrow drawn bends the fabric of fate itself; to wield it is to command the horizon, to see the unseen path of destiny’s flight.",
                ItemRarity.ASC);
    }

}
