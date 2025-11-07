package com.infinityfortress.effects;

public class TemporaryEffect implements Effects {
    private int duration;
    private int strength;

    public TemporaryEffect(int d) {
        this.duration = d;
    }

    public String getName() {
        return "Generic Name";
    }

    public void setDuration(int d) {
        this.duration = d;
    }

    public int getDuration() {
        return duration;
    }

    public void decrement() {
        duration--;
    }

    public void setStrength(int s) {
        this.strength = s;
    }

    public int getStrength() {
        return strength;
    }

    public void apply() {
        System.out.println("Generic Effect Applied!");
    }

    public void remove() {
        System.out.println("Generic Effect Removed!");
    }
}
