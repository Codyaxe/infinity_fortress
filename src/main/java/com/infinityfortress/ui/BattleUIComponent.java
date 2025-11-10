package com.infinityfortress.ui;

/**
 * Common interface for UI components that need access to battle top UI
 */
public interface BattleUIComponent {
    /**
     * Get the battle top UI reference
     */
    BattleTopUI getBattleTopUI();

    /**
     * Build a frame with the common structure
     */
    default String buildFrame(String[][] optionGrid, int[] optionHeader) {
        StringBuilder frame = new StringBuilder(getBattleTopUI().topUI.toString());

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