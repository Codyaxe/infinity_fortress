package com.infinityfortress.effects.temporaryeffect;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.effects.Effects;

public class TemporaryEffect implements Effects {
    protected NCharacter target;
    private int duration;
    private int strength;
    private boolean justApplied;
    private Runnable onSpeedChange;

    public TemporaryEffect(int d, NCharacter t) {
        this.duration = d;
        this.target = t;
        this.justApplied = true;
    }

    public String getName() {
        return "Generic Name";
    }

    public TemporaryEffectType getType() {
        return TemporaryEffectType.NONE;
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

    // Speed Change Callback
    public void setOnSpeedChange(Runnable callback) {
        this.onSpeedChange = callback;
    }

    protected void notifySpeedChange() {
        if (onSpeedChange != null) {
            onSpeedChange.run();
        }
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
