package com.infinityfortress.battle_system;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.*;
import com.infinityfortress.utils.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BattleSystem {

    Player player = new Player();
    Enemy enemy = new Enemy();

    public void start() {
        int choice, prev;
        choice = prev = 0;

        Menu battleMenu = MenuFactory.getMenu("BATTLE");

        // Gather all characters from player and enemy lists, filtering out null values
        ArrayList<NCharacter> characterList = Stream.concat(player.characters.stream(), enemy.characters.stream())
                .filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);

        NCharacter currentCharacter = turnQueue.peekCurrChar();

        battleMenu.display(player.characters, enemy.characters, turnQueue.getCurrentQueue(), choice);

        while (true) {
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                choice = Math.max(0, choice - 1);
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                choice = Math.min(3, choice + 1);
                InputHandler.right.set(false);
            }

            if (InputHandler.enter.get()) {
                switch (choice) {
                    case 0 -> {
                    }
                    case 1 -> {
                    }
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                }
                battleMenu.display(player.characters, enemy.characters, turnQueue.getCurrentQueue(), choice);
                currentCharacter = turnQueue.getCurrCharAndUpdate();
            }
            // Only repaint if choice actually changed
            if (choice != prev || InputHandler.enter.get()) {
                InputHandler.enter.set(false);
                prev = choice;
                battleMenu.display(player.characters, enemy.characters, turnQueue.getCurrentQueue(), choice);
            }
        }
    }
}
