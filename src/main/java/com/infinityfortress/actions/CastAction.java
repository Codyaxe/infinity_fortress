package com.infinityfortress.actions;

public class CastAction implements Actions {
    public String getName() {
        return "Cast";
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
