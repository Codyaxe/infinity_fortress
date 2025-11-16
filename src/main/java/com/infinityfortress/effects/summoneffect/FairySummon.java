package com.infinityfortress.effects.summoneffect;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.Printbox;

import java.util.ArrayList;
import java.util.Random;

public class FairySummon implements SummonEffect {
    private int healAmount;
    private int duration;
    private Random random;

    public FairySummon() {
        this(3);
    }

    public FairySummon(int duration) {
        this.healAmount = 8;
        this.duration = duration;
        this.random = new Random();
    }

    @Override
    public void decrementDuration() {
        if (duration > 0) {
            duration--;
        }
    }

    @Override
    public int getDuration() {
        return duration;
    }

    @Override
    public boolean isExpired() {
        return duration <= 0;
    }

    @Override
    public String getName() {
        return "Fairy";
    }

    @Override
    public void execute(NCharacter owner, ArrayList<NCharacter> allies, ArrayList<NCharacter> enemies,
            MainBattleUI battleUI) {
        ArrayList<NCharacter> targets;
        if (owner.getType() == com.infinityfortress.characters.NCharacterType.ALLY) {
            targets = allies;
        } else {
            targets = enemies;
        }

        ArrayList<NCharacter> aliveTargets = new ArrayList<>();
        for (NCharacter target : targets) {
            if (target != null && !target.isDead() && target.getHealth() < target.getMaxHealth()) {
                aliveTargets.add(target);
            }
        }

        if (aliveTargets.isEmpty()) {
            return;
        }

        NCharacter target = aliveTargets.get(random.nextInt(aliveTargets.size()));
        int currentHealth = target.getHealth();
        int maxHealth = target.getMaxHealth();
        int newHealth = Math.min(maxHealth, currentHealth + healAmount);
        target.setHealth(newHealth);
        Printbox.showMessage(battleUI, String.format("%s's Fairy heals %s for %d HP!",
                owner.getName(), target.getName(), (newHealth - currentHealth)));
    }
}
