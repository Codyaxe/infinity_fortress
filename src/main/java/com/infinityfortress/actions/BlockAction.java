package com.infinityfortress.actions;

import com.infinityfortress.actions.block.ProtectAll;
import com.infinityfortress.actions.block.ProtectOne;
import com.infinityfortress.actions.block.ProtectShit;

public class BlockAction implements Actions {

    public String getName() {
        return "Block";
    }

    public TargetingType getTargetingType() {
        return TargetingType.CHOOSE_SUBACTION;
    }

    public boolean hasSubActions() {
        return false;
    };

    public Actions[] getSubActions() {
        return new Actions[] {
                new ProtectOne(),
                new ProtectAll(),
                new ProtectShit()
        };
    };

    public void execute(Character user, Character target) {
        // None
    };
}
