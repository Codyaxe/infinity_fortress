package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.effects.summoneffect.SummonEffect;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffect;
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

        // Initialization, decisionsystem and action system must access player and
        // enemy.
        decisionSystem = new DecisionSystem(player, enemy);
        statSystem = new StatSystem(player);
        actionSystem = new ActionSystem(decisionSystem);
        itemSystem = new ItemSystem(player, enemy);

        // Gather all characters from player and enemy lists, filtering out null values
        ArrayList<NCharacter> characterList = Stream
                .concat(player.getCharacters().stream(), enemy.getCharacters().stream())
                .filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);

        // Sets up a callback that reacts to speed changes, allows for priority queue to
        // react.
        for (NCharacter character : characterList) {
            character.getAllTemporaryEffect()
                    .forEach(effect -> effect.setOnSpeedChange(() -> turnQueue.refreshQueueOrder()));
        }

        NCharacter currentCharacter = turnQueue.peekCurrChar();

        MainBattleUI mainBattleUI = new MainBattleUI(player.getCharacters(), enemy.getCharacters(),
                turnQueue.getCurrentQueue());
        while (true) {
            mainBattleUI.display();
            boolean turnComplete = false;

            // Process Summon Effects at start of turn
            processSummonEffects(currentCharacter, player.getCharacters(), enemy.getCharacters(), mainBattleUI);

            // Handles Temporary Effects
            if (!currentCharacter.getAllTemporaryEffect().isEmpty()) {
                Set<TemporaryEffect> conditions = currentCharacter.getAllTemporaryEffect();
                for (TemporaryEffect effect : conditions) {
                    effect.setOnSpeedChange(() -> turnQueue.refreshQueueOrder());

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
                            if (currentCharacter.getType() == NCharacterType.ALLY) {
                                statSystem.start(currentCharacter);
                            }
                        }
                        case 2 -> {
                            // Item
                            itemSystem.start(mainBattleUI, currentCharacter);
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
        processSummonDurations(currentCharacter, characterList);
        mainBattleUI.updateField(player.getCharacters(), enemy.getCharacters());
        mainBattleUI.display();
    }

    private void processSummonEffects(NCharacter currentCharacter, ArrayList<NCharacter> allies,
            ArrayList<NCharacter> enemies, MainBattleUI battleUI) {
        Set<SummonEffect> summons = currentCharacter.getAllSummonsEffect();

        for (SummonEffect summon : summons) {
            summon.execute(currentCharacter, allies, enemies, battleUI);
        }

        updateDeathStatus(allies);
        updateDeathStatus(enemies);
        battleUI.updateField(player.getCharacters(), enemy.getCharacters());
        battleUI.display();
    }

    private void processSummonDurations(NCharacter character, ArrayList<NCharacter> characterList) {
        Set<SummonEffect> summons = character.getAllSummonsEffect();
        Set<SummonEffect> toRemove = new java.util.HashSet<>();

        for (SummonEffect summon : summons) {
            summon.decrementDuration();
            if (summon.isExpired()) {
                toRemove.add(summon);
            }
        }

        for (SummonEffect summon : toRemove) {
            character.removeSummonEffect(summon);
        }

        updateDeathStatus(characterList);
    }

    private void updateDeathStatus(ArrayList<NCharacter> characters) {
        for (NCharacter c : characters) {
            if (c != null && c.getHealth() <= 0) {
                c.setIsDead(true);
            }
        }
    }
}