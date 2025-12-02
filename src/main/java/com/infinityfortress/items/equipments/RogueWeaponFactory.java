package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class RogueWeaponFactory {
    public Equipment createRustfangDagger() {
        return new Equipment("Rustfang Dagger", "Weapon", "dagger", "Rogue", 5, 1, 0, 1, 1, 0, 2,
                "A rusted blade concealing deadly sharpness, striking unseen and leaving foes to wonder what hit them.",
                ItemRarity.FORGED);
    }

    public Equipment createShadowbiteClaws() {
        return new Equipment("Shadowbite Claws", "Weapon", "claws", "Rogue", 9, 2, 0, 1, 1, 1, 4,
                "Forged in darkness, these claws tear flesh with silent precision, perfect for ambushes.",
                ItemRarity.FORGED);
    }

    public Equipment createTwinsteelShivs() {
        return new Equipment("Twinsteel Shivs", "Weapon", "dagger", "Rogue", 11, 1, 0, 2, 1, 2, 5,
                "Paired blades for swift, twin strikes; each cut quick, silent, and merciless.",
                ItemRarity.FORGED);
    }

    public Equipment createVenomlashDaggers() {
        return new Equipment("Venomlash Daggers", "Weapon", "dagger", "Rogue", 15, 4, 0, 1, 2, 1, 7,
                "Daggers coated in potent toxin, each slash drains life and sows fear.", ItemRarity.ENCHANTED);
    }

    public Equipment createBloodtraceChakrams() {
        return new Equipment("Bloodtrace Chakrams", "Weapon", "chakram", "Rogue", 17, 3, 0, 1, 2, 4, 7,
                "Spinning with lethal precision in close quarters, each slash leaves a trail of crimson and fear.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createWhisperfangBlades() {
        return new Equipment("Whisperfang Blades", "Weapon", "dualBlades", "Rogue", 20, 3, 0, 3, 1, 3, 10,
                "Silent as a shadow, sharp as a fang; every strike whispers death.", ItemRarity.ENCHANTED);
    }

    public Equipment createNightreaverClaws() {
        return new Equipment("Nightreaver Claws", "Weapon", "claws", "Rogue", 23, 3, 0, 4, 4, 3, 9,
                "Perfect for prowling predators, they slice silently and vanish before retaliation.",
                ItemRarity.MYSTIC);
    }

    public Equipment createEclipsingChakrams() {
        return new Equipment("Eclipsing Chakrams", "Weapon", "chakram", "Rogue", 27, 4, 0, 5, 4, 4, 10,
                "Moon-forged discs whirling in deadly arcs, striking foes with shadowed elegance.",
                ItemRarity.MYSTIC);
    }

    public Equipment createDreadveilKnives() {
        return new Equipment("Dreadveil Knives", "Weapon", "dagger", "Rogue", 29, 0, 0, 5, 7, 10, 7,
                "Every slash siphons the essence of your foe, striking with lethal precision; only the most daring rogues can wield its ruthless edge.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createGloombiteTalons() {
        return new Equipment("Gloombite Talons", "Weapon", "claws", "Rogue", 29, 6, 0, 7, 2, 7, 11,
                "Forged for the shadows, each claw strikes with cunning force; skill and timing amplify its deadly potential in every encounter.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createVeilpiercerChakrams() {
        return new Equipment("Veilpiercer Chakrams", "Weapon", "chakram", "Rogue", 30, 2, 0, 3, 5, 5, 15,
                "Luck guides each spinning blade, slicing unseen through defenses; a rogue’s touch makes the improbable strike inevitable.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscRhaenKris() {
        return new Equipment("Asc Rhaen Kris", "Weapon", "dagger", "Rogue", 40, 2, 0, 3, 5, 5, 25,
                "Whispers of forgotten gods cling to its twin edges; every strike severs not flesh, but the thread of fate that binds one to the living.",
                ItemRarity.ASC);
    }
}
