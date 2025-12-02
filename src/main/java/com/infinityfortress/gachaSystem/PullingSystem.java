package com.infinityfortress.gachaSystem;

import java.util.ArrayList;
import java.util.Random;

import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.items.equipments.Equipment;
import com.infinityfortress.pools.MainPool;
import com.infinityfortress.ui.GachaMenu.PopUpMenu;
import com.infinityfortress.utils.Animate;
import com.infinityfortress.utils.ArtManager;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.pools.CharacterPool;

public class PullingSystem {

    Player player;
    Random rand = new Random();

    public PullingSystem(Player p) {
        this.player = p;
    }

    public void pullCharacter(int pullNum) {

        ArrayList<Equipment> pulledItems = new ArrayList<>();
        ArrayList<NCharacter> pulledCharacters = new ArrayList<>();
        for (int i = 0; i < pullNum; i++) {
            float rate = rand.nextFloat();
            if (rate <= 0.14) { // Forged Equipment
                pulledItems.add(MainPool.getRandomForgedEquipment());
            } else if (rate <= 0.20) { // Enchanted Equipment
                pulledItems.add(MainPool.getRandomEnchantedEquipment());
            } else  if (rate <= 0.35) {// Specialized Character
              pulledCharacters.add(CharacterPool.getRandomSpecializedCharacters());
            } else if (rate <= 0.70) { // Non Specialized Character
              pulledCharacters.add(CharacterPool.getRandomNonSpecializedCharacters());
            }
        }

        Animate.gachaBlock("pulling", ArtManager.getFormattedPullingArt(
          "character", 45, 18
          ), 
          pulledCharacters.isEmpty()?
            pulledItems.isEmpty()?
              ArtManager.getBlankArt(45, 18):
            ArtManager.getArtByNameAndType(pulledItems.get(0).getImageType(),pulledItems.get(0).getType(), 45, 18):
          ArtManager.getArtByNameAndType(pulledCharacters.get(0).getRole().getName(), "character", 45, 18),
          38, 
          8
        );

        for (NCharacter character : pulledCharacters) {
          int choice=0;
          if (player.getCharacters().size() < 5) {
            player.getCharacters().add(character);
            continue;
          }
          while (true) {
              // Print something
              InputHandler.waitForInput();
              if (InputHandler.up.get()) {
                  choice = Math.max(0, choice - 1);
                  InputHandler.up.set(false);
              }
              if (InputHandler.down.get()) {
                  choice = Math.min(4, choice + 1);
                  InputHandler.down.set(false);
              }
              if (InputHandler.enter.get()) {
                  if (player.getCharacters().get(choice) == null) {
                      player.getCharacters().set(choice, character);
                  } else {
                      // Handle case where slot is already filled
                  }
                  InputHandler.enter.set(false);
                  break;
              }
          }
        }
    }

    public void pullEquipment(int pullNum, int bannerIndex) {// 1: Weapons 2: Armor 3: Accessories
        ArrayList<Equipment> pulledItems = new ArrayList<>();
        for (int i = 0; i < pullNum; i++) {
            float rate = rand.nextFloat();
            if (rate <= 0.441) { // Forged Equipment
              pulledItems.add(MainPool.getRandomForgedEquipment());
            } else if (rate <= 63) { // Enchanted Equipment
              pulledItems.add(MainPool.getRandomEnchantedEquipment());
            } else if (rate <= 68.6) { // Mystic Equipment
              pulledItems.add(
                switch (bannerIndex) {
                  case 0 -> MainPool.getRandomMysticWeapon();
                  case 1 -> MainPool.getRandomMysticArmor();
                  case 2 -> MainPool.getRandomMysticAccessory();
                  default -> null;
                }
              );
            } else if (rate <= 69.93) { // Ethereal Equipment
              pulledItems.add(
                switch (bannerIndex) {
                  case 0 -> MainPool.getRandomEtherealWeapon();
                  case 1 -> MainPool.getRandomEtherealArmor();
                  case 2 -> MainPool.getRandomEtherealAccessory();
                  default -> null;
                }
              );
            } else if (rate <= 70) { // Asc Equipment
              pulledItems.add(
                switch (bannerIndex) {
                  case 0 -> MainPool.getRandomAscWeapon();
                  case 1 -> MainPool.getRandomAscArmor();
                  case 2 -> MainPool.getRandomAscAccessory();
                  default -> null;
                }
              );
            }
        }
        Animate.gachaBlock("pulling", ArtManager.getFormattedPullingArt(
            switch (bannerIndex) {
              case 1 -> "weapon";
              case 2 -> "armor";
              case 3 -> "accessory";
              default -> "character";
            }, 45, 18
          ), 
          pulledItems.isEmpty()?
            ArtManager.getBlankArt(45, 18) :
            ArtManager.getArtByNameAndType(pulledItems.get(0).getImageType(),pulledItems.get(0).getType(), 45, 18),
          38, 
          8
        );
        for (Equipment item : pulledItems) {
          PopUpMenu popUpMenu = new PopUpMenu(item);
          popUpMenu.equipmentPopUp();
          InputHandler.waitForInput();
          // Tease
        }
        player.inventory.addAll(pulledItems);
    }
}