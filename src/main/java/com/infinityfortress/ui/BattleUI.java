package com.infinityfortress.ui;

public class BattleUI implements BattleUIComponent {
    private BattleTopUI top;

    public BattleUI(BattleTopUI t) {
        this.top = t;
    }

    @Override
    public BattleTopUI getBattleTopUI() {
        return this.top;
    }

    public void display(int choice) {
        int[] optionHeader = {
                30, 1, 10, 1,
                10, 1, 9, 1,
                10, 1, 10, 1, 30
        };

        String[][] optionGrid = {
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", "  ACTION  ", " ", " ", " ", "  STATS  ", " ", " ", " ", "  ITEMS   ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " },
                { " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " }
        };

        int[][] options = {
                { 1, 3 },
                { 5, 7 },
                { 9, 11 }
        };

        // Add selection indicators
        optionGrid[2][options[choice][0]] = "┌";
        optionGrid[3][options[choice][0]] = "│";
        optionGrid[4][options[choice][0]] = "└";
        optionGrid[2][options[choice][1]] = "┐";
        optionGrid[3][options[choice][1]] = "│";
        optionGrid[4][options[choice][1]] = "┘";

        System.out.print(buildFrame(optionGrid, optionHeader));
    }
}
