package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;;

public class ProtectShit implements Action {
    public String getName() {
        return "Protect Shit";
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public void execute(NCharacter user, NCharacter target) {
        // WHY WOULD YOU PROTECT AN ENEMY???
    };
}
