package com.infinityfortress.actions;

import com.infinityfortress.actions.buff.Haste;
import com.infinityfortress.actions.buff.Restore;
import com.infinityfortress.actions.buff.Savage;

public class BuffAction extends SubAction {

    public BuffAction() {
        addSubAction(new Haste());
        addSubAction(new Restore());
        addSubAction(new Savage());
    }

    public String getName() {
        return "Buff";
    }

}
