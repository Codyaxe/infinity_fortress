package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class MageWeaponFactory {
  // Added Temp Desc & Flavor
    public Equipment createAshenwoodWand() {
        return new Equipment("Ashenwood Wand", "Weapon", "Mage", 5, 2, 0, 3, 0, 0, 0,
                "Deals 120% spell damage to a single target with a chance to inflict burn.",
                "Carved from charred oak imbued with lingering flame, channeling primal fire with every flick.",
                ItemRarity.FORGED);
    }

    public Equipment createGlimmerrootStaff() {
        return new Equipment("Glimmerroot Staff", "Weapon", "Mage", 8, 3, 0, 5, 0, 0, 0,
                "Deals 110% spell damage and restores 10% mana after casting.",
                "Grown beneath moonlight, its roots still hum with the whispers of arcane nature.",
                ItemRarity.FORGED);
    }

    public Equipment createFrostpetalWand() {
        return new Equipment("Frostpetal Wand", "Weapon", "Mage", 13, 5, 0, 8, 0, 0, 0,
                "Deals 130% spell damage to a single target with a chance to freeze, preventing their next action.",
                "A fragile bloom of frozen mana, releasing sharp bursts of winter's grace.", ItemRarity.FORGED);
    }

    public Equipment createSolarisChanneler() {
        return new Equipment("Solaris Channeler", "Weapon", "Mage", 15, 7, 0, 8, 0, 0, 0,
                "Deals 125% spell damage and removes one debuff from the caster after each spell.",
                "Forged in sunfire, it radiates warmth that burns away darkness and doubt.", ItemRarity.ENCHANTED);
    }

    public Equipment createRuneboundStaff() {
        return new Equipment("Runebound Staff", "Weapon", "Mage", 19, 10, 0, 9, 0, 0, 0,
                "Deals 115% spell damage and reduces spell cooldowns by 1 turn.",
                "Every rune glows faintly, a silent hymn binding ancient wisdom to the wielder's will.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createEchoheartFocus() {
        return new Equipment("Echoheart Focus", "Weapon", "Mage", 20, 5, 0, 7, 5, 3, 0,
                "Deals 140% damage to multiple enemies (2-3 targets) with increased critical chance.",
                "The crystal within hums with voices of past sorcerers, echoing forgotten incantations.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createStarcallersBeacon() {
        return new Equipment("Starcaller's Beacon", "Weapon", "Mage", 23, 6, 0, 7, 5, 5, 0,
                "Deals 150% spell damage and grants a 20% chance to call down starfall on all enemies.",
                "A celestial conduit that draws strength from constellations long erased from mortal maps.",
                ItemRarity.MYSTIC);
    }

    public Equipment createOblivionScepter() {
        return new Equipment("Oblivion Scepter", "Weapon", "Mage", 26, -5, 5, 16, 5, 5, 0,
                "Deals 200% spell damage but drains 15% max mana. Creates shadow clones on critical hits.",
                "Its obsidian core consumes stray light, conjuring shadows that obey no master.",
                ItemRarity.MYSTIC);
    }

    public Equipment createLuminousSpire() {
        return new Equipment("Luminous Spire", "Weapon", "Mage", 29, 14, 0, 15, 0, 0, 0,
                "Deals 180% spell damage and heals all allies for 15% of damage dealt.",
                "A towering beacon of pure light magic, harnessed for unwavering power.", ItemRarity.ETHEREAL);
    }

    public Equipment createChaosveilCatalyst() {
        return new Equipment("Chaosveil Catalyst", "Weapon", "Mage", 29, 10, 0, 14, -5, 10, 0,
                "Deals 250% spell damage with random elemental effects. 10% chance to backfire and damage caster.",
                "Unstable energy swirls within, risking collapse for immense burst.", ItemRarity.ETHEREAL);
    }

    public Equipment createEterniumSoulspire() {
        return new Equipment("Eternium Soulspire", "Weapon", "Mage", 30, 5, 0, 10, 10, 5, 0,
                "Deals 160% spell damage and grants spell echoes - each spell casts again next turn at 50% power.",
                "Forged from the last fragment of timeless magic, it hums with eternity's pulse and bends mana to the caster's will.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscMagusAeonPrism() {
        return new Equipment("Asc Magus Aeon Prism", "Weapon", "Mage", 40, 10, 5, 15, 5, 5, 0,
                "Deals 300% spell damage and manipulates time - can rewind enemy actions or double ally turns.",
                "A shard of eternity bound in mortal form—its glow distorts time, letting its master weave miracles from the silence between moments.",
                ItemRarity.ASC);
    }
}
