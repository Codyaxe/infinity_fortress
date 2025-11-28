package com.infinityfortress.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public class InputHandler {
    private static final Object lock = new Object();
    private static KeyListenerThread keyListener;

    // Shared atomic booleans for input state
    public static AtomicBoolean enter = new AtomicBoolean(false);
    public static AtomicBoolean left = new AtomicBoolean(false);
    public static AtomicBoolean right = new AtomicBoolean(false);
    public static AtomicBoolean up = new AtomicBoolean(false);
    public static AtomicBoolean down = new AtomicBoolean(false);
    public static AtomicBoolean isPressed = new AtomicBoolean(false);
    public static AtomicBoolean back = new AtomicBoolean(false);

    // Made a class to simplify things. This sets up all the keys we are going to
    // use at start up. This is initiated at the start of the game.
    public static KeyListenerThread setupKeyListener() {
        // Declare the key listener thread
        keyListener = new KeyListenerThread();
        keyListener.trackKeys(
                KeyListenerThread.VK_LEFT,
                KeyListenerThread.VK_RIGHT,
                KeyListenerThread.VK_UP,
                KeyListenerThread.VK_DOWN,
                KeyListenerThread.VK_RETURN,
                KeyListenerThread.VK_ESCAPE);

        // Add a new event listener to implement onkeyPressed and onkeyReleased methods
        keyListener.addKeyEventListener(new KeyListenerThread.KeyEventListener() {
            @Override
            public void onKeyPressed(int keyCode) {
                if (!isPressed.get()) {
                    switch (keyCode) {
                        case KeyListenerThread.VK_RETURN -> {
                            AudioHandler.playEnter();
                            enter.set(true);
                        }
                        case KeyListenerThread.VK_RIGHT -> {
                            AudioHandler.playSelect();
                            right.set(true);
                        }
                        case KeyListenerThread.VK_LEFT -> {
                            AudioHandler.playSelect();
                            left.set(true);
                        }
                        case KeyListenerThread.VK_UP -> {
                            AudioHandler.playSelect();
                            up.set(true);
                        }
                        case KeyListenerThread.VK_DOWN -> {
                            AudioHandler.playSelect();
                            down.set(true);
                        }
                        case KeyListenerThread.VK_ESCAPE -> {
                            AudioHandler.playBack();
                            back.set(true);
                        }
                    }
                    notifyInput();
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

    // Method to stop all key listener, obviously.
    public static void stopKeyListener() {
        if (keyListener != null) {
            keyListener.stopListener();
        }
    }

    // For synchronization purposes. If the key input is required immediately please
    // use this in conjunction with the key listener
    public static void waitForInput() {
        synchronized (lock) {
            try {
                lock.wait(); // Wait until a key event occurs
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    // Notify waiting thread that a key event occured.
    public static void notifyInput() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    // Reset Methods
    public static void resetInputFlags() {
        enter.set(false);
        left.set(false);
        right.set(false);
        up.set(false);
        down.set(false);
        isPressed.set(false);
        back.set(false);
    }
}