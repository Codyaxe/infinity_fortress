package com.infinityfortress.ui.StatsMenu;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class StatComponent {
    public static StringBuilder display(NCharacter curr) {
        StringBuilder frame = new StringBuilder();
        String[][] stats = {
          {"LVL", curr.getLvl()+""},
          {"HP", curr.getMaxHealth()+""},
          {"MP", curr.getMaxMana()+""},
          {"STR", curr.getStrength()+""},
          {"DEF", curr.getDefense()+""},
          {"EXP", curr.getExp()+""},
          {"SPD", curr.getSpeed()+""},
          {"LUCK", curr.getLuck()+""},
          {"CRIT CHANCE", curr.getCritChance()+""},
          {"CRIT DAMAGE", curr.getCritStrength()+""}
        };

        frame.append("\033[3;57H┌").append("─".repeat(56)).append("┐");
        // frame.append("\033[4;57H│").append(" ".repeat(56)).append("│");

        for (int i = 0; i <= 10; i++) frame.append("\033[").append(4+i).append(";57H│").append(" ".repeat(56)).append("│");
        
        for (int i=0; i < stats.length; i++) {
          if ((i&1) == 0) {
            frame.append("\033[").append(5+i).append(";57H│")
            .append(" ".repeat(4))
            .append(Utils.spaceBetween(stats[i/2][0], stats[i][1], 22))
            .append(" ".repeat(4))
            .append(Utils.spaceBetween(stats[(i/2)+5][0], stats[(i/2)+5][1], 22))
            .append(" ".repeat(4));
          } else {
            frame.append("\033[").append(5+i).append(";57H│")
            .append(" ".repeat(56)).append("│");
          }
        }
        frame.append("\033[15;57H└").append("─".repeat(56)).append("┘");
        // System.out.print(frame.toString());
        return frame;
    }
}