package com.infinityfortress.ui.ItemMenu;

public class ItemSkeleton {

    static StringBuilder getComponent() {
        StringBuilder frame = new StringBuilder();
        int width = 111 + 4, height = 32;
        int startX = 2, startY = 2;

        // Draw Border
        for (int i = 0; i < height - 1; i++) {
            frame.append("\033[").append(startY + i).append(";").append(startX).append("H").append(" ".repeat(width));
        }
        return frame;
    }
}
