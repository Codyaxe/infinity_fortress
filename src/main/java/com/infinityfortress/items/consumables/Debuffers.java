package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Debuffers {
    public Consumables createWeakeningPoison() {
        return new Consumables("Weakening Poison", "Debuffer", "Any", 12, 0, 0, -3, 0, 0, 0,
                "Reduces target's Strength by 3 for 3 turns.",
                "A sickly green vial that saps the vitality from those it touches.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createAcidVial() {
        return new Consumables("Acid Vial", "Debuffer", "Any", 12, 0, -3, 0, 0, 0, 0,
                "Reduces target's Defense by 3 for 3 turns.",
                "A corrosive liquid that eats through armor and flesh alike.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createCursingHex() {
        return new Consumables("Cursing Hex", "Debuffer", "Any", 18, 0, 0, 0, 0, 0, -5,
                "Reduces target's Luck by 5 for 4 turns.",
                "A dark powder that clings to the victim, bringing misfortune with every breath.",
                ItemRarity.ENCHANTED, ConsumableTier.STANDARD);
    }

    public Consumables createParalysisSerum() {
        return new Consumables("Paralysis Serum", "Debuffer", "Any", 25, 0, -5, -5, -10, 0, 0,
                "Reduces target's Defense by 5, Strength by 5, and Critical Chance by 10% for 2 turns.",
                "A crystalline injection that locks muscles and clouds reflexes.",
                ItemRarity.ENCHANTED, ConsumableTier.GREATER);
    }

    public Consumables createManaLeech() {
        return new Consumables("Mana Leech", "Debuffer", "Any", 20, -3, 0, 0, 0, 0, 0,
                "Drains 3 Mana per turn for 4 turns.",
                "A writhing, purple substance that hungrily devours magical energy.",
                ItemRarity.MYSTIC, ConsumableTier.STANDARD);
    }

    public Consumables createDeathsBane() {
        return new Consumables("Death's Bane", "Debuffer", "Any", 35, -5, -7, -7, -15, -10, -7,
                "Severely reduces all target stats for 3 turns.",
                "A black ichor that seems to drain the very essence of life from its victim.",
                ItemRarity.ETHEREAL, ConsumableTier.UNIQUE);
    }

    public Consumables createVoidEssence() {
        return new Consumables("Void Essence", "Debuffer", "Any", 60, -10, -15, -15, -25, -20, -15,
                "Drastically reduces all target stats and may cause status effects for 4 turns.",
                "A substance that seems to exist between reality and nothingness, unmaking what it touches.",
                ItemRarity.ASC, ConsumableTier.ASC);
    }

    public Consumables createSilencePotion() {
        return new Consumables("Silence Potion", "Debuffer", "Any", 22, -10, 0, 0, 0, 0, 0,
                "Prevents target from using mana-based abilities for 3 turns.",
                "A clear liquid that muffles the voice and blocks the flow of arcane energy.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createBlindingDust() {
        return new Consumables("Blinding Dust", "Debuffer", "Any", 16, 0, 0, 0, -20, 0, -3,
                "Reduces target's Critical Chance by 20% and Luck by 3 for 3 turns.",
                "A shimmering powder that clouds vision and disrupts precision.",
                ItemRarity.FORGED, ConsumableTier.LESSER);
    }
}