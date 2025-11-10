package com.infinityfortress.roles;

import com.infinityfortress.actions.BlockAction;

public class Tank extends AbstractRole {
    public Tank() {
        super();
        actions.addLast(new BlockAction());
    }

    public String getName() {
        return "Tank";
    }
}
