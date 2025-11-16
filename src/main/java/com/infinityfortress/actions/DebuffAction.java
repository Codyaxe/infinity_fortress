package com.infinityfortress.actions;

import com.infinityfortress.actions.debuff.Curse;
import com.infinityfortress.actions.debuff.Slow;
import com.infinityfortress.actions.debuff.Weaken;

public class DebuffAction extends SubAction {

    public DebuffAction() {
        addSubAction(new Curse());
        addSubAction(new Slow());
        addSubAction(new Weaken());
    }

    public String getName() {
        return "Debuff";
    }
}