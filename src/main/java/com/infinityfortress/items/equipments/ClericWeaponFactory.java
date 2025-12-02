package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class ClericWeaponFactory {
    public Equipment createSanctumMace() {
        return new Equipment("Sanctum Mace", "Weapon", "clericMace", "Cleric", 6, 1, 0, 1, 0, 0, 4,
                "A simple yet holy weapon, it channels the light of the sanctuary to mend wounds and bolster faith.",
                ItemRarity.FORGED);
    }

    public Equipment createDawnspireCenser() {
        return new Equipment("Dawnspire Censer", "Weapon", "censer", "Cleric", 9, 3, 0, 2, 0, 0, 4,
                "Its incense burns with the first light of dawn, uplifting allies and purging darkness from their spirits.",
                ItemRarity.FORGED);
    }

    public Equipment createRadiantScepter() {
        return new Equipment("Radiant Scepter", "Weapon", "staff", "Cleric", 10, 2, 0, 3, 0, 0, 5,
                "Each strike releases a pulse of divine energy, healing the faithful and smiting the unworthy.",
                ItemRarity.FORGED);
    }

    public Equipment createLuminalRod() {
        return new Equipment("Luminal Rod", "Weapon", "staff", "Cleric", 13, 4, 0, 4, 0, 0, 5,
                "Glowing softly, it bridges mortal hands and celestial power, guiding prayers into potent restoration.",
                ItemRarity.FORGED);
    }

    public Equipment createHalobrandMace() {
        return new Equipment("Halobrand Mace", "Weapon", "clericMace", "Cleric", 14, 3, 0, 5, 0, 0, 6,
                "Forged in sacred fires, it carries a halo of power, strengthening the resolve of those it defends.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createLumenicAegis() {
        return new Equipment("Lumenic Aegis", "Weapon", "shield", "Cleric", 17, 4, 0, 6, 0, 0, 7,
                "A protective emblem, radiating light that shields companions while nourishing their vitality.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createAuricMedallion() {
        return new Equipment("Auric Medallion", "Weapon", "medallion", "Cleric", 19, 4, 0, 6, 0, 0, 9,
                "Gleaming with golden energy, it inspires courage and invigorates allies through the faith it embodies.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createBlessedCrucible() {
        return new Equipment("Blessed Crucible", "Weapon", "crucible", "Cleric", 21, 5, 0, 7, 0, 0, 9,
                "Imbued with sanctified essence, it channels restorative magic, mending wounds and fortifying spirits alike.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createSolsticeWarrod() {
        return new Equipment("Solstice Warrod", "Weapon", "staff", "Cleric", 23, 5, 0, 8, 0, 0, 10,
                "Harnessing the zenith of sunlight, it empowers healing strikes and invigorates the weary.",
                ItemRarity.MYSTIC);
    }

    public Equipment createAetheriumGavel() {
        return new Equipment("Aetherium Gavel", "Weapon", "hammer", "Cleric", 25, 3, 0, 9, 0, 0, 13,
                "A majestic instrument of divine judgement, strengthening resolve and empowering miracles beyond the ordinary.",
                ItemRarity.MYSTIC);
    }

    public Equipment createDivinePhylactery() {
        return new Equipment("Divine Phylactery", "Weapon", "medallion", "Cleric", 27, 8, 0, 7, 0, 0, 12,
                "Encased in sacred relics, it amplifies blessings and anchors the faith of those nearby.",
                ItemRarity.MYSTIC);
    }

    public Equipment createAurealiumLuminar() {
        return new Equipment("Aurealium Luminar", "Weapon", "medallion", "Cleric", 30, 7, 0, 5, 0, 0, 18,
                "Mace and amulet combined, it radiates celestial might, harmonizing strength and luck to aid allies.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createCelestivigilSeraphim() {
        return new Equipment("Celestivigil Seraphim", "Weapon", "medallion", "Cleric", 30, 12, 0, 5, 0, 0, 13,
                "Wielding both mace and amulet, it channels seraphic grace, offering divine protection and potent restoration.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscCaeloraCenser() {
        return new Equipment("Asc Caelora Censer", "Weapon", "censer", "Cleric", 35, 15, 0, 5, 0, 0, 15,
                "Its ethereal smoke drifts between realms, carrying hymns of the divine that cleanse the spirit and reshape the will of heavens.",
                ItemRarity.ASC);
    }
}
