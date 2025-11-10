package com.infinityfortress.battlesystem;

import com.infinityfortress.actions.Action;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.ActionUI;
import com.infinityfortress.ui.BattleTopUI;
import com.infinityfortress.utils.*;
import java.util.ArrayList;

public class ActionSystem {
    private final DecisionSystem decisionSystem;

    public ActionSystem(DecisionSystem decisionSystem) {
        this.decisionSystem = decisionSystem;
    }

    public boolean start(BattleTopUI battleTop, NCharacter curr) {
        ArrayList<Action> availableActions = curr.getRole().getActions();
        if (availableActions.isEmpty()) {
            System.out.println("Character has no available actions!");
            return false;
        }

        int choice = 0;
        int maxChoice = availableActions.size() - 1;
        ActionUI currUI = new ActionUI(battleTop);

        while (true) {
            currUI.display(availableActions, choice);
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                choice = Math.max(0, choice - 1);
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                choice = Math.min(maxChoice, choice + 1);
                InputHandler.right.set(false);
            }
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return false;
            }
            if (InputHandler.enter.get()) {
                Action selectedAction = availableActions.get(choice);

                if (decisionSystem.start(battleTop, curr, selectedAction)) {
                    return true;
                }
                InputHandler.enter.set(false);
            }
        }
    }
}
