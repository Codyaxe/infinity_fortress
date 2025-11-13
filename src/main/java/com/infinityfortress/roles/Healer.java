package com.infinityfortress.roles;

import com.infinityfortress.actions.HealAction;

public class Healer extends AbstractRole {
    public Healer() {
        super();
        actions.add(1, new HealAction());
    }

    public String getName() {
        return "Healer";
    }
}
