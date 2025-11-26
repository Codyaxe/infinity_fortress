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

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public void setAccessory1(Equipment accessory1) {
        this.accessory1 = accessory1;
    }

    public void setAccessory2(Equipment accessory2) {
        this.accessory2 = accessory2;
    }
}
