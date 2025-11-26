package com.infinityfortress.items;

public interface Items extends Visitable {
    public String getName();

    public String getType();

    public String getRole();

    public int getValue();

    public int getHealth();

    public int getMana();

    public int getDefense();

    public int getStrength();

    public int getCritChance();

    public int getCritStrength();

    public int getSpeed();

    public int getLuck();

    public String getDescription();

    public String getFlavorText();

    public ItemRarity getRarity();
}
