package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Restoratives {
    public Consumables createLesserVitalDraught() {
        return new Consumables("Lesser Vital Draught", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 5 HP + 6% MAX HP",
                "A simple blend of herbs and energized water, brewed by novice healers. It restores just enough life to keep you on your feet.",
                ItemRarity.FORGED);
    }

    public Consumables createVitalDraught() {
        return new Consumables("Vital Draught", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 10 HP + 12% MAX HP",
                "A refined healing mixture favored by traveling adventurers. Its warmth spreads instantly through the body.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterVitalDraught() {
        return new Consumables("Greater Vital Draught", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 16 HP + 19% MAX HP",
                "A potent restorative crafted by skilled mystics. Its radiant essence mends wounds with remarkable speed.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserMindTonic() {
        return new Consumables("Lesser Mind Tonic", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 10 MP + 7% MAX MP",
                "A light, soothing brew that clears the fog of fatigue and rekindles mental focus.",
                ItemRarity.FORGED);
    }

    public Consumables createMindTonic() {
        return new Consumables("Mind Tonic", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 20 MP + 15% MAX MP",
                "Trusted by scholars and spellcasters, this tonic sharpens concentration and restores inner clarity.",
                ItemRarity.ENCHANTED);
    }
    
    public Consumables createGreaterMindTonic() {
        return new Consumables("Greater Mind Tonic", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 32 MP + 24% MAX MP",
                "An advanced infusion imbued with arcane resonance, revitalizing one\'s mental reserves almost instantly.",
                ItemRarity.MYSTIC);
    }
    
    public Consumables createLesserSpiritElixir() {
        return new Consumables("Lesser Spirit Elixir", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 6 HP + 7% MAX HP and 7 MP + 7% MAX MP",
                "An advanced infusion imbued with arcane resonance, revitalizing one\'s mental reserves almost instantly.",
                ItemRarity.FORGED);
    }
    
    public Consumables createSpiritElixir() {
        return new Consumables("Spirit Elixir", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 13 HP + 14% MAX HP and 15 MP + 14% MAX MP",
                "Favored in long journeys, this elixir nourishes the body and reawakens the spirit in equal measure.",
                ItemRarity.ENCHANTED);
    }
    
    public Consumables createGreaterSpiritElixir() {
        return new Consumables("Greater Spirit Elixir", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Recover 21 HP + 22% MAX HP. 24 MP + 22% MAX MP",
                "A finely tuned concoction that renews both health and mana with elegant efficiency.",
                ItemRarity.MYSTIC);
    }
    
    public Consumables createVitalisAscCore() {
        return new Consumables("Greater Spirit Elixir", "Restorative", "Any", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                "Restores team's HP and MP to max.",
                "A rare ascendant relic that releases pure restorative energy, revitalizing the entire party to perfect form.",
                ItemRarity.ETHEREAL);
    }
}