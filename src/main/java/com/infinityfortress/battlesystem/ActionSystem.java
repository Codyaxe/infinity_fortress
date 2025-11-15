package com.infinityfortress.battlesystem;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.ActionComponent;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.AudioHandler;
import com.infinityfortress.utils.InputHandler;

public class ActionSystem {
  private final DecisionSystem decisionSystem;

  public ActionSystem(DecisionSystem decisionSystem) {
    this.decisionSystem = decisionSystem;
  }

  public boolean start(MainBattleUI battleUI, NCharacter curr) {
    MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new ActionComponent());

    int choice = 0;
    int maxChoice = 3;

    mainBattleUI.updateSelection();
    while (true) {
      mainBattleUI.updateChoice(choice);
      InputHandler.waitForInput();

      if (InputHandler.left.get()) {
        choice = Math.max(0, choice - 1);
        InputHandler.left.set(false);
        AudioHandler.playSelect();
      }
      if (InputHandler.right.get()) {
        choice = Math.min(maxChoice, choice + 1);
        InputHandler.right.set(false);
        AudioHandler.playSelect();
      }
      if (InputHandler.back.get()) {
        InputHandler.back.set(false);
        AudioHandler.playBack();
        return false;
      }
      if (InputHandler.enter.get()) {
        AudioHandler.playEnter();
        switch (choice) {
          case 0 -> {
            if (decisionSystem.start(mainBattleUI, curr, curr.getBasicAction())) {
              return true;
            }
          }
          case 1 -> {
            if (!curr.getSpecialAction().getAllSubActions().isEmpty()) {
              if (decisionSystem.start(mainBattleUI, curr, curr.getSpecialAction())) {
                return true;
              }
            } else {
              return true;
            }
          }
          case 2 -> {
            if (decisionSystem.start(mainBattleUI, curr, curr.getBlockAction())) {
              return true;
            }
          }
          case 3 -> {
            if (decisionSystem.start(mainBattleUI, curr, curr.getRestAction())) {
              return true;
            }

          }
        }
        mainBattleUI.updateSelection();
        InputHandler.enter.set(false);
      }
    }
  }
}
