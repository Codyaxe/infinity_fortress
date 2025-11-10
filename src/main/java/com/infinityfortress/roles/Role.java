package com.infinityfortress.roles;

import java.util.ArrayList;

import com.infinityfortress.actions.Action;

public interface Role {
    public String getName();

    public ArrayList<Action> getActions();
}
