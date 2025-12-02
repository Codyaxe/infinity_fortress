package com.infinityfortress.gachaSystem;

import com.infinityfortress.Player;
import com.infinityfortress.ui.GachaMenu.MainGachaUI;
import com.infinityfortress.utils.InputHandler;

import com.infinityfortress.utils.Animate;

public class MainGachaSystem {
  Player player;
  int currentBannerIndex = 0;
  MainGachaUI gachaUI;

  public MainGachaSystem(Player player) {
    this.player = player;
    this.gachaUI = new MainGachaUI(player.gems);
    // Animate.gachaIdle("art-idle")
  }

  public void start() {
    
    while (true) {
      Boolean isPullingFinished = false;
      gachaUI.display();
      while (!isPullingFinished) {
        gachaUI.displayBanner(currentBannerIndex);
        InputHandler.waitForInput();
        if (InputHandler.left.get()) {
          currentBannerIndex = Math.max(0, currentBannerIndex-1);
          InputHandler.left.set(false);
        }
        if (InputHandler.right.get()) {
          currentBannerIndex = Math.min(3, currentBannerIndex+1);
          InputHandler.right.set(false);
        }
        if (InputHandler.enter.get()) {
          isPullingFinished = startPulling();
          InputHandler.enter.set(false);
        }
      }
    }
  }

  private Boolean startPulling() {
    int choice = 0;
    
    while(true) {
        gachaUI.displayPullOptions(choice);
        InputHandler.waitForInput();
        
        if (InputHandler.left.get()) {
            choice = 0;
            InputHandler.left.set(false);
          }
        if (InputHandler.right.get()) {
            choice = 1;
            InputHandler.right.set(false);
        }
        if (InputHandler.enter.get()) {
            gachaUI.displayPullingUI();
            PullingSystem pullingSystem = new PullingSystem(this.player);
            if (currentBannerIndex==0) {
              pullingSystem.pullCharacter(Math.max(1,choice*10));// One or Ten Pull
            } else {
              pullingSystem.pullEquipment(Math.max(1,choice*10), currentBannerIndex);
            }
            InputHandler.enter.set(false);
            return true;
        }
        if (InputHandler.back.get()) {
            InputHandler.back.set(false);
            return false;
        }
      }
  }
}