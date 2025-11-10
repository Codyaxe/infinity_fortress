package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public interface Action {
    String getName();

    int getHitCount();

    TargetingType getTargetingType();

    void execute(NCharacter user, NCharacter target);

    default String getDescription() {
        return "No description available";
    }

    default int getManaCost() {
        return 0;
    }

    default int getBaseDamage() {
        return 0;
    }

    default String getActionType() {
        return "Action";
    }
}
