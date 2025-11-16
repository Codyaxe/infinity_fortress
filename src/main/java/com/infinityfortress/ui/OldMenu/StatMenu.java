package com.infinityfortress.ui.OldMenu;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class StatMenu {

      String[] BasicSection(NCharacter curr) {
        String[] skillGrid = new String[11];
        int size=34;
        for (int i = 0; i < skillGrid.length; i++) {
            skillGrid[i] = " ".repeat(size);
        }
        return skillGrid;
      }
      String[] SpecialSection(NCharacter curr) {
        String[] skillGrid = new String[11];
        int size=34;
        for (int i = 0; i < skillGrid.length; i++) {
            skillGrid[i] = " ".repeat(size);
        }
        return skillGrid;
      }
      String[] equipmentSection(NCharacter curr) {
        String[] skillGrid = new String[11];
        int size=34;
        for (int i = 0; i < skillGrid.length; i++) {
            skillGrid[i] = " ".repeat(size);
        }
        return skillGrid;
      }

    // String[] BasicSection(NCharacter curr) {
    //   String[] skillGrid = new String[11];
    //   int size=34;
    //   skillGrid[0] = Utils.spaceBetween(
    //     Utils.spaceBetween("Damage: ", curr.getBasicAction(), (int)size/3),
    //     Utils.spaceBetween("MP Cost: ", curr.getAttackCost(), (int)size/3),
    //     size
    //     );
    //   skillGrid[1] = Utils.spaceBetween("Skill Type: ", curr.getAttackType(), size);
    //   skillGrid[2] = Utils.spaceBetween("Hit Type: ", curr.getAttackHitCount(), size);
    //   skillGrid[3] = Utils.spaceBetween("Success Rate: ", "100%", size);
    //   skillGrid[4] = " ".repeat(size);
    //   skillGrid[5] = Utils.leftAlign("Description: ", size);

    //   String[] temp = Utils.createTextGrid(5, size, curr.getAttackDesc());
    //   for (int i = 0; i < 5; i++) skillGrid[6 + i] = Utils.leftAlign(temp[i], size);

    //   return skillGrid;
    // }

    // String[] SpecialSection(NCharacter curr) {
    //   String[] skillGrid = new String[11];
    //   int size=34;
    //   skillGrid[0] = Utils.spaceBetween(
    //     Utils.spaceBetween("Damage: ", curr.getSpecialDMG(), (int)size/3),
    //     Utils.spaceBetween("MP Cost: ", curr.getSpecialCost(), (int)size/3),
    //     size
    //   );
    //   skillGrid[1] = Utils.spaceBetween("Skill Type: ", curr.getSpecialType(), size);
    //   skillGrid[2] = Utils.spaceBetween("Hit Type: ", curr.getSpecialHitCount(), size);
    //   skillGrid[3] = Utils.spaceBetween("Success Rate: ", "100%", size);
    //   skillGrid[4] = " ".repeat(size);
    //   skillGrid[5] = Utils.leftAlign("Description: ", size);

    //   String[] temp = Utils.createTextGrid(5, size, curr.getSpecialDesc());
    //   for (int i = 0; i < 5; i++) skillGrid[6 + i] = Utils.leftAlign(temp[i], size);

    //   return skillGrid;
    // }
    
    // String[] equipmentSection(NCharacter curr) {
    //   String[] equipGrid = new String[11];
    //   int size=34;
      
    //   equipGrid[0] = Utils.leftAlign("Weapon: ", size);
    //   equipGrid[1] = Utils.leftAlign(curr.getWeapon(), size);
    //   equipGrid[2] = " ".repeat(size);
    //   equipGrid[3] = Utils.leftAlign("Armor: ", size);
    //   equipGrid[4] = Utils.leftAlign(curr.getArmor(), size);
    //   equipGrid[5] = " ".repeat(size);
    //   equipGrid[6] = Utils.leftAlign("Accessory 1: ", size);
    //   equipGrid[7] = Utils.leftAlign(curr.getAccessory1(), size);
    //   equipGrid[8] = " ".repeat(size);
    //   equipGrid[9] = Utils.leftAlign("Accessory 2: ", size);
    //   equipGrid[10]= Utils.leftAlign(curr.getAccessory2(), size);
    //   return equipGrid;
    // }

    public void display(NCharacter curr, int choice, int selected, int size) {
        StringBuilder frame = new StringBuilder();
        frame.append("\033[H");
        CharacterArt newArt = new CharacterArt();
        String[] art = newArt.art(curr.getRole().getName());

        // Spaghetti code ahead, proceed with caution
        int[] gridHeader = {1, 4, 1, 48, 1, 1, 1, 4, 22, 4, 22, 4, 1, 4, 1};
        String[][] grid = {
          {"┌", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "─", "┐"},
          {"│", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"},
          {"│", " ", "┌", "─", "┐", " ", "┌", "─", "─", "─", "─", "─", "┐", " ", "│"},
          {"│", " ", "│", "A", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "B", "│", " ", "│", " ", "L", " ", "E", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "H", " ", "s", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "M", " ", "l", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "S", " ", "c", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "D", " ", "C", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", " ", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "└", "─", "─", "─", "─", "─", "┘", " ", "│"},
          {"│", " ", "│", "a", "│", " ", " ", " ", " ", " ", " ", " ", " ", " ", "│"}
        };

        int[] descHeader = {1, 4, 1, 48, 1, 1, 1, 1, 17, 1, 1, 1, 34, 1, 1, 4, 1};
        String[][] descGrid = {
          {"│", " ", "│", "a", "│", " ", "┌", "─", "─", "─", "┬", "─", "─", "─", "┐", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "B", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "S", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", "E", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "│", "a", "│", " ", "│", " ", " ", " ", "│", " ", "i", " ", "│", " ", "│"},
          {"│", " ", "└", "─", "┘", " ", "└", "─", "─", "─", "┴", "─", "─", "─", "┘", " ", "│"}
        };

        // Pending Character Info thing
        // String[] infoSection = switch (choice) {
        //   case 0 ->  BasicSection(curr);
        //   case 1 ->  SpecialSection(curr);
        //   case 2 ->  equipmentSection(curr);
        //   default -> new String[11];
        // };

        int[][][] options = {
          { {2, 7}, {3, 7}, {4, 7},  {2, 9}, {3, 9}, {4, 9}  },
          { {5, 7}, {6, 7}, {7, 7},  {5, 9}, {6, 9}, {7, 9}  },
          { {8, 7}, {9, 7}, {10, 7}, {8, 9}, {9, 9}, {10, 9} }
        };

        String[] selectionMarkers = {"┌", "│", "└", "┐", "│", "┘"};
        for (int i=0; i<selectionMarkers.length; i++) descGrid[options[choice][i][0]][options[choice][i][1]] = selectionMarkers[i];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                switch (grid[i][j]) {
                    case "a" -> frame.append(Utils.center(art[i - 5], gridHeader[j]));
                    case "A" -> frame.append(Utils.leftAlign(" Race: " + curr.getRace().getName(), gridHeader[j]));
                    case "B" -> frame.append(Utils.leftAlign(" Role: " + curr.getRole().getName(), gridHeader[j]));
                    case "L" -> frame.append(Utils.spaceBetween("LVL ", "" + curr.getLvl(), gridHeader[j]));
                    case "E" -> frame.append(Utils.spaceBetween("EXP ", "" + curr.getExp(), gridHeader[j]));
                    case "H" -> frame.append(Utils.spaceBetween("HP ", "" + curr.getMaxHealth(), gridHeader[j]));
                    case "M" -> frame.append(Utils.spaceBetween("MP ", "" + curr.getMaxMana(), gridHeader[j]));
                    case "S" -> frame.append(Utils.spaceBetween("STR ", "" + curr.getStrength(), gridHeader[j]));
                    case "D" -> frame.append(Utils.spaceBetween("DEF ", "" + curr.getDefense(), gridHeader[j]));
                    case "s" -> frame.append(Utils.spaceBetween("SPD ", "" + curr.getSpeed(), gridHeader[j]));
                    case "l" -> frame.append(Utils.spaceBetween("LUCK ", "" + curr.getLuck(), gridHeader[j]));
                    case "c" -> frame.append(Utils.spaceBetween("CRIT CHANCE ", "" + curr.getCritChance(), gridHeader[j]));
                    case "C" -> frame.append(Utils.spaceBetween("CRIT DAMAGE ", "" + curr.getCritStrength(), gridHeader[j]));
                    default  -> {
                      if (grid[i][j].length() > 1) frame.append(grid[i][j]);
                      else frame.append(grid[i][j].repeat(gridHeader[j]));
                    }
                }
            }
            frame.append("\n");
        }

        for (int i = 0; i < descGrid.length; i++) {
            for (int j = 0; j < descGrid[i].length; j++) {
                switch (descGrid[i][j]) {
                    case "a" -> frame.append(Utils.center(art[i + 11], descHeader[j]));
                    case "B" -> frame.append(Utils.center(" BASIC SKILL ", descHeader[j]));
                    case "S" -> frame.append(Utils.center(" SPECIAL SKILL ", descHeader[j]));
                    case "E" -> frame.append(Utils.center(" EQUIPMENT ", descHeader[j]));
                    case "i" -> frame.append(" ".repeat(descHeader[j]));
                    default  -> frame.append(descGrid[i][j].repeat(descHeader[j]));
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
            String row = "";
            for (int i = 0; i < size; i++) {
              if (i == selected) row += (a==2? "  ____  " : "        ");
              else row += "  ####  ";
            }
            selectionGrid[a][1] = row;
        }

        for (int i = 0; i < selectionGrid.length; i++) {
            for (int j = 0; j < selectionGrid[i].length; j++) {
                if (selectionGrid[i][j].length() > 1) frame.append(Utils.center(selectionGrid[i][j], selectionHeader[j]));
                else frame.append(selectionGrid[i][j].repeat(selectionHeader[j]));
            }
            if (i != selectionGrid.length - 1) frame.append("\n");
        }

        System.out.print(frame.toString());
    }
}