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
import com.infinityfortress.utils.MutableInt;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.ItemMenu.MainItemMenu;

/* Visitor and Strategy Pattern */

public class ItemSystem {

  private final Player player;
  private final Enemy enemy;

  public ItemSystem(Player player, Enemy enemy) {
    this.player = player;
    this.enemy = enemy;
  }

  public void start(MainBattleUI mainBattleUI, NCharacter current) {
    handleItemMenu(mainBattleUI, current);
  }

  private void handleItemMenu(MainBattleUI mainBattleUI, NCharacter current) {
    ArrayList<Items> inventory = player.inventory;
    int size = inventory.size();
    int scrollMin = 2;
    int scrollMax = 9;
    MutableInt currArr = new MutableInt(0);
    MutableInt scrollArr = new MutableInt(0);
    MainItemMenu itemMenu = new MainItemMenu(inventory, 0);
    while (true) {
      itemMenu.display(currArr.value, scrollArr.value);
      InputHandler.waitForInput();
      handleNavigation(currArr, scrollArr, size, scrollMin, scrollMax);
      if (InputHandler.enter.get()) {
        if (processItems(mainBattleUI, inventory.get(scrollArr.value + currArr.value), current)) {
          removeDeletedItems(mainBattleUI, inventory);
          mainBattleUI.updateField(player.getCharacters(), enemy.getCharacters());
          return;
        }
      }
      if (InputHandler.back.get()) {
        InputHandler.back.set(false);
        return;
      }
    }
  }

  private void handleNavigation(MutableInt currArr, MutableInt scrollArr, int size, int scrollMin, int scrollMax) {
    if (InputHandler.left.get()) {
      InputHandler.left.set(false);
    }
    if (InputHandler.right.get()) {
      InputHandler.right.set(false);
    }
    if (InputHandler.up.get()) {
      if (currArr.value <= scrollMin && scrollArr.value > 0) {
        scrollArr.value--;
      } else {
        currArr.value = Math.max(currArr.value - 1, 0);
      }
      InputHandler.up.set(false);
    }
    if (InputHandler.down.get()) {
      if (currArr.value >= scrollMax && scrollArr.value + 12 < size) {
        scrollArr.value++;
      } else {
        currArr.value = Math.min(currArr.value + 1, 11);
      }
      InputHandler.down.set(false);
    }
  }

  private void removeDeletedItems(MainBattleUI mainBattleUI, ArrayList<Items> inventory) {
    inventory.removeIf(item -> isItemDeleted(mainBattleUI, item));
  }

  private boolean processItems(MainBattleUI mainBattleUI, Visitable item, NCharacter current) {
    ItemProcessingVisitor visitor = new ItemProcessingVisitor(mainBattleUI, current, player, enemy);
    item.accept(visitor);
    return visitor.getIsValid();
  }

  private boolean isItemDeleted(MainBattleUI mainBattleUI, Visitable item) {
    // Racoon deez nuts
    ItemDeletionVisitor racoon = new ItemDeletionVisitor();
    item.accept(racoon);
    return racoon.getIsDeleted();
  }
}

class ItemProcessingVisitor implements Visitor {
  private final MainBattleUI mainBattleUI;
  private final NCharacter current;
  private final Player player;
  private final Enemy enemy;
  private boolean isValid = true;

