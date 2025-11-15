package com.infinityfortress.ui.BattleMenu;

public class ActionComponent extends SelectionUI {
  @Override
  public StringBuilder displayChoices() {
    StringBuilder frame = new StringBuilder();
    frame.append("\033[29;27HBASIC");
    frame.append("\033[29;48HSPECIAL");
    frame.append("\033[29;70HBLOCK");
    frame.append("\033[29;90HREST");
    // System.out.print(frame.toString());
    return frame;
  }

  @Override
  public StringBuilder updateChoice(int choice) {
    StringBuilder frame = new StringBuilder();
    int options[][] = {
        { 28, 30, 24, 34 },
        { 28, 30, 45, 57 },
        { 28, 30, 67, 77 },
        { 28, 30, 87, 96 },
    };
    String[] choiceIndicators = { "┌", "┐", "└", "┘" };
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i == choice)
          frame.append("\033[").append(options[i][j / 2]).append(";").append(options[i][j % 2 + 2]).append("H")
              .append(choiceIndicators[j]);
        else
          frame.append("\033[").append(options[i][j / 2]).append(";").append(options[i][j % 2 + 2]).append("H")
              .append(" ");
      }
    }
    // System.out.print(frame.toString());
    return frame;
  }

  @Override
  public void display() {
    System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()).append(updateChoice(0)));
  }

  @Override
  public StringBuilder getSelection() {
    return (new StringBuilder().append(getSkeleton()).append(displayChoices()));
  }

}
