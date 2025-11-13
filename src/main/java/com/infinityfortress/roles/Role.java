package com.infinityfortress.roles;

import java.util.List;

import com.infinityfortress.actions.Action;

public interface Role {
    public String getName();

    public List<Action> getActions();
}
