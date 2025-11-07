package com.infinityfortress.ui;

public interface Menu {
    public void display();

    default public void display(int choice) {
        display();
    }
}

class MainMenu implements Menu {
      public static String center(String text, int width) {
        if (text == null || width <= text.length()) {
            return text;
        }
        int padding = width - text.length();
        int padLeft = padding / 2;
        int padRight = padding - padLeft;
        return " ".repeat(padLeft) + text + " ".repeat(padRight);
    }


    public void display() {
      final int max=34;
      for (int i=0; i<max; i++) {
        switch (i) {
          case 0 -> {
            System.out.print('┌');
            System.out.print("─".repeat(117));
            System.out.print('┐');
          }
          case max-1 -> {
            System.out.print('└');
            System.out.print("─".repeat(117));
            System.out.print('┘');
          }
          default -> {
            System.out.print('│');
            switch (i) {
                case max/2 -> {
                        String msg=center("Setup you console to match the box, press ESC to reset box position", 117);
                        System.out.print(msg);
                    }
                case (max/2)+1 -> {
                        String msg=center("Press Enter to continue...", 117);
                        System.out.print(msg);
                    }
                default -> System.out.print(" ".repeat(117));
            }
            System.out.print('│');
          }
        }
        if (i!=max-1) System.out.println();
      }
    }
}

//120 characters wide 117 usable
//30 characters tall 26 usable


class BattleMenu implements Menu {
    int[] fieldHeader={
      1, 1, 1, 1, 19, 1, 1, 1, 19, 1, 23, 1, 19, 1, 1, 1, 19, 1, 1, 1, 1
    };
    String[][] fieldGrid = {
      {" ", "┌", "─", "─", "─", "─", "─", "─","─","─","─","─","─","─","─","─","─","─","─","┐"," "},
      {" ", "│", " ", "┌", "─", "┐", " ", " "," "," "," "," "," "," "," ","┌","─","┐"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", " "," "," "," "," "," "," "," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", " "," "," "," "," "," "," "," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", " "," "," "," "," "," "," "," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", "┌", "─", "┐"," ","┌", "─", "┐"," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", "│", "text", "│"," ","│", "text", "│"," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "└", "─", "┘", " ", "├", "─", "┤"," ","├", "─", "┤"," ","└","─","┘"," ","│"," "},
      {" ", "│", " ", " ", " ", " ", " ", "│", "text", "│"," ","│", "text", "│"," "," "," "," "," ","│"," "},
      {" ", "│", " ", "┌", "─", "┐", " ", "├", "─", "┤"," ","├", "─", "┤"," ","┌","─","┐"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", "│", "text", "│"," ","│", "text", "│"," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", "└", "─", "┘"," ","└", "─", "┘"," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", " "," "," "," "," "," "," "," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", "┌", "─", "┐"," ","┌", "─", "┐"," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", "│", "text", "│"," ","│", "text", "│"," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "└", "─", "┘", " ", "├", "─", "┤"," ","├", "─", "┤"," ","└","─","┘"," ","│"," "},
      {" ", "│", " ", " ", " ", " ", " ", "│", "text", "│"," ","│", "text", "│"," "," "," "," "," ","│"," "},
      {" ", "│", " ", "┌", "─", "┐", " ", "├", "─", "┤"," ","├", "─", "┤"," ","┌","─","┐"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", "│", "text", "│"," ","│", "text", "│"," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", "└", "─", "┘"," ","└", "─", "┘"," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", " "," "," "," "," "," "," "," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "├", "─", "┤", " ", " "," "," "," "," "," "," "," ","├", "─", "┤"," ","│"," "},
      {" ", "│", " ", "│", "text", "│", " ", " "," "," "," "," "," "," "," ","│","text","│"," ","│"," "},
      {" ", "│", " ", "└", "─", "┘", " ", " "," "," "," "," "," "," "," ","└","─","┘"," ","│"," "},
      {" ", "└", "─", "─", "─", "─", "─", "─","─","─","─","─","─","─","─","─","─","─","─","┘"," "}
    };
    int[] actionHeader = {
      21, 1, 2, 6, 2, 1, 
      9, 1, 2, 7, 2, 1, 
      9, 1, 2, 5, 2, 1, 
      9, 1, 2, 4, 2, 1, 21
    };
    String[][] actionGrid = {
      {" ", "┌", " ", " ", " ", "┐", " ", "┌", " ", " ", " ", "┐", " ", "┌", " ", " ", " ", "┐", " ", "┌", " ", " ", " ", "┐", " "},
      {" ", "│", " ", "ATTACK", " ", "│", " ", "│", " ", "SPECIAL", " ", "│", " ", "│", " ", "BLOCK", " ", "│", " ", "│", " ", "REST", " ", "│", " "},
      {" ", "└", " ", " ", " ", "┘", " ", "└", " ", " ", " ", "┘", " ", "└", " ", " ", " ", "┘", " ", "└", " ", " ", " ", "┘", " "},
    };

    @Override
    public void display() {
      display(0);
    }

    public void display(int choice) {
      System.out.print('┌');
      System.out.print("─".repeat(117));
      System.out.println('┐');
      System.out.print("│");
      System.out.print(" ".repeat(117));
      System.out.print("│");
      for (String[] row : fieldGrid) {
        System.out.print("│ ");
        for (int i=0; i<row.length; i++) {
          if (row[i].equals("text")) {
            System.out.print(" ".repeat(fieldHeader[i]));
          } else {
            System.out.print(row[i].repeat(fieldHeader[i]));
          }
        }
        System.out.print(" │");
        System.out.println();
      }
      System.out.print("│");
      System.out.print(" ".repeat(117));
      System.out.print("│");
      
      int[][] options = {
        {1, 5},
        {7, 11},
        {13, 17},
        {19, 23}
      };

      for (String[] row : actionGrid) {
        System.out.print("│ ");
        for (int i=0; i<row.length; i++) {
          if (options[choice][0]==i) {
            System.out.print("\u001B[100m");
          }
          if (row[i].length()>1) {
            System.out.print(row[i]);
          } else {
            System.out.print(row[i].repeat(actionHeader[i]));
          }
          if (options[choice][1]==i) {
            System.out.print("\u001B[0m");
          }
        }
        System.out.print(" │");
        System.out.println();
      }

      System.out.print("│");
      System.out.print(" ".repeat(117));
      System.out.print("│");

      System.out.print('└');
      System.out.print("─".repeat(117));
      System.out.println('┘');
    }
}

class ActionMenu implements Menu {

    public void display(){
        System.out.print("Test");
        //code
    }


}
    
class StatsMenu implements Menu {
    public void display(){
        //code
    }
}

class ItemsMenu implements Menu {
    public void display(){
        //code
    }
}

class MapMenu implements Menu {
    public void display(){
        //code
    }
}

class RewardMenu implements Menu {
    public void display(){
        //code
    }
}

class GachaMenu implements Menu {
    public void display(){
        //code
    }
}