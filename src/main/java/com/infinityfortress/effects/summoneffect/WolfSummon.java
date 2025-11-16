package com.infinityfortress.effects.summoneffect;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;
import com.infinityfortress.utils.Printbox;

import java.util.ArrayList;
import java.util.Random;

public class WolfSummon implements SummonEffect {
    private int damage;
    private int numTargets;
    private int duration;
    private Random random;

    public WolfSummon() {
        this(3);
    }

    public WolfSummon(int duration) {
        this.damage = 5;
        this.numTargets = 2;
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
        return "Wolf Pack";
    }

    @Override
    public void execute(NCharacter owner, ArrayList<NCharacter> allies, ArrayList<NCharacter> enemies,
            MainBattleUI battleUI) {
        ArrayList<NCharacter> targets;
        if (owner.getType() == com.infinityfortress.characters.NCharacterType.ALLY) {
            targets = enemies;
        } else {
            targets = allies;
        }

        ArrayList<NCharacter> aliveTargets = new ArrayList<>();
        for (NCharacter target : targets) {
            if (target != null && !target.isDead()) {
                aliveTargets.add(target);
            }
        }

        if (aliveTargets.isEmpty()) {
            return;
        }

        int attackCount = Math.min(numTargets, aliveTargets.size());

        for (int i = 0; i < attackCount; i++) {
            NCharacter target = aliveTargets.get(random.nextInt(aliveTargets.size()));
            int currentHealth = target.getHealth();
            target.setHealth(Math.max(0, currentHealth - damage));
            Printbox.showMessage(battleUI, String.format("%s's Wolf Pack attacks %s for %d damage!",
                    owner.getName(), target.getName(), damage));
        }
    }
}