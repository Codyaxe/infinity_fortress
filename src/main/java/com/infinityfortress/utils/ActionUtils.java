package com.infinityfortress.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.infinityfortress.actions.Action;
import com.infinityfortress.actions.TargetingType;
import com.infinityfortress.characters.NCharacter;

/**
 * Utility class for working with NCharacter actions
 */
public class ActionUtils {

    /**
     * Get all actions of a specific targeting type
     */
    public static List<Action> getActionsByTargetingType(NCharacter character, TargetingType targetType) {
        return character.getAllActions().stream()
                .filter(action -> action.getTargetingType() == targetType)
                .collect(Collectors.toList());
    }

    /**
     * Get all offensive actions (actions that target enemies)
     */
    public static List<Action> getOffensiveActions(NCharacter character) {
        return character.getAllActions().stream()
                .filter(action -> action.getTargetingType() == TargetingType.SINGLE_ENEMY ||
                        action.getTargetingType() == TargetingType.ALL_ENEMIES ||
                        action.getTargetingType() == TargetingType.RANDOM)
                .collect(Collectors.toList());
    }

    /**
     * Get all supportive actions (actions that target allies or self)
     */
    public static List<Action> getSupportiveActions(NCharacter character) {
        return character.getAllActions().stream()
                .filter(action -> action.getTargetingType() == TargetingType.SINGLE_ALLY ||
                        action.getTargetingType() == TargetingType.ALL_ALLIES ||
                        action.getTargetingType() == TargetingType.SELF)
                .collect(Collectors.toList());
    }

    /**
     * Get actions that cost mana
     */
    public static List<Action> getActionsWithManaCost(NCharacter character) {
        return character.getAllActions().stream()
                .filter(action -> action.getManaCost() > 0)
                .collect(Collectors.toList());
    }

    /**
     * Get actions that the character can currently afford (has enough mana)
     */
    public static List<Action> getAffordableActions(NCharacter character) {
        return character.getAllActions().stream()
                .filter(action -> character.getMana() >= action.getManaCost())
                .collect(Collectors.toList());
    }

    /**
     * Get the most expensive action (highest mana cost)
     */
    public static Action getMostExpensiveAction(NCharacter character) {
        return character.getAllActions().stream()
                .max((a1, a2) -> Integer.compare(a1.getManaCost(), a2.getManaCost()))
                .orElse(null);
    }

    /**
     * Get the most damaging action (highest base damage)
     */
    public static Action getMostDamagingAction(NCharacter character) {
        return character.getAllActions().stream()
                .max((a1, a2) -> Integer.compare(a1.getBaseDamage(), a2.getBaseDamage()))
                .orElse(null);
    }

    /**
     * Check if character has any actions of a specific type
     */
    public static boolean hasActionOfType(NCharacter character, TargetingType targetType) {
        return character.getAllActions().stream()
                .anyMatch(action -> action.getTargetingType() == targetType);
    }

    /**
     * Get action names for UI display
     */
    public static List<String> getActionNames(NCharacter character) {
        return character.getAllActions().stream()
                .map(Action::getName)
                .collect(Collectors.toList());
    }

    /**
     * Find action by name (case-insensitive)
     */
    public static Action findActionByName(NCharacter character, String name) {
        return character.getAllActions().stream()
                .filter(action -> action.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Get total mana cost of all actions
     */
    public static int getTotalManaCost(NCharacter character) {
        return character.getAllActions().stream()
                .mapToInt(Action::getManaCost)
                .sum();
    }

    /**
     * Format action for display with all information
     */
    public static String formatActionInfo(Action action) {
        if (action == null)
            return "No action";

        return String.format("%s | Type: %s | Hits: %d | Damage: %d | Cost: %d MP",
                action.getName(),
                action.getActionType(),
                action.getHitCount(),
                action.getBaseDamage(),
                action.getManaCost());
    }
}