package com.infinityfortress.roles;

import com.infinityfortress.actions.CastAction;

public class Mage extends AbstractRole {
    public Mage() {
        super();
        actions.addLast(new CastAction());
    }
}
