package com.infinityfortress.PathSystem;

import com.infinityfortress.ui.PathMenu.PathUI;
import com.infinityfortress.utils.Animate;
import com.infinityfortress.utils.InputHandler;

public class MainPathSystem {

    public int start(int a, int b) {
        int choice = -1;
        PathUI mainPathUI = new PathUI(a, b);
        boolean decisionComplete = false;

        while (!decisionComplete) {
            mainPathUI.updateChoice(choice);
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                choice = 0;
                InputHandler.left.set(false);
            }
            if (InputHandler.right.get()) {
                choice = 1;
                InputHandler.right.set(false);
            }

            // !Character setup(changing positions, equipment, etc) can only be done when in a refuge
            if (InputHandler.enter.get()) {
                Animate.flashBlock("Path-Flash",mainPathUI.getFrame(choice));
                switch (choice) {
                  case 0 -> {
                      return a;
                      // System.out.println("Taken Left");
                    }
                    case 1 -> {
                      return b;
                      // System.out.println("Taken Right");
                    }
                  }
            }
        }
        return -1;
    }
}
