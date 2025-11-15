package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.IntStream;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.TargetingComponent;
import com.infinityfortress.utils.AudioHandler;
import com.infinityfortress.utils.InputHandler;

public class TargetingSystem {
    private Action selectedAction;
    private NCharacter current;

    public TargetingSystem(Action selectedAction, NCharacter current) {
        this.selectedAction = selectedAction;
        this.current = current;
    }

    public NCharacter start(MainBattleUI battleUI, ArrayList<NCharacter> targets) {

        if (current.getType() == NCharacterType.ALLY) {
            return processPlayer(battleUI, targets);
        } else {
            return processEnemy(targets);
        }

    }

    private NCharacter processPlayer(MainBattleUI battleUI, ArrayList<NCharacter> targets) {
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

    private NCharacter processEnemy(ArrayList<NCharacter> targets) {
        int maxChoice = targets.size() - 1;
        int[] scores = new int[targets.size()];

        ActionType actionType = selectedAction.getActionType();

        for (int i = 0; i <= maxChoice; i++) {
            NCharacter target = targets.get(i);

            // Damage-dependent
            if (actionType == ActionType.DAMAGE) {
                if (target.getHealth() <= (int) (0.10 * target.getMaxHealth())) {
                    scores[i] += 100;
                } else if (target.getHealth() <= (int) (0.25 * target.getMaxHealth())) {
                    scores[i] += 75;
                } else if (target.getHealth() <= (int) (0.50 * target.getMaxHealth())) {
                    scores[i] += 50;
                }

                if (attackDominant(current)) {
                    scores[i] += (int) (target.getMaxHealth() * 0.1);
                }
            }

            // Utility-dependent
            else {
                if (target.getHealth() <= (int) (0.25 * target.getMaxHealth())) {
                    scores[i] += 100;
                } else if (target.getHealth() <= (int) (0.50 * target.getMaxHealth())) {
                    scores[i] += 75;
                } else if (target.getHealth() <= (int) (0.75 * target.getMaxHealth())) {
                    scores[i] += 50;
                }
            }
        }

        int choice = IntStream.range(0, scores.length)
                .boxed()
                .max(Comparator.comparingInt(i -> scores[i]))
                .orElse(-1);

        return targets.get(choice);
    }

    private boolean attackDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Rogue") || role.equals("Archer")
                || role.equals("Mage") || role.equals("Summoner");
    }

}
