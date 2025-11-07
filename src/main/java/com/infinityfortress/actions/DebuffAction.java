package com.infinityfortress.actions;

public class DebuffAction implements Actions {
    public String getName() {
        return "Debuff";
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