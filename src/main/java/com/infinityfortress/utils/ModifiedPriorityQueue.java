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
    this.list = this.list.stream()
        .filter(pair -> !pair.first.isDead())
        .collect(Collectors.toCollection(ArrayList::new));

    if (!this.list.isEmpty()) {
      NCharacter topCharacter = this.list.get(0).first;
      if (!this.queue.contains(topCharacter)) {
        this.queue.add(topCharacter);
      }
      this.list.set(0, new Pair<>(this.list.get(0).first, 0));
      this.list = this.list.stream()
          .map(c -> new Pair<NCharacter, Integer>(c.first, c.second + c.first.getSpeed()))
          .sorted((a, b) -> b.second - a.second)
          .collect(Collectors.toCollection(ArrayList::new));
    }
  }

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
    this.queue.removeIf(c -> c.isDead());

    // Ensures there is always three characters in the queue
    while (this.queue.size() < 3 && !this.list.isEmpty()) {
      addToQueue();
    }

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

  public NCharacter getCurrCharAndUpdate() {
    this.queue.poll();
    addToQueue();
    return peekCurrChar();
  }

  public NCharacter peekCurrChar() {
    this.queue.removeIf(c -> c.isDead());
    return this.queue.peek();
  }
}
