package com.infinityfortress.ui.OldMenu;

import java.util.ArrayList;

import com.infinityfortress.characters.*;
import com.infinityfortress.utils.Utils;

public class DecisionUI implements BattleUIComponent {
    private BattleFeildUI top;

    public DecisionUI(BattleFeildUI top) {
        this.top = top;
    }

    @Override
    public BattleFeildUI getBattleFeildUI() {
        return this.top;
    }

    public void display(ArrayList<NCharacter> targets, int choice) {
        int[] optionHeader = { 1, 1, 23, 1, 43, 1, 43, 1, 1 };

        String[][] optionGrid = {
                { " ", "┌", "─", "─", "─", "─", "─", "┐", " " },
                { " ", "│", " ", " ", " ", " ", " ", "│", " " },
                { " ", "│", " ", " ", " ", " ", " ", "│", " " },
                { " ", "│", " ", " ", " ", " ", " ", "│", " " },
                { " ", "│", " ", " ", " ", " ", " ", "│", " " },
                { " ", "│", " ", " ", " ", " ", " ", "│", " " },
                { " ", "└", "─", "─", "─", "─", "─", "┘", " " }
        };

        int[][] options = {
                { 1, 3 },
                { 3, 3 },
                { 5, 3 },
                { 1, 5 },
                { 3, 5 },
                { 5, 5 }
        };

        int i = 0;
        for (; i < targets.size(); i++) {
            optionGrid[options[i][0]][options[i][1] + 1] = "\033[31m" +
                    targets.get(i).getRace().getName() + " " + targets.get(i).getRole().getName()
                    + "\u001B[0m";
        }
        optionGrid[options[choice][0]][options[choice][1]] = "➤";

        // Use custom frame building for DecisionUI since it has special formatting
        StringBuilder frame = new StringBuilder(getBattleFeildUI().topUI.toString());

        for (String[] row : optionGrid) {
            frame.append("│ ");
            for (i = 0; i < row.length; i++) {
                if (row[i].length() > 1) {
                    frame.append(Utils.leftAlign(" " + row[i], optionHeader[i] + 9));
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
