package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class WarlockWeaponFactory {
    Equipment createAshenCursedScroll() {
        return new Equipment("Ashen Cursed Scroll", "Weapon", "Warlock", 8, 4, 0, 2, 0, 0, 2,
                "Smolders with lingering ashes, each word sapping vitality from those foolish enough to read it.",
                ItemRarity.FORGED);
    }

    Equipment createShadowboundCursedScroll() {
        return new Equipment("Shadowbound Cursed Scroll", "Weapon", "Warlock", 10, 4, 0, 3, 0, 0, 3,
                "Shadows coil around its pages, whispering forbidden secrets that bend the weak to the warlock’s will.",
                ItemRarity.FORGED);
    }

    Equipment createWitheredCursedScroll() {
        return new Equipment("Withered Cursed Scroll", "Weapon", "Warlock", 13, 3, 0, 5, 0, 0, 5,
                "Ancient and brittle, yet each line drains life with an unwavering hunger for souls.",
                ItemRarity.FORGED);
    }

    Equipment createNightfallCodex() {
        return new Equipment("Nightfall Codex", "Weapon", "Warlock", 16, 5, 0, 7, 0, 0, 4,
                "Darkness seeps from its cover, commanding the unseen and calling forth ephemeral dread.",
                ItemRarity.ENCHANTED);
    }

    Equipment createPhantomCodex() {
        return new Equipment("Phantom Codex", "Weapon", "Warlock", 19, 6, 0, 7, 0, 0, 6,
                "Ghostly ink etches fates unknown, summoning spirits to haunt and serve the cunning warlock.",
                ItemRarity.ENCHANTED);
    }

    Equipment createObsiviousCodex() {
        return new Equipment("Obsivious Codex", "Weapon", "Warlock", 21, 9, 0, 5, 0, 0, 7,
                "Its cursed scripts ensnare minds, guiding unfortunate souls into unseen perils.",
                ItemRarity.ENCHANTED);
    }

    Equipment createEbonflareStaff() {
        return new Equipment("Ebonflare Staff", "Weapon", "Warlock", 24, 8, 0, 8, 0, 0, 8,
                "Dark flames surge along its shaft, burning with power to dominate the battlefield.",
                ItemRarity.MYSTIC);
    }

    Equipment createSoulrenderStaff() {
        return new Equipment("Soulrender Staff", "Weapon", "Warlock", 27, 9, 0, 6, 0, 0, 12,
                "Pulses with tormented energy, tearing essence from the living and feeding the warlock’s might.",
                ItemRarity.MYSTIC);
    }

    Equipment createDoombringerSigil() {
        return new Equipment("Doombringer Sigil", "Weapon", "Warlock", 30, 8, 0, 7, 0, 0, 15,
                "An emblem of annihilation, it bends reality itself to summon devastation upon enemies.",
                ItemRarity.ETHEREAL);
    }

    Equipment createAscWrynnorTome() {
        return new Equipment("Asc Wrynnor Tome", "Weapon", "Warlock", 35, 10, 0, 15, 0, 0, 10,
                "Inked in the blood of fallen constellations, its words shimmer and shift, whispering promises from the end of all things.",
                ItemRarity.ASC);
    }
}
