package com.infinityfortress.actions;

import com.infinityfortress.actions.power.DeepCut;
import com.infinityfortress.actions.power.Enrage;
import com.infinityfortress.actions.power.MeteorSmash;

public class PowerAction extends SubAction {

    public PowerAction() {
        addSubAction(new Enrage());
        addSubAction(new DeepCut());
        addSubAction(new MeteorSmash());
    }

    public String getName() {
        return "Power";
    }

}