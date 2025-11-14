package com.infinityfortress.actions;

public class RestAction {

    public RestAction() {

    }

    public String getName() {
        return "Rest";
    }

    String getActionType() {
        return "Restorative";
    }

    String getDescription() {
        return "Recovers a small amount of health and mana but leaves the user vulnerable.";
    }

    String getBattleDescription() {
        return "takes a moment to rest. They've become vulnerable!";
    }
}
