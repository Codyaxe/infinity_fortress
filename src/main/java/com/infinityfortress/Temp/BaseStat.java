package com.infinityfortress.Temp;

public class BaseStat {
  private int HP;
  private int MP;
  private int DEF;
  private int STR;
  private int CC;
  private int CD;
  private int LCK;

  public BaseStat(int HP, int MP, int DEF, int STR, int CC, int CD, int LCK) {
    this.HP = HP;
    this.MP = MP;
    this.DEF = DEF;
    this.STR = STR;
    this.CC = CC;
    this.CD = CD;
    this.LCK = LCK;
  }

  public int getHP() {
    return HP;
  }

  public int getMP() {
    return MP;
  }

  public int getDEF() {
    return DEF;
  }

  public int getSTR() {
    return STR;
  }

  public int getCC() {
    return CC;
  }

  public int getCD() {
    return CD;
  }

  public int getLCK() {
    return LCK;
  }
}
