package com.infinityfortress.equipments;

public class MageWeaponFactory {
    Equipment createAshenwoodWand() {
        return new Equipment("Ashenwood Wand", "Weapon", "Mage", 5, 2, 0, 3, 0, 0, 0,
                "Carved from charred oak imbued with lingering flame, channeling primal fire with every flick.",
                EquipmentRarity.FORGED);
    }

    Equipment createGlimmerrootStaff() {
        return new Equipment("Glimmerroot Staff", "Weapon", "Mage", 8, 3, 0, 5, 0, 0, 0,
                "Grown beneath moonlight, its roots still hum with the whispers of arcane nature.",
                EquipmentRarity.FORGED);
    }

    Equipment createFrostpetalWand() {
        return new Equipment("Frostpetal Wand", "Weapon", "Mage", 13, 5, 0, 8, 0, 0, 0,
                "A fragile bloom of frozen mana, releasing sharp bursts of winter’s grace.", EquipmentRarity.FORGED);
    }

    Equipment createSolarisChanneler() {
        return new Equipment("Solaris Channeler", "Weapon", "Mage", 15, 7, 0, 8, 0, 0, 0,
                "Forged in sunfire, it radiates warmth that burns away darkness and doubt.", EquipmentRarity.ENCHANTED);
    }

    Equipment createRuneboundStaff() {
        return new Equipment("Runebound Staff", "Weapon", "Mage", 19, 10, 0, 9, 0, 0, 0,
                "Every rune glows faintly, a silent hymn binding ancient wisdom to the wielder’s will.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createEchoheartFocus() {
        return new Equipment("Echoheart Focus", "Weapon", "Mage", 20, 5, 0, 7, 5, 3, 0,
                "The crystal within hums with voices of past sorcerers, echoing forgotten incantations.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createStarcallersBeacon() {
        return new Equipment("Starcaller's Beacon", "Weapon", "Mage", 23, 6, 0, 7, 5, 5, 0,
                "A celestial conduit that draws strength from constellations long erased from mortal maps.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createOblivionScepter() {
        return new Equipment("Oblivion Scepter", "Weapon", "Mage", 26, -5, 5, 16, 5, 5, 0,
                "Its obsidian core consumes stray light, conjuring shadows that obey no master.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createLuminousSpire() {
        return new Equipment("Luminous Spire", "Weapon", "Mage", 29, 14, 0, 15, 0, 0, 0,
                "A towering beacon of pure light magic, harnessed for unwavering power.", EquipmentRarity.ETHEREAL);
    }

    Equipment createChaosveilCatalyst() {
        return new Equipment("Chaosveil Catalyst", "Weapon", "Mage", 29, 10, 0, 14, -5, 10, 0,
                "Unstable energy swirls within, risking collapse for immense burst.", EquipmentRarity.ETHEREAL);
    }

    Equipment createEterniumSoulspire() {
        return new Equipment("Eternium Soulspire", "Weapon", "Mage", 30, 5, 0, 10, 10, 5, 0,
                "Forged from the last fragment of timeless magic, it hums with eternity’s pulse and bends mana to the caster’s will.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createAscMagusAeonPrism() {
        return new Equipment("Asc Magus Aeon Prism", "Weapon", "Mage", 40, 10, 5, 15, 5, 5, 0,
                "A shard of eternity bound in mortal form—its glow distorts time, letting its master weave miracles from the silence between moments.",
                EquipmentRarity.ASC);
    }
}
