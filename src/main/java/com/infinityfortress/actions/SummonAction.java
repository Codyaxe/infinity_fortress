package com.infinityfortress.actions;

import com.infinityfortress.actions.summon.SummonDragon;
import com.infinityfortress.actions.summon.SummonFairy;
import com.infinityfortress.actions.summon.SummonWolf;

public class SummonAction extends SubAction {
    public SummonAction() {
        addSubAction(new SummonWolf());
        addSubAction(new SummonFairy());
        addSubAction(new SummonDragon());
    }

    public String getName() {
        return "Summon";
    }

}