package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class ArmorFactory {
  // Added Temp Desc & Flavor Text
    public Equipment createLeatherVestment() {
        return new Equipment("Leather Vestment", "Armor", "leather", "Any", 5, 0, 3, 2, 0, 0, 0,
                "Increases defense by 3 and strength by 2, providing basic protection while maintaining mobility.",
                "Simple and supple, it grants freedom of movement while subtly fortifying the wearer's vitality.",
                ItemRarity.FORGED);
    }

    public Equipment createAshenvaleRobe() {
        return new Equipment("Ashenvale Robe", "Armor", "silk", "Any", 5, 0, 2, 3, 0, 0, 0,
                "Increases defense by 2 and strength by 3, offering balanced protection with moderate offensive capability.",
                "Woven from shadowed fibers, it siphons resilience from the darkness around, shielding its wearer with eerie durability.",
                ItemRarity.FORGED);
    }

    public Equipment createDawnplateJerkin() {
        return new Equipment("Dawnplate Jerkin", "Armor", "plate", "Any", 7, 0, 4, 3, 0, 0, 0,
                "Increases defense by 4 and strength by 3, providing enhanced protection and moderate offensive boost.",
                "Gleams with morning light, bolstering life force and invigorating the wearer against fatigue.",
                ItemRarity.FORGED);
    }

    public Equipment createUmbracowlRaiment() {//
        return new Equipment("Umbracowl Raiment", "Armor", "silk", "Any", 7, 0, 3, 4, 0, 0, 0,
                "Increases defense by 3 and strength by 4, favoring offense with adequate protective capabilities.",
                "Cloaked in twilight, its dense weave hardens the wearer against blows and harbors a shadowed presence.",
                ItemRarity.FORGED);
    }

    public Equipment createSunsteelMail() {
        return new Equipment("Sunsteel Mail", "Armor", "mail", "Any", 10, 0, 6, 4, 0, 0, 0,
                "Increases defense by 6 and strength by 4, providing substantial protection with solid offensive enhancement.",
                "Forged with sun-kissed iron, it warms the wearer and enhances endurance in prolonged combat.",
                ItemRarity.FORGED);
    }

    public Equipment createEbonveilCarapace() {//
        return new Equipment("Ebonveil Carapace", "Armor", "silk", "Any", 10, 0, 4, 6, 0, 0, 0,
                "Increases defense by 4 and strength by 6, prioritizing offensive power while maintaining defensive utility.",
                "Crafted from obsidian-steel, it deflects strikes with ruthless efficiency while shrouding the wearer in darkness.",
                ItemRarity.FORGED);
    }

    public Equipment createShadowveilCloak() {
        return new Equipment("Shadowveil Cloak", "Armor", "silk", "Any", 13, 0, 5, 8, 0, 0, 0,
                "Increases defense by 5 and strength by 8, emphasizing attack power with moderate defensive enhancement.",
                "Drapes like a shroud, granting physical resilience and an intimidating silhouette.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createSolariumSilks() {
        return new Equipment("Solarium Silks", "Armor", "silk","Any", 13, 0, 8, 5, 0, 0, 0,
                "Increases defense by 8 and strength by 5, providing superior protection with moderate attack enhancement.",
                "Flowing fabric suffused with radiant energy, it restores vigor and bolsters life with each movement.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createBlightwovenGuard() {
        return new Equipment("Blightwoven Guard", "Armor", "mail","Any", 17, 0, 6, 11, 0, 0, 0,
                "Increases defense by 6 and strength by 11, heavily favoring offensive capability with solid protection.",
                "Hardened with corruption, it absorbs force and reflects a sinister aura to deter enemies.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createAstranMantle() {
        return new Equipment("Astran Mantle", "Armor", "plate","Any", 17, 0, 11, 6, 0, 0, 0,
                "Increases defense by 11 and strength by 6, prioritizing protection with respectable offensive augmentation.",
                "Star-stitched mantle that invigorates the body and shields the wearer from harm's toll.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createShadowlaceMantle() {
        return new Equipment("Shadowlace Mantle", "Armor", "mail","Any", 20, 0, 7, 13, 0, 0, 0,
                "Increases defense by 7 and strength by 13, emphasizing powerful offensive strikes with adequate protection.",
                "Intricate dark fibers reinforce the wearer, blending protection with ominous elegance.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createLoomianJerkin() {
        return new Equipment("Loomian Jerkin", "Armor", "plate","Any", 20, 0, 13, 7, 0, 0, 0,
                "Increases defense by 13 and strength by 7, providing exceptional protection with moderate offensive enhancement.",
                "Flexible yet resilient, its craft channels life energy, making wounds harder to sustain.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createDreadfangCloak() {
        return new Equipment("Dreadfang Cloak", "Armor", "silk","Any", 22, 0, 8, 14, 0, 0, 0,
                "Increases defense by 8 and strength by 14, delivering significant offensive power with strong defensive support.",
                "Shrouded in predator motifs, it reinforces the wearer with uncanny durability and fearsome presence.",
                ItemRarity.MYSTIC);
    }

    public Equipment createAuroralVestment() {
        return new Equipment("Auroral Vestment", "Armor", "silk","Any", 22, 0, 14, 8, 0, 0, 0,
                "Increases defense by 14 and strength by 8, providing superior protection with solid offensive capability.",
                "Bathed in dawn's glow, it strengthens endurance and inspires hope to persevere.",
                ItemRarity.MYSTIC);
    }

    public Equipment createNightfangHauberk() {
        return new Equipment("Nightfang Hauberk", "Armor", "mail","Any", 24, 0, 9, 15, 0, 0, 0,
                "Increases defense by 9 and strength by 15, maximizing offensive potential with respectable protection.",
                "Shadow-imbued hauberk that hardens under pressure, reflecting the menace of the night predator.",
                ItemRarity.MYSTIC);
    }

    public Equipment createLuminarisCuirass() {
        return new Equipment("Luminaris Cuirass", "Armor", "plate","Any", 24, 0, 15, 9, 0, 0, 0,
                "Increases defense by 15 and strength by 9, emphasizing exceptional protection with solid offensive enhancement.",
                "Radiant plate that protects the body while nurturing vitality from light itself.",
                ItemRarity.MYSTIC);
    }

    public Equipment createShadowlynxCarapace() {
        return new Equipment("Shadowlynx Carapace", "Armor", "silk","Any", 27, 0, 10, 17, 0, 0, 0,
                "Increases defense by 10 and strength by 17, delivering powerful offensive strikes with substantial protection.",
                "Sleek and fortified, it favors resilience and dexterous survival in darkened encounters.",
                ItemRarity.MYSTIC);
    }

    public Equipment createHalcyonGuard() {
        return new Equipment("Halcyon Guard", "Armor", "mail","Any", 27, 0, 17, 10, 0, 0, 0,
                "Increases defense by 17 and strength by 10, providing exceptional protection with moderate offensive augmentation.",
                "Blessed armor that encourages fortitude and a calm, steady vitality in the wearer.",
                ItemRarity.MYSTIC);
    }

    public Equipment createSolarflareSolarion() {
        return new Equipment("Solarflare Solarion", "Armor", "askin","Any", 29, 0, 18, 11, 0, 0, 0,
                "Increases defense by 18 and strength by 11, granting superior protection with strong offensive enhancement.",
                "Shines with solar energy, granting vitality to endure long battles and harsh conditions.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createDamnationWraithguard() {
        return new Equipment("Damnation Wraithguard", "Armor", "mail","Any", 29, 0, 11, 18, 0, 0, 0,
                "Increases defense by 11 and strength by 18, maximizing offensive damage while maintaining solid defense.",
                "Forged from cursed materials, it hardens the wearer's defenses while emanating dread.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAurorionWing() {
        return new Equipment("Aurorion Wing", "Armor", "askin","Any", 32, 0, 19, 13, 0, 0, 0,
                "Increases defense by 19 and strength by 13, providing elite protection with substantial offensive capabilities.",
                "Radiant armor that flows like sunlight across the wearer's shoulders, uplifting spirit and vitality with every movement.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAnyxionShroud() {
        return new Equipment("Anyxion Shroud", "Armor", "silk","Any", 32, 0, 13, 19, 0, 0, 0,
                "Increases defense by 13 and strength by 19, prioritizing maximum offensive power with elite protection.",
                "Cloaked in abyssal shadow, it hardens the wearer's form while spreading an aura of silent menace.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createJudgmentAscSkin() {
        return new Equipment("Judgment Asc Skin", "Armor", "askin","Any", 35, 0, 18, 18, 0, 0, 0,
                "Increases defense by 18 and strength by 18, providing perfect balance between protection and offensive might.",
                "A living relic of divine equilibrium, it fuses only with those deemed worthy by its unseen will. To wear it is not a choice—it is a covenant with balance itself, where light and darkness breathe as one upon the bearer's flesh.",
                ItemRarity.ASC);
    }

}
