package com.infinityfortress.roles;

import com.infinityfortress.actions.CastAction;

public class Mage extends AbstractRole {
    public Mage() {
        super();
        actions.add(1, new CastAction());
    }

    public String getName() {
        return "Mage";
    }
}
