package com.infinityfortress.characters;

import com.infinityfortress.roles.*;
import com.infinityfortress.races.*;

public class NCharacterFactory {

    // Based to sa stats dun sa ating table

    public NCharacter createBeastkinCleric(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Cleric(), new Beastkin());
    }

    public NCharacter createBeastkinRogue(NCharacterType type) {
        return new NCharacter(type, 2, 0, 0, 3, 1, 5, 2, 4, 5, new Rogue(), new Beastkin());
    }

    public NCharacter createBeastkinSummoner(NCharacterType type) {
        return new NCharacter(type, 2, 3, 0, 1, 3, 3, 1, 1, 4, new Summoner(), new Beastkin());
    }

    public NCharacter createDemonMage(NCharacterType type) {
        return new NCharacter(type, 1, 5, 0, 1, 3, 2, 1, 1, 2, new Mage(), new Demon());
    }

    public NCharacter createDemonRogue(NCharacterType type) {
        return new NCharacter(type, 2, 0, 0, 3, 1, 5, 2, 4, 5, new Rogue(), new Demon());
    }

    public NCharacter createDemonWarlock(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Mage(), new Demon());
    }

    public NCharacter createDragonbornMage(NCharacterType type) {
        return new NCharacter(type, 1, 5, 0, 1, 3, 2, 1, 1, 2, new Mage(), new Dragonborn());
    }

    public NCharacter createDragonbornSummoner(NCharacterType type) {
        return new NCharacter(type, 2, 3, 0, 1, 3, 3, 1, 1, 4, new Summoner(), new Dragonborn());
    }

    public NCharacter createDragonbornWarrior(NCharacterType type) {
        return new NCharacter(type, 4, 0, 0, 3, 5, 4, 1, 1, 2, new Tank(), new Dragonborn());
    }

    public NCharacter createDwarfCleric(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Cleric(), new Dwarf());
    }

    public NCharacter createDwarfTank(NCharacterType type) {
        return new NCharacter(type, 5, 0, 0, 5, 2, 2, 0, 0, 0, new Tank(), new Dwarf());
    }

    public NCharacter createDwarfWarrior(NCharacterType type) {
        return new NCharacter(type, 4, 0, 0, 3, 5, 4, 1, 1, 2, new Tank(), new Dwarf());
    }

    public NCharacter createElfArcher(NCharacterType type) {
        return new NCharacter(type, 1, 0, 0, 1, 3, 4, 5, 2, 0, new Archer(), new Elf());
    }

    public NCharacter createElfCleric(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Cleric(), new Elf());
    }

    public NCharacter createElfHealer(NCharacterType type) {
        return new NCharacter(type, 2, 4, 0, 0, 3, 1, 0, 3, 0, new Healer(), new Elf());
    }

    public NCharacter createHumanArcher(NCharacterType type) {
        return new NCharacter(type, 1, 0, 0, 1, 3, 4, 5, 2, 0, new Archer(), new Human());
    }

    public NCharacter createHumanRogue(NCharacterType type) {
        return new NCharacter(type, 2, 0, 0, 3, 1, 5, 2, 4, 5, new Rogue(), new Human());
    }

    public NCharacter createHumanWarrior(NCharacterType type) {
        return new NCharacter(type, 4, 0, 0, 3, 5, 4, 1, 1, 2, new Tank(), new Human());
    }

    public NCharacter createNephilimCleric(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Cleric(), new Nephilim());
    }

    public NCharacter createNephilimHealer(NCharacterType type) {
        return new NCharacter(type, 2, 4, 0, 0, 3, 1, 0, 3, 0, new Healer(), new Nephilim());
    }

    public NCharacter createNephilimMage(NCharacterType type) {
        return new NCharacter(type, 1, 5, 0, 1, 3, 2, 1, 1, 2, new Mage(), new Nephilim());
    }

    public NCharacter createOrcTank(NCharacterType type) {
        return new NCharacter(type, 5, 0, 0, 5, 2, 2, 0, 0, 0, new Tank(), new Orc());
    }

    public NCharacter createOrcWarlock(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Mage(), new Orc());
    }

    public NCharacter createOrcWarrior(NCharacterType type) {
        return new NCharacter(type, 4, 0, 0, 3, 5, 4, 1, 1, 2, new Tank(), new Orc());
    }

    public NCharacter createSpiritbornCleric(NCharacterType type) {
        return new NCharacter(type, 3, 4, 0, 2, 2, 2, 1, 2, 4, new Cleric(), new Spiritborn());
    }

    public NCharacter createSpiritbornMage(NCharacterType type) {
        return new NCharacter(type, 1, 5, 0, 1, 3, 2, 1, 1, 2, new Mage(), new Spiritborn());
    }
}
