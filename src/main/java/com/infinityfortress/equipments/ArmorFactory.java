package com.infinityfortress.equipments;

public class ArmorFactory {
    Equipment createLeatherVestment() {
        return new Equipment("Leather Vestment", "Armor", "Any", 5, 0, 3, 2, 0, 0, 0,
                "Simple and supple, it grants freedom of movement while subtly fortifying the wearer's vitality.",
                EquipmentRarity.FORGED);
    }

    Equipment createAshenvaleRobe() {
        return new Equipment("Ashenvale Robe", "Armor", "Any", 5, 0, 2, 3, 0, 0, 0,
                "Woven from shadowed fibers, it siphons resilience from the darkness around, shielding its wearer with eerie durability.",
                EquipmentRarity.FORGED);
    }

    Equipment createDawnplateJerkin() {
        return new Equipment("Dawnplate Jerkin", "Armor", "Any", 7, 0, 4, 3, 0, 0, 0,
                "Gleams with morning light, bolstering life force and invigorating the wearer against fatigue.",
                EquipmentRarity.FORGED);
    }

    Equipment createUmbracowlRaiment() {
        return new Equipment("Umbracowl Raiment", "Armor", "Any", 7, 0, 3, 4, 0, 0, 0,
                "Cloaked in twilight, its dense weave hardens the wearer against blows and harbors a shadowed presence.",
                EquipmentRarity.FORGED);
    }

    Equipment createSunsteelMail() {
        return new Equipment("Sunsteel Mail", "Armor", "Any", 10, 0, 6, 4, 0, 0, 0,
                "Forged with sun-kissed iron, it warms the wearer and enhances endurance in prolonged combat.",
                EquipmentRarity.FORGED);
    }

    Equipment createEbonveilCarapace() {
        return new Equipment("Ebonveil Carapace", "Armor", "Any", 10, 0, 4, 6, 0, 0, 0,
                "Crafted from obsidian-steel, it deflects strikes with ruthless efficiency while shrouding the wearer in darkness.",
                EquipmentRarity.FORGED);
    }

    Equipment createShadowveilCloak() {
        return new Equipment("Shadowveil Cloak", "Armor", "Any", 13, 0, 5, 8, 0, 0, 0,
                "Drapes like a shroud, granting physical resilience and an intimidating silhouette.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createSolariumSilks() {
        return new Equipment("Solarium Silks", "Armor", "Any", 13, 0, 8, 5, 0, 0, 0,
                "Flowing fabric suffused with radiant energy, it restores vigor and bolsters life with each movement.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createBlightwovenGuard() {
        return new Equipment("Blightwoven Guard", "Armor", "Any", 17, 0, 6, 11, 0, 0, 0,
                "Hardened with corruption, it absorbs force and reflects a sinister aura to deter enemies.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createAstranMantle() {
        return new Equipment("Astran Mantle", "Armor", "Any", 17, 0, 11, 6, 0, 0, 0,
                "Star-stitched mantle that invigorates the body and shields the wearer from harm's toll.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createShadowlaceMantle() {
        return new Equipment("Shadowlace Mantle", "Armor", "Any", 20, 0, 7, 13, 0, 0, 0,
                "Intricate dark fibers reinforce the wearer, blending protection with ominous elegance.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createLoomianJerkin() {
        return new Equipment("Loomian Jerkin", "Armor", "Any", 20, 0, 13, 7, 0, 0, 0,
                "Flexible yet resilient, its craft channels life energy, making wounds harder to sustain.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createDreadfangCloak() {
        return new Equipment("Dreadfang Cloak", "Armor", "Any", 22, 0, 8, 14, 0, 0, 0,
                "Shrouded in predator motifs, it reinforces the wearer with uncanny durability and fearsome presence.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createAuroralVestment() {
        return new Equipment("Auroral Vestment", "Armor", "Any", 22, 0, 14, 8, 0, 0, 0,
                "Bathed in dawn's glow, it strengthens endurance and inspires hope to persevere.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createNightfangHauberk() {
        return new Equipment("Nightfang Hauberk", "Armor", "Any", 24, 0, 9, 15, 0, 0, 0,
                "Shadow-imbued hauberk that hardens under pressure, reflecting the menace of the night predator.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createLuminarisCuirass() {
        return new Equipment("Luminaris Cuirass", "Armor", "Any", 24, 0, 15, 9, 0, 0, 0,
                "Radiant plate that protects the body while nurturing vitality from light itself.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createShadowlynxCarapace() {
        return new Equipment("Shadowlynx Carapace", "Armor", "Any", 27, 0, 10, 17, 0, 0, 0,
                "Sleek and fortified, it favors resilience and dexterous survival in darkened encounters.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createHalcyonGuard() {
        return new Equipment("Halcyon Guard", "Armor", "Any", 27, 0, 17, 10, 0, 0, 0,
                "Blessed armor that encourages fortitude and a calm, steady vitality in the wearer.",
                EquipmentRarity.MYSTIC);
    }

    Equipment createSolarflareSolarion() {
        return new Equipment("Solarflare Solarion", "Armor", "Any", 29, 0, 18, 11, 0, 0, 0,
                "Shines with solar energy, granting vitality to endure long battles and harsh conditions.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createDamnationWraithguard() {
        return new Equipment("Damnation Wraithguard", "Armor", "Any", 29, 0, 11, 18, 0, 0, 0,
                "Forged from cursed materials, it hardens the wearer's defenses while emanating dread.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createAurorionWing() {
        return new Equipment("Aurorion Wing", "Armor", "Any", 32, 0, 19, 13, 0, 0, 0,
                "Radiant armor that flows like sunlight across the wearer's shoulders, uplifting spirit and vitality with every movement.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createAnyxionShroud() {
        return new Equipment("Anyxion Shroud", "Armor", "Any", 32, 0, 13, 19, 0, 0, 0,
                "Cloaked in abyssal shadow, it hardens the wearer's form while spreading an aura of silent menace.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createJudgmentAscSkin() {
        return new Equipment("Judgment Asc Skin", "Armor", "Any", 35, 0, 18, 18, 0, 0, 0,
                "A living relic of divine equilibrium, it fuses only with those deemed worthy by its unseen will. To wear it is not a choice—it is a covenant with balance itself, where light and darkness breathe as one upon the bearer's flesh.",
                EquipmentRarity.ASC);
    }

}
