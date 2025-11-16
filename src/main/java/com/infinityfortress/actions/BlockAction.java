package com.infinityfortress.actions;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffect;

public class BlockAction implements Action {
    private String message;

    public String getName() {
        return "Block";
    }

    public BlockAction() {
    }

    public int getHitCount() {
        return 0;
    }

    public int getManaCost() {
        return 0;
    };

    public int getBaseDamage() {
        return 0;
    };

    public String getStatDescription() {
        return "Block Stat Description";
    };

    public String getBattleDescription() {
        return "Block Battle Description";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.SELF;
    }

    public ActionType getActionType() {
        return ActionType.GENERIC;
    };

    public Action[] getSubActions() {
        return new Action[0];
    };

    public void execute(NCharacter user, NCharacter target) {
        TemporaryEffect block = new TemporaryEffect(1, target) {
            @Override
            public void apply() {
                this.target.setDefense(this.target.getDefense() + 3);
            }

            @Override
            public void remove() {
                this.target.setStrength(this.target.getStrength() - 3);
            }

            @Override
            public String getName() {
                return "Block";
            }
        };

        block.apply();
        message = String.format("%s blocked.", user.getName());
    };

}
