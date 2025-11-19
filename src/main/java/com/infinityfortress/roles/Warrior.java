package com.infinityfortress.roles;

import com.infinityfortress.actions.PowerAction;
import com.infinityfortress.actions.SubAction;

public class Warrior extends AbstractRole {
    public Warrior() {
        super();
        actions.add(1, new SubAction(new PowerAction()));
    }

    @Override
    public String getName() {
        return "Warrior";
    }
}