package com.infinityfortress.actions;

public enum TargetingType {
    SINGLE_ENEMY,
    SINGLE_ALLY,
    ALL_ENEMIES,
    ALL_ALLIES,
    SELF,
    CHOOSE_SUBACTION,
    RANDOM,
    NONE,
    // Additional
    Multi, // 3, one main and adjacent
    Split // Archer specific, EX: hit Enemy A twice hit Enemy C once
}