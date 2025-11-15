package com.infinityfortress.battlesystem;

import java.util.ArrayList;

import com.infinityfortress.actions.Action;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.SubActionComponent;
import com.infinityfortress.utils.AudioHandler;
import com.infinityfortress.utils.InputHandler;

public class SubActionSystem {

    public SubActionSystem() {
    }

    public Action start(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
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
                AudioHandler.playSelect();
            }
            if (InputHandler.right.get()) {
                choice = Math.min(maxChoice, choice + 1);
                InputHandler.right.set(false);
                AudioHandler.playSelect();
            }
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                AudioHandler.playBack();
                return null;
            }
            if (InputHandler.enter.get()) {
                InputHandler.enter.set(false);
                AudioHandler.playEnter();
                if (choice < availableActions.size()) {
                    return availableActions.get(choice);
                }
            }
        }
    }
}
