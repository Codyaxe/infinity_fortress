package com.infinityfortress.ui.ItemMenu;

// import com.infinityfortress.items.Items;
import java.util.ArrayList;

import com.infinityfortress.items.Items;

public class MainItemMenu {
    ArrayList<Items> items;
    int gemCount;
    
    // Battle Start
    public MainItemMenu(ArrayList<Items> i, int g) {
      this.items = i;
      this.gemCount = g;
      System.out.print(ItemSkeleton.getComponent().toString());
    }

    public void display(int curr, int currScroll) {
      System.out.print(
            ListComponent.getComponent(items, currScroll, curr)                        
            .append(ItemStatComponent.getComponent(items.get(curr+currScroll)))
            .append(ItemDescComponent.getComponent(items.get(curr+currScroll)))
            .toString());
    }
}
