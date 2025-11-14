package com.infinityfortress.ui.OldMenu;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.utils.Utils;

public class BattleFeildUI {
    StringBuilder topUI;

    public BattleFeildUI(ArrayList<NCharacter> player, ArrayList<NCharacter> enemy, ArrayList<String> turnOrder) {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[H");

        int[] fieldHeader = { 1, 1, 1, 21, 1, 21, 23, 21, 1, 21, 1, 1, 1 };

        String[][] playerGrid = {
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " }
        };

        String[][] enemyGrid = {
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " " }
        };

        for (int i = 0; i < 5; i++) {
            if (player.get(i) != null) {
                playerGrid[i] = new String[] { 
                        "┌───────────────────┐",
                        "│" + Utils.center(player.get(i).getRace().getName() + " " + player.get(i).getRole().getName(),19) + "│",
                        "├───────────────────┤",
                        "│ HP: " + Utils.center(player.get(i).getHealth() + "/" + player.get(i).getMaxHealth(), 14)+ "│",
                        "├───────────────────┤",
                        "│ MP: " + Utils.center(player.get(i).getMana() + "/" + player.get(i).getMaxMana(), 14) + "│",
                        "└───────────────────┘"
                };
            }
        }

        for (int i = 0; i < 5; i++) {
            if (enemy.get(i) != null) {
                enemyGrid[i] = new String[] { 
                        "┌───────────────────┐",
                        "│" + Utils.center(enemy.get(i).getRace().getName() + " " + enemy.get(i).getRole().getName(),19) + "│",
                        "├───────────────────┤",
                        "│ HP: " + Utils.center(enemy.get(i).getHealth() + "/" + enemy.get(i).getMaxHealth(), 14) + "│",
                        "├───────────────────┤",
                        "│ MP: " + Utils.center(enemy.get(i).getMana() + "/" + enemy.get(i).getMaxMana(), 14) + "│",
                        "└───────────────────┘"
                };
            }
        }

        String[][] fieldGrid = {
                { " ", " ", " ", " ", "➤", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", "┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐", " " },
                { " ", "│", " ", playerGrid[0][0], " ", " ", " ", " ", " ", enemyGrid[0][0], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][1], " ", " ", " ", " ", " ", enemyGrid[0][1], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][2], " ", " ", " ", " ", " ", enemyGrid[0][2], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][3], " ", " ", " ", " ", " ", enemyGrid[0][3], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][4], " ", playerGrid[1][0], " ", enemyGrid[1][0], " ", enemyGrid[0][4], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][5], " ", playerGrid[1][1], " ", enemyGrid[1][1], " ", enemyGrid[0][5], " ", "│", " " },
                { " ", "│", " ", playerGrid[0][6], " ", playerGrid[1][2], " ", enemyGrid[1][2], " ", enemyGrid[0][6], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][0], " ", playerGrid[1][3], " ", enemyGrid[1][3], " ", enemyGrid[2][0], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][1], " ", playerGrid[1][4], " ", enemyGrid[1][4], " ", enemyGrid[2][1], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][2], " ", playerGrid[1][5], " ", enemyGrid[1][5], " ", enemyGrid[2][2], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][3], " ", playerGrid[1][6], " ", enemyGrid[1][6], " ", enemyGrid[2][3], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][4], " ", playerGrid[3][0], " ", enemyGrid[3][0], " ", enemyGrid[2][4], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][5], " ", playerGrid[3][1], " ", enemyGrid[3][1], " ", enemyGrid[2][5], " ", "│", " " },
                { " ", "│", " ", playerGrid[2][6], " ", playerGrid[3][2], " ", enemyGrid[3][2], " ", enemyGrid[2][6], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][0], " ", playerGrid[3][3], " ", enemyGrid[3][3], " ", enemyGrid[4][0], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][1], " ", playerGrid[3][4], " ", enemyGrid[3][4], " ", enemyGrid[4][1], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][2], " ", playerGrid[3][5], " ", enemyGrid[3][5], " ", enemyGrid[4][2], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][3], " ", playerGrid[3][6], " ", enemyGrid[3][6], " ", enemyGrid[4][3], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][4], " ", " ", " ", " ", " ", enemyGrid[4][4], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][5], " ", " ", " ", " ", " ", enemyGrid[4][5], " ", "│", " " },
                { " ", "│", " ", playerGrid[4][6], " ", " ", " ", " ", " ", enemyGrid[4][6], " ", "│", " " },
                { " ", "└", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┘", " " }
        };

        fieldGrid[0][5] = Utils.center(turnOrder.get(0), 21 + 9);
        fieldGrid[0][6] = Utils.center(turnOrder.get(1), 23 + 9);
        fieldGrid[0][7] = Utils.center(turnOrder.get(2), 21 + 9);

        frame.append('┌');
        frame.append("─".repeat(117));
        frame.append("┐\n");

        for (String[] row : fieldGrid) {
            frame.append("│ ");
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > 1) {
                    frame.append(row[i]);
                } else {
                    frame.append(row[i].repeat(fieldHeader[i]));
                }
            }
            frame.append(" │");
            frame.append("\n");
        }
        this.topUI = frame;
    }
}
