package com.infinityfortress.utils;

public class Utils {
    public static boolean isEntered() {

        return true;
    }
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
}
