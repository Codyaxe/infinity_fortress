package com.infinityfortress.roles;

import com.infinityfortress.actions.DebuffAction;

public class Warlock extends AbstractRole {
    public Warlock() {
        super();
        actions.add(1, new DebuffAction());
        addAdditionalActions();
    }

    public String getName() {
        return "Warlock";
    }
}
