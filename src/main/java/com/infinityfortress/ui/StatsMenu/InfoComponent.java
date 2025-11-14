package com.infinityfortress.ui.StatsMenu;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.utils.DerivedStatCalculation;
import com.infinityfortress.utils.Utils;


// If you can't read it don't worry, neither can I
// Subject to Change, will be refactored later
public class InfoComponent {
  
  public StringBuilder displayBasicSkill(NCharacter curr) {
    int infoSize = 36, descSize=6, selectionSize=19;
    StringBuilder frame = new StringBuilder();

    frame.append("\033[17;57H┌").append("─".repeat(selectionSize)).append("┬").append("─".repeat(infoSize)).append("┐");
    frame.append("\033[18;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.spaceBetween(
        Utils.spaceBetween("Damage: ", ""+curr.getBasicSkillAction().getBaseDamage(), (int)infoSize/2-3),
        Utils.spaceBetween("MP Cost: ", ""+curr.getBasicSkillAction().getManaCost(), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");
    frame.append("\033[19;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.spaceBetween(
        Utils.spaceBetween("Type: ", ""+curr.getBasicSkillAction().getActionType(), (int)infoSize/2-3),
        Utils.spaceBetween("Style: ", ""+curr.getBasicSkillAction().getTargetingType(), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");
    frame.append("\033[20;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.leftAlign(
        Utils.spaceBetween("Success: ", ""+String.format("%d%%", DerivedStatCalculation.successRate(curr.getLuck())), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");

    frame.append("\033[21;57H│").append(" ".repeat(selectionSize)).append("│").append(" ".repeat(infoSize)).append("│");
    frame.append("\033[22;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Description: ", infoSize-2)).append(" │");
    
    String[] temp = Utils.createTextGrid(descSize, infoSize, curr.getBasicSkillAction().getDescription());
    for (int i = 0; i < descSize; i++) frame.append("\033[").append(23+i).append(";57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(temp[i], infoSize-2)).append(" │");
    
    frame.append("\033[29;57H└").append("─".repeat(selectionSize)).append("┴").append("─".repeat(infoSize)).append("┘");

    frame.append("\033[20;58H").append(Utils.center("BASIC SKILL", selectionSize));
    frame.append("\033[23;58H").append(Utils.center("SPECIAL SKILL",selectionSize));
    frame.append("\033[26;58H").append(Utils.center("EQUIPMENT",selectionSize));

    frame.append("\033[19;59H┌").append("\033[19;75H┐");
    frame.append("\033[21;59H└").append("\033[21;75H┘");
    return frame;
  }
  
  public StringBuilder displaySpecialSkill(NCharacter curr) {
    int infoSize = 36, descSize=6, selectionSize=19;
    StringBuilder frame = new StringBuilder();

    frame.append("\033[17;57H┌").append("─".repeat(selectionSize)).append("┬").append("─".repeat(infoSize)).append("┐");
    frame.append("\033[18;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.spaceBetween(
        Utils.spaceBetween("Damage: ", ""+curr.getSpecialSkillAction().getBaseDamage(), (int)infoSize/2-3),
        Utils.spaceBetween("MP Cost: ", ""+curr.getSpecialSkillAction().getManaCost(), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");
    frame.append("\033[19;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.spaceBetween(
        Utils.spaceBetween("Type: ", ""+curr.getSpecialSkillAction().getActionType(), (int)infoSize/2-3),
        Utils.spaceBetween("Style: ", ""+curr.getSpecialSkillAction().getTargetingType(), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");
    frame.append("\033[20;57H│").append(" ".repeat(selectionSize)).append("│ ").append(
      Utils.leftAlign(
        Utils.spaceBetween("Success: ", ""+String.format("%d%%", DerivedStatCalculation.successRate(curr.getLuck())), (int)infoSize/2-3),
        infoSize-2
      )
    ).append(" │");

    frame.append("\033[21;57H│").append(" ".repeat(selectionSize)).append("│").append(" ".repeat(infoSize)).append("│");
    frame.append("\033[22;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Description: ", infoSize-2)).append(" │");
    String[] temp = Utils.createTextGrid(descSize, infoSize, curr.getSpecialSkillAction().getDescription());
    for (int i = 0; i < descSize; i++) frame.append("\033[").append(23+i).append(";57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(temp[i], infoSize-2)).append(" │");
    frame.append("\033[29;57H└").append("─".repeat(selectionSize)).append("┴").append("─".repeat(infoSize)).append("┘");

    frame.append("\033[20;58H").append(Utils.center("BASIC SKILL", selectionSize));
    frame.append("\033[23;58H").append(Utils.center("SPECIAL SKILL",selectionSize));
    frame.append("\033[26;58H").append(Utils.center("EQUIPMENT",selectionSize));

    frame.append("\033[22;59H┌").append("\033[22;75H┐");
    frame.append("\033[24;59H└").append("\033[24;75H┘");
    return frame;
  }

  public StringBuilder displayEquipment(NCharacter curr) {
    int infoSize = 36, selectionSize=19;
    StringBuilder frame = new StringBuilder();

    frame.append("\033[17;57H┌").append("─".repeat(selectionSize)).append("┬").append("─".repeat(infoSize)).append("┐");
    
    frame.append("\033[18;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Weapon: ", infoSize-2)).append(" │");
    frame.append("\033[19;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(curr.getWeapon().getName(), infoSize-2)).append(" │");
    frame.append("\033[20;57H│").append(" ".repeat(selectionSize)).append("│").append(" ".repeat(infoSize)).append("│");
    
    frame.append("\033[21;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Armor: ", infoSize-2)).append(" │");
    frame.append("\033[22;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(curr.getArmor().getName(), infoSize-2)).append(" │");
    frame.append("\033[23;57H│").append(" ".repeat(selectionSize)).append("│").append(" ".repeat(infoSize)).append("│");
    
    frame.append("\033[24;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Accessory 1: ", infoSize-2)).append(" │");
    frame.append("\033[25;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(curr.getAccessory1().getName(), infoSize-2)).append(" │");
    frame.append("\033[26;57H│").append(" ".repeat(selectionSize)).append("│").append(" ".repeat(infoSize)).append("│");

    frame.append("\033[27;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign("Accessory 2: ", infoSize-2)).append(" │");
    frame.append("\033[28;57H│").append(" ".repeat(selectionSize)).append("│ ").append(Utils.leftAlign(curr.getAccessory2().getName(), infoSize-2)).append(" │");
    frame.append("\033[29;57H└").append("─".repeat(selectionSize)).append("┴").append("─".repeat(infoSize)).append("┘");

    frame.append("\033[20;58H").append(Utils.center("BASIC SKILL", selectionSize));
    frame.append("\033[23;58H").append(Utils.center("SPECIAL SKILL",selectionSize));
    frame.append("\033[26;58H").append(Utils.center("EQUIPMENT",selectionSize));

    frame.append("\033[25;59H┌").append("\033[25;75H┐");
    frame.append("\033[27;59H└").append("\033[27;75H┘");
    return frame;
  }

  public static StringBuilder display(NCharacter curr, int choice) {
    return switch (choice) {
      case 0 -> new InfoComponent().displayBasicSkill(curr);
      case 1 -> new InfoComponent().displaySpecialSkill(curr);
      case 2 -> new InfoComponent().displayEquipment(curr);
      default-> new StringBuilder();
    };
  }
}