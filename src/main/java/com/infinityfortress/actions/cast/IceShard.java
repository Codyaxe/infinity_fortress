package com.infinityfortress.actions.cast;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class IceShard implements Action {

    public String getName() {
        return "Ice Shard";
    }

    public IceShard() {
    }

    public int getHitCount() {
        return 1;
    }

    public int getManaCost() {
        return 12;
    }

    public int getBaseDamage() {
        return 3;
    }

    public String getStatDescription() {
        return "A frozen shard that deals good magic damage to all enemies.";
    }

    public String getBattleDescription() {
        return "Fires an ice shard to all enemies.";
    }

    public String getBattleMessage() {
        return "All enemies are strucked with ice shards.";
    }

    public TargetingType getTargetingType() {
        return TargetingType.ALL_ENEMIES;
    }

    public ActionType getActionType() {
        return ActionType.DAMAGE;
    }

    public void execute(NCharacter user, NCharacter target) {
        int damage = getBaseDamage() + (user.getStrength() / 3);
        Utils.processDamage(user, target, damage);
    }
}
