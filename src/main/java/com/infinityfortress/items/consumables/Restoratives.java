package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Restoratives {
    public Consumables createMinorHealthPotion() {
        return new Consumables("Minor Health Potion", "Restorative", "Any", 5, 0, 0, 0, 0, 0, 0,
                "Restores 25 HP instantly.",
                "A crimson liquid that warms the throat and mends minor wounds.",
                ItemRarity.FORGED, ConsumableTier.LESSER);
    }

    public Consumables createHealthPotion() {
        return new Consumables("Health Potion", "Restorative", "Any", 10, 0, 0, 0, 0, 0, 0,
                "Restores 50 HP instantly.",
                "A ruby-red elixir that courses through veins like liquid vitality.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createGreaterHealthPotion() {
        return new Consumables("Greater Health Potion", "Restorative", "Any", 20, 0, 0, 0, 0, 0, 0,
                "Restores 100 HP instantly.",
                "A deep scarlet brew that pulses with life-giving energy.",
                ItemRarity.ENCHANTED, ConsumableTier.GREATER);
    }

    public Consumables createMinorManaPotion() {
        return new Consumables("Minor Mana Potion", "Restorative", "Any", 5, 0, 0, 0, 0, 0, 0,
                "Restores 25 Mana instantly.",
                "A shimmering blue liquid that sparkles with arcane essence.",
                ItemRarity.FORGED, ConsumableTier.LESSER);
    }

    public Consumables createManaPotion() {
        return new Consumables("Mana Potion", "Restorative", "Any", 10, 0, 0, 0, 0, 0, 0,
                "Restores 50 Mana instantly.",
                "An azure elixir that hums with mystical power.",
                ItemRarity.FORGED, ConsumableTier.STANDARD);
    }

    public Consumables createGreaterManaPotion() {
        return new Consumables("Greater Mana Potion", "Restorative", "Any", 20, 0, 0, 0, 0, 0, 0,
                "Restores 100 Mana instantly.",
                "A brilliant sapphire potion that crackles with arcane lightning.",
                ItemRarity.ENCHANTED, ConsumableTier.GREATER);
    }

    public Consumables createDualElixir() {
        return new Consumables("Dual Elixir", "Restorative", "Any", 35, 0, 0, 0, 0, 0, 0,
                "Restores 75 HP and 75 Mana instantly.",
                "A swirling mixture of crimson and azure that dances between life and magic.",
                ItemRarity.MYSTIC, ConsumableTier.UNIQUE);
    }

    public Consumables createPhoenixTears() {
        return new Consumables("Phoenix Tears", "Restorative", "Any", 50, 0, 0, 0, 0, 0, 0,
                "Fully restores HP and removes all debuffs.",
                "Golden droplets that shimmer with the rebirth essence of the mythical firebird.",
                ItemRarity.ETHEREAL, ConsumableTier.UNIQUE);
    }

    public Consumables createElixirOfEternalRenewal() {
        return new Consumables("Elixir of Eternal Renewal", "Restorative", "Any", 100, 0, 0, 0, 0, 0, 0,
                "Fully restores HP and Mana, grants temporary invulnerability.",
                "A transcendent potion that seems to contain the very essence of life itself, glowing with divine radiance.",
                ItemRarity.ASC, ConsumableTier.ASC);
    }
}