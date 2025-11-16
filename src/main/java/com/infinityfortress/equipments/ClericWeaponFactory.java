package com.infinityfortress.equipments;

public class ClericWeaponFactory {
    Equipment createSanctumMace() {
        return new Equipment("Sanctum Mace", "Weapon", "Cleric", 6, 1, 0, 1, 0, 0, 4,
                "A simple yet holy weapon, it channels the light of the sanctuary to mend wounds and bolster faith.",
                EquipmentRarity.FORGED);
    }

    Equipment createDawnspireCenser() {
        return new Equipment("Dawnspire Censer", "Weapon", "Cleric", 9, 3, 0, 2, 0, 0, 4,
                "Its incense burns with the first light of dawn, uplifting allies and purging darkness from their spirits.",
                EquipmentRarity.FORGED);
    }

    Equipment createRadiantScepter() {
        return new Equipment("Radiant Scepter", "Weapon", "Cleric", 10, 2, 0, 3, 0, 0, 5,
                "Each strike releases a pulse of divine energy, healing the faithful and smiting the unworthy.",
                EquipmentRarity.FORGED);
    }

    Equipment createLuminalRod() {
        return new Equipment("Luminal Rod", "Weapon", "Cleric", 13, 4, 0, 4, 0, 0, 5,
                "Glowing softly, it bridges mortal hands and celestial power, guiding prayers into potent restoration.",
                EquipmentRarity.FORGED);
    }

    Equipment createHalobrandMace() {
        return new Equipment("Halobrand Mace", "Weapon", "Cleric", 14, 3, 0, 5, 0, 0, 6,
                "Forged in sacred fires, it carries a halo of power, strengthening the resolve of those it defends.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createLumenicAegis() {
        return new Equipment("Lumenic Aegis", "Weapon", "Cleric", 17, 4, 0, 6, 0, 0, 7,
                "A protective emblem, radiating light that shields companions while nourishing their vitality.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createAuricMedallion() {
        return new Equipment("Auric Medallion", "Weapon", "Cleric", 19, 4, 0, 6, 0, 0, 9,
                "Gleaming with golden energy, it inspires courage and invigorates allies through the faith it embodies.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createBlessedCrucible() {
        return new Equipment("Blessed Crucible", "Weapon", "Cleric", 21, 5, 0, 7, 0, 0, 9,
                "Imbued with sanctified essence, it channels restorative magic, mending wounds and fortifying spirits alike.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createSolsticeWarrod() {
        return new Equipment("Solstice Warrod", "Weapon", "Cleric", 23, 5, 0, 8, 0, 0, 10,
                "Harnessing the zenith of sunlight, it empowers healing strikes and invigorates the weary.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createAetheriumGavel() {
        return new Equipment("Aetherium Gavel", "Weapon", "Cleric", 25, 3, 0, 9, 0, 0, 13,
                "A majestic instrument of divine judgement, strengthening resolve and empowering miracles beyond the ordinary.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createDivinePhylactery() {
        return new Equipment("Divine Phylactery", "Weapon", "Cleric", 27, 8, 0, 7, 0, 0, 12,
                "Encased in sacred relics, it amplifies blessings and anchors the faith of those nearby.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createAurealiumLuminar() {
        return new Equipment("Aurealium Luminar", "Weapon", "Cleric", 30, 7, 0, 5, 0, 0, 18,
                "Mace and amulet combined, it radiates celestial might, harmonizing strength and luck to aid allies.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createCelestivigilSeraphim() {
        return new Equipment("Celestivigil Seraphim", "Weapon", "Cleric", 30, 12, 0, 5, 0, 0, 13,
                "Wielding both mace and amulet, it channels seraphic grace, offering divine protection and potent restoration.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createAscCaeloraCenser() {
        return new Equipment("Asc Caelora Censer", "Weapon", "Cleric", 35, 15, 0, 5, 0, 0, 15,
                "Its ethereal smoke drifts between realms, carrying hymns of the divine that cleanse the spirit and reshape the will of heavens.",
                EquipmentRarity.ASC);
    }
}
