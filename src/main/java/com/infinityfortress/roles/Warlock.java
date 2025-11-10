package com.infinityfortress.roles;

import com.infinityfortress.actions.DebuffAction;

public class Warlock extends AbstractRole {
    public Warlock() {
        super();
        actions.addLast(new DebuffAction());
    }

    public String getName() {
        return "Warlock";
    }
}
