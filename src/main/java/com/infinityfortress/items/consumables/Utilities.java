package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Utilities {
    public Consumables createAntidote() {
        return new Consumables("Antidote", "Utility", "Any", 8, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Removes poison and disease effects.",
                "A clear, bitter liquid that purifies the blood of toxins.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createCleansingWater() {
        return new Consumables("Cleansing Water", "Utility", "Any", 12, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Removes all debuff effects.",
                "Sacred water blessed by temple priests, it washes away curses and ailments.",
                ItemRarity.ENCHANTED, ConsumableTier.STANDARD);
    }

    public Consumables createSmokeGrenade() {
        return new Consumables("Smoke Grenade", "Utility", "Any", 15, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Creates concealment, allowing escape from combat.",
                "A small sphere that releases thick, obscuring smoke when activated.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createFlashbang() {
        return new Consumables("Flashbang", "Utility", "Any", 18, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Stuns all enemies for 1 turn.",
                "A blinding device that disorients foes with light and sound.",
                ItemRarity.ENCHANTED, ConsumableTier.STANDARD);
    }

    public Consumables createTeleportationScroll() {
        return new Consumables("Teleportation Scroll", "Utility", "Any", 25, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Instantly escape from any battle or dungeon floor.",
                "Ancient parchment inscribed with spatial magic that bends reality.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createResurrectionPotion() {
        return new Consumables("Resurrection Potion", "Utility", "Any", 100, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Revives a fallen ally with 50% HP.",
                "A miraculous elixir that can call souls back from the threshold of death.",
                ItemRarity.ETHEREAL, ConsumableTier.UNIQUE);
    }

    public Consumables createTimeShifter() {
        return new Consumables("Time Shifter", "Utility", "Any", 150, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Grants an extra turn in combat.",
                "A crystalline hourglass that manipulates the flow of time itself.",
                ItemRarity.ASC, ConsumableTier.ASC);
    }

    public Consumables createTrapDetector() {
        return new Consumables("Trap Detector", "Utility", "Any", 10, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Reveals hidden traps in the current area.",
                "A small device that hums and glows when dangerous mechanisms are nearby.",
                ItemRarity.FORGED, ConsumableTier.LESSER);
    }

    public Consumables createIdentificationLens() {
        return new Consumables("Identification Lens", "Utility", "Any", 20, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Reveals the properties of unknown items.",
                "A magical magnifying glass that unveils the true nature of mysterious objects.",
                ItemRarity.ENCHANTED, ConsumableTier.STANDARD);
    }

    public Consumables createRestoreSkillPotion() {
        return new Consumables("Restore Skill Potion", "Utility", "Any", 30, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Resets all skill cooldowns.",
                "A swirling potion that refreshes the mind and restores spent abilities.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }
}