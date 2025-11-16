package com.infinityfortress.equipments;

public class WarriorWeaponFactory {
    Equipment createRustbiteLongSword() {
        return new Equipment("Rustbite Longsword", "Weapon", "Warrior", 6, 0, 2, 4, 0, 0, 0,
                "A blade corroded yet deadly, its jagged edge bites deeper with every strike.", EquipmentRarity.FORGED);
    }

    Equipment createBonecrushWarspike() {
        return new Equipment("Bonecrush Warspike", "Weapon", "Warrior", 8, 0, 0, 5, 0, 0, 0,
                "Forged from shattered bones of ancient beasts, it delivers crushing force with each thrust.",
                EquipmentRarity.FORGED);
    }

    Equipment createForgebornBroadsword() {
        return new Equipment("Forgeborn Broadsword", "Weapon", "Warrior", 12, 0, 5, 7, 0, 0, 0,
                "Tempered in volcanic fires, it swings with relentless power and unyielding weight.",
                EquipmentRarity.FORGED);
    }

    Equipment createKnightsSaber() {
        return new Equipment("Knight's Sabre", "Weapon", "Warrior", 16, 0, 7, 9, 0, 0, 0,
                "Etched with honor-bound runes, its gleam inspires courage in allies and fear in foes.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createBloodforgeWaraxe() {
        return new Equipment("Bloodforge Waraxe", "Weapon", "Warrior", 18, 0, 6, 12, 0, 0, 0,
                "Born in sacrificial flames, each swing drips with the echoes of past battles.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createSentinelsHalberd() {
        return new Equipment("Sentinel's Halberd", "Weapon", "Warrior", 21, 0, 7, 14, 0, 0, 0,
                "A weapon of defense and offense, it guards its wielder while punishing intruders.",
                EquipmentRarity.ENCHANTED);
    }

    Equipment createKingsguardBastionblade() {
        return new Equipment("Kingsguard Bastionblade", "Weapon", "Warrior", 23, 0, 9, 14, 0, 0, 0,
                "Carved for royalty, its steel holds the might of an empire in every strike.", EquipmentRarity.MYSTIC);
    }

    Equipment createDragospireEarthgnasher() {
        return new Equipment("Dragospire Earthgnasher", "Weapon", "Warrior", 25, 0, 8, 17, 0, 0, 0,
                "Fused with dragonbone, its bite crushes armor as easily as stone.", EquipmentRarity.MYSTIC);
    }

    Equipment createLionheartClaymore() {
        return new Equipment("Lionheart Claymore", "Weapon", "Warrior", 28, 0, 2, 20, 6, 0, 0,
                "Forged with valor, its swings embody the courage of lions long past.", EquipmentRarity.ETHEREAL);
    }

    Equipment createEssenclysticSkullsplitter() {
        return new Equipment("Essenclystic Skullsplitter", "Weapon", "Warrior", 28, 0, 3, 25, 0, 0, 0,
                "Born of forbidden pacts, it siphons life with every swing, leaving Warlocks’ foes weakened and the wielder hungering for more essence.",
                EquipmentRarity.ETHEREAL);
    }

    Equipment createAscWyngardeBlade() {
        return new Equipment("Asc Wyngarde Blade", "Weapon", "Warrior", 35, 0, 3, 28, 2, 2, 0,
                "Forged from the fallen star of a long-forgotten warlord, its edge never dulls, and its bearer’s courage burns brighter with every swing.",
                EquipmentRarity.ASC);
    }

}
