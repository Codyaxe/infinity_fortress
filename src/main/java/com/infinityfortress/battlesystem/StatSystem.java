package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.StatsMenu.MainStatMenu;
import com.infinityfortress.utils.InputHandler;

public class StatSystem {
    private final Player player;

    public StatSystem(Player player) {
        this.player = player;
    }

    public void start(NCharacter currentCharacter) {
        ArrayList<NCharacter> characterList = player.characters.stream().filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));

        MainStatMenu menu = new MainStatMenu(characterList, characterList.indexOf(currentCharacter), 0);
        menu.updateCharacter();
        while (true) {
            InputHandler.waitForInput();
            if (InputHandler.left.get()) {
                menu.leftCharacter();
                InputHandler.left.set(false);
                menu.updateCharacter();
            }
            if (InputHandler.right.get()) {
                menu.rightCharacter();
                InputHandler.right.set(false);
                menu.updateCharacter();
            }
            if (InputHandler.up.get()) {
                menu.upChoice();
                InputHandler.up.set(false);
                menu.updateInfo();
            }
            if (InputHandler.down.get()) {
                menu.downChoice();
                InputHandler.down.set(false);
                menu.updateInfo();
            }
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                return;
            }
        }
    }
}
