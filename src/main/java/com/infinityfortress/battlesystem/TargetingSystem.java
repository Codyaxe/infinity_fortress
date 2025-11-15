package com.infinityfortress.battlesystem;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.TargetingComponent;
import com.infinityfortress.utils.AudioHandler;
import com.infinityfortress.utils.InputHandler;

public class TargetingSystem {
    public TargetingSystem() {
    }

    public NCharacter start(MainBattleUI battleUI, ArrayList<NCharacter> targets) {
        MainBattleUI targetUI = new MainBattleUI(battleUI, new TargetingComponent(targets));
        int choice = 0;
        int maxChoice = targets.size() - 1;

        targetUI.updateSelection();
        while (true) {
            targetUI.updateChoice(choice);
            InputHandler.waitForInput();

            if (InputHandler.right.get()) {
                if (choice % 3 < 2 && choice + 1 <= maxChoice) {
                    choice++;
                }
                InputHandler.right.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.left.get()) {
                if (choice % 3 > 0) {
                    choice--;
                }
                InputHandler.left.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.down.get()) {
                if (choice + 3 <= maxChoice) {
                    choice += 3;
                }
                InputHandler.down.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.up.get()) {
                if (choice >= 3) {
                    choice -= 3;
                }
                InputHandler.up.set(false);
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
                return targets.get(choice);
            }
        }
    }
}
