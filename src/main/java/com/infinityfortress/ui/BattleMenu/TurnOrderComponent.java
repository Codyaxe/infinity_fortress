package com.infinityfortress.ui.BattleMenu;
import com.infinityfortress.characters.*;
import java.util.Queue;
import com.infinityfortress.utils.Utils;

public class TurnOrderComponent {
  StringBuilder turnOrderUI;

  public TurnOrderComponent(Queue<NCharacter> turnOrder) {
    StringBuilder frame = new StringBuilder();
    int[] pos = {29, 49, 73};
    int[] size = {19, 23, 19};
    int idx=0;
    frame.append("\033[2;27H").append("➤");
    while (!turnOrder.isEmpty()) {
      frame.append("\033[2;").append(pos[idx]).append("H")
      .append(turnOrder.peek().getType() == NCharacterType.ALLY ? "\033[32m" : "\033[31m")
      .append(Utils.center(turnOrder.poll().getName(), size[idx++]));
    }
    frame.append("\033[0m");
    this.turnOrderUI = frame;
  }

  public void display() {
    System.out.print(this.turnOrderUI.toString());
  }

  public StringBuilder getTurnOrder() {
    return this.turnOrderUI;
  }
}
