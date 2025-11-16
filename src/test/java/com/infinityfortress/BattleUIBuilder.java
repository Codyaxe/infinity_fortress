package com.infinityfortress;

public class BattleUIBuilder {
  BattleFieldUIComponent field;
  BattleOptionsUIComponent options;

  public BattleUIBuilder(BattleFieldUIComponent field, BattleOptionsUIComponent options) {
    this.field = field;
    this.options = options;
  }

  public void display() {
    StringBuilder frame = new StringBuilder();
    frame.append("┌").append("─".repeat(117)).append("┐\n");
    frame.append("│").append("─".repeat(117)).append("│\n");
    
    for (String row : field.getUI()) {
      frame.append("│  ").append(row).append(" │\n");
    }
    for (String row : options.getUI()) {
      frame.append("│  ").append(row).append(" │\n");
    }
    frame.append("└").append("─".repeat(117)).append("┘\n");
    System.out.print(frame.toString());
}
}
