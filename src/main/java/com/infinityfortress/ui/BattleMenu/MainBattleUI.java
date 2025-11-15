package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

// update=replace object
// display=print to console
// get=return stringbuilder
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

  public void updateTurnOrder(ArrayList<String> turn) {
    this.turnOrder = new TurnOrderComponent(turn);
  }

  public void updateField(ArrayList<NCharacter> players, ArrayList<NCharacter> enemies) {
    this.field = new FieldComponent(players, enemies);
    // Add this back if necessary
    // this.field.displayComponent();
  }

  // Battle Start
  public MainBattleUI(ArrayList<NCharacter> players, ArrayList<NCharacter> enemies, ArrayList<String> turn) {
    this.turnOrder = new TurnOrderComponent(turn);
    this.field = new FieldComponent(players, enemies);
    this.selection = new OptionsComponent();
  }

  // Action Selected
  public MainBattleUI(MainBattleUI battleUI, ActionComponent actionUI) {
    this.selection = actionUI;
    this.field = battleUI.field;
    this.turnOrder = battleUI.turnOrder;
  }

  // SubAction Selected
  public MainBattleUI(MainBattleUI battleUI, SubActionComponent subActionUI) {
    this.selection = subActionUI;
    this.field = battleUI.field;
    this.turnOrder = battleUI.turnOrder;
  }

  // Target Selection
  public MainBattleUI(MainBattleUI battleUI, TargetingComponent targetingUI) {
    this.selection = targetingUI;
    this.field = battleUI.field;
    this.turnOrder = battleUI.turnOrder;
  }

  public void display() {
    // It just looks weird and that's why I like it
    System.out.print(
        this.field.getComponent()
            .append(this.turnOrder.getComponent())
            .append(this.selection.getSelection())
            .toString());
  }
}
