package com.infinityfortress.utils;

import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.ui.BattleMenu.PrintComponent;

public class Printbox {
    public static void showMessage(MainBattleUI battleUI, String message) {
        MainBattleUI printUI = new MainBattleUI(battleUI, new PrintComponent(message));
        printUI.display();
        while (true) {
            InputHandler.waitForInput();
            if (InputHandler.enter.get() || InputHandler.back.get()) {
                AudioHandler.playEnter();
                break;
            }
        }
    }
}
