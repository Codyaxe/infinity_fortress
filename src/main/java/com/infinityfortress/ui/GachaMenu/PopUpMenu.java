package com.infinityfortress.ui.GachaMenu;

import com.infinityfortress.items.equipments.Equipment;
import com.infinityfortress.utils.ArtManager;
import com.infinityfortress.utils.Utils;

public class PopUpMenu {
  private final Equipment equipment;
  private final int x=15;
  private final int y=5;

  public PopUpMenu(Equipment equipment) {
    this.equipment = equipment;
  }

  public void equipmentPopUp() {
    StringBuilder frame = new StringBuilder();
    int startX = this.x-1, startY = this.y, width = 91, height = 20;
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i=0; i<height; i++) {
      frame.append("\033[").append(startY+1+i).append(";").append(startX).append("H│")
          .append(" ".repeat(width)).append("│");
    }
    frame.append("\033[").append(startY+height+1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
    frame.append(equipmentArt()).append(equipmentStat()).append(equipmentInfo());
    
    frame.append("\033[").append(startY+height+2).append(";").append(startX).append("H").append(
      Utils.center("Congratulations! You obtained a new item!", width)
    );
    frame.append("\033[").append(startY+height+3).append(";").append(startX).append("H").append(
      Utils.center(this.equipment.getName().toUpperCase(), width)
    );
    String continueMsg="Press Enter to Continue...";
    frame.append("\033[3m").append("\033[38;5;244m")
    .append("\033[").append(startY+height+4).append(";").append(startX+2).append("H")
    .append(Utils.rightAlign(continueMsg, width));
    
    frame.append("\033[0m");
    System.out.print(frame.toString());
    // return frame;
  }
  
