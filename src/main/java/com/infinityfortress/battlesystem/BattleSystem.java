package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.utils.ModifiedPriorityQueue;

public class BattleSystem {

    Player player = new Player();
    Enemy enemy = new Enemy();
    DecisionSystem decisionSystem;
    StatSystem statSystem;
    ActionSystem actionSystem;
    ItemSystem itemSystem;

    public void start() {
        int choice = 0;

        // Initialization, decisionsystem and action system must access player and enemy.
        decisionSystem = new DecisionSystem(player, enemy);
        statSystem = new StatSystem(player);
        actionSystem = new ActionSystem(decisionSystem);

        // Gather all characters from player and enemy lists, filtering out null values
        ArrayList<NCharacter> characterList = Stream.concat(player.characters.stream(), enemy.characters.stream())
                .filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);
        NCharacter currentCharacter = turnQueue.peekCurrChar();

        MainBattleUI mainBattleUI = new MainBattleUI(player.characters, enemy.characters, turnQueue.getQueue());
        while (true) {
            mainBattleUI.display();
            // BattleFeildUI battleField = new BattleFeildUI(player.characters, enemy.characters, turnQueue.getCurrentQueue());
            // BattleUI battleUI = new BattleUI(battleField);

            boolean turnComplete = false;
            while (!turnComplete) {
              mainBattleUI.updateChoice(choice);
                // battleUI.display(choice);
                InputHandler.waitForInput();

                if (InputHandler.left.get()) {
                    choice = Math.max(0, choice - 1);
                    InputHandler.left.set(false);
                }
                if (InputHandler.right.get()) {
                    choice = Math.min(2, choice + 1);
                    InputHandler.right.set(false);
                }

                if (InputHandler.enter.get()) {
                    boolean actionSuccessful = false;
                    switch (choice) {
                        case 0 -> {
                            // Action
                            actionSuccessful = actionSystem.start(mainBattleUI, currentCharacter);
                        }
                        case 1 -> {
                            // Stat
                            // Only allow stat viewing for ally characters
                            if (currentCharacter.getType() == NCharacterType.ALLY) {
                                statSystem.start(currentCharacter);
                            }
                        }
                        case 2 -> {
                            // Equipment
                            actionSuccessful = true;
                        }
                    }

                    if (actionSuccessful) {
                        currentCharacter = turnQueue.getCurrCharAndUpdate();
                        InputHandler.enter.set(false);
                        turnComplete = true;
                    }
                    mainBattleUI.display();
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
// BattleFeildUI battleTop = new BattleFeildUI(player.characters, enemy.characters,
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
