package com.infinityfortress.equipments.armors;

public class AbstractArmor implements Armor {
    public AbstractWeapon() {
    };

    public String getName() {
        return "Abstract Armor";
    };

    public String getType() {
        return "Armor";
    };

    public String getDescription() {
        return "A blueprint for all Armor";
    };
}
