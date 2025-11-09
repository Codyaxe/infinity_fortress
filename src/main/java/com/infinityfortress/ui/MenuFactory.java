package com.infinityfortress.ui;

public class MenuFactory {
  
    public static Menu getMenu(String menuType) {
        return switch (menuType) {
            case "MAIN" -> new MainMenu();
            case "BATTLE" -> new BattleMenu();
            case "REWARD" -> new RewardMenu();
            case "MAP" -> new MapMenu();
            case "GACHA" -> new GachaMenu();
            case "STATS" -> new StatsMenu();
            case "SETUP" -> new SetupMenu();
            default -> throw new IllegalArgumentException("Unknown menu type: " + menuType);
        };
    }
}