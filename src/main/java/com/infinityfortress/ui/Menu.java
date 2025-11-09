package com.infinityfortress.ui;

import com.infinityfortress.utils.Utils;
import java.util.*;
import com.infinityfortress.Character;

// public interface Menu {
//     public void display();
// }
public interface Menu {

    void display();

    default void display(ArrayList<Character> player, ArrayList<Character> enemy, ArrayList<String> turnOrder, int choice) {
    }

    default void display(String role, int choice) {
    }
}

class SetupMenu implements Menu {

    @Override
    public void display() {
        final int max = 33;
        for (int i = 0; i < max; i++) {
            switch (i) {
                case 0 -> {
                    System.out.print('┌');
                    System.out.print("─".repeat(117));
                    System.out.print('┐');
                }
                case max - 1 -> {
                    System.out.print('└');
                    System.out.print("─".repeat(117));
                    System.out.print('┘');
                }
                default -> {
                    System.out.print('│');
                    switch (i) {
                        case max / 2 -> {
                            String msg = Utils.center("Setup your console to match the box, press ESC to reset box position", 117);
                            System.out.print(msg);
                        }
                        case (max / 2) + 1 -> {
                            String msg = Utils.center("Press Enter to continue...", 117);
                            System.out.print(msg);
                        }
                        default ->
                            System.out.print(" ".repeat(117));
                    }
                    System.out.print('│');
                }
            }
            if (i != max - 1) {
                System.out.println();
            }
        }
    }
}

class MainMenu implements Menu {

    @Override
    public void display() {
        System.out.print("Main Menu");
        //code
    }
}

//120 characters wide 117 usable
//30 characters tall 26 usable
class BattleMenu implements Menu {
  
    @Override
    public void display() {
        display(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0);
    }

