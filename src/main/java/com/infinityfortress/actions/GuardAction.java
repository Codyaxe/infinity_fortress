package com.infinityfortress.actions;

import com.infinityfortress.actions.guard.ProtectAll;
import com.infinityfortress.actions.guard.ProtectOne;
import com.infinityfortress.actions.guard.ProtectShit;

public class GuardAction extends SubAction {

    public GuardAction() {
        addSubAction(new ProtectOne());
        addSubAction(new ProtectAll());
        addSubAction(new ProtectShit());
    }

    public String getName() {
        return "Guard";
    }
}
