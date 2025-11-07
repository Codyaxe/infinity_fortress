package com.infinityfortress.roles;

import com.infinityfortress.actions.StealAction;

public class Rogue extends AbstractRole {
    public Rogue() {
        super();
        actions.addLast(new StealAction());
    }
}
