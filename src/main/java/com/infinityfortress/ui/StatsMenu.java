package com.infinityfortress.ui;

import com.infinityfortress.actions.Action;
import com.infinityfortress.characters.*;
import com.infinityfortress.utils.Utils;

public class StatsMenu {

    void check(int num) {
        System.out.println(num);
    }

    public void display(NCharacter curr, int choice, int selected, int size) {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[H");
        CharacterArt newArt = new CharacterArt();
        String[] art = newArt.art(curr.getRole().getName());

        // Spaghetti code ahead, proceed with caution
        int[] gridHeader = { 1, 4, 1, 48, 1, 1, 1, 4, 22, 4, 22, 4, 1, 4, 1 };
        int[] descHeader = { 1, 4, 1, 48, 1, 1, 1, 1, 1, 15, 1, 1, 1, 1, 34, 1, 1, 4, 1 };
        String[][] grid = {
                { "┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐" },
                { "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│" },
                { "│", " ", "┌", "─", "┐", " ", "┌", "─", "─", "─", "─", "─", "┐", " ", "│" },
                { "│", " ", "│", "Race: ", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "Role", "│", " ", "│", " ", "LVL", " ", "EXP", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", "HP", " ", "SPD", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", "MP", " ", "LUCK", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", "STR", " ", "CRIT CHANCE", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", "DEF", " ", "CRIT DAMAGE", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "└", "─", "─", "─", "─", "─", "┘", " ", "│" },
                { "│", " ", "│", "art", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│" }
        };

        String[][] descGrid = { // 2, 14
                { "│", " ", "│", "art", "│", " ", "┌", "─", "─", "─", "─", "─", "┬", "─", "─", "─", "┐", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },

                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", "BASIC SKILL", " ", " ", "│", " ", " ", " ", "│", " ",
                        "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", "SPECIAL SKILL", " ", " ", "│", " ",
                        Utils.leftAlign("Description: ", descHeader[14]), " ", "│", " ", "│" },

                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", "EQUIPMENT", " ", " ", "│", " ", " ", " ", "│", " ",
                        "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "│", "art", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", " ", " ", "│", " ", "│" },
                { "│", " ", "└", "─", "┘", " ", "└", "─", "─", "─", "─", "─", "┴", "─", "─", "─", "┘", " ", "│" }
        };

        switch (choice) {
            case 0 -> {
                // Display basic/first action
                Action basicAction = curr.getBasicAction();
                if (basicAction != null) {
                    descGrid[1][14] = Utils.spaceBetween("Skill Type: ", basicAction.getActionType(), descHeader[14]);
                    descGrid[2][14] = Utils.spaceBetween("Hit Type: ", String.valueOf(basicAction.getHitCount()),
                            descHeader[14]);
                    descGrid[3][14] = Utils.spaceBetween("Damage: ", String.valueOf(basicAction.getBaseDamage()),
                            descHeader[14]);
                    descGrid[4][14] = Utils.spaceBetween("MP Cost: ", String.valueOf(basicAction.getManaCost()),
                            descHeader[14]);
                    String[] temp = Utils.createTextGrid(5, descHeader[14], basicAction.getDescription());
                    for (int i = 0; i < 5; i++) {
                        descGrid[7 + i][14] = Utils.leftAlign(temp[i], descHeader[14]);
                    }
                } else {
                    // No basic action available
                    descGrid[1][14] = Utils.spaceBetween("Skill Type: ", "None", descHeader[14]);
                    descGrid[2][14] = Utils.spaceBetween("Hit Type: ", "N/A", descHeader[14]);
                    descGrid[3][14] = Utils.spaceBetween("Damage: ", "N/A", descHeader[14]);
                    descGrid[4][14] = Utils.spaceBetween("MP Cost: ", "N/A", descHeader[14]);
                    String[] temp = Utils.createTextGrid(5, descHeader[14], "No action available");
                    for (int i = 0; i < 5; i++) {
                        descGrid[7 + i][14] = Utils.leftAlign(temp[i], descHeader[14]);
                    }
                }
            }
            case 1 -> {
                // Display special/second action
                Action specialAction = curr.getSpecialAction();
                if (specialAction != null) {
                    descGrid[1][14] = Utils.spaceBetween("Skill Type: ", specialAction.getActionType(), descHeader[14]);
                    descGrid[2][14] = Utils.spaceBetween("Hit Type: ", String.valueOf(specialAction.getHitCount()),
                            descHeader[14]);
                    descGrid[3][14] = Utils.spaceBetween("Damage: ", String.valueOf(specialAction.getBaseDamage()),
                            descHeader[14]);
                    descGrid[4][14] = Utils.spaceBetween("MP Cost: ", String.valueOf(specialAction.getManaCost()),
                            descHeader[14]);
                    String[] temp = Utils.createTextGrid(5, descHeader[14], specialAction.getDescription());
                    for (int i = 0; i < 5; i++) {
                        descGrid[7 + i][14] = Utils.leftAlign(temp[i], descHeader[14]);
                    }
                } else {
                    // No special action available
                    descGrid[1][14] = Utils.spaceBetween("Skill Type: ", "None", descHeader[14]);
                    descGrid[2][14] = Utils.spaceBetween("Hit Type: ", "N/A", descHeader[14]);
                    descGrid[3][14] = Utils.spaceBetween("Damage: ", "N/A", descHeader[14]);
                    descGrid[4][14] = Utils.spaceBetween("MP Cost: ", "N/A", descHeader[14]);
                    String[] temp = Utils.createTextGrid(5, descHeader[14], "No special action available");
                    for (int i = 0; i < 5; i++) {
                        descGrid[7 + i][14] = Utils.leftAlign(temp[i], descHeader[14]);
                    }
                }
            }
        }

        int[][][] options = {
                {
                        { 2, 8 },
                        { 3, 8 },
                        { 4, 8 },
                        { 2, 10 },
                        { 3, 10 },
                        { 4, 10 }
                },
                {
                        { 5, 8 },
                        { 6, 8 },
                        { 7, 8 },
                        { 5, 10 },
                        { 6, 10 },
                        { 7, 10 }
                },
                {
                        { 8, 8 },
                        { 9, 8 },
                        { 10, 8 },
                        { 8, 10 },
                        { 9, 10 },
                        { 10, 10 }
                }
        };

        descGrid[options[choice][0][0]][options[choice][0][1]] = "┌";
        descGrid[options[choice][1][0]][options[choice][1][1]] = "│";
        descGrid[options[choice][2][0]][options[choice][2][1]] = "└";
        descGrid[options[choice][3][0]][options[choice][3][1]] = "┐";
        descGrid[options[choice][4][0]][options[choice][4][1]] = "│";
        descGrid[options[choice][5][0]][options[choice][5][1]] = "┘";

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals("art")) {
                    int artIndex = i - 5;
                    if (artIndex >= 0 && artIndex < art.length) {
                        frame.append(Utils.center(art[artIndex], gridHeader[j]));
                    } else {
                        frame.append(Utils.center(" ", gridHeader[j]));
                    }
                } else if (grid[i][j].contains("Race")) {
                    frame.append(Utils.leftAlign(" Race: " + curr.getRace().getName(), gridHeader[j]));
                } else if (grid[i][j].contains("Role")) {
                    frame.append(Utils.leftAlign(" Role: " + curr.getRole().getName(), gridHeader[j]));
                } else if (grid[i][j].contains("LVL")) {
                    frame.append(Utils.spaceBetween("LVL ", "" + curr.getLvl(), gridHeader[j]));
                } else if (grid[i][j].contains("EXP")) {
                    frame.append(Utils.spaceBetween("EXP ", "" + curr.getExp(), gridHeader[j]));
                } else if (grid[i][j].contains("HP")) {
                    frame.append(Utils.spaceBetween("HP ", "" + curr.getMaxHealth(), gridHeader[j]));
                } else if (grid[i][j].contains("MP")) {
                    frame.append(Utils.spaceBetween("MP ", "" + curr.getMaxMana(), gridHeader[j]));
                } else if (grid[i][j].contains("STR")) {
                    frame.append(Utils.spaceBetween("STR ", "" + curr.getStrength(), gridHeader[j]));
                } else if (grid[i][j].contains("DEF")) {
                    frame.append(Utils.spaceBetween("DEF ", "" + curr.getDefense(), gridHeader[j]));
                } else if (grid[i][j].contains("SPD")) {
                    frame.append(Utils.spaceBetween("SPD ", "" + curr.getSpeed(), gridHeader[j]));
                } else if (grid[i][j].contains("LUCK")) {
                    frame.append(Utils.spaceBetween("LUCK ", "" + curr.getLuck(), gridHeader[j]));
                } else if (grid[i][j].contains("CRIT CHANCE")) {
                    frame.append(Utils.spaceBetween("CRIT CHANCE ", "" + curr.getCritChance(), gridHeader[j]));
                } else if (grid[i][j].contains("CRIT DAMAGE")) {
                    frame.append(Utils.spaceBetween("CRIT DAMAGE ", "" + curr.getCritStrength(), gridHeader[j]));
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
                    int artIndex = i + 11;
                    if (artIndex >= 0 && artIndex < art.length) {
                        frame.append(Utils.center(art[artIndex], descHeader[j]));
                    } else {
                        frame.append(Utils.center(" ", descHeader[j]));
                    }
                } else if (descGrid[i][j].length() > 1) {
                    frame.append(Utils.center(descGrid[i][j], descHeader[j]));
                } else {
                    frame.append(descGrid[i][j].repeat(descHeader[j]));
                }
            }
            frame.append("\n");
        }

        int[] selectionHeader = { 1, 117, 1 };
        String[][] selectionGrid = {
                { "│", " ", "│" },
                { "│", " ", "│" },
                { "│", " ", "│" },
                { "└", "─", "┘" }
        };

        for (int a = 0; a < 3; a++) {
            String selection = "";
            for (int i = 0; i < size; i++) {
                if (i == selected) {
                    if (a == 2) {
                        selection += "  ____  ";
                    } else {
                        selection += "        ";
                    }
                } else {
                    selection += "  ####  ";
                }
            }
            selectionGrid[a][1] = selection;
        }

        for (int i = 0; i < selectionGrid.length; i++) {
            for (int j = 0; j < selectionGrid[i].length; j++) {
                if (selectionGrid[i][j].length() > 1) {
                    frame.append(Utils.center(selectionGrid[i][j], selectionHeader[j]));
                } else {
                    frame.append(selectionGrid[i][j].repeat(selectionHeader[j]));
                }
            }
            if (i != selectionGrid.length - 1) {
                frame.append("\n");
            }
        }

        System.out.print(frame.toString());
        System.out.flush();
    }
}
