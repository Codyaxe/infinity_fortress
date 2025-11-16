package com.infinityfortress.actions.cast;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class LightningBolt implements Action {

    public String getName() {
        return "Lightning Bolt";
    }

    public LightningBolt() {
    }

    public int getHitCount() {
        return 1;
    }

    public int getManaCost() {
        return 25;
    }

    public int getBaseDamage() {
        return 9;
    }

    public String getStatDescription() {
        return "A powerful lightning strike that deals powerful magic damage to all enemies.";
    }

    public String getBattleDescription() {
        return "Strikes all enemies with lightning.";
    }

    public String getBattleMessage() {
        return "All enemies are strucked with lighting.";
    }

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ENEMIES;
    }

    public ActionType getActionType() {
        return ActionType.DAMAGE;
    }

    public void execute(NCharacter user, NCharacter target) {
        int damage = getBaseDamage() + user.getStrength();
        Utils.processDamage(user, target, damage);
    }
}
