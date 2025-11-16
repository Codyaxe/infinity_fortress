package com.infinityfortress.ui;

import com.infinityfortress.utils.Utils;

// will be refactored later
public class SetupMenu {
    public void display() {
        final int max = 33;
        for (int i = 0; i < max; i++) {
            switch (i) {
                case 0 -> {
                    System.out.print('┌');
                    System.out.print("─".repeat(117));
                    System.out.print('┐');
                }
                case max - 1 -> {
                    System.out.print('└');
                    System.out.print("─".repeat(117));
                    System.out.print('┘');
                }
                default -> {
                    System.out.print('│');
                    switch (i) {
                        case max / 2 -> {
                            String msg = Utils.center(
                                    "Setup your console to match the box, press ESC to reset box position", 117);
                            System.out.print(msg);
                        }
                        case (max / 2) + 1 -> {
                            String msg = Utils.center("Press Enter to continue...", 117);
                            System.out.print(msg);
                        }
                        default ->
                            System.out.print(" ".repeat(117));
                    }
                    System.out.print('│');
                }
            }
            if (i != max - 1) {
                System.out.println();
            }
        }
    }
}