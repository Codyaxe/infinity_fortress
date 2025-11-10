package com.infinityfortress.utils;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;
import com.infinityfortress.Character;
import com.infinityfortress.Character.Type;

public final class ModifiedPriorityQueue {

    private ArrayList<Pair<Character, Integer>> list;
    final private Queue<Character> queue=new LinkedList<>();

    public void addToQueue() {
        this.queue.add(this.list.get(0).first);
        this.list.set(0, new Pair<>(this.list.get(0).first, 0));
        this.list = this.list.stream()
                .map(c -> new Pair<Character, Integer>(c.first, c.second + c.first.speed))
                .sorted((a, b) -> b.second - a.second)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ModifiedPriorityQueue(ArrayList<Pair<Character, Integer>> priorities) {
        this.list = priorities.stream()
                .filter(p -> p.first != null)
                .sorted((a, b) -> b.second - a.second)
                .collect(Collectors.toCollection(ArrayList::new));
        addToQueue();
        addToQueue();
        addToQueue();
    }

    public ArrayList<String> getCurrentQueue() {
        ArrayList<String> turnOrder = new ArrayList<>();
        for (Character c : this.queue) {
            if (c.type==Type.ALLY) {
              turnOrder.add("\033[32m" + c.race + " " + c.role + "\u001B[0m");
            } else {
              turnOrder.add("\033[31m" + c.race + " " + c.role + "\u001B[0m");
            }
        }
        return turnOrder;
    }

    public Character getCurrCharAndUpdate() {
      this.queue.poll();
      addToQueue();
      return peekCurrChar();
    }

    public Character peekCurrChar() {
        return this.queue.peek();
    }
}
