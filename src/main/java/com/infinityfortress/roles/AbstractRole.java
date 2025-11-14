package com.infinityfortress.roles;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import com.infinityfortress.actions.*;

public class AbstractRole implements Role {
    protected ArrayList<Action> actions = new ArrayList<>();

    public AbstractRole() {
        actions.add(new AttackAction());
        actions.add(new BlockAction());
        actions.add(new RestAction());

    }

    public String getName() {
        return "Abstract Role";
    }

    public List<Action> getActions() {
        return Collections.unmodifiableList(actions);
    }

}