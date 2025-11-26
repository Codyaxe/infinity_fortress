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
        if (processItems(mainBattleUI, player.inventory.get(curr), current)) {
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

      }
    }

    ValidatingVisitor itemVisitor = new ValidatingVisitor();

    item.accept(itemVisitor);
    return itemVisitor.getIsValid();

  }
}
