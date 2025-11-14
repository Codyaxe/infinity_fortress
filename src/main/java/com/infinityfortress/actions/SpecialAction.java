package com.infinityfortress.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Collections;

import com.infinityfortress.characters.NCharacter;

public class SpecialAction implements MainAction {

    private static final Map<String, String[][]> ACTIONS = new HashMap<>();
    
    static {
        // Magic Damage actions - [name, description] pairs
        ACTIONS.put("Magic Damage", new String[][]{
            {"Fireball", "A burst of flame that scorches enemies."},
            {"Ice Shard", "Sharp ice projectiles pierce through foes."},
            {"Lightning Bolt", "Electric energy strikes with devastating power."},
            {"Arcane Missile", "A focused magical projectile."},
            {"Frost Beam", "Freezing beam that chills enemies."},
            {"Flame Lance", "A spear of concentrated fire."},
            {"Thunder Strike", "Thunder crashes down upon enemies."},
            {"Ice Blast", "Explosive ice damages multiple foes."},
            {"Meteor", "A falling meteor crushes enemies."},
            {"Chain Lightning", "Lightning jumps between multiple targets."},
            {"Blizzard", "Freezing storm hits all enemies."},
            {"Inferno", "Raging fire engulfs the battlefield."}
        });
        
        // Damage actions - [name, description] pairs
        ACTIONS.put("Damage", new String[][]{
            {"Shadow Strike", "A precise strike that may deal extra damage."},
            {"Whirlwind", "Hits multiple nearby enemies."},
            {"Berserker Rage", "Unleashes primal fury in combat."},
            {"Assassinate", "A deadly assassination attempt."},
            {"Backstab", "Strikes from behind for massive damage."},
            {"Critical Strike", "A perfectly aimed critical blow."},
            {"Devastate", "Devastates enemies with overwhelming force."},
            {"Rampage", "Goes into a destructive rampage."},
            {"Flurry", "A rapid series of attacks."},
            {"Execute", "Executes weakened enemies."},
            {"Decapitate", "A clean beheading strike."},
            {"Eviscerate", "Tears enemies apart viciously."}
        });
        
        // Drain actions - [name, description] pairs
        ACTIONS.put("Drain", new String[][]{
            {"Siphon", "Life-stealing attack that heals the user."},
            {"Life Steal", "Drains life force from enemies."},
            {"Mana Drain", "Steals magical energy from targets."},
            {"Soul Rend", "Tears at the enemy's very soul."},
            {"Vampiric Strike", "Strike that feeds on enemy blood."},
            {"Energy Leech", "Leeches energy from foes."},
            {"Spirit Drain", "Drains spiritual essence."},
            {"Essence Steal", "Steals the essence of enemies."},
            {"Blood Suck", "Sucks blood to restore health."},
            {"Power Absorb", "Absorbs enemy power."}
        });
        
        // Summon actions - [name, description] pairs
        ACTIONS.put("Summon", new String[][]{
            {"Summon Wolf", "Summons a friendly wolf to fight."},
            {"Call Bear", "Calls upon a powerful bear ally."},
            {"Raise Skeleton", "Raises undead skeleton warriors."},
            {"Conjure Elemental", "Conjures an elemental being."},
            {"Summon Phoenix", "Summons a majestic phoenix."},
            {"Call Dragon", "Calls forth a mighty dragon."},
            {"Animate Golem", "Animates a stone golem guardian."},
            {"Invoke Demon", "Invokes a demonic ally."},
            {"Summon Angel", "Summons an angelic protector."},
            {"Call Storm", "Calls forth a raging storm."}
        });
        
        // Buff actions - [name, description] pairs
        ACTIONS.put("Buff", new String[][]{
            {"Blessing", "Grants divine blessing."},
            {"Haste", "Increases speed and agility."},
            {"Strength", "Enhances physical strength."},
            {"Protection", "Provides magical protection."},
            {"Regeneration", "Grants regenerative abilities."},
            {"Clarity", "Clears the mind for focus."},
            {"Fortify", "Fortifies defenses."},
            {"Empower", "Empowers all abilities."},
            {"Enhance", "Enhances combat prowess."},
            {"Divine Favor", "Receives divine favor."},
            {"Battle Fury", "Enters a furious battle state."},
            {"Adrenaline", "Pumps adrenaline for peak performance."}
        });
        
        // Debuff actions - [name, description] pairs
        ACTIONS.put("Debuff", new String[][]{
            {"Curse", "Places a dark curse on enemies."},
            {"Weaken", "Weakens enemy strength."},
            {"Slow", "Slows enemy movement."},
            {"Poison", "Inflicts poisonous damage over time."},
            {"Blind", "Blinds enemies temporarily."},
            {"Confuse", "Confuses enemy actions."},
            {"Fear", "Instills fear in enemies."},
            {"Silence", "Silences enemy spellcasters."},
            {"Paralyze", "Paralyzes enemies briefly."},
            {"Hex", "Hexes enemies with bad luck."},
            {"Doom", "Brings impending doom."},
            {"Plague", "Spreads disease among foes."}
        });
    }

    private String name;
    private String description;
    private int hitCount;
    private int manaCost;
    private int baseDamage;
    private String actionType;
    private TargetingType targetingType;
    private ArrayList<Action> subActions; // Subactions for special abilities
    private boolean hasSubaction = false;

    public SpecialAction() {
      Random rnd = new Random();
      int random = rnd.nextInt(3)+1;
      if (random > 1) {
        ArrayList<Action> temp =new ArrayList<>();
        temp.add(new SpecialAction(random));
        this.subActions = temp;
        this.hasSubaction = true;
      } else {
        replace(new SpecialAction(random));
      }
    }

    public final void replace(SpecialAction sa) {
      this.name = sa.name;
      this.description = sa.description;
      this.hitCount = sa.hitCount;
      this.manaCost = sa.manaCost;
      this.baseDamage = sa.baseDamage;
      this.actionType = sa.actionType;
      this.targetingType = sa.targetingType;
      this.hasSubaction = false;
    }


    // Random constructor with parameter (for subactions)
    public SpecialAction(int randInt) {
        Random rnd = new Random();
        
        // Pick a random action type
        String[] actionTypes = ACTIONS.keySet().toArray(new String[0]);
        String selectedType = actionTypes[rnd.nextInt(actionTypes.length)];
        
        // Get actions for the selected type
        String[][] actions = ACTIONS.get(selectedType);
        int index = rnd.nextInt(actions.length);
        
        this.name = actions[index][0]; // First element is name
        this.description = actions[index][1]; // Second element is description
        this.hitCount = rnd.nextInt(3) + 1; // 1-3 hits
        this.manaCost = rnd.nextInt(5) + 3; // 3-7 mana for special actions
        this.baseDamage = rnd.nextInt(7) + 8; // 8-14 damage
        this.actionType = selectedType;
        
        // Set targeting based on action type  
        switch (selectedType) {
            case "Buff":
                this.targetingType = TargetingType.SELF;
                break;
            case "Debuff":
            case "Drain":
                this.targetingType = TargetingType.SINGLE_ENEMY;
                break;
            case "Magic Damage":
            case "Damage":
                this.targetingType = rnd.nextBoolean() ? TargetingType.SINGLE_ENEMY : TargetingType.ALL_ENEMIES;
                break;
            case "Summon":
                this.targetingType = TargetingType.NONE;
                break;
            default:
                this.targetingType = TargetingType.SINGLE_ENEMY;
                break;
        }
    }

    @Override
    public ArrayList<Action> getActions() {
        return subActions;
    }

    @Override
    public boolean hasSubActions() {
        return hasSubaction;
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

    }
}