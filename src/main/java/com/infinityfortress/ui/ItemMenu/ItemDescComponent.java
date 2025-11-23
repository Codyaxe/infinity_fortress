package com.infinityfortress.ui.ItemMenu;

import com.infinityfortress.items.Items;
import com.infinityfortress.utils.Utils;

public class ItemDescComponent {

    static StringBuilder getComponent(Items item) {
        StringBuilder frame = new StringBuilder();
        int width = 111 / 2, height = 31 - 11 - 3;
        int startX = width + 4 + 1, startY = 15;

        // Draw Border
        frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
        for (int i = 1; i < height - 1; i++) {
            frame.append("\033[").append(startY + i).append(";").append(startX).append("H│").append(" ".repeat(width)).append("│");
          }
        frame.append("\033[").append(startY + height - 1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
        
        // Info
        int idx=startY+2;
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign(Utils.spaceBetween("Type:",item.getType(), (width-2)/3), width-2));
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign(Utils.spaceBetween("Rarity:",""+item.getRarity(), (width-2)/3), width-2));
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign(Utils.spaceBetween("Role:",item.getRole(), (width-2)/3), width-2));
        
        // Description
        idx++;
        frame.append("\033[").append(idx++).append(";").append(startX+3).append("H")
        .append(Utils.leftAlign("Description: ", width-2));

        for (String i: Utils.createTextGrid(4, width-4,item.getDescription())) {
          frame.append("\033[").append(idx++).append(";").append(startX+3).append("H").append(Utils.leftAlign(i, width-4));
        }
        
        // Flavor Text
        frame.append("\033[3m").append("\033[38;5;244m");
        String[] textGrid = java.util.Arrays.stream(Utils.createTextGrid(4, width-4, item.getFlavorText()))
            .filter(line -> !line.equals(" "))
            .toArray(String[]::new);
        for (int i = 0; i < textGrid.length; i++) {
          frame.append("\033[").append(idx + 3 - i).append(";").append(startX+3).append("H").append(Utils.leftAlign(textGrid[textGrid.length - 1 - i], width-4));
        }

        //Reset formatting
        frame.append("\033[0m");
        return frame;
    }
}