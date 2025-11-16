package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.IntStream;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.ActionType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.effects.temporaryeffect.ProtectEffect;
import com.infinityfortress.effects.temporaryeffect.RageEffect;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffect;
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

            switch (actionType) {
                case DAMAGE:
                    if (target.getHealth() <= (int) (0.10 * target.getMaxHealth())) {
                        scores[i] += 100;
                    } else if (target.getHealth() <= (int) (0.25 * target.getMaxHealth())) {
                        scores[i] += 75;
                    } else if (target.getHealth() <= (int) (0.50 * target.getMaxHealth())) {
                        scores[i] += 50;
                    }

                    if (isSquishy(current)) {
                        scores[i] += (int) ((target.getMaxHealth() / target.getHealth()) * 2);
                    }

                    break;
                case HEAL:
                    if (target.getHealth() <= (int) (0.25 * target.getMaxHealth())) {
                        scores[i] += 100;
                    } else if (target.getHealth() <= (int) (0.50 * target.getMaxHealth())) {
                        scores[i] += 75;
                    } else if (target.getHealth() <= (int) (0.75 * target.getMaxHealth())) {
                        scores[i] += 50;
                    }
                    break;
                case RESTORATION:
                    if (target.getMana() <= (int) (0.25 * target.getMaxMana())) {
                        scores[i] += 100;
                    } else if (target.getMana() <= (int) (0.50 * target.getMaxMana())) {
                        scores[i] += 75;
                    } else if (target.getMana() <= (int) (0.75 * target.getMaxMana())) {
                        scores[i] += 50;
                    }
                    break;
                case PROTECTION:
                    if (defenseDominant(target)) {
                        scores[i] += 50;
                    } else if (isSquishy(target)) {
                        scores[i] += 75;
                    }

                    if (!hasCondition(target, new ProtectEffect())) {
                        scores[i] -= 200;
                    }
                    break;
                case STRENGTH:
                    if (attackDominant(target) && !hasCondition(target, new RageEffect())) {
                        scores[i] += 50;
                    }
                    break;
                case SPEED:
                    if (speedDominant(target)) {
                        scores[i] += 50;
                    }
                    break;
                case CRITICAL:
                    if (criticalDominant(target)) {
                        scores[i] += 50;
                    }
                    break;
                case HEALTH:
                    if (healthDominant(target)) {
                        scores[i] += 50;
                    } else if (isSquishy(target)) {
                        scores[i] += 75;
                    }
                    break;
                case UTILITY:
                    if (utilityDependent(target)) {
                        scores[i] += 50;
                    }
                    break;
                default:
                    break;
            }
        }

        int maxScore = IntStream.of(scores).max().orElse(-1);

        ArrayList<Integer> maxIndices = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                maxIndices.add(i);
            }
        }

        int choice = maxIndices.get((int) (Math.random() * maxIndices.size()));

        return targets.get(choice);
    }

    private boolean attackDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Rogue") || role.equals("Archer")
                || role.equals("Mage") || role.equals("Summoner");
    }

    private boolean speedDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Rogue") || role.equals("Archer");
    }

    private boolean criticalDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Mage") || role.equals("Archer");
    }

    private boolean healthDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Tank");
    }

    private boolean defenseDominant(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Tank") || role.equals("Warlock");
    }

    private boolean utilityDependent(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Warrior") || role.equals("Mage") || role.equals("Warlock") || role.equals("Rogue")
                || role.equals("Summoner");
    }

    private boolean isSquishy(NCharacter character) {
        String role = character.getRole().getName();
        return role.equals("Healer") || role.equals("Cleric") || role.equals("Archer") || role.equals("Rogue")
                || role.equals("Summoner");
    }

    private boolean hasCondition(NCharacter character, TemporaryEffect status) {
        for (TemporaryEffect condition : character.getAllTemporaryEffect()) {
            if (condition.equals(status)) {
                return true;
            }
        }
        return false;
    }

}
