package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;

import com.infinityfortress.utils.Utils;

public class TurnOrderComponent {
  StringBuilder turnOrderUI;

  public TurnOrderComponent(ArrayList<String> turnOrder) {
    StringBuilder frame = new StringBuilder();
    int[] pos = { 29, 49, 73 };
    int[] size = { 19, 23, 19 };
    frame.append("\033[2;27H").append("➤");

    // Clears the Queue
    for (int i = 0; i < 3; i++) {
      frame.append("\033[2;").append(pos[i]).append("H")
          .append(" ".repeat(size[i] + 9));
    }

    // Add the turns
    for (int i = 0; i < Math.min(turnOrder.size(), 3); i++) {
      frame.append("\033[2;").append(pos[i]).append("H")
          .append(Utils.center(turnOrder.get(i), size[i] + 9));
    }

    frame.append("\033[0m");
    this.turnOrderUI = frame;
  }

  public void displayComponent() {
    System.out.print(this.turnOrderUI.toString());
  }

  public StringBuilder getComponent() {
    return this.turnOrderUI;
  }
}
