package com.infinityfortress.ui;

import java.util.ArrayList;

import com.infinityfortress.Character;
import com.infinityfortress.utils.Utils;

public class DecisionUI extends BattleUI {
    public DecisionUI(BattleTopUI top) {
        super(top);
    }

    public void display(ArrayList<Character> enemy, int choice) {
        StringBuilder frame = new StringBuilder(this.top.topUI.toString());
        // int[] optionHeader = {2, 1, 11, 1, 43, 1, 55, 1, 2};
        int[] optionHeader = {1, 1, 23, 1, 43, 1, 43, 1, 1};

        String[][] optionGrid = {
            {" ", "┌", "─", "─", "─", "─", "─", "┐", " "},
            {" ", "│", " ", " ", " ", " ", " ", "│", " "},
            {" ", "│", " ", " ", " ", " ", " ", "│", " "},
            {" ", "│", " ", " ", " ", " ", " ", "│", " "},
            {" ", "│", " ", " ", " ", " ", " ", "│", " "},
            {" ", "│", " ", " ", " ", " ", " ", "│", " "},
            {" ", "└", "─", "─", "─", "─", "─", "┘", " "}
        };

        int[][] options = {
            {1, 3},
            {3, 3},
            {5, 3},
            {1, 5},
            {3, 5},
            {5, 5}
        };

        int i = 0;
        for (; i < enemy.size(); i++) {
            optionGrid[options[i][0]][options[i][1] + 1] = 
            "\033[31m" + 
            enemy.get(i).race + " " + enemy.get(i).role 
            + "\u001B[0m"
            ;
        }
        optionGrid[options[choice][0]][options[choice][1]] = "➤";

        for (String[] row : optionGrid) {
            frame.append("│ ");
            for (i = 0; i < row.length; i++) {
                if (row[i].length() > 1) {
                    frame.append(Utils.leftAlign(" "+row[i], optionHeader[i]+9));
                } else {
                    frame.append(row[i].repeat(optionHeader[i]));
                }
            }
            frame.append(" │");
            frame.append("\n");
        }

        frame.append('└');
        frame.append("─".repeat(117));
        frame.append('┘');
        System.out.print(frame.toString());
    }
}
