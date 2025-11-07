package com.infinityfortress.actions;

public class AttackAction implements Actions {
    public String getName() {
        return "Attack";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Actions[] getSubActions() {
        return new Actions[0];
    };

    public void execute(Character user, Character target) {
        // Deal normal damage to an attacker
    };
}
