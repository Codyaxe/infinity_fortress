package com.infinityfortress.battle_system;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infinityfortress.ui.Menu;

public class BattleSystem {

    public void start(){
        //Display BattleMenu choice is given

        //Battle Loop
 int choice, prev;
        choice = prev = 0;

        // Create Turn Order Array
        Menu battleMenu = MenuFactory.getMenu("BATTLE");
        ArrayList<Pair<Character, Integer>> characterList = Stream.concat(
                player.characters.stream(), enemy.characters.stream())
                .filter(c -> c != null)
                .map(c -> new Pair<>(c, c.speed))
                .collect(Collectors.toCollection(ArrayList::new));
        ModifiedPriorityQueue turnQueue = new ModifiedPriorityQueue(characterList);
        Character curr=turnQueue.peekCurrChar();

        battleMenu.display(player.characters, enemy.characters,turnQueue.getCurrentQueue(), choice);
        
        while (true) {
          waiting();
          
          if (left.get()) {
            choice = Math.max(0, choice - 1);
            left.set(false);
          }
          if (right.get()) {
            choice = Math.min(3, choice + 1);
              right.set(false);
            }
            if (enter.get()) {
              switch(choice) {
                case 0 -> {
                }
                case 1 -> {
                }
                case 2 -> {
                }
                case 3 -> {
                }
              }
              battleMenu.display(player.characters, enemy.characters,turnQueue.getCurrentQueue(), choice);
              curr=turnQueue.getCurrCharAndUpdate();
            }
            // Only repaint if choice actually changed
            // curr=turnQueue.peekCurrChar();
            if (choice != prev || enter.get()) {
              enter.set(false);
              prev = choice;
              battleMenu.display(player.characters, enemy.characters, turnQueue.getCurrentQueue(), choice);
            }
        }
    }
    }
}
