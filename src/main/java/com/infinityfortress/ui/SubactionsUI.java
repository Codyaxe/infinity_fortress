package com.infinityfortress.ui;

//Test
import java.util.ArrayList;

import com.infinityfortress.actions.*;
import com.infinityfortress.utils.Utils;

public class SubactionsUI implements BattleUIComponent {
    private BattleTopUI top;

    public SubactionsUI(BattleTopUI top) {
        this.top = top;
    }

    @Override
    public BattleTopUI getBattleTopUI() {
        return this.top;
    }

    public void display(ArrayList<Action> subaction, int choice) {
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
        for (; i < subaction.size(); i++) {
            optionGrid[options[i][0]][options[i][1] + 1] = "\033[31m" +
                    subaction.get(i).getName()
                    + "\u001B[0m";
        }
        optionGrid[options[choice][0]][options[choice][1]] = "➤";

        // Use custom frame building for DecisionUI since it has special formatting
        StringBuilder frame = new StringBuilder(getBattleTopUI().topUI.toString());

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
