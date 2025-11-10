package com.infinityfortress.utils;

public class Utils {

<<<<<<< HEAD
    public static boolean isEntered() {

        return true;
    }

    // public static void clearConsole() {
    // System.out.print("\033[H\033[2J");
    // System.out.flush();
    // }
=======
>>>>>>> 51d72730d22d823c83c78de5f00c53deed00ffe2
    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        int padding = width - text.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        return " ".repeat(padLeft) + text + " ".repeat(padRight);
    }

    public static String leftAlign(String text, int width) {
        int padding = width - text.length();
        return text + " ".repeat(padding);
    }

    public static String rightAlign(String text, int width) {
        int padding = width - text.length();
        return " ".repeat(padding) + text;
    }

    public static String spaceBetween(String text1, String text2, int width) {
        int padding = width - text1.length() - text2.length();
        return text1 + " ".repeat(padding) + text2;
    }

    public static String[] createTextGrid(int rows, int cols, String text) {
        String[] words = text.split("\\s+");
        String[] grid = new String[rows];
        
        int wordIndex = 0;
        for (int row = 0; row < rows && wordIndex < words.length; row++) {
            StringBuilder currentRow = new StringBuilder();
            
            // Add words to current row until column limit is reached
            while (wordIndex < words.length) {
                String word = words[wordIndex];
                
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
