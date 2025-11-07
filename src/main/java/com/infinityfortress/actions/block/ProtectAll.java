package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Actions;
import com.infinityfortress.actions.TargetingType;

public class ProtectAll implements Actions {
    public String getName() {
        return "Protect All";
    }

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ALLIES;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Actions[] getSubActions() {
        return new Actions[0];
    };

    public void execute(Character user, Character target) {
        // If the target gets attacked, the user gets attacked instead.
        // Battle System will use "for all" characters for this function
    };
}
