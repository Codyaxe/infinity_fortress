package com.infinityfortress.battlesystem;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.TemporaryEffect;
import com.infinityfortress.ui.*;
import com.infinityfortress.utils.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BattleSystem {

    Player player = new Player();
    Enemy enemy = new Enemy();
    DecisionSystem decisionSystem;
    StatSystem statSystem;
    ActionSystem actionSystem;

    public void start() {
        int choice = 0;

        // Initialization, decisionsystem and actionsystem must access player and enemy.
        decisionSystem = new DecisionSystem(player, enemy);
        statSystem = new StatSystem(player);
        actionSystem = new ActionSystem(decisionSystem);

        // Gather all characters from player and enemy lists, filtering out null values
        ArrayList<NCharacter> characterList = Stream.concat(player.characters.stream(), enemy.characters.stream())
                .filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);
        NCharacter currentCharacter = turnQueue.peekCurrChar();

        while (true) {
            BattleTopUI battleTop = new BattleTopUI(player.characters, enemy.characters, turnQueue.getCurrentQueue());
            BattleUI battleUI = new BattleUI(battleTop);

            boolean turnComplete = false;

            // Handles Temporary Effects
            if (!currentCharacter.getAllTemporaryEffect().isEmpty()) {
                ArrayList<TemporaryEffect> conditions = currentCharacter.getAllTemporaryEffect();
                for (TemporaryEffect effect : conditions) {
                    if (effect.isJustApplied()) {
                        effect.setJustApplied(false);
                    } else {
                        effect.decrement();
                        if (effect.getDuration() == 0) {
                            effect.remove();
                        }
                    }
                }
                conditions.removeIf(effect -> effect.getDuration() == 0);
            }

            while (!turnComplete) {

                battleUI.display(choice);
                InputHandler.waitForInput();

                if (InputHandler.left.get()) {
                    choice = Math.max(0, choice - 1);
                    InputHandler.left.set(false);
                    AudioHandler.playSelect();
                }
                if (InputHandler.right.get()) {
                    choice = Math.min(2, choice + 1);
                    InputHandler.right.set(false);
                    AudioHandler.playSelect();
                }

                if (InputHandler.enter.get()) {
                    boolean actionSuccessful = false;
                    AudioHandler.playEnter();
                    switch (choice) {
                        case 0 -> {
                            // Action
                            actionSuccessful = actionSystem.start(battleTop, currentCharacter);
                        }
                        case 1 -> {
                            // Stat
                            statSystem.start(currentCharacter);
                        }
                        case 2 -> {
                            // Equipment
                            actionSuccessful = false;
                        }
                    }

                    // Update the character priority when their turn ends.
                    if (actionSuccessful) {
                        currentCharacter = turnQueue.getCurrCharAndUpdate();
                        InputHandler.enter.set(false);
                        turnComplete = true;
                    }
                }
            }
        }
    }
}

// public void battleLoop() {
// // Create Turn Order Array
// ArrayList<Pair<Character, Integer>> characterList = Stream.concat(
// player.characters.stream(), enemy.characters.stream())
// .filter(c -> c != null)
// .map(c -> new Pair<>(c, c.speed))
// .collect(Collectors.toCollection(ArrayList::new));
// ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);
// Character curr = turnQueue.peekCurrChar();

// while (true) {
// int choice = 0;
// BattleTopUI battleTop = new BattleTopUI(player.characters, enemy.characters,
// turnQueue.getCurrentQueue());
// BattleUI battleUI = new BattleUI(battleTop);
// while (true) {
// battleUI.display(choice);
// waiting();
// if (left.get()) {
// choice = Math.max(0, choice - 1);
// left.set(false);
// }
// if (right.get()) {
// choice = Math.min(2, choice + 1);
// right.set(false);
// }
// if (enter.get()) {
// boolean flag = false;
// switch (choice) {
// case 0 -> {
// if (actionLoop(battleTop, curr)) {
// curr = turnQueue.getCurrCharAndUpdate();
// flag=true;
// }
// }
// case 1 -> {
// if (curr.type == Character.Type.ALLY) {
// statLoop(curr);
// }
// }
// case 2 -> {
// curr = turnQueue.getCurrCharAndUpdate();
// enter.set(false);
// flag = true;
// break;
// }
// }
// if (flag) break;
// }
// }
// }
// }