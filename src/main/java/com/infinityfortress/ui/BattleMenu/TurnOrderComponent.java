package com.infinityfortress.ui.BattleMenu;
import java.util.ArrayList;

import com.infinityfortress.utils.Utils;

public class TurnOrderComponent {
  StringBuilder turnOrderUI;

  public TurnOrderComponent(ArrayList<String> turnOrder) {
    StringBuilder frame = new StringBuilder();
    int[] pos = {29, 49, 73};
    int[] size = {19, 23, 19};
    int idx=0;
    frame.append("\033[2;27H").append("➤");
    for (String name : turnOrder) {
      frame.append("\033[2;").append(pos[idx]).append("H")
      .append(Utils.center(name, size[idx++] + 9));
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
