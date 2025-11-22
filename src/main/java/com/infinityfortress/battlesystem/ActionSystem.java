package com.infinityfortress.battlesystem;

import java.util.Comparator;
import java.util.stream.IntStream;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.ActionComponent;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.InputHandler;

public class ActionSystem {
  private final DecisionSystem decisionSystem;

  public ActionSystem(DecisionSystem decisionSystem) {
    this.decisionSystem = decisionSystem;
  }

  public boolean start(MainBattleUI battleUI, NCharacter curr) {

    if (curr.getType() == NCharacterType.ALLY) {
      return processPlayer(battleUI, curr);
    }
    return processEnemy(battleUI, curr);

  }

  private boolean processPlayer(MainBattleUI battleUI, NCharacter curr) {

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
      }
      if (InputHandler.right.get()) {
        choice = Math.min(maxChoice, choice + 1);
        InputHandler.right.set(false);
      }
      if (InputHandler.back.get()) {
        InputHandler.back.set(false);
        return false;
      }
      if (InputHandler.enter.get()) {
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

  private boolean processEnemy(MainBattleUI battleUI, NCharacter curr) {

    MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new ActionComponent());

    int[] scores = { 50, 0, 0, 0 };
    final int BASIC = 0;
    final int SPECIAL = 1;
    final int BLOCK = 2;
    final int REST = 3;

    // Mana scoring
    if (curr.getMana() == 0) {
      scores[REST] += 100;
    } else if (curr.getMana() < (int) (0.33 * curr.getMaxMana())) {
      scores[REST] += 75;
    } else if (curr.getMana() == curr.getMana()) {
      scores[SPECIAL] += 75;
    }

    // Special-dependent scoring
    if (specialDominant(curr)) {
      scores[SPECIAL] += 50;
    } else {
      scores[BASIC] += 50;
    }

    // Health scoring
    if (curr.getHealth() < (int) (0.50 * curr.getMaxHealth())) {
      if (curr.getRole().getName() == "Healer") {
        scores[SPECIAL] += 75;
      }
      if (specialVulnerable(curr)) {
        scores[BLOCK] += 50;
      } else {
        scores[BLOCK] += 25;
      }
    } else if (curr.getHealth() < (int) (0.25 * curr.getMaxHealth())) {
      if (curr.getRole().getName() == "Healer") {
        scores[SPECIAL] += 100;
      }
      if (specialVulnerable(curr)) {
        scores[BLOCK] += 75;
      } else {
        scores[BLOCK] += 50;
      }
    }

    int choice = IntStream.range(0, scores.length)
        .boxed()
        .max(Comparator.comparingInt(i -> scores[i]))
        .orElse(-1);

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

    return true;

  }

  private boolean specialDominant(NCharacter curr) {
    String role = curr.getRole().getName();
    return role.equals("Mage") || role.equals("Cleric")
        || role.equals("Warlock") || role.equals("Tank")
        || role.equals("Summoner");
  }

  private boolean specialVulnerable(NCharacter curr) {
    String role = curr.getRole().getName();
    return role.equals("Mage") || role.equals("Archer")
        || role.equals("Summoner");
  }
}
