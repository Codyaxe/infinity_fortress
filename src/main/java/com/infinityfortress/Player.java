package com.infinityfortress;

import java.util.ArrayList;
import java.util.Arrays;

import com.infinityfortress.characters.NCharacter;
import com.infinityfortress.characters.NCharacterFactory;
import com.infinityfortress.characters.NCharacterType;
import com.infinityfortress.items.Items;
import com.infinityfortress.items.consumables.Boosters;
import com.infinityfortress.items.consumables.Debuffers;
import com.infinityfortress.items.consumables.Restoratives;
import com.infinityfortress.items.consumables.Utilities;
import com.infinityfortress.items.equipments.AccessoryFactory;
import com.infinityfortress.items.equipments.ArmorFactory;
import com.infinityfortress.items.equipments.MageWeaponFactory;
import com.infinityfortress.items.equipments.WarriorWeaponFactory;

public class Player {
    public ArrayList<NCharacter> characters = new ArrayList<>(Arrays.asList(null, null, null, null, null));
    public ArrayList<Items> inventory = new ArrayList<>();
    public int gems = 0;

    public Player() {
        // Generate random number of characters (1-5)

        // Random rand = new Random();
        // int numCharacters = 1 + rand.nextInt(5); // 1-5 characters

        NCharacterFactory factory = new NCharacterFactory();

        characters.set(0, factory.createDemonWarlock(NCharacterType.ALLY));
        characters.set(1, factory.createHumanCleric(NCharacterType.ALLY));
        characters.set(2, factory.createDragonbornMage(NCharacterType.ALLY));
        // characters.set(3, factory.createBeastkinArcher(NCharacterType.ALLY));
        // characters.set(4, factory.createBeastkinSummoner(NCharacterType.ALLY));

        // Random Inventory for testing (20 items)
        ArmorFactory armorFactory = new ArmorFactory();
        WarriorWeaponFactory warriorWeaponFactory = new WarriorWeaponFactory();
        MageWeaponFactory mageWeaponFactory = new MageWeaponFactory();
        AccessoryFactory accessoryFactory = new AccessoryFactory();
        Restoratives restorativesFactory = new Restoratives();
        Boosters boostersFactory = new Boosters();
        Debuffers debuffersFactory = new Debuffers();
        Utilities utilitiesFactory = new Utilities();

        // Add random items to inventory
        inventory.add(armorFactory.createLeatherVestment());
        inventory.add(armorFactory.createLeatherVestment());
        inventory.add(warriorWeaponFactory.createRustbiteLongSword());
        inventory.add(restorativesFactory.createHealthPotion());
        inventory.add(restorativesFactory.createHealthPotion());
        inventory.add(mageWeaponFactory.createAshenwoodWand());
        inventory.add(mageWeaponFactory.createAshenwoodWand());
        inventory.add(mageWeaponFactory.createAshenwoodWand());
        inventory.add(boostersFactory.createStrengthBrew());
        inventory.add(armorFactory.createAshenvaleRobe());
        inventory.add(armorFactory.createAshenvaleRobe());
        inventory.add(armorFactory.createAshenvaleRobe());
        inventory.add(restorativesFactory.createManaPotion());
        inventory.add(debuffersFactory.createWeakeningPoison());
        inventory.add(accessoryFactory.createHaloOfSolara());
        inventory.add(accessoryFactory.createHaloOfSolara());
        inventory.add(utilitiesFactory.createAntidote());
        inventory.add(utilitiesFactory.createAntidote());
        inventory.add(utilitiesFactory.createAntidote());
        inventory.add(warriorWeaponFactory.createBonecrushWarspike());
        inventory.add(armorFactory.createDawnplateJerkin());
        inventory.add(restorativesFactory.createGreaterHealthPotion());
        inventory.add(restorativesFactory.createGreaterHealthPotion());
        inventory.add(restorativesFactory.createGreaterHealthPotion());
        inventory.add(boostersFactory.createDefenseOintment());
        inventory.add(mageWeaponFactory.createGlimmerrootStaff());
        inventory.add(mageWeaponFactory.createGlimmerrootStaff());
        inventory.add(debuffersFactory.createAcidVial());
        inventory.add(debuffersFactory.createAcidVial());
        inventory.add(utilitiesFactory.createSmokeGrenade());
        inventory.add(utilitiesFactory.createSmokeGrenade());
        inventory.add(accessoryFactory.createRiftbinderRing());
        inventory.add(accessoryFactory.createRiftbinderRing());
        inventory.add(accessoryFactory.createRiftbinderRing());
        inventory.add(restorativesFactory.createDualElixir());
        inventory.add(restorativesFactory.createDualElixir());
        inventory.add(restorativesFactory.createDualElixir());
        inventory.add(restorativesFactory.createDualElixir());
        inventory.add(boostersFactory.createCriticalElixir());
        inventory.add(boostersFactory.createCriticalElixir());
    }
}