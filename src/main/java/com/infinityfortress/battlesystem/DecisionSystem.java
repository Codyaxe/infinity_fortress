package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.ActionComponent;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;

public class DecisionSystem {
    private final Player player;
    private final Enemy enemy;

    public DecisionSystem(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean start(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new ActionComponent());

        TargetingType targetType = selectedAction.getTargetingType();

        mainBattleUI.display();
        switch (targetType) {
            case TargetingType.SINGLE_ENEMY -> {
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                if (enemies.isEmpty()) {
                    System.out.println("No valid targets available!");
                    return false;
                }
                TargetingSystem targetingSystem = new TargetingSystem();
                NCharacter target = targetingSystem.start(mainBattleUI, enemies);
                if (target != null) {
                    selectedAction.execute(curr, target);
                    return true;
                }
                return false;
            }
            case TargetingType.SINGLE_ALLY -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                if (allies.isEmpty()) {
                    System.out.println("No valid ally targets available!");
                    return false;
                }
                TargetingSystem targetingSystem = new TargetingSystem();
                NCharacter target = targetingSystem.start(mainBattleUI, allies);
                if (target != null) {
                    selectedAction.execute(curr, target);
                    return true;
                }
                return false;
            }
            case TargetingType.ALL_ENEMIES -> {
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                for (NCharacter enemy : enemies) {
                    selectedAction.execute(curr, enemy);
                }
                return true;
            }
            case TargetingType.ALL_ALLIES -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                for (NCharacter ally : allies) {
                    selectedAction.execute(curr, ally);
                }
                return true;
            }
            case TargetingType.SELF -> {
                selectedAction.execute(curr, curr);
                return true;
            }
            case TargetingType.NONE -> {
                selectedAction.execute(curr, null);
                return true;
            }
            case TargetingType.RANDOM -> {
                ArrayList<NCharacter> possibleTargets = getAliveEnemies(curr);
                if (!possibleTargets.isEmpty()) {
                    int randomIndex = (int) (Math.random() * possibleTargets.size());
                    selectedAction.execute(curr, possibleTargets.get(randomIndex));
                    return true;
                }
                return false;
            }
            case TargetingType.CHOOSE_SUBACTION -> {
                SubActionSystem subActionSystem = new SubActionSystem();
                Action subAction = subActionSystem.start(battleUI, curr, selectedAction.getAllSubActions());

                if (subAction == null) {
                    return false;
                }

                return start(battleUI, curr, subAction);

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

}
