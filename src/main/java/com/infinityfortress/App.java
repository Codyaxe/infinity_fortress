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
        Utils.initiallizeBorders();
        InputHandler.waitForInput();
        game.setup();
        
        Utils.clearConsole();
        // game.intro();
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
        Utils.hideCursor();
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

}

// 0-32
// 0-118
// 3, 25
// 116, 25
// 3, 31
// 116, 31
