package com.infinityfortress;

import java.util.concurrent.atomic.AtomicBoolean;

import com.infinityfortress.battlesystem.BattleSystem;
import com.infinityfortress.ui.*;
import com.infinityfortress.utils.*;
import com.sun.jna.Platform;

public class App {

    public static void main(String[] args) {
        App game = new App();
        InputHandler.setupKeyListener();
        Utils.clearConsole();
        Utils.hideCursor();
        // game.intro();
        game.setup();
        game.gameLoop();
        InputHandler.stopKeyListener();
        Utils.showCursor();
    }

    public void intro() {
        if (!Platform.isWindows()) {
            System.err.println("This program only supports Windows platform");
            return;
        }

        Thread t = new Thread(() -> {
            dialouge(
                    "Welcome to the infinity fortress! The game that manifests abominations beyond your imaginations",
                    50);
            dialouge(
                    "Do you know that you can skip using the enter key? Wow!!!",
                    50);
        });

        t.start();

        // Template code for Thread.sleep
        try {
            t.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public void dialouge(String text, int duration) {
        for (int i = 0; i < text.length(); i++) {
            // Check if skip was requested
            if (InputHandler.enter.get()) {
                System.out.print(text.substring(i));
                break;
            }
            System.out.print(text.charAt(i));
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }
        System.out.println("\nPress Enter to continue...");
        InputHandler.waitForInput();
        System.out.println();
    }

    public void setup() {
        Utils.clearConsole();
        SetupMenu setup = new SetupMenu();
        AtomicBoolean isSettingUp = new AtomicBoolean(true);
        while (isSettingUp.get()) {
            setup.display();
            InputHandler.waitForInput();
            if (InputHandler.enter.get()) {
                isSettingUp.set(false);
            }
            Utils.clearConsole();
        }
    }

    public void gameLoop() {
        BattleSystem battle = new BattleSystem();
        battle.start();
    }

    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
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

    // public boolean actionLoop(BattleTopUI battleTop, Character curr) {
    // int choice = 0;
    // ActionUI currUI = new ActionUI(battleTop);

    // while (true) {
    // currUI.display(choice);
    // waiting();

    // if (left.get()) {
    // choice = Math.max(0, choice - 1);
    // left.set(false);
    // }
    // if (right.get()) {
    // choice = Math.min(3, choice + 1);
    // right.set(false);
    // }
    // if (back.get()) {
    // back.set(false);
    // return false;
    // }
    // if (enter.get()) {
    // switch (choice) {
    // case 0 -> {
    // if (decisionLoop(battleTop, curr)) {
    // return true;
    // }
    // }
    // }
    // }
    // }
    // }

    // public boolean decisionLoop(BattleTopUI battleTop, Character curr) {
    // int choice = 0;
    // DecisionUI currUI = new DecisionUI(battleTop);
    // ArrayList<Character> enemies = enemy.characters.stream().filter(c -> c !=
    // null).collect(Collectors.toCollection(ArrayList::new));
    // int maxChoice = enemies.size() - 1;
    // while (true) {
    // currUI.display(enemies, choice);
    // waiting();

    // if (right.get()) {
    // if (choice + 3 <= maxChoice) {
    // choice += 3;
    // }
    // right.set(false);
    // }

    // if (left.get()) {
    // if (choice >= 3) {
    // choice -= 3;
    // }
    // left.set(false);
    // }

    // if (down.get()) {
    // if (choice % 3 + 1 < 3 && choice + 1 <= maxChoice) {
    // choice++;
    // }
    // down.set(false);
    // }

    // if (up.get()) {
    // if ((choice % 3) > 0) {
    // choice--;
    // }
    // up.set(false);
    // }

    // if (back.get()) {
    // back.set(false);
    // return false;
    // }

    // if (enter.get()) {
    // switch (choice) {
    // case 0 -> {
    // // a
    // }
    // case 1 -> {
    // // b
    // }
    // case 2 -> {
    // // c
    // }
    // case 3 -> {
    // // d
    // }
    // case 4 -> {
    // // e
    // }
    // case 5 -> {
    // // x
    // }
    // }
    // return true;
    // }
    // }
    // }

    public void resultLoop() {

    }

    // public void statLoop(Character currCharact) {
    // int choice = 0;
    // ArrayList<Character> characterList = player.characters.stream().filter(c -> c
    // != null).collect(Collectors.toCollection(ArrayList::new));
    // int curr = characterList.indexOf(currCharact);
    // StatsMenu statsMenu = new StatsMenu();
    // Utils.clearConsole();
    // while (true) {
    // statsMenu.display(characterList.get(curr), choice, curr,
    // characterList.size());
    // waiting();

    // if (left.get()) {
    // curr = Math.max(0, curr - 1);
    // left.set(false);
    // }
    // if (right.get()) {
    // curr = Math.min(characterList.size() - 1, curr + 1);
    // right.set(false);
    // }
    // if (up.get()) {
    // choice = Math.max(0, choice - 1);
    // up.set(false);
    // }
    // if (down.get()) {
    // choice = Math.min(2, choice + 1);
    // down.set(false);
    // }
    // if (back.get()) {
    // back.set(false);
    // return;
    // }
    // }
    // }
}

// 0-32
// 0-118
// 3, 25
// 116, 25
// 3, 31
// 116, 31
