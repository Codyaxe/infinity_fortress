package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Actions;
import com.infinityfortress.actions.TargetingType;

public class ProtectOne implements Actions {
    public String getName() {
        return "Protect One";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Actions[] getSubActions() {
        return new Actions[0];
    };

    public void execute(Character user, Character target) {
        // If your target gets attacked, the user gets attacked instead.
    };
}
