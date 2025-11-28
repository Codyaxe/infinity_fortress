# 🏰Infinity Fortress

Infinity Fortress is a console-based turn-based game with gacha elements. Something dark is dwelling underneath.

## Overview

This is a (definitely simple) turn-based battle game with fantasy elements. Players can pull (or gamble their gems) to get characters with a change to get (nothing or) a powerful chracter.

### Features

- **Pull From Banners**: Yes! You read that right! Gacha-style character pulls. Pray to RNGesus accordingly.  
- **Battle AI Enemies**: Unleash your chaotic arsenal and absolutely delete anything that looks at you funny.  
- **Item System**: Loot. All. The. Things. Gather mountains of items and equipment to beef up your crew.  
- **81 Characters**: That’s right—**81** characters to either obliterate or collect.
- **Approximately 150+ Items To Discover**: A treasure trove of gear waiting to charge your battle potential.  
- **Keyboard Inputs Supported**: It’s console-based but hey, keyboards actually work. Totally Overkill!
- **ASCII ART!!??**: VISUALIZE YOUR CHARACTERS IN BEAUTIFUL TEXT GLORY!! YOUR EYES AREN’T READY!!!  
- **Features Audio and Music**: Wait—we have sound now? Are we… game developers??

### Object-oriented Principles

This project follows core object‑oriented principles to keep the codebase modular, maintainable, and easy to extend. Key practices and examples:

- **Encapsulation:** Most fields are `private` or `protected`; access is exposed through methods (getters/setters) and behavior-bearing methods rather than direct field access. This keeps internal state safe and makes refactoring easier.

Example:
```java
// Private character list and can be obtained through a getter
public class Enemy {
    private ArrayList<NCharacter> characters = new ArrayList<>(Arrays.asList(null, null, null, null, null));

    public Enemy() {

        NCharacterFactory factory = new NCharacterFactory();

        characters.set(0, factory.createDwarfTank(NCharacterType.ENEMY));
        characters.set(1, factory.createBeastkinRogue(NCharacterType.ENEMY));
        characters.set(2, factory.createDragonbornSummoner(NCharacterType.ENEMY));
        characters.set(3, factory.createDwarfWarrior(NCharacterType.ENEMY));
        characters.set(4, factory.createOrcWarlock(NCharacterType.ENEMY));
    }

    // Getter
    public ArrayList<NCharacter> getCharacters() {
        return characters;
    }
}
```
- **Abstraction:** Interfaces and abstract classes are used to hide implementation details. For example, `InputHandler` and `AudioHandler` separate the game logic from input and audio implementations so different handlers can be utilized without changing game code.

Example:
```java
// Details about Inputhandler is abstracted
private void handleNavigation(MutableInt choice, int maxChoice, ArrayList<NCharacter> targets) {
        if (InputHandler.right.get()) {
            if (targets.size() > 2 && choice.value == targets.size() - 1) {
                choice.value = 2;
            } else if (choice.value % 3 < 2 && choice.value + 1 <= maxChoice) {
                choice.value++;
            }
            InputHandler.right.set(false);
        }

        if (InputHandler.left.get()) {
            if (targets.size() > 2 && choice.value == 3) {
                choice.value = 0;
            } else if (choice.value % 3 > 0) {
                choice.value--;
            }
            InputHandler.left.set(false);
        }

        if (InputHandler.down.get()) {
            if (choice.value <= 2 && choice.value + 3 >= targets.size() - 1 && targets.size() > 3) {
                choice.value = targets.size() - 1;
            } else if (choice.value + 3 <= maxChoice) {
                choice.value += 3;
            }
            InputHandler.down.set(false);
        }

        if (InputHandler.up.get()) {
            if (choice.value >= 3) {
                choice.value -= 3;
            }
            InputHandler.up.set(false);
        }
    }
```
- **Inheritance:** Some interface and classes share common behavior while allowing specialization (e.g., character and item subclasses). However, the code mostly favors composition because it improves clarity and reduces coupling.

Example:
```java
// Interface Inheritance
public interface Items extends Visitable {
    public String getName();

    public String getType();

    public String getRole();

    public int getValue();

    public int getHealth();

    public int getMana();

    public int getDefense();

    public int getStrength();

    public int getCritChance();

    public int getCritStrength();

    public int getSpeed();

    public int getLuck();

    public String getDescription();

    public String getFlavorText();

    public ItemRarity getRarity();
}

```
- **Polymorphism:** Actions, effects, roles, races and items implement common interfaces or extend base classes and override behavior, enabling flexible strategies and Visitor/Strategy-like patterns across the codebase.

Example:
```java
class SingleAllyHandler extends TargetingHandlerBase {

    public SingleAllyHandler(Player player, Enemy enemy) {
        super(player, enemy);
    }

    @Override
    public boolean handle(MainBattleUI battleUI, NCharacter curr, Action selectedAction) {
        ArrayList<NCharacter> allies = getAliveAllies(curr);
        if (allies.isEmpty()) {
            Printbox.showMessage(battleUI, "No valid ally targets available!");
            return false;
        }
        TargetingSystem targetingSystem = new TargetingSystem(selectedAction, curr);
        NCharacter target = targetingSystem.start(battleUI, allies);
        if (target != null && processMP(curr, selectedAction, battleUI)) {
            selectedAction.execute(curr, target); //Polymorphism
            Printbox.showMessage(battleUI, selectedAction.getBattleMessage());
            return true;
        }
        return false;
    }
}
```

## System Requirements

- OS: Windows 7 or higher (32-bit or 64-bit)
- Processor: Any modern CPU (Pentium 4 or newer)
- Memory: 512 MB RAM
- Storage: 100 MB available space
- Input: Keyboard

## Prerequisites

Ensure you have the following installed on your system:

- Java Development Kit (JDK) 21 or higher (tested with Java 21 and 24)
- Apache Maven
- A terminal or command prompt

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Codyaxe/infinity_fortress.git
   ```

2. Navigate to the project directory:
   ```bash
   cd infinity_fortress
   ```

3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Game

1. Use a terminal and navigate to the `target` directory:
   ```bash
   cd target
   ```

2. Run the game:
   ```bash
   java -jar infinity-fortress-1.0-SNAPSHOT.jar
   ```

   Or run directly from the project root:
   ```bash
   java -jar target/infinity-fortress-1.0-SNAPSHOT.jar
   ```

   Or double click the run.bat file in the root folder
   ```bash
    run.bat
   ```
## Contributors
The drunk devs that made this repo possible is brought to you by:
- **@codyxe**: System and Utility Programmer

- **@Trill1um**: UI and System Programmer

- **@HoYeJi**: Game Balance and Designer