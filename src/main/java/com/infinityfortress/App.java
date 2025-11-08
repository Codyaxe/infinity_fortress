package com.infinityfortress;

import java.util.concurrent.atomic.AtomicBoolean;

import com.infinityfortress.ui.Menu;
import com.infinityfortress.ui.MenuFactory;
import com.infinityfortress.utils.KeyListenerThread;
import com.infinityfortress.utils.Utils;
import com.sun.jna.Platform;

public class App {
    static AtomicBoolean enter = new AtomicBoolean(false);
    static AtomicBoolean left = new AtomicBoolean(false);
    static AtomicBoolean right = new AtomicBoolean(false);
    static AtomicBoolean up = new AtomicBoolean(false);
    static AtomicBoolean down = new AtomicBoolean(false);
    static AtomicBoolean isPressed = new AtomicBoolean(false);
    static AtomicBoolean back = new AtomicBoolean(false);

    static final Object lock = new Object();

    public static void main(String[] args) {
        App game = new App();
        Utils.clearConsole();
        Utils.hideCursor();
        KeyListenerThread listen = game.setupListeners();
        game.intro();
        game.gameLoop();
        listen.stopListener();
        Utils.showCursor();
    }

    public static void waiting() {
        synchronized (App.lock) {
            try {
                App.lock.wait(); // Wait until a key event occurs
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void notif() {
        synchronized (App.lock) {
            App.lock.notify();
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
        keyListener.trackKey(KeyListenerThread.VK_LEFT);
        keyListener.trackKey(KeyListenerThread.VK_RIGHT);
        keyListener.trackKey(KeyListenerThread.VK_UP);
        keyListener.trackKey(KeyListenerThread.VK_DOWN);
        keyListener.trackKey(KeyListenerThread.VK_RETURN);
        keyListener.trackKey(KeyListenerThread.VK_ESCAPE);

        // Add a new event listener to implement onkeyPressed and onkeyReleased methods
        // using anonymous classes
        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                if (!isPressed.get()) {
                    switch (keyCode) {
                        case KeyListenerThread.VK_RETURN -> enter.set(true);
                        case KeyListenerThread.VK_RIGHT -> right.set(true);
                        case KeyListenerThread.VK_LEFT -> left.set(true);
                        case KeyListenerThread.VK_UP -> up.set(true);
                        case KeyListenerThread.VK_DOWN -> down.set(true);
                        case KeyListenerThread.VK_ESCAPE -> back.set(true);
                    }
                    App.notif();
                    isPressed.set(true);
                }
            }

            @Override
            public void onKeyReleased(int keyCode) {
                isPressed.set(false);
                switch (keyCode) {
                    case KeyListenerThread.VK_RETURN -> enter.set(false);
                    case KeyListenerThread.VK_UP -> up.set(false);
                    case KeyListenerThread.VK_DOWN -> down.set(false);
                    case KeyListenerThread.VK_ESCAPE -> back.set(false);
                    case KeyListenerThread.VK_RIGHT -> right.set(false);
                    case KeyListenerThread.VK_LEFT -> left.set(false);
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
        setup.display();
        AtomicBoolean isSettingUp = new AtomicBoolean(true);
        while (isSettingUp.get()) {
            waiting();
            if (enter.get()) isSettingUp.set(false);
            Utils.clearConsole();
        }
    }

    public void gameLoop() {
      statLoop();
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
