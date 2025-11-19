package com.infinityfortress.actions;

import java.util.ArrayList;
import java.util.List;

import com.infinityfortress.characters.NCharacter;

public class SubAction implements Action {
    protected final List<Action> subActions = new ArrayList<>();
    private String message;

    public SubAction() {
    }

    public SubAction(Action act) {
        addSubAction(act);
    }

    public String getName() {
        return "Sub Actions";
    };

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
        return "A SUBACTION";
    };

    public String getBattleDescription() {
        return "A SUBACTION";
    };

    public String getBattleMessage() {
        return message;
    };

    public TargetingType getTargetingType() {
        return TargetingType.CHOOSE_SUBACTION;
    };

    public ActionType getActionType() {
        return ActionType.NOTHING;
    };

    @Override
    public ArrayList<Action> getAllSubActions() {
        return new ArrayList<>(subActions);
    };

    // Say your character levels up or learns a new skill, you can use addSubaction.
    public final void addSubAction(Action action) {
        subActions.add(action);
    }

    public void removeSubAction(Action action) {
        subActions.remove(action);
    }

    // For name-based finding
    public Action getSubAction(String name) {
        for (Action action : subActions) {
            if (action.getName().equals(name)) {
                return action;
            }
        }
        return null;
    }

    // For positional-based finding
    public Action getSubAction(int index) {
        if (index >= 0 && index < subActions.size()) {
            return subActions.get(index);
        }
        return null;
    }

    public boolean hasSubAction(String name) {
        for (Action action : subActions) {
            if (action.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearSubActions() {
        subActions.clear();
    }

    public int getSubActionCount() {
        return subActions.size();
    }

    public void execute(NCharacter user, NCharacter target) {
        System.out.println("Why are you executing a generic sub action?");
    };
}
