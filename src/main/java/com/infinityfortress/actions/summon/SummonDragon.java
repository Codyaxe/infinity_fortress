package com.infinityfortress.actions.summon;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.summoneffect.DragonSummon;

public class SummonDragon implements Action {
    private String message;

    public String getName() {
        return "Summon Dragon";
    }

    public SummonDragon() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 8;
    }

    public int getBaseDamage() {
        return 0;
    }

    public String getStatDescription() {
        return "Summons a dragon that strikes a single enemy each turn for great damage";
    }

    public String getBattleDescription() {
        return "Summons a dragon to strike enemies";
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
        user.addSummonEffect(new DragonSummon(5));
        message = user.getName() + " summons a dragon to protect them!";
    }
}
