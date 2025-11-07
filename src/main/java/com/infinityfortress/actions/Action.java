package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;

public interface Action {
    String getName();

    TargetingType getTargetingType();

    void execute(NCharacter user, NCharacter target);

}
