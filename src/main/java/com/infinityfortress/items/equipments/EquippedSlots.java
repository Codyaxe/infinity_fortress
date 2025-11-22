package com.infinityfortress.items.equipments;

public class EquippedSlots {
    Equipment weapon;
    Equipment armor;
    Equipment accessory1;
    Equipment accessory2;

    public EquippedSlots() {
        this.weapon = new Equipment();
        this.armor = new Equipment();
        this.accessory1 = new Equipment();
        this.accessory2 = new Equipment();
    }

    public String getWeaponName() {
        return weapon.getName();
    }

    public String getArmorName() {
        return armor.getName();
    }

    public String getAccessory1Name() {
        return accessory1.getName();
    }

    public String getAccessory2Name() {
        return accessory2.getName();
    }
}
