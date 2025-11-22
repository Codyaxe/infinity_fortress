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
          
        // Info
        int idx=startY+2;
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign("Type: "+item.getType(), width-2));
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign("Rarity: "+item.getRarity(), width-2));
        frame.append("\033[").append(idx++).append(";").append(startX+1).append("H")
        .append(Utils.rightAlign("Role: "+item.getRole(), width-2));
        
        // Description
        idx++;
        frame.append("\033[").append(idx++).append(";").append(startX+3).append("H")
        .append(Utils.leftAlign("Description: ", width-2));

        for (String i: Utils.createTextGrid(4, width-4,item.getDescription())) {
          frame.append("\033[").append(idx++).append(";").append(startX+3).append("H").append(Utils.leftAlign(i, width-4));
        }
        idx++;
        
        // Flavor Text
        frame.append("\033[3m").append("\033[38;5;244m");
        for (String i: Utils.createTextGrid(4, width-4,item.getFlavorText())) {
          frame.append("\033[").append(idx++).append(";").append(startX+3).append("H").append(Utils.leftAlign(i, width-4));
        }
        frame.append("\033[0m");

        frame.append("\033[").append(startY + height - 1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");

        return frame;
    }
}
