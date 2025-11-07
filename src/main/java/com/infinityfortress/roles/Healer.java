package com.infinityfortress.roles;

import com.infinityfortress.actions.HealAction;

public class Healer extends AbstractRole {
    public Healer() {
        super();
        actions.addLast(new HealAction());
    }
}
