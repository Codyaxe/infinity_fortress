package com.infinityfortress.actions;

import com.infinityfortress.actions.cast.Fireball;
import com.infinityfortress.actions.cast.IceShard;
import com.infinityfortress.actions.cast.LightningBolt;

public class CastAction extends SubAction {

    public CastAction() {
        addSubAction(new IceShard());
        addSubAction(new Fireball());
        addSubAction(new LightningBolt());
    }

    public String getName() {
        return "Cast";
    }

}