  public ItemProcessingVisitor(MainBattleUI mainBattleUI, NCharacter current, Player player, Enemy enemy) {
    this.mainBattleUI = mainBattleUI;
    this.current = current;
    this.player = player;
    this.enemy = enemy;
  }

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
    NCharacter target = targetingSystem.start(mainBattleUI, player.getCharacters());
    if (target != null) {
      processEquipment(equipment, target);
    }
  }

  @Override
  public void visit(Consumables cons) {
    TargetingSystem targetingSystem = new TargetingSystem(null, current);
    NCharacter target = null;

    switch (cons.getType()) {
      case "Booster":
        target = targetingSystem.start(mainBattleUI, player.getCharacters());
        if (target != null) {
          processStatusBasedConsumables(cons, target);
        }
        break;
      case "Debuffer":
        target = targetingSystem.start(mainBattleUI, enemy.getCharacters());
        if (target != null) {
          processStatusBasedConsumables(cons, target);
        }
        break;
      case "Restorative":
        target = targetingSystem.start(mainBattleUI, player.getCharacters());
        if (target != null) {
          processRestorativeConsumables(cons, target);
        }
        break;
      case "Utility":
        // logic
        break;
      default:
        Printbox.showMessage(mainBattleUI, "Error! What type of consumable is this?");
        break;
    }
  }

  private void processEquipment(Equipment equipment, NCharacter target) {
    if (equipment.getRole() != "Any" && equipment.getRole() != target.getRole().getName()) {
      isValid = false;
      return;
    }

    switch (equipment.getType()) {
      case "Accessory":
        // Equip to first available slot, proper selector will be implemented later
        if (!target.getEquipment().getAccessory1().getisUsed()) {
          target.getEquipment().setAccessory1(equipment);
          target.updateStatFromEquipment(equipment);
          equipment.setIsUsed(true);
        } else if (!target.getEquipment().getAccessory2().getisUsed()) {
          target.getEquipment().setAccessory2(equipment);
          target.updateStatFromEquipment(equipment);
          equipment.setIsUsed(true);
        } else {
          target.getEquipment().getAccessory1().setIsUsed(false);
          target.removeStatsFromEquipment(target.getEquipment().getAccessory1());
          target.getEquipment().setAccessory1(equipment);
          target.updateStatFromEquipment(equipment);
          equipment.setIsUsed(true);
        }
        break;
      case "Weapon":
        if (target.getEquipment().getWeapon() != null && target.getEquipment().getWeapon().getisUsed()) {
          target.getEquipment().getWeapon().setIsUsed(false);
          target.removeStatsFromEquipment(target.getEquipment().getWeapon());
        }
        target.getEquipment().setWeapon(equipment);
        target.updateStatFromEquipment(equipment);
        equipment.setIsUsed(true);
        break;
      case "Armor":
        if (target.getEquipment().getArmor() != null && target.getEquipment().getArmor().getisUsed()) {
          target.getEquipment().getArmor().setIsUsed(false);
          target.removeStatsFromEquipment(target.getEquipment().getArmor());
        }
        target.getEquipment().setArmor(equipment);
        target.updateStatFromEquipment(equipment);
        equipment.setIsUsed(true);
        break;
      default:
        Printbox.showMessage(mainBattleUI, "Error! No Equipment of that type is found.");
    }
  }

  private void processStatusBasedConsumables(Consumables cons, NCharacter target) {
    if (cons.getRole() != "Any" && cons.getRole() != target.getRole().getName()) {
      isValid = false;
      return;
    }

    FactoryEffect effect = new FactoryEffect(cons.getName(), cons.getDuration(), target, cons.getHealth(),
        cons.getMana(), cons.getDefense(),
        cons.getStrength(), cons.getCritChance(), cons.getCritStrength(), cons.getLuck(), cons.getSpeed(),
        TemporaryEffectType.BUFF);

    target.addTemporaryEffect(effect);
    effect.apply();
    cons.setIsConsumed(true);
  }

  private void processRestorativeConsumables(Consumables cons, NCharacter target) {
    if (cons.getRole() != "Any" && cons.getRole() != target.getRole().getName()) {
      isValid = false;
      return;
    }

    // Restore health and mana
    int healthRestore = cons.getHealth();
    int manaRestore = cons.getMana();
    target.setHealth(Math.min(target.getHealth() + healthRestore, target.getMaxHealth()));
    target.setMana(Math.min(target.getMana() + manaRestore, target.getMaxMana()));
    cons.setIsConsumed(true);
  }
}

class ItemDeletionVisitor implements Visitor {
  private boolean isDeleted = false;

  public boolean getIsDeleted() {
    return isDeleted;
  }

  @Override
  public void visit(Equipment equipment) {
    // Logic for removed equipment if needed
  }

  @Override
  public void visit(Consumables cons) {
    if (cons.getIsConsumed()) {
      isDeleted = true;
    }
  }
}
