package com.infinityfortress.ui.ItemMenu;

import java.util.ArrayList;

import com.infinityfortress.items.Items;
import com.infinityfortress.utils.Utils;

public class ListComponent {

    static StringBuilder getComponent(ArrayList<Items> items, int currScroll, int curr) {
        StringBuilder frame = new StringBuilder();
        int startX = 4, startY = 3, width = 111 / 2 - 3, height = 31 - 2;

        // Draw Border
        frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
        for (int i = 1; i < height - 1; i++) {
            frame.append("\033[").append(startY + i).append(";").append(startX).append("H│").append(" ".repeat(width)).append("│");
        }
        frame.append("\033[").append(startY + height - 1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");

        frame.append("\033[").append(startY + 2).append(";").append(startX + 3).append("H").append(
          Utils.spaceBetween("INVENTORY", Utils.spaceBetween("GEMS: ", "00", (width-4)/4), width - 4)
        );

        int i=1;
        for (Items item : items.subList(currScroll, currScroll + 12)) {
            frame.append("\033[").append(startY + 2 + (i*2)).append(";").append(startX + 5).append("H").append(Utils.spaceBetween(item.getName(), "" + item.getHealth(), width-8));
            i++;
        }
        frame.append("\033[").append(startY + height - 1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
        frame.append(updateSelection(curr));
        return frame;
    }

    static private StringBuilder updateSelection(int curr) {
        StringBuilder frame = new StringBuilder();
        int startX = 4, startY = 3, width = 111 / 2 - 3;
        int selectionY = startY + 3 + (curr * 2);

        // Clear previous selection indicators
        for (int i = 0; i < 12; i++) {
            frame.append("\033[").append(startY + 3 + (i * 2)).append(";").append(startX + 2).append("H ");
            frame.append("\033[").append(startY + 5 + (i * 2)).append(";").append(startX + 2).append("H ");
            frame.append("\033[").append(startY + 3 + (i * 2)).append(";").append(startX + width - 3 + 2).append("H ");
            frame.append("\033[").append(startY + 5 + (i * 2)).append(";").append(startX + width - 3 + 2).append("H ");
        }

        // Selection Indicators
        frame.append("\033[").append(selectionY).append(";").append(startX + 2).append("H┌");
        frame.append("\033[").append(selectionY).append(";").append(startX + 2 + width - 3).append("H┐");
        frame.append("\033[").append(selectionY + 2).append(";").append(startX + 2).append("H└");
        frame.append("\033[").append(selectionY + 2).append(";").append(startX + width - 3 + 2).append("H┘");

        return frame;
    }
}
