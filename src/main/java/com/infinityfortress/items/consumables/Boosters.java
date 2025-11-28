package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Boosters {
    public Consumables createStrengthBrew() {
        return new Consumables("Strength Brew", "Booster", "Any", 15, 3, 0, 0, 5, 0, 0, 0, 0, 0,
                "Increases Strength by 5 for 3 turns.",
                "A thick, amber liquid that makes muscles surge with newfound power.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createDefenseOintment() {
        return new Consumables("Defense Ointment", "Booster", "Any", 15, 3, 0, 5, 0, 0, 0, 0, 0, 0,
                "Increases Defense by 5 for 3 turns.",
                "A silvery paste that hardens the skin like tempered steel.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createLuckCharm() {
        return new Consumables("Luck Charm", "Booster", "Any", 20, 3, 0, 0, 0, 0, 0, 5, 0, 0,
                "Increases Luck by 5 for 3 turns.",
                "A glittering charm that seems to bend probability itself.",
                ItemRarity.ENCHANTED, ConsumableTier.STANDARD);
    }

    public Consumables createCriticalElixir() {
        return new Consumables("Critical Elixir", "Booster", "Any", 25, 3, 0, 0, 0, 10, 5, 0, 0, 0,
                "Increases Critical Chance by 10% and Critical Strength by 5 for 3 turns.",
                "A razor-sharp potion that makes every strike feel destined to find weakness.",
                ItemRarity.ENCHANTED, ConsumableTier.GREATER);
    }

    public Consumables createWarriorsVigor() {
        return new Consumables("Warrior's Vigor", "Booster", "Warrior", 30, 4, 0, 3, 7, 5, 0, 0, 0, 0,
                "Increases Defense by 3, Strength by 7, and Critical Chance by 5% for 4 turns.",
                "A robust tonic that fills the drinker with the courage of ancient heroes.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createMagesInsight() {
        return new Consumables("Mage's Insight", "Booster", "Mage", 30, 4, 5, 0, 0, 0, 0, 3, 0, 0,
                "Increases Mana by 5 and Luck by 3 for 4 turns.",
                "A crystalline potion that sharpens the mind and opens pathways to arcane wisdom.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createArchersZen() {
        return new Consumables("Archer's Zen", "Booster", "Archer", 30, 4, 0, 0, 3, 15, 7, 5, 0, 0,
                "Increases Strength by 3, Critical Chance by 15%, Critical Strength by 7, and Luck by 5 for 4 turns.",
                "A pale green elixir that steadies the hand and sharpens the eye.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createBerserkerRage() {
        return new Consumables("Berserker Rage", "Booster", "Any", 40, 3, 0, -5, 15, 20, 10, 0, 0, 0,
                "Increases Strength by 15, Critical Chance by 20%, and Critical Strength by 10, but decreases Defense by 5 for 3 turns.",
                "A blood-red concoction that trades caution for overwhelming fury.",
                ItemRarity.ETHEREAL, ConsumableTier.UNIQUE);
    }

    public Consumables createDivineBlessing() {
        return new Consumables("Divine Blessing", "Booster", "Any", 75, 5, 10, 10, 10, 15, 15, 10, 0, 0,
                "Increases all stats significantly for 5 turns.",
                "A radiant golden elixir that channels the favor of celestial beings themselves.",
                ItemRarity.ASC, ConsumableTier.ASC);
    }
}