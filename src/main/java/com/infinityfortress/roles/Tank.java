package com.infinityfortress.roles;

import com.infinityfortress.actions.GuardAction;

public class Tank extends AbstractRole {
    public Tank() {
        super();
        actions.add(1, new GuardAction());
    }

    public String getName() {
        return "Tank";
    }
}
