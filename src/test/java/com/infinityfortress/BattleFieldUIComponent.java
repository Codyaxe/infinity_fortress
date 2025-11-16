package com.infinityfortress;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class BattleFieldUIComponent {
    private final String[] UI = new String [23];

    public String[] getUI() {
        return this.UI;
    }

    public void updateComponent(ArrayList<NCharacter> player, ArrayList<NCharacter> enemy) {
        int[] gridHeader = { 1, 1, 21, 1, 21, 23, 21, 1, 21, 1, 1 };

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
                        "│" + Utils.center(enemy.get(i).getRace().getName() + " " + enemy.get(i).getRole().getName(),
                                19) + "│",
                        "├───────────────────┤",
                        "│ HP: " + Utils.center(enemy.get(i).getHealth() + "/" + enemy.get(i).getMaxHealth(), 14) + "│",
                        "├───────────────────┤",
                        "│ MP: " + Utils.center(enemy.get(i).getMana() + "/" + enemy.get(i).getMaxMana(), 14) + "│",
                        "└───────────────────┘"
                };
            }
        }

        String[][] grid = {
                { "┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐" },
                { "│", " ", playerGrid[0][0], " ", " ", " ", " ", " ", enemyGrid[0][0], " ", "│" },
                { "│", " ", playerGrid[0][1], " ", " ", " ", " ", " ", enemyGrid[0][1], " ", "│" },
                { "│", " ", playerGrid[0][2], " ", " ", " ", " ", " ", enemyGrid[0][2], " ", "│" },
                { "│", " ", playerGrid[0][3], " ", " ", " ", " ", " ", enemyGrid[0][3], " ", "│" },
                { "│", " ", playerGrid[0][4], " ", playerGrid[1][0], " ", enemyGrid[1][0], " ", enemyGrid[0][4], " ", "│" },
                { "│", " ", playerGrid[0][5], " ", playerGrid[1][1], " ", enemyGrid[1][1], " ", enemyGrid[0][5], " ", "│" },
                { "│", " ", playerGrid[0][6], " ", playerGrid[1][2], " ", enemyGrid[1][2], " ", enemyGrid[0][6], " ", "│" },
                { "│", " ", playerGrid[2][0], " ", playerGrid[1][3], " ", enemyGrid[1][3], " ", enemyGrid[2][0], " ", "│" },
                { "│", " ", playerGrid[2][1], " ", playerGrid[1][4], " ", enemyGrid[1][4], " ", enemyGrid[2][1], " ", "│" },
                { "│", " ", playerGrid[2][2], " ", playerGrid[1][5], " ", enemyGrid[1][5], " ", enemyGrid[2][2], " ", "│" },
                { "│", " ", playerGrid[2][3], " ", playerGrid[1][6], " ", enemyGrid[1][6], " ", enemyGrid[2][3], " ", "│" },
                { "│", " ", playerGrid[2][4], " ", playerGrid[3][0], " ", enemyGrid[3][0], " ", enemyGrid[2][4], " ", "│" },
                { "│", " ", playerGrid[2][5], " ", playerGrid[3][1], " ", enemyGrid[3][1], " ", enemyGrid[2][5], " ", "│" },
                { "│", " ", playerGrid[2][6], " ", playerGrid[3][2], " ", enemyGrid[3][2], " ", enemyGrid[2][6], " ", "│" },
                { "│", " ", playerGrid[4][0], " ", playerGrid[3][3], " ", enemyGrid[3][3], " ", enemyGrid[4][0], " ", "│" },
                { "│", " ", playerGrid[4][1], " ", playerGrid[3][4], " ", enemyGrid[3][4], " ", enemyGrid[4][1], " ", "│" },
                { "│", " ", playerGrid[4][2], " ", playerGrid[3][5], " ", enemyGrid[3][5], " ", enemyGrid[4][2], " ", "│" },
                { "│", " ", playerGrid[4][3], " ", playerGrid[3][6], " ", enemyGrid[3][6], " ", enemyGrid[4][3], " ", "│" },
                { "│", " ", playerGrid[4][4], " ", " ", " ", " ", " ", enemyGrid[4][4], " ", "│" },
                { "│", " ", playerGrid[4][5], " ", " ", " ", " ", " ", enemyGrid[4][5], " ", "│" },
                { "│", " ", playerGrid[4][6], " ", " ", " ", " ", " ", enemyGrid[4][6], " ", "│" },
                { "└", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┘" }
        };

        for (int i = 0; i < grid.length; i++) {
          StringBuilder row = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].length() > 1) row.append(grid[i][j]);
                else row.append(grid[i][j].repeat(gridHeader[j]));
            }
            this.UI[i]=row.toString();
        }
    }
}
