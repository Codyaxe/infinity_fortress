package com.infinityfortress.roles;

import com.infinityfortress.actions.PowerAction;

public class Warrior extends AbstractRole {
    public Warrior() {
        super();
        actions.add(1, new PowerAction());
    }

    public String getName() {
        return "Warrior";
    }
}
