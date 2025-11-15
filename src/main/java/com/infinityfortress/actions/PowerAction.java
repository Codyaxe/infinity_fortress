package com.infinityfortress.actions;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

public class PowerAction implements Action {
    public PowerAction() {
    }

    @Override
    public String getName() {
        return "Power";
    }

    public boolean isSubAction() {
        return true;
    }

    @Override
    public int getHitCount() {
        return 1;
    }
    
    @Override
    public int getManaCost() {
        return 5;
    }
    
    @Override
    public int getBaseDamage() {
        return 10;
    }
    
    @Override
    public String getActionType() {
        return "Power";
    }
    
    @Override
    public String getStatDescription() {
        return "A powerful ability that enhances combat effectiveness";
    }
    
    @Override
    public String getBattleDescription() {
        return "Unleashes raw power to devastate enemies";
    }
    
    @Override
    public TargetingType getTargetingType() {
        return TargetingType.SINGLE_ENEMY;
    }
        
    @Override
    public ArrayList<Action> getAllSubActions() {
        return new ArrayList<Action>();
    }
    
    @Override
    public void execute(NCharacter user, NCharacter target) {
        System.out.println(user.getName() + " uses " + getName() + " against " + target.getName());
        // Add power action logic here
    }
}