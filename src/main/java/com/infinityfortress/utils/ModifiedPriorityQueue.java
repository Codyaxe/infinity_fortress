package com.infinityfortress.utils;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;

public final class ModifiedPriorityQueue {

  private ArrayList<Pair<NCharacter, Integer>> list;
  final private Queue<NCharacter> queue = new LinkedList<>();

  public void addToQueue() {
    this.queue.add(this.list.get(0).first);
    this.list.set(0, new Pair<>(this.list.get(0).first, 0));
    this.list = this.list.stream()
        .map(c -> new Pair<NCharacter, Integer>(c.first, c.second + c.first.getSpeed()))
        .sorted((a, b) -> b.second - a.second)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  // I modified the code so it handles speed directly from a list of character
  // instead of storing the speed in pair values
  public ModifiedPriorityQueue(ArrayList<NCharacter> characters) {
    this.list = characters.stream()
        .filter(c -> c != null)
        .map(c -> new Pair<>(c, c.getSpeed()))
        .sorted((a, b) -> b.second - a.second)
        .collect(Collectors.toCollection(ArrayList::new));
    addToQueue();
    addToQueue();
    addToQueue();
  }

  public ArrayList<String> getCurrentQueue() {
    ArrayList<String> turnOrder = new ArrayList<>();
    for (NCharacter c : this.queue) {
      if (c.getType() == NCharacterType.ALLY) {
        turnOrder.add("\033[32m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      } else {
        turnOrder.add("\033[31m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      }
    }
    return turnOrder;
  }

  public Queue<NCharacter> getQueue() {
    return this.queue;
  }

  public NCharacter getCurrCharAndUpdate() {
    this.queue.poll();
    addToQueue();
    return peekCurrChar();
  }

  public NCharacter peekCurrChar() {
    return this.queue.peek();
  }

  public String showQueue() {
    StringBuilder sb = new StringBuilder();
    for (NCharacter c : this.queue) {
      sb.append(c.getRole().getName()).append(" ").append(c.getRole().getName()).append(" | ");
    }
    return sb.toString();
  }
}
