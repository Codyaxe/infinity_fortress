package com.infinityfortress.ui.BattleMenu;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;
import java.util.ArrayList;

public class FieldComponent {
  private final StringBuilder frameUI;

  public FieldComponent(ArrayList<NCharacter> players, ArrayList<NCharacter> enemies) {
    StringBuilder frame = new StringBuilder();
    int startX = 4, startY = 3, width = 111, height = 21;

    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i = 1; i <= height; i++)
      frame.append("\033[").append(startY + i).append(";").append(startX).append("H│").append(" ".repeat(width))
          .append("│");
    frame.append("\033[").append(startY + height + 1).append(";").append(startX).append("H└").append("─".repeat(width))
        .append("┘");

    int[][] playerCoords = {
        { 6, 4 },
        { 28, 8 },
        { 6, 11 },
        { 28, 15 },
        { 6, 18 },
    };

    int[][] enemyCoords = {
        { 94, 4 },
        { 72, 8 },
        { 94, 11 },
        { 72, 15 },
        { 94, 18 },
    };

    for (int i = 0; i < players.size(); i++) {
      if (players.get(i) != null && !players.get(i).isDead()) {
        frame.append(CharacterDisplay(players.get(i), playerCoords[i][0], playerCoords[i][1]));
      }

    }

    for (int i = 0; i < enemies.size(); i++) {
      if (enemies.get(i) != null && !enemies.get(i).isDead()) {
        frame.append(CharacterDisplay(enemies.get(i), enemyCoords[i][0], enemyCoords[i][1]));
      }
    }

    this.frameUI = frame;
  }

  private static StringBuilder CharacterDisplay(NCharacter character, int xPos, int yPos) {
    if (character == null)
      return new StringBuilder();
    StringBuilder frame = new StringBuilder();
    int width = 19;
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H┌").append("─".repeat(width)).append("┐");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H│")
        .append(Utils.center(character.getName(), width)).append("│");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H├").append("─".repeat(width)).append("┤");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H│ HP: ")
        .append(Utils.center(character.getHealth() + "/" + character.getMaxHealth(), width - 5)).append("│");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H├").append("─".repeat(width)).append("┤");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H│ MP: ")
        .append(Utils.center(character.getMana() + "/" + character.getMaxMana(), width - 5)).append("│");
    frame.append("\033[").append(yPos++).append(";").append(xPos).append("H└").append("─".repeat(width)).append("┘");
    return frame;
  }

  public void displayComponent() {
    System.out.print(this.frameUI.toString());
  }

  public StringBuilder getComponent() {
    return this.frameUI;
  }
}
