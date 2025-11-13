package com.infinityfortress.actions;

import com.infinityfortress.actions.block.ProtectAll;
import com.infinityfortress.actions.block.ProtectOne;
import com.infinityfortress.actions.block.ProtectShit;

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
