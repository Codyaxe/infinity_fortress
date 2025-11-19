package com.infinityfortress.effects.summoneffect;

import java.util.ArrayList;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.ui.BattleMenu.MainBattleUI;

public interface SummonEffect {
    void execute(NCharacter owner, ArrayList<NCharacter> allies, ArrayList<NCharacter> enemies, MainBattleUI battleUI);

    void decrementDuration();

    int getDuration();

    boolean isExpired();

    String getName();
}
