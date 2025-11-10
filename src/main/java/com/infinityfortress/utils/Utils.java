package com.infinityfortress.utils;

public class Utils {

    public static boolean isEntered() {

        return true;
    }

    // public static void clearConsole() {
    // System.out.print("\033[H\033[2J");
    // System.out.flush();
    // }
    public static void clearConsole() {
        // System.out.print("\u001B[H\u001B[2J");
        // System.out.flush();
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
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        return " ".repeat(padLeft) + text + " ".repeat(padRight);
    }

    public static String leftAlign(String text, int width) {
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        return text + " ".repeat(padding);
    }

    public static String rightAlign(String text, int width) {
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        return " ".repeat(padding) + text;
    }
}
