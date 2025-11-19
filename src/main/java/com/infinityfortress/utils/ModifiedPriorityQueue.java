package com.infinityfortress.utils;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.stream.Collectors;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;

public final class ModifiedPriorityQueue {

  private ArrayList<NCharacter> allCharacters;
  final private Queue<NCharacter> queue = new LinkedList<>();

  public ModifiedPriorityQueue(ArrayList<NCharacter> characters) {
    this.allCharacters = characters.stream()
        .filter(c -> c != null)
        .collect(Collectors.toCollection(ArrayList::new));

    // Initialize the first round
    resetRound();
    fillQueue();
  }

  // Reset all characters' turn flags for a new round
  private void resetRound() {
    for (NCharacter c : this.allCharacters) {
      if (!c.isDead()) {
        c.setHasTakenTurn(false);
      }
    }
  }

  // Fill the queue with up to 3 characters who haven't taken their turn yet
  private void fillQueue() {
    this.queue.removeIf(c -> c.isDead());

    while (this.queue.size() < 3) {
      // Get alive characters who haven't taken their turn, sorted by speed
      ArrayList<NCharacter> availableCharacters = this.allCharacters.stream()
          .filter(c -> !c.isDead() && !c.hasTakenTurn() && !this.queue.contains(c))
          .sorted((a, b) -> b.getSpeed() - a.getSpeed())
          .collect(Collectors.toCollection(ArrayList::new));

      if (availableCharacters.isEmpty()) {
        // All characters have taken their turn, start a new round
        resetRound();
        availableCharacters = this.allCharacters.stream()
            .filter(c -> !c.isDead() && !c.hasTakenTurn() && !this.queue.contains(c))
            .sorted((a, b) -> b.getSpeed() - a.getSpeed())
            .collect(Collectors.toCollection(ArrayList::new));

        if (availableCharacters.isEmpty()) {
          break; // No more characters available
        }
      }

      this.queue.add(availableCharacters.get(0));
    }
  }

  public void refreshQueueOrder() {
    ArrayList<NCharacter> queuedCharacters = new ArrayList<>(this.queue);
    this.queue.clear();

    queuedCharacters.stream()
        .sorted((a, b) -> b.getSpeed() - a.getSpeed())
        .forEach(this.queue::add);
  }

  public ArrayList<String> getCurrentQueue() {
    this.queue.removeIf(c -> c.isDead());
    fillQueue();

    ArrayList<String> turnOrder = new ArrayList<>();
    for (NCharacter c : this.queue) {
      if (c.getType() == NCharacterType.ALLY) {
        turnOrder.add("\033[32m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      } else {
        turnOrder.add("\033[31m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      }
    }

    // If queue has less than 3, preview who's next in the upcoming round
    if (turnOrder.size() < 3) {
      ArrayList<NCharacter> nextRoundPreview = this.allCharacters.stream()
          .filter(c -> !c.isDead() && c.hasTakenTurn())
          .sorted((a, b) -> b.getSpeed() - a.getSpeed())
          .limit(3 - turnOrder.size())
          .collect(Collectors.toCollection(ArrayList::new));

      for (NCharacter c : nextRoundPreview) {
        if (c.getType() == NCharacterType.ALLY) {
          turnOrder.add("\033[32m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
        } else {
          turnOrder.add("\033[31m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
        }
      }
    }

    return turnOrder;
  }

  public NCharacter getCurrCharAndUpdate() {
    NCharacter current = this.queue.poll();
    if (current != null) {
      current.setHasTakenTurn(true);
    }
    fillQueue();
    return peekCurrChar();
  }

  public NCharacter peekCurrChar() {
    this.queue.removeIf(c -> c.isDead());
    return this.queue.peek();
  }
}
