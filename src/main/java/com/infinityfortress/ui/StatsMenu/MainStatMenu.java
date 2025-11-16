package com.infinityfortress.ui.StatsMenu;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.Utils;

public final class MainStatMenu {
  private int characterIndex;
  private int choice;
  private final ArrayList<NCharacter> characterList;

  public void upChoice() {
    choice = Math.max(0, choice - 1);
  }

  public void downChoice() {
    choice = Math.min(2, choice + 1);
  }

  public void leftCharacter() {
    characterIndex = Math.max(0, characterIndex - 1);
  }

  public void rightCharacter() {
    characterIndex = Math.min(characterList.size() - 1, characterIndex + 1);
  }

  public void updateCharacter() {
    StringBuilder frame = new StringBuilder();
    System.out.print(
      frame
      .append(ArtComponent.display(characterList.get(characterIndex)))
      .append(StatComponent.display(characterList.get(characterIndex)))
      .append(InfoComponent.display(characterList.get(characterIndex), choice))
      .toString()
    );
    updateCharacterIndicator();
  }

  public void updateInfo() {
    System.out.print(InfoComponent.display(characterList.get(characterIndex), choice));
  }

  public void updateCharacterIndicator() {
    StringBuilder frame = new StringBuilder();
    for (int i=0; i<3; i++) {
        String row = "";
        for (int j=0; j<characterList.size(); j++) {
            if (j == characterIndex) 
            row+= (i==2)? "  ____  " : "        ";
            else row+= "  ####  ";
        }
        frame.append("\033[").append(30+i).append(";5H").append(Utils.center(row, 109));
    }
    System.out.print(frame.toString());
  }

  public MainStatMenu(ArrayList<NCharacter> characterList, int characterIndex, int choice) {
    this.choice = choice;
    this.characterIndex = characterIndex;
    this.characterList = characterList;
    // Utils.clearConsole();
    Utils.initiallizeBorders();
    updateCharacter();
    updateCharacterIndicator();
  }

}