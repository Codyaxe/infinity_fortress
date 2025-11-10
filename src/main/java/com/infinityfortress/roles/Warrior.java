package com.infinityfortress.roles;

import com.infinityfortress.actions.PowerAction;

public class Warrior extends AbstractRole {
    public Warrior() {
        super();
        actions.addLast(new PowerAction());
    }

    public String getName() {
        return "Warrior";
    }
}
