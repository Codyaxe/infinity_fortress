package com.infinityfortress.actions.block;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;;

public class ProtectAll implements Action {
    public String getName() {
        return "Protect All";
    }

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ALLIES;
    }

    public void execute(NCharacter user, NCharacter target) {
        ProtectOne protectOne = new ProtectOne();
        protectOne.execute(user, target);
    };
}
