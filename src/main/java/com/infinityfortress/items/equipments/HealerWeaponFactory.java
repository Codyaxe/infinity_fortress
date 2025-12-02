package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class HealerWeaponFactory {
    public Equipment createSanctumIcon() {
        return new Equipment("Sanctum Icon", "Weapon", "medallion", "Healer", 5, 3, 0, 2, 0, 0, 0,
                "A sacred emblem radiating calm, channeling restorative energy to mend wounds with gentle precision.",
                ItemRarity.FORGED);
    }

    public Equipment createLifebloomMedallion() {
        return new Equipment("Lifebloom Medallion", "Weapon", "medallion", "Healer", 8, 4, 0, 3, 0, 0, 1,
                "Infused with the essence of life, it subtly accelerates healing for allies within its soothing aura.",
                ItemRarity.FORGED);
    }

    public Equipment createCelestineGlobe() {
        return new Equipment("Celestine Globe", "Weapon", "place", "orb", 12, 6, 0, 4, 0, 0, 2,
                "Glowing with celestial light, it nurtures vitality and rejuvenates even the weariest of hearts.",
                ItemRarity.FORGED);
    }

    public Equipment createVerdantCrucible() {
        return new Equipment("Verdant Crucible", "Weapon", "place", "crucible", 15, 8, 0, 5, 0, 0, 2,
                "A verdant vessel of nature’s power, empowering the healer to mend grievous injuries swiftly.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createMoonlitTalisman() {
        return new Equipment("Moonlit Talisman", "Weapon", "medallion", "Healer", 19, 10, 0, 5, 0, 0, 4,
                "Batched in silver light, its charm enhances the strength of restorative magic under any night sky.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createAuroraSphere() {
        return new Equipment("Aurora Sphere", "Weapon", "orb", "Healer", 20, 9, 0, 5, 0, 0, 6,
                "Shimmering with prismatic hues, each pulse restores vigor to allies, weaving a veil of protection.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createEvergloamSigil() {
        return new Equipment("Evergloam Sigil", "Weapon", "sigil", "Healer", 23, 12, 0, 6, 0, 0, 5,
                "A mystical sigil resonating with twilight energy, it bolsters the healer’s command over life’s flow.",
                ItemRarity.MYSTIC);
    }

    public Equipment createRadiantPendant() {
        return new Equipment("Radiant Pendant", "Weapon", "medallion", "Healer", 26, 14, 0, 6, 0, 0, 6,
                "Encased in radiant crystal, it channels pure restorative force, sustaining allies in the heat of battle.",
                ItemRarity.MYSTIC);
    }

    public Equipment createEthereonSanctifier() {
        return new Equipment("Ethereon Sanctifier", "Weapon", "medallion", "Healer", 29, 16, 0, 7, 0, 0, 6,
                "Forged from ethereal essence, it sanctifies wounds with unmatched potency, turning pain into fleeting whispers.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createSoulweaverAegis() {
        return new Equipment("Soulweaver Aegis", "Weapon", "shield", "Healer", 30, 7, 0, 15, 0, 0, 8,
                "Threads of souls entwine within, subtly mending and empowering, binding life’s fragility to the healer’s will.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createLuminalNexus() {
        return new Equipment("Luminal Nexus", "Weapon", "medallion", "Healer", 30, 20, 0, 5, 0, 0, 5,
                "A nexus of pure light, it radiates restorative energy, guiding allies from the brink with unwavering grace.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscHalienRod() {
        return new Equipment("Asc Halien Rod", "Weapon", "staff", "Healer", 35, 15, 0, 10, 0, 0, 10,
                "A relic of purest light, said to be sung into existence by seraphic choirs; its radiance heals even the scars of memories.",
                ItemRarity.ASC);
    }
}
