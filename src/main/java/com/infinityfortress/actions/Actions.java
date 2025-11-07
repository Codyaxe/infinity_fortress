package com.infinityfortress.actions;

public interface Actions {
    String getName();

    TargetingType getTargetingType();

    boolean hasSubActions();

    Actions[] getSubActions();

    void execute(Character user, Character target);

}