    @Override
    public void display(ArrayList<Character> player, ArrayList<Character> enemy, ArrayList<String> turnOrder, int choice) {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[H");
        // Define grid layouts
        int[] fieldHeader = {1, 1, 1, 21, 1, 21, 23, 21, 1, 21, 1, 1, 1};
        String[][] playerGrid = {
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "}
        };
        String[][] enemyGrid = {
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " "}
        };

        for (int i = 0; i < 5; i++) {
            if (player.get(i) != null) {
                playerGrid[i] = new String[]{ // ✅ Correct syntax
                    "┌───────────────────┐",
                    "│" + Utils.center(player.get(i).race + " " + player.get(i).role, 19) + "│",
                    "├───────────────────┤",
                    "│ HP: " + Utils.center(player.get(i).hp + "/" + player.get(i).maxHp,14) + "│",
                    "├───────────────────┤",
                    "│ MP: " + Utils.center(player.get(i).mp + "/" + player.get(i).maxMp,14) + "│",
                    "└───────────────────┘"
                };
            
          }
        }
        for (int i = 0; i < 5; i++) {
            if (enemy.get(i) != null) {
                enemyGrid[i] = new String[]{ // ✅ Correct syntax
                    "┌───────────────────┐",
                    "│" + Utils.center(enemy.get(i).race + " " + enemy.get(i).role, 19) + "│",
                    "├───────────────────┤",
                    "│ HP: " + Utils.center(enemy.get(i).hp + "/" + enemy.get(i).maxHp, 14) + "│",
                    "├───────────────────┤",
                    "│ MP: " + Utils.center(enemy.get(i).mp + "/" + enemy.get(i).maxMp, 14) + "│",
                    "└───────────────────┘"
                };
            
          }
        }
        String[][] fieldGrid = {
            {" ", " ", " ",       " ",        "➤",      Utils.center(turnOrder.get(0), 21+9),         Utils.center(turnOrder.get(1), 23+9),      Utils.center(turnOrder.get(2), 21+9),        " ",      " ",        " ", " ", " "},
            {" ", "┌", "─",       "─",        "─",      "─",         "─",      "─",        "─",      "─",        "─", "┐", " "},
            {" ", "│", " ", playerGrid[0][0], " ",      " ",         " ",      " ",        " ", enemyGrid[0][0], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][1], " ",      " ",         " ",      " ",        " ", enemyGrid[0][1], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][2], " ",      " ",         " ",      " ",        " ", enemyGrid[0][2], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][3], " ",      " ",         " ",      " ",        " ", enemyGrid[0][3], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][4], " ", playerGrid[1][0], " ", enemyGrid[1][0], " ", enemyGrid[0][4], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][5], " ", playerGrid[1][1], " ", enemyGrid[1][1], " ", enemyGrid[0][5], " ", "│", " "},
            {" ", "│", " ", playerGrid[0][6], " ", playerGrid[1][2], " ", enemyGrid[1][2], " ", enemyGrid[0][6], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][0], " ", playerGrid[1][3], " ", enemyGrid[1][3], " ", enemyGrid[2][0], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][1], " ", playerGrid[1][4], " ", enemyGrid[1][4], " ", enemyGrid[2][1], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][2], " ", playerGrid[1][5], " ", enemyGrid[1][5], " ", enemyGrid[2][2], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][3], " ", playerGrid[1][6], " ", enemyGrid[1][6], " ", enemyGrid[2][3], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][4], " ", playerGrid[3][0], " ", enemyGrid[3][0], " ", enemyGrid[2][4], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][5], " ", playerGrid[3][1], " ", enemyGrid[3][1], " ", enemyGrid[2][5], " ", "│", " "},
            {" ", "│", " ", playerGrid[2][6], " ", playerGrid[3][2], " ", enemyGrid[3][2], " ", enemyGrid[2][6], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][0], " ", playerGrid[3][3], " ", enemyGrid[3][3], " ", enemyGrid[4][0], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][1], " ", playerGrid[3][4], " ", enemyGrid[3][4], " ", enemyGrid[4][1], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][2], " ", playerGrid[3][5], " ", enemyGrid[3][5], " ", enemyGrid[4][2], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][3], " ", playerGrid[3][6], " ", enemyGrid[3][6], " ", enemyGrid[4][3], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][4], " ",       " ",        " ",       " ",       " ", enemyGrid[4][4], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][5], " ",      " ",         " ",       " ",       " ", enemyGrid[4][5], " ", "│", " "},
            {" ", "│", " ", playerGrid[4][6], " ",      " ",         " ",       " ",       " ", enemyGrid[4][6], " ", "│", " "},
            {" ", "└", "─",       "─",        "─",      "─",         "─",       "─",       "─",      "─",        "─", "┘", " "}
        };
        int[] actionHeader = {
            21, 1, 2, 6, 2, 1,
            9, 1, 2, 7, 2, 1,
            9, 1, 2, 5, 2, 1,
            9, 1, 2, 4, 2, 1, 21
        };
        String[][] actionGrid = {
            {" ", " ", " ",    " ",   " ", " ", " ", " ", " ",   " ",     " ", " ", " ", " ", " ",    " ",  " ", " ", " ", " ", " ",   " ",  " ", " ", " "},
            {" ", " ", " ", "ATTACK", " ", " ", " ", " ", " ", "SPECIAL", " ", " ", " ", " ", " ", "BLOCK", " ", " ", " ", " ", " ", "REST", " ", " ", " "},
            {" ", " ", " ",    " ",   " ", " ", " ", " ", " ",   " ",     " ", " ", " ", " ", " ",    " ",  " ", " ", " ", " ", " ",   " ",  " ", " ", " "},
        };
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
        frame.append("│");
        frame.append(" ".repeat(117));
        frame.append("│\n");
        frame.append("│");
        frame.append(" ".repeat(117));
        frame.append("│\n");

        int[][] options = {
            {1, 5},
            {7, 11},
            {13, 17},
            {19, 23}
        };


        actionGrid[0][options[choice][0]] = "┌";
        actionGrid[1][options[choice][0]] = "│";
        actionGrid[2][options[choice][0]] = "└";
        actionGrid[0][options[choice][1]] = "┐";
        actionGrid[1][options[choice][1]] = "│";
        actionGrid[2][options[choice][1]] = "┘";


        for (String[] row : actionGrid) {
            frame.append("│ ");
            for (int i = 0; i < row.length; i++) {
                if (row[i].length() > 1) {
                    frame.append(row[i]);
                } else {
                    frame.append(row[i].repeat(actionHeader[i]));
                }
                if (options[choice][1] == i) {
                    frame.append("\u001B[0m");
                }
            }
            frame.append(" │");
            frame.append("\n");
        }

        frame.append("│");
        frame.append(" ".repeat(117));
        frame.append("│\n");
        frame.append("│");
        frame.append(" ".repeat(117));
        frame.append("│");

        frame.append('└');
        frame.append("─".repeat(117));
        frame.append('┘');
        System.out.print(frame.toString());
    }
}

class ActionMenu implements Menu {

    @Override
    public void display() {
        System.out.print("Test");
        //code
    }
}

// ┌ ─ ┐ │ └ ┘ ├ ┤ ┬ ┴ ┼  
class StatsMenu implements Menu {

