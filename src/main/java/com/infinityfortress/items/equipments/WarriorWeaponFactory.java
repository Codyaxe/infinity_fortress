package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class WarriorWeaponFactory {
  // Added Temp Desc & Flavor Text
    public Equipment createRustbiteLongSword() {
        return new Equipment("Rustbite Longsword", "Weapon", "sword", "Warrior", 6, 0, 2, 4, 0, 0, 0,
                "Deals 140% weapon damage with defensive bonus of 2, providing moderate offense with light protection.",
                "A blade corroded yet deadly, its jagged edge bites deeper with every strike.", ItemRarity.FORGED);
    }

    public Equipment createBonecrushWarspike() {
        return new Equipment("Bonecrush Warspike", "Weapon", "polearm", "Warrior", 8, 0, 0, 5, 0, 0, 0,
                "Deals 150% weapon damage focused purely on crushing offense with no defensive capabilities.",
                "Forged from shattered bones of ancient beasts, it delivers crushing force with each thrust.",
                ItemRarity.FORGED);
    }

    public Equipment createForgebornBroadsword() {
        return new Equipment("Forgeborn Broadsword", "Weapon", "sword", "Warrior", 12, 0, 5, 7, 0, 0, 0,
                "Deals 170% weapon damage with defensive bonus of 5, balancing substantial offense with solid protection.",
                "Tempered in volcanic fires, it swings with relentless power and unyielding weight.",
                ItemRarity.FORGED);
    }

    public Equipment createKnightsSaber() {
        return new Equipment("Knight's Sabre", "Weapon", "sword", "Warrior", 16, 0, 7, 9, 0, 0, 0,
                "Deals 190% weapon damage with defensive bonus of 7, providing strong offense with enhanced protection.",
                "Etched with honor-bound runes, its gleam inspires courage in allies and fear in foes.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createBloodforgeWaraxe() {
        return new Equipment("Bloodforge Waraxe", "Weapon", "waraxe", "Warrior", 18, 0, 6, 12, 0, 0, 0,
                "Deals 220% weapon damage with defensive bonus of 6, delivering devastating strikes with moderate protection.",
                "Born in sacrificial flames, each swing drips with the echoes of past battles.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createSentinelsHalberd() {
        return new Equipment("Sentinel's Halberd", "Weapon", "polearm", "Warrior", 21, 0, 7, 14, 0, 0, 0,
                "Deals 240% weapon damage with defensive bonus of 7, excelling at both offense and counter-attacks.",
                "A weapon of defense and offense, it guards its wielder while punishing intruders.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createKingsguardBastionblade() {
        return new Equipment("Kingsguard Bastionblade", "Weapon", "sword", "Warrior", 23, 0, 9, 14, 0, 0, 0,
                "Deals 240% weapon damage with defensive bonus of 9, balancing elite offense with superior protection.",
                "Carved for royalty, its steel holds the might of an empire in every strike.", ItemRarity.MYSTIC);
    }

    public Equipment createDragospireEarthgnasher() {
        return new Equipment("Dragospire Earthgnasher", "Weapon", "hammer", "Warrior", 25, 0, 8, 17, 0, 0, 0,
                "Deals 270% weapon damage with defensive bonus of 8, crushing armor and barriers with devastating force.",
                "Fused with dragonbone, its bite crushes armor as easily as stone.", ItemRarity.MYSTIC);
    }

    public Equipment createLionheartClaymore() {
        return new Equipment("Lionheart Claymore", "Weapon", "sword", "Warrior", 28, 0, 2, 20, 6, 0, 0,
                "Deals 320% weapon damage with 6% critical hit chance, sacrificing defense for overwhelming offensive power.",
                "Forged with valor, its swings embody the courage of lions long past.", ItemRarity.ETHEREAL);
    }

    public Equipment createEssenclysticSkullsplitter() {
        return new Equipment("Essenclystic Skullsplitter", "Weapon", "hammer", "Warrior", 28, 0, 3, 25, 0, 0, 0,
                "Deals 350% weapon damage and drains enemy life force on hit, converting 20% of damage dealt into healing.",
                "Born of forbidden pacts, it siphons life with every swing, leaving Warlocks' foes weakened and the wielder hungering for more essence.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscWyngardeBlade() {
        return new Equipment("Asc Wyngarde Blade", "Weapon", "sword", "Warrior", 35, 0, 3, 28, 2, 2, 0,
                "Deals 400% weapon damage with 2% critical hit chance and 2% critical strength, the ultimate warrior weapon.",
                "Forged from the fallen star of a long-forgotten warlord, its edge never dulls, and its bearer's courage burns brighter with every swing.",
                ItemRarity.ASC);
    }

}
