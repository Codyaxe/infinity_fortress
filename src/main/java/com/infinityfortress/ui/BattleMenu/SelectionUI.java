package com.infinityfortress.ui.BattleMenu;

public abstract class SelectionUI {
  public abstract void display();
  public abstract StringBuilder updateChoice(int choice);
  public abstract StringBuilder displayChoices();
  public abstract StringBuilder getSelection();

  public static StringBuilder getSkeleton() {
    StringBuilder frame = new StringBuilder();
    int startX = 4, startY = 26, width = 111, height = 7;
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i=1; i< height-1; i ++) frame.append("\033[").append(startY+i).append(";").append(startX).append("H│").append(" ".repeat(width)).append("│");
    frame.append("\033[").append(startY+height-1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
    // System.out.print(frame.toString());
    return frame;
  }
}