package com.infinityfortress.roles;

import com.infinityfortress.actions.GuardAction;

public class Tank extends AbstractRole {
    public Tank() {
        super();
        actions.addLast(new GuardAction());
    }

    public String getName() {
        return "Tank";
    }
}
