package com.infinityfortress.utils;

import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.PrintComponent;

public class Utils {

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initiallizeBorders() {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[1;1H┌").append("─".repeat(117)).append("┐\n");
        for (int i = 0; i < 31; i++)
            frame.append("\033[").append(i + 2).append(";1H│").append(" ".repeat(117)).append("│\n");
        frame.append("\033[33;1H└").append("─".repeat(117)).append("┘");
        System.out.print(frame.toString());
    }

    public static void hideCursor() {
        System.out.print("\u001B[?25l");
        System.out.flush();
    }

    public static void showCursor() {
        System.out.print("\u001B[?25h");
        System.out.flush();
    }

    public static String center(String text, int width) {
        // Handle case where width is less than text length
        if (width < text.length()) {
            return text.substring(0, width);
        }

        int padding = width - text.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        return " ".repeat(padLeft) + text + " ".repeat(padRight);
    }

    public static String leftAlign(String text, int width) {
        // Handle case where width is less than text length
        if (width < text.length()) {
            return text.substring(0, width);
        }

        int padding = width - text.length();
        return text + " ".repeat(padding);
    }

    public static String rightAlign(String text, int width) {
        // Handle case where width is less than text length
        if (width < text.length()) {
            return text.substring(0, width);
        }

        int padding = width - text.length();
        return " ".repeat(padding) + text;
    }

    public static String spaceBetween(String text1, String text2, int width) {
        // Handle case where combined text is longer than width
        int combinedLength = text1.length() + text2.length();
        if (width < combinedLength) {
            // Prioritize text1, truncate text2 if needed
            if (width <= text1.length()) {
                return text1.substring(0, width);
            } else {
                int remainingWidth = width - text1.length();
                return text1 + text2.substring(0, remainingWidth);
            }
        }

        int padding = width - text1.length() - text2.length();
        return text1 + " ".repeat(padding) + text2;
    }

    public static String[] createTextGrid(int rows, int cols, String text) {
        if (text == null || text.isEmpty()) {
            String[] emptyGrid = new String[rows];
            for (int i = 0; i < rows; i++) {
                emptyGrid[i] = " ";
            }
            return emptyGrid;
        }
        String[] words = text.split("\\s+");
        String[] grid = new String[rows];

        int wordIndex = 0;
        for (int row = 0; row < rows && wordIndex < words.length; row++) {
            StringBuilder currentRow = new StringBuilder();

            // Add words to current row until column limit is reached
            while (wordIndex < words.length) {
                String word = words[wordIndex];

                // Handle case where individual word is longer than column width
                if (word.length() > cols) {
                    word = word.substring(0, cols);
                }

                // Check if adding this word would exceed column limit
                String testLine = currentRow.length() == 0 ? word : currentRow + " " + word;

                if (testLine.length() <= cols) {
                    // Word fits, add it
                    if (currentRow.length() > 0) {
                        currentRow.append(" ");
                    }
                    currentRow.append(word);
                    wordIndex++;
                } else {
                    // Word doesn't fit, move to next row
                    break;
                }
            }

            grid[row] = currentRow.toString();
        }

        // Fill remaining rows with empty strings
        for (int row = 0; row < rows; row++) {
            if (grid[row] == null) {
                grid[row] = " ";
            }
        }

        return grid;
    }

}
