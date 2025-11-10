package com.infinityfortress.roles;

import com.infinityfortress.actions.RangeAction;

public class Archer extends AbstractRole {
    public Archer() {
        super();
        actions.addLast(new RangeAction());
    }

    public String getName() {
        return "Archer";
    }
}
