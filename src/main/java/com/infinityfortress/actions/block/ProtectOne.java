package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;

public class ProtectOne implements Action {
    public String getName() {
        return "Protect One";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ALLY;
    }

    public void execute(Character user, Character target) {
        // If your target gets attacked, the user gets attacked instead.
    };
}
