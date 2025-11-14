package com.infinityfortress.battlesystem;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.ActionComponent;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.InputHandler;

public class ActionSystem {
    private final DecisionSystem decisionSystem;
    private final SubActionSystem subActionSystem;
    
    public ActionSystem(DecisionSystem decisionSystem) {
      this.decisionSystem = decisionSystem;
      this.subActionSystem = new SubActionSystem(decisionSystem);
    }

    public boolean start(MainBattleUI battleUI, NCharacter curr) {
        MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new ActionComponent());
        // if (availableActions.isEmpty()) {
        //     System.out.println("Character has no available actions!");
        //     return false;
        // }

        int choice = 0;
        // int maxChoice = availableActions.size() - 1;
        int maxChoice = 3;
        
        // TEMP ACTIONS
        mainBattleUI.updateSelection();
        while (true) {
            mainBattleUI.updateChoice(choice);
            InputHandler.waitForInput();

            if (InputHandler.left.get()) {
                choice = Math.max(0, choice - 1);
                InputHandler.left.set(false);
                AudioHandler.playSelect();
            }
            // 27 5 111
            if (InputHandler.right.get()) {
                choice = Math.min(maxChoice, choice + 1);
                InputHandler.right.set(false);
                AudioHandler.playSelect();
            }
            if (InputHandler.back.get()) {
                InputHandler.back.set(false);
                AudioHandler.playBack();
                return false;
            }
            if (InputHandler.enter.get()) {
              switch (choice) {
                case 0 -> {

                }
                case 1 -> {
                  // System.out.println("Special Skill Selected");
                  // System.out.println("Has SubActions: " + curr.getSpecialSkillAction().hasSubActions());
                  // System.out.println("SubActions Size: " + curr.getSpecialSkillAction().getActions().size());
                  if (curr.getSpecialSkillAction().hasSubActions()) {
                    subActionSystem.start(mainBattleUI, curr, curr.getSpecialSkillAction().getActions());
                  } else {
                    return true;
                  }

                }
                case 2 -> {

                }
                case 3 -> {

                }
              }
              // if (selectedAction.size()>1){
              //   if (subActionSystem.start(mainBattleUI, curr, selectedAction)) {
              //       return true;
              //   }
              // }
              // else {
              //   if (decisionSystem.start(mainBattleUI, curr, selectedAction.get(0))) {
              //       return true;
              //   }
              // }
              mainBattleUI.updateSelection();
              InputHandler.enter.set(false);
            }
        }
    }
}
