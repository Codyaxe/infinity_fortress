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
import com.infinityfortress.utils.Printbox;

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
                    Printbox.showMessage(mainBattleUI, "No valid ally targets available!");
                    return false;
                }
                TargetingSystem targetingSystem = new TargetingSystem(selectedAction, curr);
                NCharacter target = targetingSystem.start(mainBattleUI, enemies);
                if (target != null && processMP(curr, selectedAction, mainBattleUI)) {
                    selectedAction.execute(curr, target);
                    Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                    return true;
                }
                return false;
            }
            case SINGLE_ALLY -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                if (allies.isEmpty()) {
                    Printbox.showMessage(mainBattleUI, "No valid ally targets available!");
                    return false;
                }
                TargetingSystem targetingSystem = new TargetingSystem(selectedAction, curr);
                NCharacter target = targetingSystem.start(mainBattleUI, allies);
                if (target != null && processMP(curr, selectedAction, mainBattleUI)) {
                    selectedAction.execute(curr, target);
                    Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                    return true;
                }
                return false;
            }
            case ALL_ENEMIES -> {
                ArrayList<NCharacter> enemies = getAliveEnemies(curr);
                if (processMP(curr, selectedAction, mainBattleUI)) {
                    for (NCharacter enemy : enemies) {
                        selectedAction.execute(curr, enemy);
                    }
                    Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                    return true;
                }
                return false;
            }
            case ALL_ALLIES -> {
                ArrayList<NCharacter> allies = getAliveAllies(curr);
                if (processMP(curr, selectedAction, mainBattleUI)) {
                    for (NCharacter ally : allies) {
                        selectedAction.execute(curr, ally);
                    }
                    Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                    return true;
                }
                return false;
            }
            case SELF -> {
                if (processMP(curr, selectedAction, mainBattleUI)) {
                    selectedAction.execute(curr, curr);
                    Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                    return true;
                }
                return false;
            }
            case NONE -> {
                selectedAction.execute(curr, null);
                return true;
            }
            case RANDOM -> {
                ArrayList<NCharacter> possibleTargets = getAliveEnemies(curr);
                if (!possibleTargets.isEmpty() && processMP(curr, selectedAction, mainBattleUI)) {
                    int randomIndex = (int) (Math.random() * possibleTargets.size());
                    selectedAction.execute(curr, possibleTargets.get(randomIndex));
                    return true;
                }
                Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
                return false;
            }
            case TargetingType.CHOOSE_SUBACTION -> {
                SubActionSystem subActionSystem = new SubActionSystem();
                while (true) {
                    Action subAction = subActionSystem.start(battleUI, curr, selectedAction.getAllSubActions());

                    if (subAction == null) {
                        return false;
                    }

                    if (start(battleUI, curr, subAction)) {
                        return true;
                    }
                }
            }
            default -> {
                Printbox.showMessage(battleUI, "Unknown Targeting Type" + targetType);
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
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return player.characters.stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    // Helper method to get alive allies based on current character's type. If it's
    // a player's turn, send ally's pool. If it's an enemy's turn, send enemy's
    // pool.
    private ArrayList<NCharacter> getAliveAllies(NCharacter curr) {
        if (curr.getType() == NCharacterType.ALLY) {
            return player.characters.stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return enemy.characters.stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    private boolean processMP(NCharacter curr, Action selectedAction, MainBattleUI battleUI) {
        int currentMana = curr.getMana() - selectedAction.getManaCost();
        if (currentMana < 0) {
            Printbox.showMessage(battleUI, "You do not have enough mana!");
            return false;
        }
        curr.setMana(currentMana);
        return true;
    }
}
