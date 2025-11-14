package com.infinityfortress.battlesystem;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.SubActionComponent;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.actions.Action;


public class SubActionSystem {
    private final DecisionSystem decisionSystem;

    public SubActionSystem(DecisionSystem decisionSystem) {
        this.decisionSystem = decisionSystem;
    }

    public boolean start(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
        MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new SubActionComponent(availableActions));

        int choice = 0;
        int maxChoice = availableActions.size() - 1;
        
        mainBattleUI.updateSelection();
        while (true) {
            mainBattleUI.updateChoice(choice);
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
              // if (choice >= availableActions.size()) {
              //     InputHandler.enter.set(false);
              //     continue; // Skip if choice is out of bounds
              // }
              InputHandler.enter.set(false);
            }
        }
    }
}
