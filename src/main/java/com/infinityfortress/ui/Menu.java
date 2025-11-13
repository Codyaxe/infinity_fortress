package com.infinityfortress.ui;

import java.util.*;
import com.infinityfortress.characters.*;;

public interface Menu {

    void display();

    default void display(ArrayList<NCharacter> player, ArrayList<NCharacter> enemy, ArrayList<String> turnOrder,
            int choice) {
    }

    default void display(String role, int choice) {
    }

    default void display(int choice) {
    }
}

class MainMenu implements Menu {

    @Override
    public void display() {
        System.out.print("Main Menu");
        // code
    }
}

// 120 characters wide 117 usable
// 30 characters tall 26 usable
// ┌ ─ ┐ │ └ ┘ ├ ┤ ┬ ┴ ┼

class ItemsMenu implements Menu {

    public void display() {
        // code
    }
}

class MapMenu implements Menu {

    public void display() {
        // code
    }
}

class RewardMenu implements Menu {

    public void display() {
        // code
    }
}

class GachaMenu implements Menu {

    public void display() {
    }
}
