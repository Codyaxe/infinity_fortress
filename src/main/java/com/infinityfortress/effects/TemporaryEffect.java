package com.infinityfortress.effects;

import com.infinityfortress.characters.NCharacter;

public class TemporaryEffect implements Effects {
    protected NCharacter target;
    private int duration;
    private int strength;
    private boolean justApplied;

    public TemporaryEffect(int d, NCharacter t) {
        this.duration = d;
        this.target = t;
        this.justApplied = true;
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

    // Instant Application Flag
    public boolean isJustApplied() {
        return justApplied;
    }

    public void setJustApplied(boolean x) {
        justApplied = x;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TemporaryEffect other = (TemporaryEffect) obj;
        return this.getName().equals(other.getName()) && this.target.equals(other.target);
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + target.hashCode();
    }
}
