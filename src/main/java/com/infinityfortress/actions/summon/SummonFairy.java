package com.infinityfortress.actions.summon;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.summoneffect.FairySummon;

public class SummonFairy implements Action {
    private String message;

    public String getName() {
        return "Summon Fairy";
    }

    public SummonFairy() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 10;
    }

    public int getBaseDamage() {
        return 0;
    }

    public String getStatDescription() {
        return "Summons a fairy familiar that heals a random ally each turn for a great amount";
    }

    public String getBattleDescription() {
        return "Summons a fairy to heal allies";
    }

    public String getBattleMessage() {
        return message;
    }

    public TargetingType getTargetingType() {
        return TargetingType.SELF;
    }

    public ActionType getActionType() {
        return ActionType.UTILITY;
    }

    public void execute(NCharacter user, NCharacter target) {
        user.addSummonEffect(new FairySummon(5));
        message = user.getName() + " summons a fairy familiar to aid allies!";
    }
}
