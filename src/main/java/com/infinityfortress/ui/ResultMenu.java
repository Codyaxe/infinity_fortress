package com.infinityfortress.ui;

public class ResultMenu implements BattleUIComponent {
  private BattleTopUI top;

  public ResultMenu(BattleTopUI top) {
    this.top = top;
  }

  @Override
  public BattleTopUI getBattleTopUI() {
    return this.top;
  }
}
