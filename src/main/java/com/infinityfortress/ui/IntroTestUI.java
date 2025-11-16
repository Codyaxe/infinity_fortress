package com.infinityfortress.ui;

import com.infinityfortress.utils.AudioHandler;
import com.infinityfortress.utils.InputHandler;

public class IntroTestUI {

    String s1 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠔⠪⡲⠴⠄⣔⠆⠀⠠⢲⡢⡀⢀⢔⢤⠠⠲⠲⠴⢄⠦⠖⣦⣢⠠⠠⠒⢇⠶⢰⢠⢖⠀⠀⢒⢦⠄⠀⡰⡄⡄⡒⠕⢖⠴⢄⢴⡂⠀⠔⠎⠞⡖⣢⢤⣠⣄⠀⠀⣠⡲⠄⠄⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s2 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⢎⠆⣯⠇⠀⠀⢸⢪⣣⠁⢙⠀⠀⠀⢀⢼⢐⢀⣀⣀⠀⠀⠀⠀⢀⣞⢌⢮⢗⠀⠀⠀⡯⣫⡈⠈⡅⠀⠀⠀⡰⡕⡕⡽⡂⠀⠁⢀⡤⠒⣠⠅⠱⠀⠀⠀⠰⡏⠄⠀⢸⡹⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s3 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢇⣏⢂⡷⡅⠀⠀⢸⠐⣕⡅⢨⠀⠀⠀⢨⢫⢪⠁⠙⠈⠈⠀⠀⠀⢸⣸⢸⢸⡎⠀⠀⠀⡃⢕⣣⠀⠆⠀⠀⠀⡏⣇⢳⢧⠃⠀⢠⡳⠁⢸⢺⠄⢨⠀⠀⠀⢘⡮⠀⠀⡴⡕⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s4 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡤⢎⣎⢄⠿⠂⠀⢀⢜⣄⠸⡾⣬⠀⠀⣠⠤⣫⡢⠀⠀⠀⠀⠀⠀⣠⠴⣱⡸⡸⠋⠀⠀⡤⣣⡈⢾⣧⡁⠀⢀⡤⢎⣥⢪⠻⠁⠀⢪⢟⡄⠪⡲⡁⠰⠀⠀⠰⠘⣯⣢⡚⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s5 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠏⠑⠉⢰⠁⠀⠄⠫⠊⠂⠅⠘⠫⠀⠀⠪⠑⠑⠁⡖⠀⡀⠂⠀⠀⠭⠉⠁⢑⢔⠀⡐⠸⡑⠊⡐⠈⠙⠂⠀⠘⡉⠉⠂⡪⠀⢀⠠⠑⠕⣝⢦⣣⣤⣸⢄⠂⠀⠸⠑⠑⠉⡪⠀⢀⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s6 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠁⠀⠈⠈⠀⠈⠉⠁⠀⠀⠀⠀⠀⠀⠁⠁⠁⠀⠉⠀⠀⠀⠀⠀⠁⠉⠀⠀⠈⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠈⠈⠈⠀⠁⠁⠀⠀⠀⠀⠁⠁⠁⠀⠀⠀⠀⠀⠈⠈⠈⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s7 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠴⢔⢤⢄⠤⢦⢢⣄⣀⠀⠀⠀⡠⡔⠒⡐⠀⠀⠀⠀⢠⠲⡲⡤⡤⠠⠠⣤⡀⠀⠤⠖⡖⡖⡔⣄⡠⣀⠄⠠⠲⡲⢔⡤⠠⠠⣢⣀⠀⡰⢔⠦⡤⡠⡴⢔⡤⣀⠀⠀⠀⠀⡄⠴⣔⢤⠠⢀⠀⠀⠀⠀⡄⠴⣔⢤⠠⢀⠀⠀⠀⠀⠀⠀⠀";
    String s8 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⠀⣔⡅⠅⢀⡈⡀⠀⠀⠠⣜⡝⠠⡵⠈⠙⣗⡆⠀⠀⠀⣠⣎⠢⡂⠀⣷⡊⠀⠁⠀⣠⢑⢨⠊⠩⡁⠀⠈⠀⢀⡧⡑⠆⠀⣗⡆⠀⠀⠀⢠⢎⢐⢀⢀⠉⠈⠀⠀⢀⡜⣖⣤⢠⡡⡊⠂⠀⠀⢀⡜⣖⣤⢠⡡⡊⠂⠀⠀⠀⠀⠀⠀⠀⠀";
    String s9 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢐⢕⢇⠝⠙⠜⠀⠀⠀⢽⡺⠀⢪⢻⠂⠀⠳⣽⠂⠀⠀⡎⡮⢨⠂⢜⢮⠀⠀⠠⣺⠁⢰⢽⠄⠨⡀⠀⠀⠀⡪⣳⠨⡃⠔⡧⡁⠀⠀⠀⡝⡵⢘⠘⠙⠅⠁⠀⠀⠘⢗⢮⢪⣹⣜⢝⢷⡄⠀⠘⢗⢮⢪⣹⣜⢝⢷⡄⠀⠀⠀⠀⠀⠀⠀";
    String s10 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡄⣏⢅⠂⠀⠀⠀⠀⠠⡣⢻⠀⠱⣝⠆⠀⡱⢩⠇⠀⣄⢮⣋⠔⡁⠀⢕⢅⠀⢜⡽⡀⠪⡮⡂⢨⠀⠀⠀⣠⢜⡪⡈⡆⠀⠪⡢⠀⠀⣠⡸⣩⡐⠖⠧⠕⠀⠀⠀⢀⣄⡤⡳⣨⢊⢧⠙⠀⠀⢀⣄⡤⡳⣨⢊⢧⠙⠀⠀⠀⠀⠀⠀⠀⠀";
    String s11 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠪⠚⠘⠑⢔⠀⠀⠄⠀⠀⠈⢝⢥⠀⢘⠀⣠⢏⠃⠀⠘⠕⠑⠃⢱⠀⠀⡐⠡⠂⠸⢸⡹⣢⣣⣠⣐⡅⠄⠈⠞⠘⠉⢢⠂⠀⠨⠈⠆⠈⠇⠋⠊⢰⠀⠀⡠⠀⠀⡎⠁⡠⠊⠙⠱⠫⠀⠀⠀⡎⠁⡠⠊⠙⠱⠫⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";
    String s12 = "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠈⠈⠀⠈⠈⠀⠀⠀⠀⠀⠈⠁⠊⠈⠁⠀⠀⠀⠀⠁⠁⠁⠀⠁⠁⠀⠀⠀⠀⠀⠈⠈⠈⠁⠁⠀⠀⠀⠁⠁⠁⠂⠁⠁⠁⠀⠀⠀⠁⠁⠁⠁⠁⠁⠀⠀⠀⠀⠁⠂⠀⠀⠀⠀⠀⠀⠀⠁⠁⠂⠀⠀⠀⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀";

    // Default console dimensions used in this project (see notes in App.java)
    private static final int DEFAULT_CONSOLE_WIDTH = 118;
    private static final int DEFAULT_CONSOLE_HEIGHT = 32;

    private String[] getSignLines() {
        return new String[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12 };
    }

    public void display() {
        type(DEFAULT_CONSOLE_WIDTH, DEFAULT_CONSOLE_HEIGHT, 38);
    }

    public void type(int consoleWidth, int consoleHeight, int duration) {

        AudioHandler.playIntro();

        boolean isSkipped = false;

        for (int i = 0; i < (consoleHeight - 12) / 2; i++) {
            System.out.println();
        }

        for (String text : getSignLines()) {
            String line = centerSafe(text, consoleWidth);
            for (int i = 0; i < line.length(); i++) {
                if (InputHandler.enter.get()) {
                    AudioHandler.stopIntro();
                    isSkipped = true;
                    break;
                }
                System.out.print(line.charAt(i));
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println();
        }
        if (!isSkipped) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }

    private String centerSafe(String text, int width) {
        if (text == null)
            return "";
        if (width <= 0)
            return text;
        int len = text.length();
        if (len >= width)
            return text;
        int padding = width - len;
        int left = padding / 2;
        int right = padding - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }

}
