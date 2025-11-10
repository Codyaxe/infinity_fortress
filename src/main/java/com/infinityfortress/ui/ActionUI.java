package com.infinityfortress.ui;

public class ActionUI extends BattleUI {
    public ActionUI(BattleTopUI top) {
      super(top);
    }

    @Override
    public void display(int choice) {
        StringBuilder frame = new StringBuilder(this.top.topUI.toString());

        int[] optionHeader = {
            21, 1, 2, 6, 2, 1,
            9, 1, 2, 7, 2, 1,
            9, 1, 2, 5, 2, 1,
            9, 1, 2, 4, 2, 1, 21
        };

        String[][] optionGrid = {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "ATTACK", " ", " ", " ", " ", " ", "SPECIAL", " ", " ", " ", " ", " ", "BLOCK", " ", " ", " ", " ", " ", "REST", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},};

        int[][] options = {
            {1, 5},
            {7, 11},
            {13, 17},
            {19, 23}
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