    @Override
    public void display() {
        display("Mage", 0);
    }

    @Override
    public void display(String role, int choice) {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[H");
        // frame.append("\033[H\033[2J");

        // Previous
        CharArt newArt = new CharArt();
        String[] art = newArt.art(role);

        // Spaghetti code ahead, proceed with caution
        int[] gridHeader = {1, 4, 1, 48, 1, 1, 1, 4, 3, 4, 22, 11, 6, 6, 1, 4, 1};
        int[] descHeader = {1, 4, 1, 48, 1, 1, 1, 1, 1, 16, 1, 1, 1, 35, 1, 4, 1};
        String[][] grid = {
            {"┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐"},
            {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
            {"│", " ", "┌", "─", "┐", " ", "┌", "─", "─", "─", "─", "─", "─", "─", "┐", " ", "│"},
            {"│", " ", "│", "Race: ", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "Role", "│", " ", "│", " ", "LVL", " 00", " ", "EXP", "00/00", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", "HP", " 00", " ", "SPD", "00", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", "MP", "00", " ", "LUCK", "00", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", "STR", "00", " ", "CRIT CHANCE", "00", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", "DEF", "00", " ", "CRIT DAMAGE", "00", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", " ", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "└", "─", "─", "─", "─", "─", "─", "─", "┘", " ", "│"},
            {"│", " ", "│", "art", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"}
        };
        String[][] descGrid = {
            {"│", " ", "│", "art", "│", " ", "┌", "─", "─", "─", "─", "─", "┬", "─", "┐", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", "BASIC ATTACK", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", "SPECIAL ATTACK", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", "EQUIPMENT", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│", " ", "│"},
            {"│", " ", "└", "─", "┘", " ", "└", "─", "─", "─", "─", "─", "┴", "─", "┘", " ", "│"},
            {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
            {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
            {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
            {"└", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┘"}
        };

        switch (choice) {
            case 0 -> {
                descGrid[2][8] = "┌";
                descGrid[3][8] = "│";
                descGrid[4][8] = "└";
                descGrid[2][10] = "┐";
                descGrid[3][10] = "│";
                descGrid[4][10] = "┘";
            }
            case 1 -> {
                descGrid[5][8] = "┌";
                descGrid[6][8] = "│";
                descGrid[7][8] = "└";
                descGrid[5][10] = "┐";
                descGrid[6][10] = "│";
                descGrid[7][10] = "┘";
            }
            case 2 -> {
                descGrid[8][8] = "┌";
                descGrid[9][8] = "│";
                descGrid[10][8] = "└";
                descGrid[8][10] = "┐";
                descGrid[9][10] = "│";
                descGrid[10][10] = "┘";
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals("art")) {
                    frame.append(Utils.center(art[i - 5], gridHeader[j]));
                } else if (grid[i][j].equals("stats")) {
                    frame.append(" ".repeat(gridHeader[j]));
                } else if (grid[i][j].equals("stats2")) {
                    frame.append(" ".repeat(gridHeader[j]));
                } else if (grid[i][j].contains("Race")) {
                    frame.append(Utils.leftAlign(" Race: Human", gridHeader[j]));
                } else if (grid[i][j].contains("Role")) {
                    frame.append(Utils.leftAlign(" Role: " + role, gridHeader[j]));
                } else if (grid[i][j].contains("LVL")) {
                    frame.append(Utils.leftAlign("LVL", gridHeader[j]));
                } else if (grid[i][j].contains("EXP")) {
                    frame.append(Utils.leftAlign("EXP", gridHeader[j]));
                } else if (grid[i][j].contains("HP")) {
                    frame.append(Utils.leftAlign("HP", gridHeader[j]));
                } else if (grid[i][j].contains("MP")) {
                    frame.append(Utils.leftAlign("MP", gridHeader[j]));
                } else if (grid[i][j].contains("STR")) {
                    frame.append(Utils.leftAlign("STR", gridHeader[j]));
                } else if (grid[i][j].contains("DEF")) {
                    frame.append(Utils.leftAlign("DEF", gridHeader[j]));
                } else if (grid[i][j].contains("SPD")) {
                    frame.append(Utils.leftAlign("SPD", gridHeader[j]));
                } else if (grid[i][j].contains("LUCK")) {
                    frame.append(Utils.leftAlign("LUCK", gridHeader[j]));
                } else if (grid[i][j].contains("CRIT CHANCE")) {
                    frame.append(Utils.leftAlign("CRIT CHANCE", gridHeader[j]));
                } else if (grid[i][j].contains("CRIT DAMAGE")) {
                    frame.append(Utils.leftAlign("CRIT DAMAGE", gridHeader[j]));
                } else if (grid[i][j].contains("00")) {
                    frame.append(Utils.rightAlign("00", gridHeader[j]));
                } else if (grid[i][j].length() > 1) {
                    frame.append(Utils.center(grid[i][j], gridHeader[j]));
                } else {
                    frame.append(grid[i][j].repeat(gridHeader[j]));
                }
            }
            frame.append("\n");
        }
        for (int i = 0; i < descGrid.length; i++) {
            for (int j = 0; j < descGrid[i].length; j++) {
                if (descGrid[i][j].equals("art")) {
                    frame.append(Utils.center(art[i + 11], descHeader[j]));
                } else if (descGrid[i][j].length() > 1) {
                    frame.append(Utils.center(descGrid[i][j], descHeader[j]));
                } else {
                    frame.append(descGrid[i][j].repeat(descHeader[j]));
                }
            }
            if (i != descGrid.length - 1) {
                frame.append("\n");
            }
        }
        System.out.print(frame.toString());
        System.out.flush();
    }
}

class ItemsMenu implements Menu {

    public void display() {
        //code
    }
}

class MapMenu implements Menu {

    public void display() {
        //code
    }
}

class RewardMenu implements Menu {

    public void display() {
        //code
    }
}

class GachaMenu implements Menu {

    public void display() {
    }
}

class CharArt {

    String[] mageArt = {
        "                            ",
        "                            ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣾⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⡆⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⡋⠘⠛⢟⢧⣀⠀⠀⠀⠀⠀⠀⠀⢠⠃⠀⡇⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣄⠀⠀⠀⢠⣾⣿⣔⡂⡀⠀⠀⠀⠀⣺⡀⣰⠇⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⣘⠿⣢⣀⡤⡿⡛⡽⣿⣿⣥⡁⠂⡀⠀⣸⡳⠋  ",
        "⠀⠀⠀⠀⠀⣠⣶⣿⢷⢽⣿⣿⡿⡷⡽⣿⣾⣎⠛⣏⠂⠀⠀⣿⠁⠀  ",
        "⠀⠀⠀⠀⠀⢼⣾⣺⢭⣷⣗⡭⣫⣷⣝⣞⢾⡶⠀⠸⠀⠀⡸⠇⠀⠀  ",
        "⠀⠀⠀⠀⠀⢸⡾⡎⢿⣿⣿⣿⣿⣿⣿⢺⢽⣇⠀⠀⠀⠀⡕⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⢼⣻⠊⠸⣽⣽⣿⣿⣽⠅⠈⣯⡷⠀⠀⠀⣼⠃⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⢿⡏⠀⢠⢿⣿⣿⣿⡿⡅⠀⢸⡿⣣⠀⢠⠓⠀⠀⠀⠀  ",
        "   ⠀⣽⢷⠃⢠⣟⢟⣿⣿⢿⢾⣻⣄⠈⢯⣿⡀⡼⠁⠀⠀⠀⠀⠀ ",
        "   ⢐⣟⡇⢀⣯⣷⣿⣮⣻⣽⣾⣾⣽⡀⠸⣺⣧⠇⠀⠀⠀⠀⠀⠀ ",
        "   ⢸⢽⠀⢘⣵⣷⣿⣿⣿⣿⣿⢷⣯⡣⠀⣝⡟⠀⠀⠀⠀⠀⠀⠀ ",
        "   ⢘⡟⡇⢸⣿⢵⣿⣿⣿⣿⣿⣷⢻⣿⠠⣿⡍⠀⠀⠀⠀⠀⠀⠀ ",
        "   ⠈⠳⢸⠸⢧⡯⢿⣿⣿⣿⣻⣿⡝⣿⡅⡞⠃⠀⠀⠀⠀⠀⠀⠀ ",
        "      ⢸⡇⢺⣿⡘⢿⣿⣿⣿⣿⣿⡜⢯⠃⠀⠀⠀⠀⠀⠀⠀ ",
        "      ⠸⠁⠀⢻⣧⠈⢻⣿⣿⣿⣿⡯⣏⠂⠀⠀⠀⠀⠀⠀⠀ ",
        "       ⠀⠀⠀⠙⢧⠀⠉⠿⣾⣿⢽⣺⣷⣦⡀⠀⠀⠀⠀⠀ ",
        "        ⠀⠀⠀⠀⠁⠀⠀⠀⢑⠏⠛⠟⠟⠿⠻⠲⠐⠀⠀ ",
        "                            ",
        "                            ",
        "                            ",};

    String[] warlockArt = {
        "                                ",
        "                                ",
        "  ⠀⠀⢀⡆⢀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "  ⠘⡄⢱⠹⣷⡏⢜⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⢀⡉⢻⣧⣿⣧⣿⣁⠄⠀⠀⠀⠀⠀⢀⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⢈⠭⣿⣿⣿⠻⢄⠀⠀⠀⠸⡀⢠⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣳⠀  ",
        "⠀⠀⠀⠏⣿⠝⠂⠀⠀⠀⠀⣴⠋⣼⣿⣿⣿⣏⠉⡇⠀⠀⠀⠀⠀⠀⢰⣾⡋⠠  ",
        "⠀⠀⠀⠀⣻⠀⠀⠀⠀⠀⠀⣻⣶⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⢰⢷⡿⠿⠆  ",
        "⠀⠀⠀⠨⣿⣇⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⣸⢈⢡⣀⠀  ",
        "⠀⠀⠀⠀⢹⢻⣷⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⢀⢀⣴⣿⠾⠓⠁⠀  ",
        "⠀⠀⠀⠀⢸⣠⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⡟⠉⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⣯⣿⣿⣿⢋⣿⣿⣿⣿⣿⣿⣿⣿⡏⢿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⡇⠛⢹⠀⣼⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⡃⠀⢨⣺⠑⢸⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⡇⠀⠐⠙⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⡇⠀⠈⠘⠠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⡇⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⣷⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⡇⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠨⡇⠀⢰⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⡀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠈⠓⠾⠿⠿⠿⠿⠿⠿⠿⠿⣿⣿⣿⡿⠿⠿⠿⠛⠂⠀⠀⠀⠀⠀⠀  ",
        "                                ",
        "                                ",};

    String[] clericArt = {
        "                           ",
        "                           ",
        "  ⠀⠀⠠⠐⢀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "  ⠀⠀⠄⢿⣤⠠⠀⠀⠀⠀⢀⣤⡀⠀⠀⠀⠀⠀⠀⠀⡴⢤⡀⠀ ",
        "    ⠀⠘⣯⠀⠐⠀⠀⢀⣾⣗⣿⣧⠀⠀⠀⠀⠀⢸⠠⡂⡇⠀ ",
        "⠀⠀⠀⠀⠀⢀⣯⣷⡄⠀⠀⠀⢿⣿⣽⡃⠀⠀⠀⠀⠀⠘⣎⡴⠁⠀ ",
        "⠀⠀⠀⠀⠀⢸⢿⣿⣿⣢⣀⢸⡾⡿⣟⣧⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⣯⣿⣿⣿⣿⣟⣿⣟⡷⣗⣿⣥⡀⠀⠀⠀⠀⢹⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠉⠙⡻⣿⢿⣏⣷⣷⣽⡿⣿⣿⡀⠀⠀⠀⡕⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣽⡷⣿⣿⣿⢿⣺⣿⣫⣶⣶⣾⢽⡂⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣯⡏⣿⣿⣿⣿⡽⣿⣿⣿⣷⡇⡇⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⣰⣷⣿⣿⣿⢷⣫⣿⣿⣿⣿⣻⣽⢿⣿⢿⠃⡇⠀⠀⠀ ",
        "⠀⠀⠀⠀⣼⢿⣿⣿⣿⣿⣯⣿⣯⣿⣿⣿⢽⣾⣿⣎⠋⠠⡇⠀⠀⠀ ",
        "⠀⠀⠀⣼⣿⣿⣿⣿⣿⣗⣿⣗⣿⣿⣿⣟⣾⣷⣿⡾⡄⢸⡂⠀⠀⠀ ",
        "⠀⠀⣼⣿⣽⣿⣿⣿⣿⣾⣿⢷⣿⣿⣿⡗⣿⣿⢾⣿⣷⢸⠂⠀⠀⠀ ",
        "⠀⢀⣿⣷⣿⣿⣿⣿⣳⣿⣿⣼⢽⣿⣿⡯⡇⣿⡿⣿⣻⣽⠀⠀⠀⠀ ",
        "⠀⠐⣿⡏⠙⠻⣿⣟⣿⣿⣟⣿⣿⣿⣿⣿⡧⣿⣿⠻⢼⣿⠀⠀⠀⠀ ",
        "⠀⠀⠻⡧⠀⠀⠈⣽⣿⣿⣟⢷⣿⣻⣿⣟⣿⣿⣿⡀⡾⢻⠀⠀⠀⠀ ",
        "⠀⠀⠀⠙⠀⠀⢰⣿⣿⣿⣿⣿⣼⣵⣳⣏⣶⣿⣿⡇⠁⢸⠀⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠈⠙⠙⣿⢿⢿⣿⣿⣿⣿⣿⣿⡿⠫⠀⡕⠀⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢴⢿⠓⠀⠈⠉⠉⠁⠀⠿⢿⢤⠀⡇⠀⠀⠀⠀ ",
        "                           ",
        "                           ",};

    String[] summonerArt = {
        "                       ",
        "                       ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⣾⢀⡀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀",
        "  ⠀⠀⠀⠀⠀⠀⣹⡷⠁⠀⠀⠀⣸⡿⠻⣿⡆⠀⠀⠀⠀",
        "  ⠀⠀⠀⠀⠠⣾⣿⠅⠀⠀⠀⠀⣼⠱⣷⣽⠇⠀⠀⠀⠀",
        "    ⠀⠀⣾⣿⠋⠀⣀⡀⠀⠠⣿⠀⠈⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⢹⣿⡄⣼⣿⣿⣧⢀⡗⠀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠸⣿⣿⣻⣿⣿⣿⢳⡇⠀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⢿⣿⣄⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⢰⣿⣿⣿⣿⣿⠏⡿⠀⣙⣿⣿⠀⠀⠀⠀⠀",
        "    ⠀⢄⣾⣿⣿⣿⣿⡏⣴⣷⣿⣿⠟⠁⠀⠀⠀⠀⠀",
        "    ⠀⣿⣿⣿⣿⣿⣿⣅⢺⠛⠙⠁⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⢹⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "   ⠀⠀⣺⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "   ⠀⠀⣺⣿⣿⣿⣿⡟⣿⣿⣞⣷⣀⠀⠀⠀⠀⠀⠀⠀",
        "     ⣺⣿⣿⡯⣿⣷⢸⣿⣿⣼⣿⡄⠀⠀⠀⠀⠀⠀",
        "    ⢠⣿⣿⣼⠇⢻⣿⣾⠙⣿⣿⣿⣧⠂⠀⠀⠀⠀⠀",
        "   ⠀⢸⣿⣿⡏⠀⠀⠛⣿⣆⢻⣿⣿⣿⡔⠀⠀⠀⠀⠀",
        "  ⠀⢀⡿⣿⣿⠀⠀⠀⢀⡏⠙⢆⢻⣿⡎⢿⣦⡀⡀⠀⠀",
        "⠀⠀⠘⣰⣿⣯⠀⠀⠀⢰⠇⠀⠨⡂⣿⣿⡀⠙⠓⠣⠆⠁ ",
        "⠀⠐⢿⡿⡿⠛⠁⠀⠀⠸⠁⠀⠐⠀⠻⢿⡿⠇⠀⠀⠀⠀ ",
        "                       ",};

    String[] rogueArt = {
        "                                        ",
        "                                        ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣞⣾⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣻⣺⢾⢽⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣔⡿⡜⣯⣟⡾⣲⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣵⣝⢇⣟⣞⡺⣽⣳⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡾⠞⣛⣾⡺⡧⡏⢾⡽⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⢾⢯⢏⢰⣳⣓⢏⡿⣆⠈⢫⡷⣃⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⣠⡠⣞⡯⠛⠈⣌⡷⣝⣝⢽⣽⣀⡈⣯⢷⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢀⡠⢴⠸⢜⠈⡱⠁⠀⣤⢼⣾⣺⣗⣯⢷⢳⡯⣇⠀⠀⠹⡝⡨⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⣀⣤⢮⠳⠙⠉⠀⠈⠀⠀⣀⣪⡯⣯⣺⢸⡾⣽⢽⡇⡹⣽⢲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ",
        "      ⠀⠀⠀⠀⠀⠀⠠⢖⡿⣽⢾⡽⣐⡾⡯⣯⢷⣻⣆⠽⣞⣷⡹⣽⣒⠲⠤⠤⠒⠒⠒⠒⠢⢀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⡽⡷⣕⣷⣻⡽⡯⣯⢷⡏⢯⣟⡾⣽⣺⢼⡯⣷⣳⣗⡿⠝⠷⢲⡄⠀⠀",
        "⠀⠀⠀⣀⠄⠀⠀⠀⠀⠀⠀⢀⠼⠝⡯⣟⡾⣵⠙⠀⠉⠫⣯⢳⣗⣟⣗⣯⡯⣯⢷⡳⡷⢧⢰⢆⠀⠛⠀⠀",
        "⠀⠀⢰⡇⠀⣴⢋⣁⡀⠀⠀⠀⠀⠀⣺⣽⡝⣼⢇⠀⠀⠀⠈⠃⡵⣯⢷⠳⡏⠫⢿⢄⠥⠤⣅⠉⠇⠀⢠⠀",
        "⠀⠲⡘⣗⡄⢳⣟⠊⠉⠲⣄⡀⠀⠀⣟⡎⢀⠛⠀⠀⠀⠀⠀⠀⠁⢻⡽⡄⠉⠒⠀⠉⠳⠀⢸⠆⠀⢀⡖⠀",
        "⠀⠀⠑⠪⢯⣗⣝⡳⠤⡄⡀⠀⢠⡼⡽⠂⠋⠀⠀⠀⠀⠀⠀⠀⢀⠀⣟⣗⣀⠀⠐⣄⣀⡴⣯⢴⠮⠋⠀⠀",
        "⠀⠀⠀⠐⠢⡭⣚⣗⣖⣢⡠⠤⢘⣒⣈⣠⡤⣼⠤⠀⠀⠀⡄⠀⢠⡇⠈⠚⠓⠓⣠⣗⡯⠿⢙⣉⠄⠊⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠉⠚⠽⠾⡽⠻⡳⣗⣟⣮⣭⣤⣤⢤⠴⠞⡃⠼⠓⠁⠤⠲⠮⠟⢗⠯⠟⠙⠁⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠁⠁⠑⠑⠒⠂⠀⠀⠊⠐⠓⠋⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "                                        ",
        "                                        ",};

    String[] archerArt = {
        "                           ",
        "                           ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⣲⠳⠀",
        "⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⢠⠎⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡦⡀⠤⠀⠀⠠⢹⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⣀⣶⣿⣿⣿⣿⣿⣿⡿⣿⣝⢕⠀⠈⡠⠁⡸⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠻⣅⢳⡐⠀⠀⡇⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⠢⠀⡝⠐⡀⢠⠃⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⣿⣿⡟⢿⣿⣿⣿⣿⣿⣄⠔⠀⠀⠀⡜⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠠⣾⣿⣿⡧⢈⣽⣿⣿⣿⣿⣿⣧⣄⠀⣸⠃⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠠⣄⠸⣿⣿⢢⣿⣿⣿⣿⣿⣿⣿⡝⠻⣿⡗⠀⠀⠀⠀⠀⠀⠀",
        "⠀⢄⣰⣤⣜⠄⢿⣿⣼⣿⣿⣿⣿⣿⣿⣿⣟⣠⠏⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠓⠽⡻⢒⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠑⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⢀⣿⣿⠙⠻⠛⠛⠻⠻⠿⣿⣿⠿⠿⠿⠟⠛⠁⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⢐⣿⣿⣤⣀⣢⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠻⣿⠗⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠋⠁⠀⠀⠀⠀⠀⠀⠀",
        "                           ",};

    String[] healerArt = {
        "                           ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⠀⠀",
        "⠀⠀⠤⠤⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣗⠀⠀",
        "⠀⢲⣶⣶⡼⠂⠀⠀⠀⠀⠀⠀⠀⣠⣶⣶⣶⡀⠀⠀⠀⠀⠀⢸⣿⡃⠀",
        "⠀⢼⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣸⡟⠀⠀",
        "⠀⢀⣸⠅⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣇⣀⠀⠀⠀⣰⣿⡇⠀⠀",
        "⠈⠉⠛⠻⣦⡀⠀⠀⠀⢀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⢿⠂⠀⠀",
        "⠀⠀⠀⠀⠘⢿⣶⣄⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠉⠉⠀⣺⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠈⠻⠿⠿⠛⢻⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⡿⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣀⡀⡏⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⠆⠀⠙⢷⣧⡀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⡁⠀⠀⢸⡃⢽⡆⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⡅⠀⢀⣸⣧⠟⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⡅⠀⢼⣹⠂⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢽⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠈⣿⢷⡄⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⣀⣿⠾⠁⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⡇⣼⠋⡇⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠹⢷⣧⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⢸⡍⢷⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠟⣿⡟⠛⠛⣿⡏⠉⠀⠀⣸⠆⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣰⣿⡇⠀⠀⠻⢿⣶⡄⠀⠸⠁⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠛⠁⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀",
        "                           ",};

    String[] tankArt = {
        "                                ",
        "           ⠀⠀⠀⠀⣤⠀⠀⠀⠀⣶⣆⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "         ⠀⠀⠀⠀⠀⣼⣿⣧⠀⠀⣾⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀ ",
        "         ⣀⣀⠀⠀⣸⡏⠀⠹⣇⣼⢏⣠⣤⣖⡀⠀⠀⠀⠀⠀⠀  ",
        "        ⠱⣿⣿⣿⣷⣿⣥⣦⣤⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀ ",
        "         ⠾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⣭⡀⠀⠀⠀⠀⠀",
        "        ⠀⠉⠽⣿⣿⣿⣿⣿⣿⣿⣿⣟⣟⣷⠁⣰⣿⣧⠀⠀⠀⠀⠀ ",
        "       ⠀⠀⠀⡈⣿⣿⣿⣿⣿⣿⡿⡝⠹⣿⣷⣼⣿⣿⣿⣡⠤⠊⠀⠀ ",
        "     ⠀⠀⠀⠀⠀⠀⣿⢿⣿⣿⣿⣿⣾⣾⣇⠀⠉⣿⣿⣿⣿⣿⣷⣤⠀⣀⠄",
        "   ⠀⠀⠀⠀⠀⠀⠀⡯⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣼⣿⣿⣿⣿⣿⣿⣯⠀⠀ ",
        " ⠀⠀⠀⠀⠀⠀⠀⠠⣗⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠁⠀  ",
        " ⠀⠀⠀⠀⠀⠀⢀⣞⢹⣿⣿⣿⣿⣿⣿⣿⣿⣝⠋⣿⣿⡿⣿⡿⠟⠀⠙⠀⠀  ",
        " ⠀⠀⢀⣤⣀⣠⣿⠁⣾⣿⣿⣿⣿⣟⣿⣿⣿⣷⠀⠉⠙⠁⠈⠁⠀⠀⠀⠀⠀  ",
        " ⠀⢠⣿⣿⣿⣿⣷⡀⢹⣿⣿⡿⣿⣵⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⣠⣿⣿⣿⣿⣿⡿⠀⠹⣿⣿⣻⣿⡗⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠐⣻⣿⣿⣿⣿⡿⠁⠀⠀⣿⣿⣯⣿⡇⢻⣿⢿⢯⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠈⠙⠿⣿⡿⠁⠀⠀⠀⢿⣿⣿⠺⣿⠀⡏⣿⣿⣿⡏⠀⠀⠀⠀       ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠋⠀⠀⠘⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡿⠀⠀⠀⠀⠀⠘⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣿⣿⡿⠀⠀⠀⠀⠀⠀⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠊⠋⠋⠁⠀⠀⠀⠀⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "                                ",};

    String[] warriorArt = {
        "                                 ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡮⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⢠⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⢽⣻⣄⣄⣤⣤⢼⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⣯⣟⣖⠨⡾⡞⣯⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣲⣲⣤⡈⣶⣞⡾⡄⠛⢒⣷⣻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⣰⢿⣽⣳⡯⡧⣷⢯⣟⡗⣈⣶⣻⠂⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠠⣿⢽⠞⡇⠁⠀⠉⣟⣾⡳⠟⡚⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢘⢷⣤⣠⣷⣻⡎⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣟⣾⣳⣟⣞⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣞⣷⣻⣞⣷⣻⣞⣷⣻⣞⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣗⣟⡾⡾⡎⠀⠈⠺⣳⣻⢾⣵⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣮⢿⣽⡻⠀⠀⠀⠀⠀⠙⠽⣾⢽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢿⡽⡾⠁⠀⠀⠀⠀⠀⠀⠀⣹⣟⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣟⡯⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢟⣾⡂⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⣠⢾⡳⠏⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢺⢷⡀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⢀⣴⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣇⡀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⣟⣾⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠫⠻⠱⠢⠀⠀⠀⠀",
        "                                 ",
        "                                 ",};

    String[] art(String role) {
        return switch (role) {
            case "Mage" ->
                mageArt;
            case "Warlock" ->
                warlockArt;
            case "Cleric" ->
                clericArt;
            case "Summoner" ->
                summonerArt;
            case "Rogue" ->
                rogueArt;
            case "Archer" ->
                archerArt;
            case "Healer" ->
                healerArt;
            case "Tank" ->
                tankArt;
            case "Warrior" ->
                warriorArt;
            default ->
                new String[]{""};
        };
    }

    String[][] allArt() {
        return new String[][]{
            mageArt,
            warlockArt,
            clericArt,
            summonerArt,
            rogueArt,
            archerArt,
            healerArt,
            tankArt,
            warriorArt
        };
    }
}
