package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Player;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.StatsMenu.MainStatMenu;
import com.infinityfortress.utils.InputHandler;
import com.infinityfortress.utils.AudioHandler;

public class StatSystem {
    private final Player player;

    public StatSystem(Player player) {
        this.player = player;
    }

    public void start(NCharacter currentCharacter) {
        ArrayList<NCharacter> characterList = player.characters.stream().filter(c -> c != null)
                .collect(Collectors.toCollection(ArrayList::new));
        // StatsMenu statsMenu = new StatsMenu();

        MainStatMenu menu = new MainStatMenu(characterList, characterList.indexOf(currentCharacter), 0);
        while (true) {
            // statsMenu.display(characterList.get(selected), choice, selected,
            // characterList.size());
            InputHandler.waitForInput();
            if (InputHandler.left.get()) {
                menu.leftCharacter();
                InputHandler.left.set(false);
                menu.updateCharacter();
                AudioHandler.playSelect();
            }
            if (InputHandler.right.get()) {
                menu.rightCharacter();
                InputHandler.right.set(false);
                menu.updateCharacter();
                AudioHandler.playSelect();
            }
            if (InputHandler.up.get()) {
                menu.upChoice();
                InputHandler.up.set(false);
                menu.updateInfo();
                AudioHandler.playSelect();
            }
            if (InputHandler.down.get()) {
                menu.downChoice();
                InputHandler.down.set(false);
                menu.updateInfo();
                AudioHandler.playSelect();
            }
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                AudioHandler.playBack();
                return;
            }
        }
    }
}
