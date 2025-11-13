package com.infinityfortress.roles;

import com.infinityfortress.actions.BuffAction;

public class Cleric extends AbstractRole {
    public Cleric() {
        super();
        actions.add(1, new BuffAction());
    }

    public String getName() {
        return "Cleric";
    }
}
