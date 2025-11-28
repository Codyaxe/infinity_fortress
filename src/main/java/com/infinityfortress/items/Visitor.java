package com.infinityfortress.items;

import com.infinityfortress.items.equipments.Equipment;
import com.infinityfortress.items.consumables.Consumables;

public interface Visitor {
    void visit(Equipment equipment);

    void visit(Consumables consumable);
}
