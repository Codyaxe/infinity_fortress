package com.infinityfortress.ui.OldMenu;

import java.util.List;

import com.infinityfortress.actions.Action;

public class ActionUI implements BattleUIComponent {
    private final BattleFieldUI top;

    public ActionUI(BattleFieldUI top) {
        this.top = top;
    }

    @Override
    public BattleFieldUI getBattleFieldUI() {
        return this.top;
    }

    public void display(List<Action> availableActions, int choice) {
        int[] optionHeader = {
                21, 1, 2, 6, 2, 1,
                9, 1, 2, 7, 2, 1,
                9, 1, 2, 5, 2, 1,
                9, 1, 2, 4, 2, 1, 21
        };

        String[][] optionGrid = {
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " },
                { " ", " ", " ", "ATTACK", " ", " ", " ", " ", " ", "SPECIAL", " ", " ", " ", " ", " ",
                        "BLOCK", " ",
                        " ", " ", " ", " ", "REST", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
                        " ", " ", " ",
                        " ", " ", " ", " ", " " }, };

        int[][] options = {
                { 1, 5 },
                { 7, 11 },
                { 13, 17 },
                { 19, 23 }
        };

        // Selection indicators
        optionGrid[2][options[choice][0]] = "┌";
        optionGrid[3][options[choice][0]] = "│";
        optionGrid[4][options[choice][0]] = "└";
        optionGrid[2][options[choice][1]] = "┐";
        optionGrid[3][options[choice][1]] = "│";
        optionGrid[4][options[choice][1]] = "┘";

        System.out.print(buildFrame(optionGrid, optionHeader));
    }
}
