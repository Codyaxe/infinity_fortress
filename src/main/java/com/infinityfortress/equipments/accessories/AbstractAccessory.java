package com.infinityfortress.equipments.accessories;

public class AbstractAccessory implements Accessory {
    public AbstractAccessory() {
    };

    public String getName() {
        return "Abstract Accessory";
    };

    public String getType() {
        return "Accessory";
    };

    public String getDescription() {
        return "A blueprint for all Accessory";
    };
}
