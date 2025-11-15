package com.infinityfortress.actions;

import java.util.ArrayList;
import java.util.Random;

import com.infinityfortress.characters.NCharacter;

/**
 * Generates random actions with randomized attributes
 */
public class RandomActionGenerator {
    static final Random random = new Random();

    // Action name pools by category
    static final String[][] ACTION_NAMES = {
            // Damage actions
            { "Strike", "Slash", "Crush", "Devastate", "Annihilate", "Pummel", "Cleave", "Smash" },
            // Heal actions
            { "Heal", "Restore", "Mend", "Cure", "Revive", "Rejuvenate", "Recover", "Regenerate" },
            // Buff actions
            { "Strengthen", "Haste", "Bless", "Fortify", "Empower", "Inspire", "Rally", "Enhance" },
            // Debuff actions
            { "Weaken", "Slow", "Curse", "Poison", "Blind", "Confuse", "Fear", "Silence" },
            // Summon actions
            { "Summon Wolf", "Call Bear", "Raise Skeleton", "Invoke Spirit", "Conjure Elemental", "Create Golem" },
            // Other actions
            { "Block", "Guard", "Focus", "Rest", "Steal", "Counter", "Reflect", "Absorb" }
    };

    static final String[][] ACTION_DESCRIPTIONS = {
            // Damage descriptions
            { "A powerful physical attack", "Sharp blade cuts deep", "Overwhelming crushing force",
                    "Devastating blow that destroys", "Complete annihilation of foe", "Relentless pummeling assault",
                    "Heavy cleaving strike", "Bone-crushing smash" },
            // Heal descriptions
            { "Restores health gradually", "Brings back vitality", "Mends wounds and injuries",
                    "Cures ailments and diseases", "Revives fallen ally", "Rejuvenates body and spirit",
                    "Natural recovery process", "Regenerates lost health" },
            // Buff descriptions
            { "Increases physical power", "Boosts speed and agility", "Divine blessing protects",
                    "Fortifies defenses", "Empowers all abilities", "Inspires courage and strength",
                    "Rallies spirit for battle", "Enhances combat prowess" },
            // Debuff descriptions
            { "Reduces enemy strength", "Slows movement speed", "Dark curse afflicts foe",
                    "Poison damages over time", "Blinds enemy vision", "Confuses enemy actions",
                    "Instills paralyzing fear", "Silences magic casting" },
            // Summon descriptions
            { "Summons loyal wolf ally", "Calls powerful bear", "Raises undead skeleton",
                    "Invokes spiritual entity", "Conjures elemental being", "Creates stone guardian" },
            // Other descriptions
            { "Defensive blocking stance", "Protective guard position", "Concentrates mental energy",
                    "Rests to recover stamina", "Steals from enemy", "Counters incoming attack",
                    "Reflects damage back", "Absorbs enemy energy" }
    };

    /**
     * Generates a single random action
     *
     * @return A new randomized Action implementation
     */
    public static Action generateRandomAction() {
        // Pick random category
        int categoryIndex = random.nextInt(ACTION_NAMES.length);
        String name = getRandomName(categoryIndex);
        String description = getRandomDescription(categoryIndex);
        String message = "Fill me up!";

        // Generate random attributes
        ActionType actionType = getRandomActionType();
        int hitCount = random.nextInt(3) + 1; // 1-3 hits
        int baseDamage = random.nextInt(20) + 1; // 1-20 damage
        int manaCost = random.nextInt(10); // 0-9 mana
        TargetingType targetingType = TargetingType.values()[random.nextInt(TargetingType.values().length)];

        return new RandomAction(actionType, hitCount, baseDamage, manaCost, name, description, message, targetingType);
    }

    /**
     * Generates multiple random actions
     *
     * @param count Number of actions to generate (1-5)
     * @return ArrayList of random actions
     */
    public static ArrayList<Action> generateRandomActions(int count) {
        if (count < 1 || count > 5) {
            throw new IllegalArgumentException("Action count must be between 1 and 5");
        }

        ArrayList<Action> actions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            actions.add(generateRandomAction());
        }
        return actions;
    }

    /**
     * Generates random sub-actions and adds them to the provided SubAction
     *
     * @param subAction The SubAction to add random actions to
     * @return The modified SubAction with added random sub-actions
     */
    public static SubAction generateComplexAction(SubAction subAction) {
        // Add 1-3 random sub-actions
        int subActionCount = random.nextInt(3) + 1;
        for (int i = 0; i < subActionCount; i++) {
            subAction.addSubAction(generateRandomAction());
        }

        return subAction;
    }

    private static String getRandomName(int categoryIndex) {
        String[] names = ACTION_NAMES[categoryIndex];
        return names[random.nextInt(names.length)];
    }

    private static String getRandomDescription(int categoryIndex) {
        String[] descriptions = ACTION_DESCRIPTIONS[categoryIndex];
        return descriptions[random.nextInt(descriptions.length)];
    }

    private static ActionType getRandomActionType() {
        ActionType[] actionTypes = { ActionType.BUFF, ActionType.DAMAGE, ActionType.DEBUFF, ActionType.GENERIC,
                ActionType.HEAL, ActionType.PROTECTION, ActionType.UTILITY };
        return actionTypes[random.nextInt(actionTypes.length)];
    }

    /**
     * Inner class for random action implementation
     */
    private static class RandomAction implements Action {

        private final ActionType actionType;
        private final int hitCount;
        private final int baseDamage;
        private final int manaCost;
        private final String name;
        private final String description;
        private final String message;
        private final TargetingType targetingType;

        public RandomAction(ActionType actionType, int hitCount, int baseDamage, int manaCost,
                String name, String description, String message, TargetingType targetingType) {
            this.actionType = actionType;
            this.hitCount = hitCount;
            this.baseDamage = baseDamage;
            this.manaCost = manaCost;
            this.name = name;
            this.description = description;
            this.message = message;
            this.targetingType = targetingType;
        }

        @Override
        public String getName() {
            return name;
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
        public ActionType getActionType() {
            return actionType;
        }

        @Override
        public String getStatDescription() {
            return description;
        }

        @Override
        public String getBattleDescription() {
            return description;
        }

        @Override
        public String getBattleMessage() {
            return message;
        }

        @Override
        public TargetingType getTargetingType() {
            return targetingType;
        }

        @Override
        public void execute(NCharacter user, NCharacter target) {
            System.out.println(user.getName() + " uses " + name + " on " + target.getName());
        }
    }
}
