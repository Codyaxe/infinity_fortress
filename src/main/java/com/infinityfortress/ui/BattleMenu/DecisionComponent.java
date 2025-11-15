package com.infinityfortress.ui.BattleMenu;

public class DecisionComponent extends SelectionUI {
  @Override
  public StringBuilder displayChoices() {
    StringBuilder frame = new StringBuilder();
    frame.append("\033[29;36HACTION");
    frame.append("\033[29;58HSTAT");
    frame.append("\033[29;79HITEM");
    // System.out.print(frame.toString());
    return frame;
  }

  @Override
  public StringBuilder updateChoice(int choice) {
    StringBuilder frame = new StringBuilder();
    int options[][] = {
      {28, 30, 33, 44},
      {28, 30, 55, 64},
      {28, 30, 76, 85},
    };
    String[] choiceIndicators = {"┌", "┐", "└", "┘"};
    for (int i=0; i<3; i++) {
      for (int j=0; j<4; j++) {
        if (i == choice) 
          frame.append("\033[").append(options[i][j/2]).append(";").append(options[i][j%2+2]).append("H").append(choiceIndicators[j]);
        else 
          frame.append("\033[").append(options[i][j/2]).append(";").append(options[i][j%2+2]).append("H").append(" ");
      }
    }
    // System.out.print(frame.toString());
    return frame;
  }

//28, 41
  @Override
  public void display() {
    System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()).append(updateChoice(0)));
  }
  
  @Override
  public StringBuilder getSelection() {
    return (new StringBuilder().append(getSkeleton()).append(displayChoices()));
  }
}
