package com.infinityfortress.actions.summon;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.summoneffect.WolfSummon;

public class SummonWolf implements Action {
    private String message;

    public String getName() {
        return "Summon Wolf";
    }

    public SummonWolf() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 6;
    }

    public int getBaseDamage() {
        return 0;
    }

    public String getStatDescription() {
        return "Summons a wolf pack that attacks 2 random enemies each turn for a good damage";
    }

    public String getBattleDescription() {
        return "Summons a wolf pack to attack enemies";
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
        user.addSummonEffect(new WolfSummon(8));
        message = user.getName() + " summons a wolf pack!";
    }
}
