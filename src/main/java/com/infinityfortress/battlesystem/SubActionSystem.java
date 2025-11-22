package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

import com.infinityfortress.actions.Action;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.SubActionComponent;
import com.infinityfortress.utils.InputHandler;

public class SubActionSystem {

    public SubActionSystem() {
    }

    public Action start(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
        if (curr.getType() == NCharacterType.ALLY) {
            return processPlayer(battleUI, curr, availableActions);
        } else {
            return processEnemy(curr, availableActions);
        }
    }

    private Action processPlayer(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
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
                return null;
            }
            if (InputHandler.enter.get()) {
                InputHandler.enter.set(false);
                if (choice < availableActions.size()) {
                    return availableActions.get(choice);
                }
            }
        }
    }

    private Action processEnemy(NCharacter curr, ArrayList<Action> availableActions) {
        int[] scores = new int[availableActions.size()];

        for (int i = 0; i < availableActions.size(); i++) {
            Action action = availableActions.get(i);
            if (isCastable(curr, action)) {
                scores[i] += 50;
            }

            if (curr.getMana() == curr.getMaxMana() && action.getManaCost() >= 10) {
                scores[i] += 10;
            }

        }

        int choice = IntStream.range(0, scores.length)
                .boxed()
                .max(Comparator.comparingInt(i -> scores[i]))
                .orElse(-1);

        return availableActions.get(choice);

    }

    private boolean isCastable(NCharacter curr, Action action) {
        return curr.getMana() >= action.getManaCost();
    }

}
