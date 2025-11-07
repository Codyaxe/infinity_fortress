package com.infinityfortress;

import java.util.concurrent.atomic.AtomicBoolean;

import com.infinityfortress.utils.KeyListenerThread;
import com.infinityfortress.utils.Utils;
import com.sun.jna.Platform;
import com.infinityfortress.ui.Menu;
import com.infinityfortress.ui.MenuFactory;

public class App {

    static final Object lock = new Object();

    public static void waiting() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait until a key event occurs
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void notif() {
        synchronized (lock) {
            lock.notify();
        }
    }

    public static void main(String[] args) {
        App game = new App();
        Utils.clearConsole();
        game.intro();
        game.gameLoop();
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
        KeyListenerThread keyListener = new KeyListenerThread();

        keyListener.trackKey(KeyListenerThread.VK_RETURN);

        AtomicBoolean skipRequested = new AtomicBoolean(false);

        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                if (keyCode == KeyListenerThread.VK_RETURN) {
                    skipRequested.set(true);
                    synchronized (lock) {
                        lock.notify();
                    }
                }
            }

            @Override
            public void onKeyReleased(int keyCode) {
            }
        });

        keyListener.start();
        keyListener.waitUntilReady();

        for (int i = 0; i < text.length(); i++) {
            // Check if skip was requested
            if (skipRequested.get()) {
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
        keyListener.stopListener();

        System.out.println();
    }

    public void gameLoop() {
        /*
         * Here is the general gist on how to start a keyboard event listener:
         * Declare a keyboard listener thread.
         * Track a key using the trackKey method
         * Define a particular flag
         * Implement a KeyEventListener using anonymous classes
         * Start the thread
         * {insert code}
         * Close the thread
         */

        // Declare the key listener thread
        KeyListenerThread keyListener = new KeyListenerThread();

        // Track the "Enter Key"
        keyListener.trackKey(KeyListenerThread.VK_RIGHT);
        keyListener.trackKey(KeyListenerThread.VK_RETURN);
        keyListener.trackKey(KeyListenerThread.VK_LEFT);
        keyListener.trackKey(KeyListenerThread.VK_ESCAPE);

        // Create a flag to track if skip was requested, use Atomic Boolean.
        AtomicBoolean skipRequested = new AtomicBoolean(false);
        AtomicBoolean left = new AtomicBoolean(false);
        AtomicBoolean right = new AtomicBoolean(false);
        AtomicBoolean isPressed = new AtomicBoolean(false);
        AtomicBoolean isSettingUp = new AtomicBoolean(true);
        AtomicBoolean reset = new AtomicBoolean(false);

        // Add a new event listener to implement onkeyPressed and onkeyReleased methods
        // using anonymous classes
        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                // System.out.println("Key Pressed: " + keyCode);
                if (!isPressed.get()) {
                    if (isSettingUp.get()) {
                        if (keyCode == KeyListenerThread.VK_RETURN) {
                            isSettingUp.set(false);
                            notif();
                        }
                        if (keyCode == KeyListenerThread.VK_ESCAPE) {
                            notif();
                        }
                    } else {
                        switch (keyCode) {
                            case KeyListenerThread.VK_RETURN -> {
                                skipRequested.set(true);
                            }
                            case KeyListenerThread.VK_RIGHT -> {
                                right.set(true);
                            }
                            case KeyListenerThread.VK_LEFT -> {
                                left.set(true);
                            }
                        }
                        notif();
                    }
                    isPressed.set(true);

                }
            }

            @Override
            public void onKeyReleased(int keyCode) {
                isPressed.set(false);
                if (keyCode == KeyListenerThread.VK_RIGHT) {
                    right.set(false);
                }
                if (keyCode == KeyListenerThread.VK_LEFT) {
                    left.set(false);
                }
                if (keyCode == KeyListenerThread.VK_ESCAPE) {
                    reset.set(false);
                }
            }
        });

        keyListener.start();
        keyListener.waitUntilReady();

        // simple game state
        boolean running = true;
        int prev = 0;
        int choice = 0;
        final int frameMillis = 50; // 20 FPS

        Menu mainMenu = MenuFactory.getMenu("BATTLE");
        Menu setup = MenuFactory.getMenu("MAIN");

        Utils.hideCursor();
        Utils.clearConsole();

        while (isSettingUp.get()) {
            setup.display();
            waiting();
            Utils.clearConsole();
        }

        mainMenu.display(choice);

        while (running) {
            waiting();

            if (left.get()) {
                choice = Math.max(0, choice - 1);
                left.set(false);
            }
            if (right.get()) {
                choice = Math.min(3, choice + 1);
                right.set(false);
            }

            // Only repaint if choice actually changed
            if (choice != prev) {
                prev = choice;
                Utils.clearConsole();
                mainMenu.display(choice);
            }

            // simple fixed-timestep sleep
            try {
                Thread.sleep(frameMillis);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                running = false;
            }
        }

        keyListener.stopListener();
        Utils.showCursor();
        System.out.println();
    }
}
