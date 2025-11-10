package com.infinityfortress.battlesystem;

import com.infinityfortress.ui.*;
import com.infinityfortress.utils.*;

public class StatSystem {
    public void start() {
        int pick, pPrev, choice, cPrev;
        pick = pPrev = choice = cPrev = 0;

        Menu statsMenu = MenuFactory.getMenu("STATS");

        // Preview only
        String[] roles = {
                "Mage",
                "Warlock",
                "Cleric",
                "Summoner",
                "Rogue",
                "Archer",
                "Healer",
                "Tank",
                "Warrior"
        };

        statsMenu.display(roles[pick], choice);

        while (true) {
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                pick = Math.max(0, pick - 1);
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                pick = Math.min(8, pick + 1);
                InputHandler.right.set(false);
            }
            if (InputHandler.up.get()) {
                choice = Math.max(0, choice - 1);
                InputHandler.up.set(false);
            }
            if (InputHandler.down.get()) {
                choice = Math.min(2, choice + 1);
                InputHandler.down.set(false);
            }

            // Only repaint if choice actually changed
            if (choice != cPrev || pick != pPrev) {
                cPrev = choice;
                pPrev = pick;
                statsMenu.display(roles[pick], choice);
            }
        }
    }
}
