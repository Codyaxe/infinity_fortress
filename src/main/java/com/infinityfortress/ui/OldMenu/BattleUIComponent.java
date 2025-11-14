package com.infinityfortress.ui.OldMenu;

public interface BattleUIComponent {
    // Use Composition to get the top UI instead of inheritance.
    BattleFeildUI getBattleFeildUI();

    // Build a frame with the common structure

    default String buildFrame(String[][] optionGrid, int[] optionHeader) {
        StringBuilder frame = new StringBuilder(getBattleFeildUI().topUI.toString());

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

        return frame.toString();
    }
}