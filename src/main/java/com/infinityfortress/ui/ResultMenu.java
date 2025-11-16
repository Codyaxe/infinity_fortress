package com.infinityfortress.ui;

import com.infinityfortress.ui.OldMenu.BattleFieldUI;
import com.infinityfortress.ui.OldMenu.BattleUIComponent;

public class ResultMenu implements BattleUIComponent {
  private BattleFieldUI top;

  public ResultMenu(BattleFieldUI top) {
    this.top = top;
  }

  @Override
  public BattleFieldUI getBattleFieldUI() {
    return this.top;
  }
}
