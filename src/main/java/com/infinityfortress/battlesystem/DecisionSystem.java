package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.ui.BattleTopUI;
import com.infinityfortress.ui.DecisionUI;
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

        switch (targetType) {
            case SINGLE_ENEMY -> {
                // Show enemy selection UI
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                if (enemies.isEmpty()) {
                    System.out.println("No valid targets available!");
                    return false;
                }
                NCharacter target = selectTarget(battleTop, enemies, "Choose enemy target:");
                if (target != null) {
                    selectedAction.execute(curr, target);
                    return true;
                }
                return false;
            }
            case SINGLE_ALLY -> {
                // Show ally selection UI
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                if (allies.isEmpty()) {
                    System.out.println("No valid ally targets available!");
                    return false;
                }
                NCharacter target = selectTarget(battleTop, allies, "Choose ally target:");
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
                // Randomly select target from appropriate pool
                ArrayList<NCharacter> possibleTargets = getAliveEnemies(curr);
                if (!possibleTargets.isEmpty()) {
                    int randomIndex = (int) (Math.random() * possibleTargets.size());
                    selectedAction.execute(curr, possibleTargets.get(randomIndex));
                    return true;
                }
                return false;
            }
            case CHOOSE_SUBACTION -> {
                // Implement subactions
                System.out.println("Sub-action selection not yet implemented");
                return false;
            }
            default -> {
                System.out.println("Unknown targeting type: " + targetType);
                return false;
            }
        }
    }

    // Helper method to get alive enemies based on current character's type
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

    // Helper method to get alive allies based on current character's type
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

    // Target selection UI
    private NCharacter selectTarget(BattleTopUI battleTop, ArrayList<NCharacter> targets, String prompt) {
        int choice = 0;
        DecisionUI currUI = new DecisionUI(battleTop);
        int maxChoice = targets.size() - 1;

        System.out.println(prompt);

        while (true) {
            currUI.display(targets, choice);
            InputHandler.waitForInput();

            if (InputHandler.right.get()) {
                if (choice + 3 <= maxChoice) {
                    choice += 3;
                }
                InputHandler.right.set(false);
            }

            if (InputHandler.left.get()) {
                if (choice >= 3) {
                    choice -= 3;
                }
                InputHandler.left.set(false);
            }

            if (InputHandler.down.get()) {
                if (choice % 3 + 1 < 3 && choice + 1 <= maxChoice) {
                    choice++;
                }
                InputHandler.down.set(false);
            }

            if (InputHandler.up.get()) {
                if ((choice % 3) > 0) {
                    choice--;
                }
                InputHandler.up.set(false);
            }

            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return null; // Selection cancelled
            }

            if (InputHandler.enter.get()) {
                InputHandler.enter.set(false);
                return targets.get(choice); // Return selected target
            }
        }
    }
}
