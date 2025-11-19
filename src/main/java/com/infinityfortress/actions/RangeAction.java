package com.infinityfortress.actions;

import com.infinityfortress.actions.range.Barrage;
import com.infinityfortress.actions.range.Multishot;
import com.infinityfortress.actions.range.RapidShot;

public class RangeAction extends SubAction {
    public RangeAction() {
        addSubAction(new Barrage());
        addSubAction(new Multishot());
        addSubAction(new RapidShot());
    }

    public String getName() {
        return "Range";
    }
}