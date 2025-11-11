package com.infinityfortress.utils;

public class DerivedStatCalculation {
    public static int successRate(int luck) {
      return (int)Math.round(100*(0.7 + 0.3 * (1- Math.exp(-0.04*luck))));
    }

    public static int healingAmount(int strength, int targetMaxHp, int targetCurrentHp) {
      return (int)(targetMaxHp * (.20 + strength * 1.2) - targetCurrentHp);
    }

    public static int damageDealt(int dmg, int enemyDef) {
      return Math.round(dmg * (100/(100 + enemyDef)));
    }

    public static int critDamageOutput(int strength, float critDamage) {
      return Math.round(strength * (1 + critDamage));
    }

    public boolean didCrit(float critChance) {
      return Math.random() < critChance;
    }
}
