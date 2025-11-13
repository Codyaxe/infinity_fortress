package com.infinityfortress.equipments;

import com.infinityfortress.equipments.accessories.*;
import com.infinityfortress.equipments.weapons.*;
import com.infinityfortress.equipments.armors.*;

public class Equipment {
    Weapon weapon;
    Armor armor;
    Accessory accessory1;
    Accessory accessory2;

    public Equipment() {
        this.weapon = new AbstractWeapon();
        this.armor = new AbstractArmor();
        this.accessory1 = new AbstractAccessory();
        this.accessory2 = new AbstractAccessory();
    }
}
