package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.ui.BattleTopUI;
import com.infinityfortress.ui.DecisionUI;
import com.infinityfortress.ui.SubactionsUI;
import com.infinityfortress.characters.*;
import com.infinityfortress.utils.*;

public class DecisionSystem {
    private final Player player;
    private final Enemy enemy;

    public DecisionSystem(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean start(BattleTopUI battleTop, NCharacter curr, Action selectedAction) {
        TargetingType targetType = selectedAction.getTargetingType();

        // Checks which the ability targets
        switch (targetType) {
            case SINGLE_ENEMY -> {
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                if (enemies.isEmpty()) {
                    System.out.println("No valid targets available!");
                    return false;
                }
                NCharacter target = selectTarget(battleTop, enemies);
                if (target != null) {
                    selectedAction.execute(curr, target);
                    return true;
                }
                return false;
            }
            case SINGLE_ALLY -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                if (allies.isEmpty()) {
                    System.out.println("No valid ally targets available!");
                    return false;
                }
                NCharacter target = selectTarget(battleTop, allies);
                if (target != null) {
                    selectedAction.execute(curr, target);
                    return true;
                }
                return false;
            }
            case ALL_ENEMIES -> {
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                for (NCharacter enemy : enemies) {
                    selectedAction.execute(curr, enemy);
                }
                return true;
            }
            case ALL_ALLIES -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                for (NCharacter ally : allies) {
                    selectedAction.execute(curr, ally);
                }
                return true;
            }
            case SELF -> {
                selectedAction.execute(curr, curr);
                return true;
            }
            case NONE -> {
                selectedAction.execute(curr, null);
                return true;
            }
            case RANDOM -> {
                ArrayList<NCharacter> possibleTargets = getAliveEnemies(curr);
                if (!possibleTargets.isEmpty()) {
                    int randomIndex = (int) (Math.random() * possibleTargets.size());
                    selectedAction.execute(curr, possibleTargets.get(randomIndex));
                    return true;
                }
                return false;
            }
            case CHOOSE_SUBACTION -> {
                Action subAction = selectSubAction(battleTop, selectedAction);

                if (subAction == null) {
                    return false;
                }

                return start(battleTop, curr, subAction);

            }
            default -> {
                System.out.println("Unknown targeting type: " + targetType);
                return false;
            }
        }
    }

    // Helper method to get alive enemies based on current character's type. If it's
    // a player's turn, send enemy's pool. If it's an enemy's turn, send ally's
    // pool.
    private ArrayList<NCharacter> getAliveEnemies(NCharacter curr) {
        if (curr.getType() == NCharacterType.ALLY) {
            return enemy.characters.stream()
                    .filter(c -> c != null && c.getHealth() > 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return player.characters.stream()
                    .filter(c -> c != null && c.getHealth() > 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    // Helper method to get alive allies based on current character's type. If it's
    // a player's turn, send ally's pool. If it's an enemy's turn, send enemy's
    // pool.
    private ArrayList<NCharacter> getAliveAllies(NCharacter curr) {
        if (curr.getType() == NCharacterType.ALLY) {
            return player.characters.stream()
                    .filter(c -> c != null && c.getHealth() > 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return enemy.characters.stream()
                    .filter(c -> c != null && c.getHealth() > 0)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    // Subaction selection UI; will refactor
    private Action selectSubAction(BattleTopUI battleTop, Action subactions) {
        int choice = 0;
        int maxChoice = subactions.getAllSubActions().size() - 1;

        if (maxChoice == -1) {
            System.out.println("What? The Subactions are empty????");
            return null;
        }

        SubactionsUI currUI = new SubactionsUI(battleTop);

        while (true) {
            currUI.display(subactions.getAllSubActions(), choice);
            InputHandler.waitForInput();

            if (InputHandler.right.get()) {
                if (choice + 3 <= maxChoice) {
                    choice += 3;
                }
                InputHandler.right.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.left.get()) {
                if (choice >= 3) {
                    choice -= 3;
                }
                InputHandler.left.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.down.get()) {
                if (choice % 3 + 1 < 3 && choice + 1 <= maxChoice) {
                    choice++;
                }
                InputHandler.down.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.up.get()) {
                if ((choice % 3) > 0) {
                    choice--;
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
                return subactions.getAllSubActions().get(choice);
            }
        }
    }

    // Target selection UI; will refactor
    private NCharacter selectTarget(BattleTopUI battleTop, ArrayList<NCharacter> targets) {
        int choice = 0;
        DecisionUI currUI = new DecisionUI(battleTop);
        int maxChoice = targets.size() - 1;

        while (true) {
            currUI.display(targets, choice);
            InputHandler.waitForInput();

            if (InputHandler.right.get()) {
                if (choice + 3 <= maxChoice) {
                    choice += 3;
                }
                InputHandler.right.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.left.get()) {
                if (choice >= 3) {
                    choice -= 3;
                }
                InputHandler.left.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.down.get()) {
                if (choice % 3 + 1 < 3 && choice + 1 <= maxChoice) {
                    choice++;
                }
                InputHandler.down.set(false);
                AudioHandler.playSelect();
            }

            if (InputHandler.up.get()) {
                if ((choice % 3) > 0) {
                    choice--;
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
