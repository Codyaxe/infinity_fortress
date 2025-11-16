package com.infinityfortress.actions;

import com.infinityfortress.actions.heal.HealOne;
import com.infinityfortress.actions.heal.HealAll;

public class HealAction extends SubAction {

    public HealAction() {
        addSubAction(new HealOne());
        addSubAction(new HealAll());
    }

    @Override
    public String getName() {
        return "Heal";
    }
}