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
import com.infinityfortress.utils.MutableInt;

/* Changed the code so it follows a Strategy Pattern */

public class SubActionSystem {

    public SubActionSystem() {
    }

    public Action start(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
        SubActionProcessor processor = curr.getType() == NCharacterType.ALLY ? new PlayerSubActionProcessor()
                : new EnemySubActionProcessor();
        return processor.process(battleUI, curr, availableActions);
    }
}

interface SubActionProcessor {
    Action process(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions);
}

class PlayerSubActionProcessor implements SubActionProcessor {

    @Override
    public Action process(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
        MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new SubActionComponent(availableActions));

        MutableInt choice = new MutableInt(0);
        int maxChoice = availableActions.size() - 1;

        mainBattleUI.updateSelection();
        while (true) {
            mainBattleUI.updateChoice(choice.value);
            InputHandler.waitForInput();
            handleNavigation(choice, maxChoice);
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return null;
            }
            if (InputHandler.enter.get()) {
                InputHandler.enter.set(false);
                if (choice.value < availableActions.size()) {
                    return availableActions.get(choice.value);
                }
            }
        }
    }

    private void handleNavigation(MutableInt choice, int maxChoice) {
        if (InputHandler.left.get()) {
            choice.value = Math.max(0, choice.value - 1);
            InputHandler.left.set(false);
        }
        if (InputHandler.right.get()) {
            choice.value = Math.min(maxChoice, choice.value + 1);
            InputHandler.right.set(false);
        }
    }
}

class EnemySubActionProcessor implements SubActionProcessor {

    @Override
    public Action process(MainBattleUI battleUI, NCharacter curr, ArrayList<Action> availableActions) {
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
