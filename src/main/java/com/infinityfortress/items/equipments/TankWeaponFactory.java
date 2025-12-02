package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class TankWeaponFactory {
    public Equipment createIroncladShield() {
        return new Equipment("Ironclad Shield", "Weapon", "shield", "Tank", 5, 0, 4, 1, 0, 0, 0,
                "A steadfast shield of tempered steel, absorbing blows and anchoring defenders at the heart of battle.",
                ItemRarity.FORGED);
    }

    public Equipment createWarbreakerHammer() {
        return new Equipment("Warbreaker Hammer", "Weapon", "hammer", "Tank", 9, 0, 4, 5, 0, 0, 0,
                "A brutal hammer designed to shatter armor and bones alike, punishing those who dare approach.",
                ItemRarity.FORGED);
    }

    public Equipment createBastionGauntlets() {
        return new Equipment("Bastion Gauntlets", "Weapon", "gauntlets", "Tank", 13, 0, 8, 7, 0, 0, 0,
                "Heavy gauntlets crafted for parries and blocks, turning enemy strikes into harmless echoes.",
                ItemRarity.FORGED);
    }

    public Equipment createVanguardsBulwark() {
        return new Equipment("Vanguard's Bulwark", "Weapon", "hammer", "Tank", 16, 0, 10, 6, 0, 0, 0,
                "An enchanted shield that bolsters allies’ courage while deflecting attacks with uncanny precision.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createOathforgedShield() {
        return new Equipment("Oathforged Shield", "Weapon", "shield", "Tank", 18, 0, 13, 3, 0, 0, 0,
                "Bound by solemn vows, it protects allies and embodies the resolve of its wielder.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createStormhammerGauntlets() {
        return new Equipment("Stormhammer Gauntlets", "Weapon", "gauntlets", "Tank", 21, 0, 12, 9, 0, 0, 0,
                "Gauntlets crackling with lightning, smashing foes while guarding the frontline with electric force.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createEarthshatterWarhammer() {
        return new Equipment("Earthshatter Warhammer", "Weapon", "hammer", "Tank", 23, 0, 10, 13, 0, 0, 0,
                "A titan-forged hammer that shakes the battlefield, crushing armor and morale in equal measure.",
                ItemRarity.MYSTIC);
    }

    public Equipment createSanctumbreakerGauntlets() {
        return new Equipment("Sanctumbreaker Gauntlets", "Weapon", "gauntlets", "Tank", 26, 0, 13, 13, 0, 0, 0,
                "Crafted for sieges and champions, they punch through walls and enemy lines with devastating might.",
                ItemRarity.MYSTIC);
    }

    public Equipment createHeavensunderMaul() {
        return new Equipment("Heavensunder Maul", "Weapon", "hammer", "Tank", 28, 0, 10, 18, 0, 0, 0,
                "Wielded by chosen defenders, each swing reverberates with divine force, breaking the strongest of foes.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createSeraphicBulwark() {
        return new Equipment("Seraphic Bulwark", "Weapon", "hammer", "Tank", 28, 0, 18, 10, 0, 0, 0,
                "A radiant shield blessed by celestial power, inspiring allies and turning aside even the fiercest assaults.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAegisOfTheTitans() {
        return new Equipment("Aegis of the Titans", "Weapon", "pavise", "Tank", 30, 0, 20, 10, 0, 0, 0,
                "A legendary shield of unmatched might, unyielding against any assault and inspiring allies to defy fate itself.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscTarkoitusvoimaPavise() {
        return new Equipment("Asc Tarkoitusvoima Pavise", "Weapon", "pavise", "Tank", 35, 0, 25, 10, 0, 0, 0,
                "Formed from celestial ore that once guarded the gates of heaven, it shields not the body, but the very essence of the bearer’s being.",
                ItemRarity.ASC);
    }
}
