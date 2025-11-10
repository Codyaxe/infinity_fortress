package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public interface Action {
    String getName();

    int getHitCount();

    int getManaCost();

    int getBaseDamage();

    String getActionType();

    String getDescription();

    TargetingType getTargetingType();

    void execute(NCharacter user, NCharacter target);

}
