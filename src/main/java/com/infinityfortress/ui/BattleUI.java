package com.infinityfortress.ui;

public class BattleUI {
    BattleTopUI top;

    public BattleUI(BattleTopUI t) {
      this.top = t;
    }

    public void display(int choice) {
        StringBuilder frame = new StringBuilder(this.top.topUI.toString());
        int[] optionHeader = {
            30, 1, 10, 1,
            10, 1, 9, 1,
            10, 1, 10, 1, 30
        };

        //33, 12, 10, 11, 10, 13, 32
        String[][] optionGrid = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", "  ACTION  ", " ", " ", " ", "  STATS  ", " ", " ", " ", "  ITEMS   ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };

        int[][] options = {
            {1, 3},
            {5, 7},
            {9, 11}
        };

        optionGrid[2][options[choice][0]] = "┌";
        optionGrid[3][options[choice][0]] = "│";
        optionGrid[4][options[choice][0]] = "└";
        optionGrid[2][options[choice][1]] = "┐";
        optionGrid[3][options[choice][1]] = "│";
        optionGrid[4][options[choice][1]] = "┘";

        for (String[] row : optionGrid) {
            frame.append("│ ");
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > 1) {
                    frame.append(row[i]);
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
