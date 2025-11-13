package com.infinityfortress.roles;

import com.infinityfortress.actions.RangeAction;

public class Archer extends AbstractRole {
    public Archer() {
        super();
        actions.add(1, new RangeAction());
    }

    public String getName() {
        return "Archer";
    }
}
