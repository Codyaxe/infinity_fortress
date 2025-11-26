package com.infinityfortress.battlesystem;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.Enemy;
import com.infinityfortress.Player;
import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.ui.BattleMenu.ActionComponent;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.Printbox;

/* Changed the code so it follows a Strategy Pattern */

public class DecisionSystem {
    private final Player player;
    private final Enemy enemy;

    public DecisionSystem(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean start(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        MainBattleUI mainBattleUI = new MainBattleUI(battleUI, new ActionComponent());

        TargetingType targetType = selectedAction.getTargetingType();

        mainBattleUI.display();
        TargetingHandler handler = getHandler(targetType);
        return handler != null ? handler.handle(mainBattleUI, curr, selectedAction) : false;
    }

    private TargetingHandler getHandler(TargetingType targetType) {
        return switch (targetType) {
            case SINGLE_ENEMY -> new SingleEnemyHandler(player, enemy);
            case SINGLE_ALLY -> new SingleAllyHandler(player, enemy);
            case ALL_ENEMIES -> new AllEnemiesHandler(player, enemy);
            case ALL_ALLIES -> new AllAlliesHandler(player, enemy);
            case SELF -> new SelfHandler();
            case NONE -> new NoneHandler();
            case RANDOM -> new RandomHandler(player, enemy);
            case CHOOSE_SUBACTION -> new ChooseSubActionHandler(player, enemy);
            default -> null;
        };
    }
}

interface TargetingHandler {
    boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction);
}

abstract class TargetingHandlerBase implements TargetingHandler {
    protected final Player player;
    protected final Enemy enemy;

    public TargetingHandlerBase(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    protected boolean processMP(NCharacter curr, Action selectedAction, MainBattleUI battleUI) {
        int currentMana = curr.getMana() - selectedAction.getManaCost();
        if (currentMana < 0) {
            Printbox.showMessage(battleUI, "You do not have enough mana!");
            return false;
        }
        curr.setMana(currentMana);
        return true;
    }

    protected ArrayList<NCharacter> getAliveEnemies(NCharacter curr) {
        if (curr.getType() == NCharacterType.ALLY) {
            return enemy.getCharacters().stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return player.getCharacters().stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    protected ArrayList<NCharacter> getAliveAllies(NCharacter curr) {
        if (curr.getType() == NCharacterType.ALLY) {
            return player.getCharacters().stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        } else {
            return enemy.getCharacters().stream()
                    .filter(c -> c != null && !c.isDead())
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }
}

class SingleEnemyHandler extends TargetingHandlerBase {

    public SingleEnemyHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> enemies = getAliveEnemies(curr);
        if (enemies.isEmpty()) {
            Printbox.showMessage(battleUI, "No valid enemy targets available!");
            return false;
        }
        TargetingSystem targetingSystem = new TargetingSystem(selectedAction, curr);
        NCharacter target = targetingSystem.start(battleUI, enemies);
        if (target != null && processMP(curr, selectedAction, battleUI)) {
            selectedAction.execute(curr, target);
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }
}

class SingleAllyHandler extends TargetingHandlerBase {

    public SingleAllyHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> allies = getAliveAllies(curr);
        if (allies.isEmpty()) {
            Printbox.showMessage(battleUI, "No valid ally targets available!");
            return false;
        }
        TargetingSystem targetingSystem = new TargetingSystem(selectedAction, curr);
        NCharacter target = targetingSystem.start(battleUI, allies);
        if (target != null && processMP(curr, selectedAction, battleUI)) {
            selectedAction.execute(curr, target);
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }
}

class AllEnemiesHandler extends TargetingHandlerBase {

    public AllEnemiesHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> enemies = getAliveEnemies(curr);
        if (processMP(curr, selectedAction, battleUI)) {
            for (NCharacter enemy : enemies) {
                selectedAction.execute(curr, enemy);
            }
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }
}

class AllAlliesHandler extends TargetingHandlerBase {

    public AllAlliesHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> allies = getAliveAllies(curr);
        if (processMP(curr, selectedAction, battleUI)) {
            for (NCharacter ally : allies) {
                selectedAction.execute(curr, ally);
            }
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }
}

class SelfHandler implements TargetingHandler {
    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        if (processMP(curr, selectedAction, battleUI)) {
            selectedAction.execute(curr, curr);
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }

    private boolean processMP(NCharacter curr, Action selectedAction, MainBattleUI battleUI) {
        int currentMana = curr.getMana() - selectedAction.getManaCost();
        if (currentMana < 0) {
            Printbox.showMessage(battleUI, "You do not have enough mana!");
            return false;
        }
        curr.setMana(currentMana);
        return true;
    }
}

class NoneHandler implements TargetingHandler {
    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        selectedAction.execute(curr, null);
        return true;
    }
}

class RandomHandler extends TargetingHandlerBase {

    public RandomHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> possibleTargets = getAliveEnemies(curr);
        if (!possibleTargets.isEmpty() && processMP(curr, selectedAction, battleUI)) {
            int randomIndex = (int) (Math.random() * possibleTargets.size());
            selectedAction.execute(curr, possibleTargets.get(randomIndex));
            return true;
        }
        Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
        return false;
    }
}

class ChooseSubActionHandler extends TargetingHandlerBase {

    public ChooseSubActionHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        SubActionSystem subActionSystem = new SubActionSystem();
        while (true) {
            Action subAction = subActionSystem.start(battleUI, curr, selectedAction.getAllSubActions());

            if (subAction == null) {
                return false;
            }

            DecisionSystem decisionSystem = new DecisionSystem(player, enemy);
            if (decisionSystem.start(battleUI, curr, subAction)) {
                return true;
            }
        }
    }
}
