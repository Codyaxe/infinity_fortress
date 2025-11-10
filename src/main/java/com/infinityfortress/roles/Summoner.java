package com.infinityfortress.roles;

import com.infinityfortress.actions.SummonAction;

public class Summoner extends AbstractRole {
    public Summoner() {
        super();
        actions.addLast(new SummonAction());
    }

    public String getName() {
        return "Summoner";
    }
}
