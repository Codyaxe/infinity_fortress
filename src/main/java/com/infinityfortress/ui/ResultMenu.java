package com.infinityfortress.ui;

import com.infinityfortress.ui.OldMenu.BattleFeildUI;
import com.infinityfortress.ui.OldMenu.BattleUIComponent;

public class ResultMenu implements BattleUIComponent {
  private BattleFeildUI top;

  public ResultMenu(BattleFeildUI top) {
    this.top = top;
  }

  @Override
  public BattleFeildUI getBattleFeildUI() {
    return this.top;
  }
}
