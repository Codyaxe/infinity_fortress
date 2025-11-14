package com.infinityfortress.actions;

import java.util.ArrayList;

public interface MainAction extends Action {
  ArrayList<Action> getActions();
  boolean hasSubActions();
}
