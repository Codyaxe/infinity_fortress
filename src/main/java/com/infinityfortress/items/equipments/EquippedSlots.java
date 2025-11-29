package com.infinityfortress.items.equipments;

import java.util.ArrayList;
import java.util.Arrays;

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

    public Equipment getWeapon() {
        return weapon;
    }

    public Equipment getArmor() {
        return armor;
    }

    public Equipment getAccessory1() {
        return accessory1;
    }

    public Equipment getAccessory2() {
        return accessory2;
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

    // Equals implementation
    public boolean equals(Equipment equipment) {
        ArrayList<Equipment> equipments = new ArrayList<>(
                Arrays.asList(this.accessory1, this.accessory2, this.armor, this.weapon));

        for (Equipment eq : equipments) {
            if (eq.getName() == equipment.getName()) {
                return true;
            }
        }
        return false;
    }
}
