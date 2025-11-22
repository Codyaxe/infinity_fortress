package com.infinityfortress.battlesystem;

import com.infinityfortress.*;

import com.infinityfortress.items.Items;
import java.util.ArrayList;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.ui.ItemMenu.MainItemMenu;

public class ItemSystem {

    private final Player player;

    public ItemSystem(Player player) {
        this.player = player;
    }

    public void start() {
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
                  curr=Math.max(curr-1, 0);
                }
                InputHandler.up.set(false);
            }

            if (InputHandler.down.get()) {
              if (curr >= scrollMax && currScroll + 12 < size) {
                currScroll++;
              } else {
                curr=Math.min(curr+1, 11);
              }
              InputHandler.down.set(false);
            }

            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return;
            }
        }
    }
}
