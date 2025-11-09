package com.infinityfortress.roles;

import java.util.ArrayList;
import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.AttackAction;

public class AbstractRole implements Role {
    ArrayList<Action> actions = new ArrayList<>();

    public AbstractRole() {
        actions.addLast(new AttackAction());
    }

    public String getName(){
        return "Abstract Role";
    }
}
