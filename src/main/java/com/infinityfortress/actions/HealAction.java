package com.infinityfortress.actions;

public class HealAction implements Actions {
    public String getName() {
        return "Heal";
    }

    public TargetingType getTargetingType() {
        return TargetingType.CHOOSE_SUBACTION;
    }

    public boolean hasSubActions() {
        return true;
    };

    public Actions[] getSubActions() {
        return new Actions[] {};
    };

    public void execute(Character user, Character target) {
        // None
    };
}