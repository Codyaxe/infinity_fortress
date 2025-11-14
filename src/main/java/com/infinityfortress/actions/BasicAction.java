package com.infinityfortress.actions;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

public class BasicAction implements MainAction {

    private static final Map<String, String[][]> ACTIONS = new HashMap<>();
    
    static {
        // Damage actions - [name, description] pairs
        ACTIONS.put("Damage", new String[][]{
            {"Slash", "A quick slashing attack."},
            {"Strike", "A simple physical strike."},
            {"Punch", "A powerful punch."},
            {"Kick", "A swift kick."},
            {"Stab", "A precise stabbing motion."},
            {"Thrust", "A focused thrust."},
            {"Jab", "A quick jab."},
            {"Swipe", "A wide sweeping attack."},
            {"Chop", "A chopping motion."},
            {"Cleave", "A heavy cleaving blow."},
            {"Smash", "A devastating smash."},
            {"Crush", "A crushing attack."},
            {"Pound", "A pounding strike."},
            {"Bash", "A bashing blow."},
            {"Hammer", "A hammer-like strike."},
            {"Whack", "A solid whack."}
        });
        
        // Heal actions - [name, description] pairs
        ACTIONS.put("Heal", new String[][]{
            {"Heal", "Restores a small amount of health."},
            {"Mend", "Mends minor wounds."},
            {"Restore", "Restores vitality."},
            {"Cure", "Cures ailments."},
            {"Bandage", "Quick battlefield first aid."},
            {"Recover", "Natural recovery."},
            {"Rejuvenate", "Rejuvenates the body."},
            {"Revitalize", "Revitalizes energy."}
        });
        
        // Defense actions - [name, description] pairs
        ACTIONS.put("Defense", new String[][]{
            {"Block", "A defensive maneuver."},
            {"Guard", "Protective stance."},
            {"Parry", "Deflects incoming attacks."},
            {"Dodge", "Quick evasive movement."},
            {"Shield", "Raises shield defense."},
            {"Deflect", "Deflects attacks away."},
            {"Counter", "Counters enemy attacks."},
            {"Evade", "Evades incoming damage."}
        });
        
        // Buff actions - [name, description] pairs
        ACTIONS.put("Buff", new String[][]{
            {"Focus", "Increases concentration."},
            {"Concentrate", "Enhances focus."},
            {"Strengthen", "Strengthens abilities."},
            {"Energize", "Energizes the body."},
            {"Inspire", "Inspires confidence."},
            {"Rally", "Rallies spirit."},
            {"Motivate", "Motivates for battle."},
            {"Empower", "Empowers abilities."}
        });
    }

    private String name;
    private String description;
    private int hitCount;
    private int manaCost;
    private int baseDamage;
    private String actionType;
    private TargetingType targetingType;
    private boolean hasSubaction = false;

    // Random constructor
    public BasicAction() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        
        // Pick a random action type
        String[] actionTypes = ACTIONS.keySet().toArray(new String[0]);
        String selectedType = actionTypes[rnd.nextInt(actionTypes.length)];
        
        // Get actions for the selected type
        String[][] actions = ACTIONS.get(selectedType);
        int index = rnd.nextInt(actions.length);
        
        this.name = actions[index][0]; // First element is name
        this.description = actions[index][1]; // Second element is description
        this.hitCount = 1;
        this.manaCost = rnd.nextInt(0, 3); // 0-2 mana for basic actions
        this.baseDamage = rnd.nextInt(3, 8); // 3-7 damage
        this.actionType = selectedType;
        
        // Set targeting based on action type
        switch (selectedType) {
            case "Heal":
            case "Buff":
                this.targetingType = TargetingType.SELF;
                break;
            case "Defense":
                this.targetingType = rnd.nextBoolean() ? TargetingType.SELF : TargetingType.SINGLE_ENEMY;
                break;
            default: // Damage
                this.targetingType = TargetingType.SINGLE_ENEMY;
                break;
        }
    }

    // Custom constructor
    public BasicAction(String name, String description, int manaCost, int baseDamage, String actionType, TargetingType targetingType) {
        this.name = name;
        this.description = description;
        this.hitCount = 1;
        this.manaCost = manaCost;
        this.baseDamage = baseDamage;
        this.actionType = actionType;
        this.targetingType = targetingType;
    }

    @Override
    public boolean hasSubActions() {
        return hasSubaction;
    }

    @Override
    public ArrayList<Action> getActions() {
        return new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getHitCount() {
        return hitCount;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public String getActionType() {
        return actionType;
    }

    @Override
    public TargetingType getTargetingType() {
        return targetingType;
    }

    @Override
    public void execute(NCharacter user, NCharacter target) {
        // Basic action execution logic
        System.out.println(user.getName() + " uses " + name + " on " + target.getName());
    }
}
