package com.infinityfortress.actions;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

public interface Action {
    String getName();

    int getHitCount();

    int getManaCost();

    int getBaseDamage();

    String getActionType();

    String getStatDescription();

    String getBattleDescription();

    TargetingType getTargetingType();
    

    default ArrayList<Action> getAllSubActions() {
        return new ArrayList<Action>();
    }

    void execute(NCharacter user, NCharacter target);

}