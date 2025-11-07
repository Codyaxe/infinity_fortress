package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Actions;
import com.infinityfortress.actions.TargetingType;

public class ProtectShit implements Actions {
    public String getName() {
        return "Protect Shit";
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
        // WHY WOULD YOU PROTECT AN ENEMY???
    };
}
