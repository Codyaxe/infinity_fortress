package com.infinityfortress.roles;

import com.infinityfortress.actions.SummonAction;

public class Summoner extends AbstractRole {
    public Summoner() {
        super();
        actions.add(1, new SummonAction());
    }

    public String getName() {
        return "Summoner";
    }
}
