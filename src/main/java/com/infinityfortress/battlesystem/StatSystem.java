package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.StatsMenu;
import com.infinityfortress.utils.*;

public class StatSystem {
    private final Player player;

    public StatSystem(Player player) {
        this.player = player;
    }

    public void start(NCharacter currCharact) {
        int choice = 0;

        ArrayList<NCharacter> characterList = player.characters.stream().filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        int curr = characterList.indexOf(currCharact);
        StatsMenu statsMenu = new StatsMenu();
        Utils.clearConsole();
        while (true) {
            statsMenu.display(characterList.get(curr), choice, curr,
                    characterList.size());
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                curr = Math.max(0, curr - 1);
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                curr = Math.min(characterList.size() - 1, curr + 1);
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
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return;
            }
        }
    }
}
