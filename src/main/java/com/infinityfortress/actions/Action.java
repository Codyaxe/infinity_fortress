package com.infinityfortress.actions;

public interface Action {
    String getName();

    TargetingType getTargetingType();

    void execute(Character user, Character target);

}
