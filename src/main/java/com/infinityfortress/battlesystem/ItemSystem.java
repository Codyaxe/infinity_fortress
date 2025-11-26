package com.infinityfortress.battlesystem;

import com.infinityfortress.*;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.temporaryeffect.FactoryEffect;
import com.infinityfortress.effects.temporaryeffect.TemporaryEffectType;
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
  private final Enemy enemy;

  public ItemSystem(Player player, Enemy enemy) {
    this.player = player;
    this.enemy = enemy;
  }

  public void start(MainBattleUI mainBattleUI, NCharacter current) {
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
        if (processItems(mainBattleUI, inventory.get(curr), current)) {
          for (Items item : inventory) {
            if (isItemDeleted(mainBattleUI, item)) {
              inventory.remove(item);
            }
          }
          return;
        }
      }

      if (InputHandler.back.get()) {
        InputHandler.back.set(false);
        return;
      }
    }
  }

  private boolean processItems(MainBattleUI mainBattleUI, Visitable item, NCharacter current) {

    // Visitor Approach
    class ValidatingVisitor implements Visitor {
      public boolean isValid = true;

      public boolean getIsValid() {
        return isValid;
      }

      @Override
      public void visit(Equipment equipment) {
        if (equipment.getisUsed()) {
          Printbox.showMessage(mainBattleUI, "Equipment is already in use!");
          return;
        }
        TargetingSystem targetingSystem = new TargetingSystem(null, current);
        NCharacter curr = targetingSystem.start(mainBattleUI, player.getCharacters());
        if (curr != null) {
          processEquipment(equipment, curr);
        }
      }

      @Override
      public void visit(Consumables cons) {
        TargetingSystem targetingSystem = new TargetingSystem(null, current);
        NCharacter curr;

        switch (cons.getType()) {

          case "Booster":
            curr = targetingSystem.start(mainBattleUI, player.getCharacters());
            if (curr != null) {
              proccessConsumables(cons, curr);
            }
            break;
          case "Debuffer":
            curr = targetingSystem.start(mainBattleUI, enemy.getCharacters());
            if (curr != null) {
              proccessConsumables(cons, curr);
            }
            break;
          case "Restorative":
            // logic
            break;
          case "Utility":
            // logic
            break;
          default:
            Printbox.showMessage(mainBattleUI, "Error! What type of consumable is this?");
            break;
        }
      }

      private void processEquipment(Equipment equipment, NCharacter curr) {
        if (equipment.getRole() != "Any" && equipment.getRole() != curr.getRole().getName()) {
          isValid = false;
          return;
        }

        // Replace Logic
        switch (equipment.getType()) {
          case "Accessory":
            // UI to choose which equipment accessory

            int choice = 1;
            if (InputHandler.enter.get()) {
              if (choice == 1) {
                if (curr.getEquipment().getAccessory1().getisUsed()) {
                  curr.getEquipment().getAccessory1().setIsUsed(false);
                }
                curr.getEquipment().setAccessory1(equipment);
                equipment.setIsUsed(true);
              } else if (choice == 2) {
                if (curr.getEquipment().getAccessory2().getisUsed()) {
                  curr.getEquipment().getAccessory2().setIsUsed(false);
                }
                curr.getEquipment().setAccessory2(equipment);
                equipment.setIsUsed(true);
              } else {
                Printbox.showMessage(mainBattleUI, "Error! Invalid Accessory choice.");
              }
            }

            break;
          case "Weapon":
            if (curr.getEquipment().getWeapon().getisUsed()) {
              curr.getEquipment().getWeapon().setIsUsed(false);
            }
            curr.getEquipment().setWeapon(equipment);
            equipment.setIsUsed(true);
            break;
          case "Armor":
            if (curr.getEquipment().getArmor().getisUsed()) {
              curr.getEquipment().getArmor().setIsUsed(false);
            }
            curr.getEquipment().setArmor(equipment);
            equipment.setIsUsed(true);
            break;
          default:
            Printbox.showMessage(mainBattleUI, "Error! No Equipment of that type is found.");
        }
      }

      private void proccessConsumables(Consumables cons, NCharacter curr) {
        if (cons.getRole() != "Any" && cons.getRole() != curr.getRole().getName()) {
          isValid = false;
          return;
        }

        FactoryEffect effect = new FactoryEffect(cons.getName(), cons.getDuration(), curr, cons.getHealth(),
            cons.getMana(), cons.getDefense(),
            cons.getStrength(), cons.getCritChance(), cons.getCritStrength(), cons.getLuck(), cons.getSpeed(),
            TemporaryEffectType.BUFF);

        curr.addTemporaryEffect(effect);
        effect.apply();
        cons.setIsConsumed(true);

      }
    }

    // Restorative

    // Utility

    ValidatingVisitor itemVisitor = new ValidatingVisitor();

    item.accept(itemVisitor);
    return itemVisitor.getIsValid();

  }

  private boolean isItemDeleted(MainBattleUI mainBattleUI, Visitable item) {

    class GarbageCheckerVisitor implements Visitor {
      private boolean isDeleted = false;

      public boolean getIsDeleted() {
        return isDeleted;
      }

      @Override
      public void visit(Equipment equipment) {
        // Logic for removed equipment
      }

      @Override
      public void visit(Consumables cons) {
        if (cons.getIsConsumed()) {
          isDeleted = true;
        }
      }

    }

    // Cute name :>
    GarbageCheckerVisitor racoon = new GarbageCheckerVisitor();
    item.accept(racoon);
    return racoon.getIsDeleted();
  }
}
