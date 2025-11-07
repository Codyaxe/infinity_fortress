package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;

public class TemporaryEffect implements Effects {
    protected NCharacter target;
    private int duration;
    private int strength;

    public TemporaryEffect(int d, NCharacter t) {
        this.duration = d;
        this.target = t;
    }

    public String getName() {
        return "Generic Name";
    }

    // Duration Access Methods

    public void setDuration(int d) {
        this.duration = d;
    }

    public int getDuration() {
        return duration;
    }

    public void decrement() {
        duration--;
    }

    // Strength Access Methods

    public void setStrength(int s) {
        this.strength = s;
    }

    public int getStrength() {
        return strength;
    }

    // Effect Override

    public void apply() {
        System.out.println("Generic Effect Applied!");
    }

    public void remove() {
        System.out.println("Generic Effect Removed!");
    }
}
