package com.infinityfortress.PathSystem;

import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.ui.PathMenu.PathUI;

public class MainPathSystem {

    public void start() {
        int choice = -1;
        PathUI mainPathUI = new PathUI();
        boolean decisionComplete = false;

        while (!decisionComplete) {
            mainPathUI.updateChoice(choice);
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                choice = 0;
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                choice = 1;
                InputHandler.right.set(false);
            }

            if (InputHandler.enter.get()) {
                switch (choice) {
                    case 0 -> {
                        // Action
                        // System.out.println();
                    }
                    case 1 -> {
                        // Stat
                        // System.out.println();
                    }
                }
            }
        }
    }
}
