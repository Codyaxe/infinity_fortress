package com.infinityfortress;

import com.sun.jna.Platform;

import java.util.concurrent.atomic.AtomicBoolean;
import com.infinityfortress.utils.KeyListenerThread;

public class App {
    public static void main(String[] args) {
        App game = new App();
        game.intro();
    }

    public void intro() {
        if (!Platform.isWindows()) {
            System.err.println("This program only supports Windows platform");
            return;
        }

        Thread t = new Thread(() -> {
            printType(
                    "Welcome to the infinity fortress! The game that manifests abominations beyond your imaginations",
                    50);
            printType(
                    "Do you know that you can skip using the enter key? Wow!!!",
                    50);
        });

        t.start();

        // Template code for Thread.sleep
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public void printType(String s, long duration) {
        /*
         * Here is the general gist on how to start a keyboard event listener:
         * Start a keyboard listener thread.
         * Track a key using the trackKey method
         * Define a particular flag
         * Implement a KeyEventListener using anonymous classes
         * Start the thread
         * {insert code}
         * Close the thread
         */

        // Start the key listener thread
        KeyListenerThread keyListener = new KeyListenerThread();

        // Track a the "Enter Key"
        keyListener.trackKey(KeyListenerThread.VK_RETURN);

        // Create a flag to track if skip was requested, use Atomic Boolean.
        AtomicBoolean skipRequested = new AtomicBoolean(false);

        // Add a new event listener to implement onkeyPressed and onkeyReleased methods
        // using anonymous classes
        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                if (keyCode == KeyListenerThread.VK_RETURN) {
                    skipRequested.set(true);
                }
            }

            @Override
            public void onKeyReleased(int keyCode) {
            }
        });

        keyListener.start();

        // Synchronization purpose, waits for the thread to get ready. Use this if
        // the keyListener is immediately required
        keyListener.waitUntilReady();

        for (int i = 0; i < s.length(); i++) {
            // Check if skip was requested
            if (skipRequested.get()) {
                System.out.print(s.substring(i));
                break;
            }

            System.out.print(s.charAt(i));

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                break;
            }
        }

        keyListener.stopListener();

        System.out.println();
    }
}
