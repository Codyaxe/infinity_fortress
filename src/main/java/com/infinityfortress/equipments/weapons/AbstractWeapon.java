package com.infinityfortress.equipments.weapons;

public class AbstractWeapon implements Weapon {
    public AbstractWeapon() {
    };

    public String getName() {
        return "Abstract Weapon";
    };

    public String getType() {
        return "Weapon";
    };

    public String getDescription() {
        return "A blueprint for all Weapon";
    };
}
