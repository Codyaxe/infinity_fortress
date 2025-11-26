package com.infinityfortress.battlesystem;

import com.infinityfortress.*;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.items.Visitor;
import com.infinityfortress.items.Items;
import com.infinityfortress.items.Visitable;
import com.infinityfortress.items.consumables.Consumables;
import com.infinityfortress.items.equipments.Equipment;

import java.util.ArrayList;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.utils.Printbox;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.ItemMenu.MainItemMenu;

public class ItemSystem {

  private final Player player;

  public ItemSystem(Player player) {
    this.player = player;
  }

  public void start(MainBattleUI mainBattleUI) {
    ArrayList<Items> inventory = player.inventory;
    int size = inventory.size(), scrollMin = 2, scrollMax = 12 - 3, curr = 0, currScroll = 0;
    MainItemMenu itemMenu = new MainItemMenu(inventory, 0);
    while (true) {
      itemMenu.display(curr, currScroll);
      InputHandler.waitForInput();
      if (InputHandler.left.get()) {
        InputHandler.left.set(false);
      }

      if (InputHandler.right.get()) {
        InputHandler.right.set(false);
      }

      if (InputHandler.up.get()) {
        if (curr <= scrollMin && currScroll > 0) {
          currScroll--;
        } else {
          curr = Math.max(curr - 1, 0);
        }
        InputHandler.up.set(false);
      }

      if (InputHandler.down.get()) {
        if (curr >= scrollMax && currScroll + 12 < size) {
          currScroll++;
        } else {
          curr = Math.min(curr + 1, 11);
        }
        InputHandler.down.set(false);
      }

      if (InputHandler.enter.get()) {
        // Process Item
      }

      if (InputHandler.back.get()) {
        InputHandler.back.set(false);
        return;
      }
    }
  }

  private boolean processItems(MainBattleUI mainBattleUI, Player player, Visitable item) {
    TargetingSystem targetingSystem = new TargetingSystem();
    NCharacter curr = targetingSystem.start(mainBattleUI, player.getCharacters());

    // Visitor Approach
    class ValidatingVisitor implements Visitor {
      public boolean isValid = true;

      public boolean getIsValid() {
        return isValid;
      }

      @Override
      public void visit(Equipment equipment) {
        if (equipment.getRole() != "Any" && equipment.getRole() != curr.getRole().getName()) {
          isValid = false;
          return;
        }

        switch (equipment.getType()) {
          case "Accessory":
            // UI to choose which equipment

            int choice = 1;
            if (InputHandler.enter.get()) {
              if (choice == 1) {
                curr.getEquipment().setAccessory1(equipment);
              } else if (choice == 2) {
                curr.getEquipment().setAccessory2(equipment);
              } else {
                Printbox.showMessage(mainBattleUI, "Error! Invalid Accessory choice.");
              }
            }
            break;
          case "Weapon":
            curr.getEquipment().setWeapon(equipment);
            break;
          case "Armor":
            curr.getEquipment().setArmor(equipment);
            break;
          default:
            Printbox.showMessage(mainBattleUI, "Error! No Equipment of the type is found.");
        }
      }

      @Override
      public void visit(Consumables consumable) {
        if (consumable.getRole() != "Any" && consumable.getRole() != curr.getRole().getName()) {
          isValid = false;
          return;
        }
      }
    }

    ValidatingVisitor itemVisitor = new ValidatingVisitor();

    item.accept(itemVisitor);
    return itemVisitor.getIsValid();

  }

  // private boolean isEquipment(Equipment item) {
  // return item.getType().equals("Weapon") || item.getType().equals("Armor") ||
  // item.getType().equals("Accessory");
  // }

  // private boolean isConsumables(Consumables item) {
  // return item.getType().equals("Boosters") ||
  // item.getType().equals("Debuffers")
  // || item.getType().equals("Restoratives") ||
  // item.getType().equals("Utilities");
  // }

}
