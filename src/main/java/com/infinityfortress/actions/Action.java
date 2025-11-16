package com.infinityfortress.actions;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

public interface Action {
    String getName();

    int getHitCount();

    int getManaCost();

    int getBaseDamage();

    String getStatDescription();

    String getBattleDescription();

    String getBattleMessage();

    TargetingType getTargetingType();

    ActionType getActionType();

    default ArrayList<Action> getAllSubActions() {
        return new ArrayList<Action>();
    }

    void execute(NCharacter user, NCharacter target);

}