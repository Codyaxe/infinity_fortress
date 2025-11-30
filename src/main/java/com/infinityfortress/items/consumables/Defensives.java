package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Defensives {
    public Consumables createAegisWard() {
        return new Consumables("Aegis Ward", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Grants 20 Shield.",
                "A thin veil of hardened light forms the moment it leaves your hand.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createBastionWard() {
        return new Consumables("Bastion Ward", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Grants 40 Shield.",
                "Layers of shimmering force interlock, forming a barrier that hums with intent.",
                ItemRarity.MYSTIC);
    }

    public Consumables createAsctralBulwark() {
        return new Consumables("Asctral Bulwark", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Grants 75 Shield.",
                "A cosmic shell flickers into existence, woven from stardust and quiet gravity.",
                ItemRarity.ETHEREAL);
    }

    public Consumables createVeilOfSafeguard() {
        return new Consumables("Veil of Safeguard", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Nullifies DMG taken for 1 hit.",
                "A fleeting shimmer envelopes you, turning the next strike to harmless wind.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createVeilOfImmunity() {
        return new Consumables("Veil of Immunity", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Nullifies DMG taken for 2 hit.",
                "A serene, weightless radiance binds to your form, denying all harm that follows.",
                ItemRarity.MYSTIC);
    }

    public Consumables createVeilOfAscsolutePhalanx() {
        return new Consumables("Veil of Ascsolute Phalanx", "Defensive", "Any", -1, 0, 0, 0, -3, 0, 0, 0, 0, 0,
                "Nullifies DMG taken for 4 hit.",
                "Reality bends around you, refusing to let even calamity leave a mark.",
                ItemRarity.ETHEREAL);
    }
}