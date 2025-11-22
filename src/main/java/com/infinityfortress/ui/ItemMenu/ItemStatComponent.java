package com.infinityfortress.ui.ItemMenu;

import com.infinityfortress.utils.Utils;
import com.infinityfortress.items.Items;



public class ItemStatComponent {
    static StringBuilder getComponent(Items item) {

    StringBuilder frame = new StringBuilder();
    int width = 111/2, height = 11;
    int startX = width + 4 + 1, startY = 3;

    // Draw Border
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i = 1; i < height - 1; i++)
      frame.append("\033[").append(startY + i).append(";").append(startX).append("H│").append(" ".repeat(width))
          .append("│");
          
    int statWidth = (width - 2)/3 - 4;
    int space=5;

    frame.append("\033[").append(startY + 2).append(";").append(startX+4).append("H").append("ITEM STATS");
    frame.append("\033[").append(startY + 2 + 2).append(";").append(startX+4).append("H")
    .append(Utils.spaceBetween("HP:" , ""+ item.getHealth(), statWidth)).append(" ".repeat(space))
    .append(Utils.spaceBetween("DEF:" , ""+ item.getDefense(), statWidth)).append(" ".repeat(space))
    .append(Utils.spaceBetween("CRIT C.:" , ""+ item.getCritChance(), statWidth));

    frame.append("\033[").append(startY + 2 + 4).append(";").append(startX+4).append("H")
    .append(Utils.spaceBetween("MP:" , ""+ item.getMana(), statWidth)).append(" ".repeat(space))
    .append(Utils.spaceBetween("SPD:" , ""+ item.getSpeed(), statWidth)).append(" ".repeat(space))
    .append(Utils.spaceBetween("CRIT D.:" , ""+ item.getCritStrength(), statWidth));

    frame.append("\033[").append(startY + 2 + 6).append(";").append(startX+4).append("H")
    .append(Utils.spaceBetween("STR:" , ""+ item.getStrength(), statWidth)).append(" ".repeat(space))
    .append(Utils.spaceBetween("LUCK:" , ""+ item.getLuck(), statWidth)).append(" ".repeat(space));
    
    frame.append("\033[").append(startY + 2 + 6 + 2).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");

    return frame;
  }
}