  private StringBuilder equipmentArt() {
    StringBuilder frame = new StringBuilder();
    int startX = this.x+1, startY = this.y+1, width = 45, height = 18;
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    String[] art = ArtManager.getArtByNameAndType(equipment.getImageType(), equipment.getType(),width, height);
    for (int i=0; i<height; i++) {
      frame.append("\033[").append(startY+1+i).append(";").append(startX).append("H│")
          .append(art[i]).append("│");
    }
    frame.append("\033[").append(startY+height+1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
    return frame;
  }
  
  private StringBuilder equipmentInfo() {
    StringBuilder frame = new StringBuilder();
    int startX = this.x+1+45+2+1, startY = this.y+9, width = 40-1, height = 10;
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i=0; i<height; i++) {
      frame.append("\033[").append(startY+1+i).append(";").append(startX).append("H│")
          .append(" ".repeat(width)).append("│");
    }
    frame.append("\033[").append(startY+height+1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");

    

    // Description
    frame.append("\033[").append(startY+1).append(";").append(startX+2).append("H")
    .append(Utils.leftAlign("Description: ", width-2));
    int idx=startY+2;
    for (String i: Utils.createTextGrid(4, width-2,this.equipment.getDescription())) {
      frame.append("\033[").append(idx++).append(";").append(startX+2).append("H").append(Utils.leftAlign(i, width-4));
    }
    
    // Flavor Text
    frame.append("\033[3m").append("\033[38;5;244m");
    String[] textGrid = java.util.Arrays.stream(Utils.createTextGrid(4, width-2, this.equipment.getFlavorText()))
    .filter(line -> !line.equals(" "))
    .toArray(String[]::new);
    for (int i = 0; i < textGrid.length; i++) {
      frame.append("\033[").append(startY+height - i).append(";").append(startX+2).append("H").append(Utils.leftAlign(textGrid[textGrid.length - 1 - i], width-4));
    }
    if (textGrid.length == 0)
      frame.append("\033[").append(startY+height).append(";").append(startX+2).append("H").append(Utils.leftAlign("Flavor Text Missing", width-4));

    frame.append("\033[0m");
    

    return frame;
  }
  
  private StringBuilder equipmentStat() {
    StringBuilder frame = new StringBuilder();
    int startX = this.x+1+45+2+1, startY = this.y+1, width = 40-1, height = 6;
    frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
    for (int i=0; i<height; i++) {
      frame.append("\033[").append(startY+1+i).append(";").append(startX).append("H│")
          .append(" ".repeat(width)).append("│");
    }
    frame.append("\033[").append(startY+height+1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
    int statWidth = (width - 2)/3 - 4;
    int space=5;
    frame.append("\033[").append(startY + 1).append(";").append(startX+2).append("H").append("ITEM STATS");
    frame.append("\033[").append(startY + 2).append(";").append(startX+2).append("H")
      .append(Utils.spaceBetween("HP:" , ""+ this.equipment.getHealth(), statWidth)).append(" ".repeat(space))
      .append(Utils.spaceBetween("DEF:" , ""+ this.equipment.getDefense(), statWidth)).append(" ".repeat(space))
      .append(Utils.spaceBetween("CC:" , ""+ this.equipment.getCritChance(), statWidth));

    frame.append("\033[").append(startY + 4).append(";").append(startX+2).append("H")
      .append(Utils.spaceBetween("MP:" , ""+ this.equipment.getMana(), statWidth)).append(" ".repeat(space))
      .append(Utils.spaceBetween("SPD:" , ""+ this.equipment.getSpeed(), statWidth)).append(" ".repeat(space))
      .append(Utils.spaceBetween("CD:" , ""+ this.equipment.getCritStrength(), statWidth));

    frame.append("\033[").append(startY + 6).append(";").append(startX+2).append("H")
      .append(Utils.spaceBetween("STR:" , ""+ this.equipment.getStrength(), statWidth)).append(" ".repeat(space))
      .append(Utils.spaceBetween("LCK:" , ""+ this.equipment.getLuck(), statWidth)).append(" ".repeat(space));
    return frame;

  }

  public void displayCharacterPopUp(Equipment equipment) {
    
  }
}


// 1-33
// 1-119




// Warrior Weapons
// Rustbite Longsword — Longsword
// Bonecrush Warspike — Polearm
// Forgeborn Broadsword — Broadsword
// Knight's Sabre — Sabre
// Bloodforge Waraxe — War Axe
// Sentinel's Halberd — Halberd
// Kingsguard Bastionblade — Sword
// Dragospire Earthgnasher — Warhammer 
// Lionheart Claymore — Claymore
// Essenclystic Skullsplitter — Warhammer
// Asc Wyngarde Blade — Sword

// Ranger Weapons
// Thornstrike Bow — Bow
// Windwhisper Slingshot — Slingshot
// Emberroot Shortbow — Shortbow
// Moonveil Longbow — Longbow
// Stormpiercer Composite — Composite Bow
// Falcon’s Pride — Bow
// Sunflare Harbinger — Bow
// Aetherstring Vanguard — Bow
// Soulpiercer Arbalest — Arbalest
// Bloodmoon Reaver — Bow
// Asc Avarin Pinaka — Bow

// Mage Weapons
// Ashenwood Wand — Wand
// Glimmerroot Staff — Staff
// Frostpetal Wand — Wand
// Solaris Channeler — Focus / Channeler
// Runebound Staff — Staff
// Echoheart Focus — Focus
// Starcaller’s Beacon — Focus / Catalyst
// Oblivion Scepter — Scepter
// Luminous Spire — Staff
// Chaosveil Catalyst — Catalyst
// Eternium Soulspire — Staff
// Asc Magus Aeon Prism — Focus

// Tank Weapons
// Ironclad Shield — Shield
// Warbreaker Hammer — Warhammer
// Bastion Gauntlets — Gauntlets
// Vanguard’s Bulwark — Shield
// Oathforged Shield — Shield
// Stormhammer Gauntlets — Gauntlets
// Earthshatter Warhammer — Warhammer
// Sanctumbreaker Gauntlets — Gauntlets
// Heavensunder Maul — Maul
// Seraphic Bulwark — Shield
// Aegis of the Titans — Shield
// Asc Tarkoitusvoima Pavise — Pavise

// Rogue Weapons
// Rustfang Dagger — Dagger
// Shadowbite Claws — Claw
// Twinsteel Shivs — Dagger
// Venomlash Daggers — Dagger
// Bloodtrace Chakrams — Chakrams
// Whisperfang Blades — Dual Blades
// Nightreaver Claws — Claws
// Eclipsing Chakrams — Chakrams
// Dreadveil Knives — Knives
// Gloombite Talons — Talons
// Veilpiercer Chakrams — Chakrams
// Asc Rhaen Kris — Kris

// Healer Weapons
// Sanctum Icon — Icon 
// Lifebloom Medallion — Medallion
// Celestine Globe — Orb
// Verdant Crucible — Crucible
// Moonlit Talisman — Talisman
// Aurora Sphere — Orb
// Evergloam Sigil — Sigil
// Radiant Pendant — Pendant
// Ethereon Sanctifier — Relic
// Soulweaver Aegis — Aegis
// Luminal Nexus — Holy Artifact
// Asc Halien Rod — Rod

// Summoner Weapons
// Glimmering Totem — Totem
// Whispering Codex — Spellbook
// Starwoven Grimoire — Spellbook
// Arcsain Idol — Idol
// Totem of the Dawn — Totem
// Shadowbind Tome — Spellbook
// Soulforge Lexicon — Spellbook
// Effigy of the Damned — Effigy
// Asc Sangre Heart — Relic

// Cleric Weapons
// Sanctum Mace — Mace
// Dawnspire Censer — Censer
// Radiant Scepter — Scepter
// Luminal Rod — Rod
// Halobrand Mace — Mace
// Lumenic Aegis — Aegis
// Auric Medallion — Medallion
// Blessed Crucible — Crucible
// Solstice Warrod — Rod
// Aetherium Gavel — Gavel
// Divine Phylactery — Relic
// Aurealium Luminar — Relic
// Celestivigil Seraphim — Relic
// Asc Caelora Censer — Censer

// Warlock Weapons
// Ashen Cursed Scroll — Scroll
// Shadowbound Cursed Scroll — Scroll
// Withered Cursed Scroll — Scroll
// Nightfall Codex — Spellbook
// Phantom Codex — Spellbook
// Obsivious Codex — Spellbook
// Ebonflare Staff — Staff
// Soulrender Staff — Staff
// Doombringer Sigil — Relic
// Asc Wrynnor Tome — Spellbook