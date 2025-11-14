package com.infinityfortress;

import com.infinityfortress.utils.Utils;

public class BattleOptionsUIComponent {
    private final String[] UI = new String[13];

    public String[] getUI() {
        return this.UI;
    }

    public void updateUI(int choice) {
        int[] optionHeader = {
            30, 1, 10, 1,
            10, 1, 9, 1,
            10, 1, 9, 1, 31
        };

        String[][] optionGrid = {
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " ", " ", "ACTION", " ", " ", " ", "STATS", " ", " ", " ", "ITEMS", " ", " " },
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
            { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }
        };

        int[][] options = {
            { 1, 3 },
            { 5, 7 },
            { 9, 11 }
        };

        String[] selectionIndicators = { "┌", "│", "└", "┐", "│", "┘" };

        for (int i=0; i<selectionIndicators.length; i++) {
            optionGrid[2 + (i % 3)][options[choice][i / 3]] = selectionIndicators[i];
        }

        for (int i=0; i<optionGrid.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j=0; j<optionGrid[i].length; j++) {
                if (optionGrid[i][j].length() > 1) {
                    row.append(Utils.center(optionGrid[i][j], optionHeader[j]));
                } else {
                    row.append(optionGrid[i][j].repeat(optionHeader[j]));
                }
            }
            this.UI[i] = row.toString();
        }

        // Add selection indicators
        // optionGrid[2][options[choice][0]] = "┌";
        // optionGrid[3][options[choice][0]] = "│";
        // optionGrid[4][options[choice][0]] = "└";
        // optionGrid[2][options[choice][1]] = "┐";
        // optionGrid[3][options[choice][1]] = "│";
        // optionGrid[4][options[choice][1]] = "┘";

    }
}
