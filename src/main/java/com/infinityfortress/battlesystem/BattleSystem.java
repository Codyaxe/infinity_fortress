package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.effects.TemporaryEffect;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.AudioHandler;
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

        // Initialization, decisionsystem and action system must access player and
        // enemy.
        decisionSystem = new DecisionSystem(player, enemy);
        statSystem = new StatSystem(player);
        actionSystem = new ActionSystem(decisionSystem);

        // Gather all characters from player and enemy lists, filtering out null values
        ArrayList<NCharacter> characterList = Stream.concat(player.characters.stream(), enemy.characters.stream())
                .filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);
        NCharacter currentCharacter = turnQueue.peekCurrChar();

        MainBattleUI mainBattleUI = new MainBattleUI(player.characters, enemy.characters, turnQueue.getCurrentQueue());
        while (true) {
            mainBattleUI.display();
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

            while (!turnComplete && currentCharacter.getType() == NCharacterType.ALLY) {
                mainBattleUI.updateChoice(choice);
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
                            actionSuccessful = actionSystem.start(mainBattleUI, currentCharacter);
                        }
                        case 1 -> {
                            // Stat
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
                        turnComplete = true;
                        InputHandler.enter.set(false);

                    }

                    mainBattleUI.display();
                }
            }

            while (!turnComplete && currentCharacter.getType() == NCharacterType.ENEMY) {
                boolean actionSuccessful = false;
                actionSuccessful = actionSystem.start(mainBattleUI, currentCharacter);
                if (actionSuccessful) {
                    turnComplete = true;
                }
            }
            processEnd(mainBattleUI, characterList, currentCharacter);
            currentCharacter = turnQueue.getCurrCharAndUpdate();
            mainBattleUI.updateTurnOrder(turnQueue.getCurrentQueue());

        }
    }

    public void processEnd(MainBattleUI mainBattleUI, ArrayList<NCharacter> characterList,
            NCharacter currentCharacter) {
        for (NCharacter character : characterList) {
            if (character.getHealth() <= 0) {
                character.setIsDead(true);
            }
        }
        mainBattleUI.updateField(player.characters, enemy.characters);
    }
}