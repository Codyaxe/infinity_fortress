package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public class MainBattleUI {
  SelectionUI selection;
  FieldComponent field;
  TurnOrderComponent turnOrder;
  
  public void updateChoice(int choice) {
    System.out.print(this.selection.updateChoice(choice).toString());
  }

  public void updateSelection() {
    System.out.print(this.selection.getSelection().toString());
  }

  public void updateTurnOrder(Queue<NCharacter> turnOrder) {
    Queue<NCharacter> turn = new LinkedList<>();
    turn.addAll(turnOrder);
    this.turnOrder = new TurnOrderComponent(turn);
    System.out.print(this.turnOrder.getTurnOrder().toString());
  }
  
  public void updateField(ArrayList<NCharacter> players, ArrayList<NCharacter> enemies, Queue<NCharacter> turnOrder) {
    this.field = new FieldComponent(players, enemies);
    this.field.display();
    System.out.print(this.field.getField().toString());
  }
  
  public MainBattleUI(ArrayList<NCharacter> players, ArrayList<NCharacter> enemies, Queue<NCharacter> tempQueue) {
    Queue<NCharacter> turn = new LinkedList<>();
    turn.addAll(tempQueue);
    this.turnOrder = new TurnOrderComponent(turn);
    this.field = new FieldComponent(players, enemies);
    this.selection = new OptionsComponent();
  }

  public MainBattleUI(MainBattleUI battleUI, ActionComponent actionUI) {
    this.selection = actionUI;
    this.field = battleUI.field;
    this.turnOrder = battleUI.turnOrder;
  }

  public MainBattleUI(MainBattleUI battleUI, SubActionComponent subActionUI) {
    this.selection = subActionUI;
    this.field = battleUI.field;
    this.turnOrder = battleUI.turnOrder;
  }

  public void display() {
    Utils.initiallizeBorders();
    // It just looks weird but I like it
    System.out.print(
      this.field.getField().append(
        this.turnOrder.getTurnOrder().append(
          this.selection.getSelection()
        )
      )
    );
  }
}
