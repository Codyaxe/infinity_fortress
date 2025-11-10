package com.infinityfortress;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.infinityfortress.Character.Type;
import com.infinityfortress.ui.*;
import com.infinityfortress.utils.*;
import com.sun.jna.Platform;

public class App {

    AtomicBoolean enter = new AtomicBoolean(false);
    AtomicBoolean left = new AtomicBoolean(false);
    AtomicBoolean right = new AtomicBoolean(false);
    AtomicBoolean up = new AtomicBoolean(false);
    AtomicBoolean down = new AtomicBoolean(false);
    AtomicBoolean isPressed = new AtomicBoolean(false);
    AtomicBoolean back = new AtomicBoolean(false);

    final Object lock = new Object();
    Player player = new Player();
    Enemy enemy = new Enemy();

    public static void main(String[] args) {
        App game = new App();
        KeyListenerThread listen = game.setupListeners();
        Utils.clearConsole();
        Utils.hideCursor();
        // game.intro();
        game.setup();
        game.gameLoop();
        listen.stopListener();
        Utils.showCursor();
    }

    public void Test() {

    }

    public void waiting() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait until a key event occurs
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void notif() {
        synchronized (lock) {
            lock.notify();
        }
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
            if (enter.get()) {
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
        waiting();
        System.out.println();
    }

    public KeyListenerThread setupListeners() {
        // Declare the key listener thread
        KeyListenerThread keyListener = new KeyListenerThread();
        keyListener.trackKeys(
                KeyListenerThread.VK_LEFT,
                KeyListenerThread.VK_RIGHT,
                KeyListenerThread.VK_UP,
                KeyListenerThread.VK_DOWN,
                KeyListenerThread.VK_RETURN,
                KeyListenerThread.VK_ESCAPE
        );
        // Add a new event listener to implement onkeyPressed and onkeyReleased methods
        // using anonymous classes
        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                if (!isPressed.get()) {
                    switch (keyCode) {
                        case KeyListenerThread.VK_RETURN ->
                            enter.set(true);
                        case KeyListenerThread.VK_RIGHT ->
                            right.set(true);
                        case KeyListenerThread.VK_LEFT ->
                            left.set(true);
                        case KeyListenerThread.VK_UP ->
                            up.set(true);
                        case KeyListenerThread.VK_DOWN ->
                            down.set(true);
                        case KeyListenerThread.VK_ESCAPE ->
                            back.set(true);
                    }
                    notif();
                    isPressed.set(true);
                }
            }

            @Override
            public void onKeyReleased(int keyCode) {
                isPressed.set(false);
                switch (keyCode) {
                    case KeyListenerThread.VK_RETURN ->
                        enter.set(false);
                    case KeyListenerThread.VK_UP ->
                        up.set(false);
                    case KeyListenerThread.VK_DOWN ->
                        down.set(false);
                    case KeyListenerThread.VK_ESCAPE ->
                        back.set(false);
                    case KeyListenerThread.VK_RIGHT ->
                        right.set(false);
                    case KeyListenerThread.VK_LEFT ->
                        left.set(false);
                }
            }
        });

        keyListener.start();
        keyListener.waitUntilReady();
        return keyListener;
    }

    public void setup() {
        Utils.clearConsole();
        Menu setup = MenuFactory.getMenu("SETUP");
        AtomicBoolean isSettingUp = new AtomicBoolean(true);
        while (isSettingUp.get()) {
            setup.display();
            waiting();
            if (enter.get()) {
                isSettingUp.set(false);
            }
            Utils.clearConsole();
        }
    }

    public void gameLoop() {
        battleLoop();
    }

    public void print(String text) {
        System.out.print(text);
    }

    public void println(String text) {
        System.out.println(text);
    }

    public void battleLoop() {
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

    public void statLoop() {
        int pick, pPrev, choice, cPrev;
        pick = pPrev = choice = cPrev = 0;

        Menu statsMenu = MenuFactory.getMenu("STATS");

        // Preview only
        String[] roles = {
            "Mage",
            "Warlock",
            "Cleric",
            "Summoner",
            "Rogue",
            "Archer",
            "Healer",
            "Tank",
            "Warrior"
        };

        statsMenu.display(roles[pick], choice);

        while (true) {
            waiting();

            if (left.get()) {
                pick = Math.max(0, pick - 1);
                left.set(false);
            }
            if (right.get()) {
                pick = Math.min(8, pick + 1);
                right.set(false);
            }
            if (up.get()) {
                choice = Math.max(0, choice - 1);
                up.set(false);
            }
            if (down.get()) {
                choice = Math.min(2, choice + 1);
                down.set(false);
            }
            // Only repaint if choice actually changed
            if (choice != cPrev || pick != pPrev) {
                cPrev = choice;
                pPrev = pick;
                statsMenu.display(roles[pick], choice);
            }
        }
    }
}
