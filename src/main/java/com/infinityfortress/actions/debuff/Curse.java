package com.infinityfortress.actions.debuff;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.CurseEffect;

public class Curse implements Action {
    private String message;

    public String getName() {
        return "Curse";
    }

    public Curse() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 5;
    }

    public int getBaseDamage() {
        return 0;
    }

    public String getStatDescription() {
        return "Reduces the target's defense by 5 for 3 turns.";
    }

    public String getBattleDescription() {
        return "Curses the target, lowering their defenses.";
    }

    public String getBattleMessage() {
        return message;
    }

    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }

    public ActionType getActionType() {
        return ActionType.UTILITY;
    }

    public void execute(NCharacter user, NCharacter target) {
        CurseEffect curseEffect = new CurseEffect(3, target);

        curseEffect.apply();
        target.addTemporaryEffect(curseEffect);
        message = String.format("%s is cursed!", target.getName());
    }
}
