package com.infinityfortress.actions;

public class AttackAction implements Action {
    public String getName() {
        return "Attack";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(Character user, Character target) {
        // Deal normal damage to a target
    };
}
