package com.infinityfortress.utils;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterType;

public final class ModifiedPriorityQueue {

  private ArrayList<NCharacter> allCharacters;
  private List<NCharacter> fullTurnOrder;
  private final Queue<NCharacter> displayQueue = new LinkedList<>(); // UI display only

  public ModifiedPriorityQueue(ArrayList<NCharacter> characters) {
    this.allCharacters = characters.stream()
        .filter(c -> c != null)
        .collect(Collectors.toCollection(ArrayList::new));

    this.fullTurnOrder = new ArrayList<>();

    resetRound();
  }

  // Reset all characters' turn flags for a new round
  private void resetRound() {
    for (NCharacter c : this.allCharacters) {
      if (!c.isDead()) {
        c.setHasTakenTurn(false);
      }
    }

    // Rebuild full turn order for the new round
    fullTurnOrder = this.allCharacters.stream()
        .filter(c -> !c.isDead())
        .sorted((a, b) -> b.getSpeed() - a.getSpeed())
        .collect(Collectors.toCollection(ArrayList::new));

    updateVisibleQueue();
  }

  // Update the visible queue (first 3 from full turn order)
  private void updateVisibleQueue() {
    displayQueue.clear();
    fullTurnOrder.stream()
        .filter(c -> !c.isDead() && !c.hasTakenTurn())
        .limit(3)
        .forEach(displayQueue::add);
  }

  public void refreshQueueOrder() {

    List<NCharacter> notYetActed = fullTurnOrder.stream()
        .filter(c -> !c.isDead() && !c.hasTakenTurn())
        .sorted((a, b) -> b.getSpeed() - a.getSpeed())
        .collect(Collectors.toList());

    List<NCharacter> alreadyActed = fullTurnOrder.stream()
        .filter(c -> c.hasTakenTurn())
        .sorted((a, b) -> b.getSpeed() - a.getSpeed())
        .collect(Collectors.toList());

    // Rebuild full turn order: not-yet-acted first (sorted by speed), then
    // already-acted
    fullTurnOrder.clear();
    fullTurnOrder.addAll(notYetActed);
    fullTurnOrder.addAll(alreadyActed);

    // Update the visible queue
    updateVisibleQueue();
  }

  public ArrayList<String> getCurrentQueue() {
    return getCurrentQueue(null);
  }

  public ArrayList<String> getCurrentQueue(NCharacter curr) {
    this.displayQueue.removeIf(c -> c.isDead());
    updateVisibleQueue();

    // UI display handling for cases when using items/changing equipment that
    // changes speed midaction
    ArrayList<String> turnOrder = new ArrayList<>();
    if (curr != null) {
      turnOrder.add("\033[32m" + curr.getRace().getName() + " " + curr.getRole().getName() + "\u001B[0m");
    }

    for (NCharacter c : this.displayQueue) {
      if (c.getType() == NCharacterType.ALLY) {
        turnOrder.add("\033[32m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      } else {
        turnOrder.add("\033[31m" + c.getRace().getName() + " " + c.getRole().getName() + "\u001B[0m");
      }
    }

    // If queue has less than 3, preview who's next in the upcoming round. This
    // happens in a scenario where there are less than 3 people left who hasn't
    // taken their turn or there are less than 3 characters left alive. Their turn
    // has taken once their turn starts.
    if (turnOrder.size() < 3) {
      ArrayList<NCharacter> nextRoundPreview = fullTurnOrder.stream()
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
    // Get next character from full turn orders
    NCharacter current = fullTurnOrder.stream()
        .filter(c -> !c.isDead() && !c.hasTakenTurn())
        .findFirst()
        .orElse(null);

    if (current != null) {
      current.setHasTakenTurn(true);
    }

    // Check if round is complete
    boolean allActed = fullTurnOrder.stream()
        .filter(c -> !c.isDead())
        .allMatch(NCharacter::hasTakenTurn);

    if (allActed) {
      resetRound();
    }

    updateVisibleQueue();

    return current;
  }

  public NCharacter peekCurrChar() {
    this.displayQueue.removeIf(c -> c.isDead());
    return this.displayQueue.peek();
  }
}