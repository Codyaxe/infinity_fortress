package com.infinityfortress.actions;

import com.infinityfortress.actions.block.ProtectAll;
import com.infinityfortress.actions.block.ProtectOne;
import com.infinityfortress.actions.block.ProtectShit;

public class BlockAction extends SubAction {

    public BlockAction() {
        addSubAction(new ProtectOne());
        addSubAction(new ProtectAll());
        addSubAction(new ProtectShit());
    }

    public String getName() {
        return "Block";
    }
}
