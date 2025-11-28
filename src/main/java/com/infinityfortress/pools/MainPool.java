package com.infinityfortress.pools;

import java.util.ArrayList;
import java.util.Random;

import com.infinityfortress.items.equipments.*;


public class MainPool {
  public static Equipment getRandomForgedEquipment() {
    ArrayList<Equipment> equipment = new ArrayList<>();
    
    equipment.addAll(getForgedArmor());
    equipment.addAll(getForgedWeapons());
    
    Random rand = new Random();
    int randomIndex = rand.nextInt(equipment.size());
    return equipment.get(randomIndex);
  }
  
  public static Equipment getRandomEnchantedEquipment() {
    ArrayList<Equipment> equipment = new ArrayList<>();
    
    equipment.addAll(getEnchantedArmor());
    equipment.addAll(getEnchantedWeapons());
    equipment.addAll(getEnchantedAccessories());
    
    Random rand = new Random();
    int randomIndex = rand.nextInt(equipment.size());
    return equipment.get(randomIndex);
  }
  
  public static Equipment getRandomMysticEquipment() {
    ArrayList<Equipment> equipment = new ArrayList<>();
    
    equipment.addAll(getMysticArmor());
    equipment.addAll(getMysticWeapons());
    equipment.addAll(getMysticAccessories());
    
    Random rand = new Random();
    int randomIndex = rand.nextInt(equipment.size());
    return equipment.get(randomIndex);
  }

  public static Equipment getRandomEtherealEquipment() {
    ArrayList<Equipment> equipment = new ArrayList<>();
    
    equipment.addAll(getEtherealArmor());
    equipment.addAll(getEtherealWeapons());
    equipment.addAll(getEtherealAccessories());
    
    Random rand = new Random();
    int randomIndex = rand.nextInt(equipment.size());
    return equipment.get(randomIndex);
  }
  
  public static Equipment getRandomAscEquipment() {
    ArrayList<Equipment> equipment = new ArrayList<>();
    
    equipment.addAll(getAscArmor());
    equipment.addAll(getAscWeapons());
    equipment.addAll(getAscAccessories());
    
    Random rand = new Random();
    int randomIndex = rand.nextInt(equipment.size());
    return equipment.get(randomIndex);
  }

  // RANDOM EQUIPMENT BY TYPE AND RARITY

  // MYSTIC
  public static Equipment getRandomMysticArmor() {
    ArrayList<Equipment> armor = getMysticArmor();
    Random rand = new Random();
    int randomIndex = rand.nextInt(armor.size());
    return armor.get(randomIndex);
  }

  public static Equipment getRandomMysticWeapon() {
    ArrayList<Equipment> weapons = getMysticWeapons();
    Random rand = new Random();
    int randomIndex = rand.nextInt(weapons.size());
    return weapons.get(randomIndex);
  }

  public static Equipment getRandomMysticAccessory() {
    ArrayList<Equipment> accessories = getMysticAccessories();
    Random rand = new Random();
    int randomIndex = rand.nextInt(accessories.size());
    return accessories.get(randomIndex);
  }

  // ETHEREAL
  public static Equipment getRandomEtherealArmor() {
    ArrayList<Equipment> armor = getEtherealArmor();
    Random rand = new Random();
    int randomIndex = rand.nextInt(armor.size());
    return armor.get(randomIndex);
  }

  public static Equipment getRandomEtherealWeapon() {
    ArrayList<Equipment> weapons = getEtherealWeapons();
    Random rand = new Random();
    int randomIndex = rand.nextInt(weapons.size());
    return weapons.get(randomIndex);
  }

  public static Equipment getRandomEtherealAccessory() {
    ArrayList<Equipment> accessories = getEtherealAccessories();
    Random rand = new Random();
    int randomIndex = rand.nextInt(accessories.size());
    return accessories.get(randomIndex);
  }

  // ASC
  public static Equipment getRandomAscArmor() {
    ArrayList<Equipment> armor = getAscArmor();
    Random rand = new Random();
    int randomIndex = rand.nextInt(armor.size());
    return armor.get(randomIndex);
  }

  public static Equipment getRandomAscWeapon() {
    ArrayList<Equipment> weapons = getAscWeapons();
    Random rand = new Random();
    int randomIndex = rand.nextInt(weapons.size());
    return weapons.get(randomIndex);
  }

  public static Equipment getRandomAscAccessory() {
    ArrayList<Equipment> accessories = getAscAccessories();
    Random rand = new Random();
    int randomIndex = rand.nextInt(accessories.size());
    return accessories.get(randomIndex);
  }


  // FORGED EQUIPMENT
  public static ArrayList<Equipment> getForgedArmor() {
    ArrayList<Equipment> armor = new ArrayList<>();
    ArmorFactory factory = new ArmorFactory();
    
    armor.add(factory.createLeatherVestment());
    armor.add(factory.createAshenvaleRobe());
    armor.add(factory.createDawnplateJerkin());
    armor.add(factory.createUmbracowlRaiment());
    armor.add(factory.createSunsteelMail());
    armor.add(factory.createEbonveilCarapace());
    
    return armor;
  }

  public static ArrayList<Equipment> getForgedWeapons() {
    ArrayList<Equipment> weapons = new ArrayList<>();
    
    // WARRIOR WEAPONS
    WarriorWeaponFactory warriorFactory = new WarriorWeaponFactory();
    weapons.add(warriorFactory.createRustbiteLongSword());
    weapons.add(warriorFactory.createBonecrushWarspike());
    weapons.add(warriorFactory.createForgebornBroadsword());
    
    // MAGE WEAPONS
    MageWeaponFactory mageFactory = new MageWeaponFactory();
    weapons.add(mageFactory.createAshenwoodWand());
    weapons.add(mageFactory.createGlimmerrootStaff());
    weapons.add(mageFactory.createFrostpetalWand());
    
    // ARCHER WEAPONS
    ArcherWeaponFactory archerFactory = new ArcherWeaponFactory();
    weapons.add(archerFactory.createThornstrikeBow());
    weapons.add(archerFactory.createWindwhisperSlingshot());
    weapons.add(archerFactory.createEmberrootShortbow());
    
    // TANK WEAPONS
    TankWeaponFactory tankFactory = new TankWeaponFactory();
    weapons.add(tankFactory.createIroncladShield());
    weapons.add(tankFactory.createWarbreakerHammer());
    weapons.add(tankFactory.createBastionGauntlets());
    
    // ROGUE WEAPONS
    RogueWeaponFactory rogueFactory = new RogueWeaponFactory();
    weapons.add(rogueFactory.createRustfangDagger());
    weapons.add(rogueFactory.createShadowbiteClaws());
    weapons.add(rogueFactory.createTwinsteelShivs());
    
    // HEALER WEAPONS
    HealerWeaponFactory healerFactory = new HealerWeaponFactory();
    weapons.add(healerFactory.createSanctumIcon());
    weapons.add(healerFactory.createLifebloomMedallion());
    weapons.add(healerFactory.createCelestineGlobe());
    
    // CLERIC WEAPONS
    ClericWeaponFactory clericFactory = new ClericWeaponFactory();
    weapons.add(clericFactory.createSanctumMace());
    weapons.add(clericFactory.createDawnspireCenser());
    weapons.add(clericFactory.createRadiantScepter());
    weapons.add(clericFactory.createLuminalRod());
    
    // SUMMONER WEAPONS
    SummonerWeaponFactory summonerFactory = new SummonerWeaponFactory();
    weapons.add(summonerFactory.createGlimmeringTotem());
    weapons.add(summonerFactory.createWhisperingCodex());
    
    // WARLOCK WEAPONS
    WarlockWeaponFactory warlockFactory = new WarlockWeaponFactory();
    weapons.add(warlockFactory.createAshenCursedScroll());
    weapons.add(warlockFactory.createShadowboundCursedScroll());
    weapons.add(warlockFactory.createWitheredCursedScroll());
    
    return weapons;
  }

  // ENCHANTED EQUIPMENT
  public static ArrayList<Equipment> getEnchantedArmor() {
    ArrayList<Equipment> armor = new ArrayList<>();
    ArmorFactory factory = new ArmorFactory();
    
    armor.add(factory.createShadowveilCloak());
    armor.add(factory.createSolariumSilks());
    armor.add(factory.createBlightwovenGuard());
    armor.add(factory.createAstranMantle());
    armor.add(factory.createShadowlaceMantle());
    armor.add(factory.createLoomianJerkin());
    
    return armor;
  }

  public static ArrayList<Equipment> getEnchantedAccessories() {
    ArrayList<Equipment> accessories = new ArrayList<>();
    AccessoryFactory factory = new AccessoryFactory();
    
    accessories.add(factory.createHaloOfSolara());
    accessories.add(factory.createRiftbinderRing());
    accessories.add(factory.createEmberstrideBoots());
    accessories.add(factory.createRadixianVisor());
    accessories.add(factory.createObsiwrathHelm());
    accessories.add(factory.createSanctiumGrasp());
    accessories.add(factory.createHexedGloves());
    accessories.add(factory.createVisageOfSerenity());
    accessories.add(factory.createHollowedEchoMask());
    accessories.add(factory.createAscensionCharm());
    accessories.add(factory.createDawningFaithCrest());
    accessories.add(factory.createMascariumSigil());
    accessories.add(factory.createSeraphineEffigy());
    accessories.add(factory.createMiramoreMarionette());
    accessories.add(factory.createNightbloomShackle());
    accessories.add(factory.createDawnlinkBand());
    accessories.add(factory.createBloodshardBracelet());
    
    return accessories;
  }

  public static ArrayList<Equipment> getEnchantedWeapons() {
    ArrayList<Equipment> weapons = new ArrayList<>();
    
    // WARRIOR WEAPONS
    WarriorWeaponFactory warriorFactory = new WarriorWeaponFactory();
    weapons.add(warriorFactory.createKnightsSaber());
    weapons.add(warriorFactory.createBloodforgeWaraxe());
    weapons.add(warriorFactory.createSentinelsHalberd());
    
    // MAGE WEAPONS
    MageWeaponFactory mageFactory = new MageWeaponFactory();
    weapons.add(mageFactory.createSolarisChanneler());
    weapons.add(mageFactory.createRuneboundStaff());
    weapons.add(mageFactory.createEchoheartFocus());
    
    // ARCHER WEAPONS
    ArcherWeaponFactory archerFactory = new ArcherWeaponFactory();
    weapons.add(archerFactory.createMoonveilLongbow());
    weapons.add(archerFactory.createStormpiercerComposite());
    
    // TANK WEAPONS
    TankWeaponFactory tankFactory = new TankWeaponFactory();
    weapons.add(tankFactory.createVanguardsBulwark());
    weapons.add(tankFactory.createOathforgedShield());
    weapons.add(tankFactory.createStormhammerGauntlets());
    
    // ROGUE WEAPONS
    RogueWeaponFactory rogueFactory = new RogueWeaponFactory();
    weapons.add(rogueFactory.createVenomlashDaggers());
    weapons.add(rogueFactory.createBloodtraceChakrams());
    weapons.add(rogueFactory.createWhisperfangBlades());
    
    // HEALER WEAPONS
    HealerWeaponFactory healerFactory = new HealerWeaponFactory();
    weapons.add(healerFactory.createVerdantCrucible());
    weapons.add(healerFactory.createMoonlitTalisman());
    weapons.add(healerFactory.createAuroraSphere());
    
    // CLERIC WEAPONS
    ClericWeaponFactory clericFactory = new ClericWeaponFactory();
    weapons.add(clericFactory.createHalobrandMace());
    weapons.add(clericFactory.createLumenicAegis());
    weapons.add(clericFactory.createAuricMedallion());
    weapons.add(clericFactory.createBlessedCrucible());
    
    // SUMMONER WEAPONS
    SummonerWeaponFactory summonerFactory = new SummonerWeaponFactory();
    weapons.add(summonerFactory.createStarwovenGrimoire());
    weapons.add(summonerFactory.createArcsainIdol());
    
    // WARLOCK WEAPONS
    WarlockWeaponFactory warlockFactory = new WarlockWeaponFactory();
    weapons.add(warlockFactory.createNightfallCodex());
    weapons.add(warlockFactory.createPhantomCodex());
    weapons.add(warlockFactory.createObsiviousCodex());
    
    return weapons;
  }

  // MYSTIC EQUIPMENT
  public static ArrayList<Equipment> getMysticArmor() {
    ArrayList<Equipment> armor = new ArrayList<>();
    ArmorFactory factory = new ArmorFactory();
    
    armor.add(factory.createDreadfangCloak());
    armor.add(factory.createAuroralVestment());
    armor.add(factory.createNightfangHauberk());
    armor.add(factory.createLuminarisCuirass());
    armor.add(factory.createShadowlynxCarapace());
    armor.add(factory.createHalcyonGuard());
    
    return armor;
  }

  public static ArrayList<Equipment> getMysticAccessories() {
    ArrayList<Equipment> accessories = new ArrayList<>();
    AccessoryFactory factory = new AccessoryFactory();
    
    accessories.add(factory.createTwinlightCirclet());
    accessories.add(factory.createDawnsongStuds());
    accessories.add(factory.createWhispercoilEarrings());
    accessories.add(factory.createVeilstepTreads());
    accessories.add(factory.createDawnwatchersHelm());
    accessories.add(factory.createLumenPathCloak());
    accessories.add(factory.createEndlessNightShroud());
    accessories.add(factory.createAureusMark());
    accessories.add(factory.createHexrootTalisman());
    accessories.add(factory.createCelestineAnklet());
    accessories.add(factory.createDualityTotem());
    accessories.add(factory.createMirrorveilMask());
    accessories.add(factory.createSunpierceQuiver());
    accessories.add(factory.createWillowfangQuiver());
    accessories.add(factory.createBloomOfHalcyon());
    accessories.add(factory.createGravepetalBlossom());
    accessories.add(factory.createVitalousCrystal());
    accessories.add(factory.createEnergiumMeteor());
    accessories.add(factory.createObsidianheartCore());
    accessories.add(factory.createEarthshatterSarsen());
    accessories.add(factory.createWhizzapEmber());
    accessories.add(factory.createSoulpiercerPrism());
    accessories.add(factory.createCalamiteShard());
    accessories.add(factory.createSerenditeGem());
    
    return accessories;
  }

  public static ArrayList<Equipment> getMysticWeapons() {
    ArrayList<Equipment> weapons = new ArrayList<>();
    
    // WARRIOR WEAPONS
    WarriorWeaponFactory warriorFactory = new WarriorWeaponFactory();
    weapons.add(warriorFactory.createKingsguardBastionblade());
    weapons.add(warriorFactory.createDragospireEarthgnasher());
    
    // MAGE WEAPONS
    MageWeaponFactory mageFactory = new MageWeaponFactory();
    weapons.add(mageFactory.createStarcallersBeacon());
    weapons.add(mageFactory.createOblivionScepter());
    
    // ARCHER WEAPONS
    ArcherWeaponFactory archerFactory = new ArcherWeaponFactory();
    weapons.add(archerFactory.createFalconsPride());
    weapons.add(archerFactory.createSunflareHarbinger());
    
    // TANK WEAPONS
    TankWeaponFactory tankFactory = new TankWeaponFactory();
    weapons.add(tankFactory.createEarthshatterWarhammer());
    weapons.add(tankFactory.createSanctumbreakerGauntlets());
    
    // ROGUE WEAPONS
    RogueWeaponFactory rogueFactory = new RogueWeaponFactory();
    weapons.add(rogueFactory.createNightreaverClaws());
    weapons.add(rogueFactory.createEclipsingChakrams());
    
    // HEALER WEAPONS
    HealerWeaponFactory healerFactory = new HealerWeaponFactory();
    weapons.add(healerFactory.createEvergloamSigil());
    weapons.add(healerFactory.createRadiantPendant());
    
    // CLERIC WEAPONS
    ClericWeaponFactory clericFactory = new ClericWeaponFactory();
    weapons.add(clericFactory.createSolsticeWarrod());
    weapons.add(clericFactory.createAetheriumGavel());
    weapons.add(clericFactory.createDivinePhylactery());
    
    // SUMMONER WEAPONS
    SummonerWeaponFactory summonerFactory = new SummonerWeaponFactory();
    weapons.add(summonerFactory.createTotemOfTheDawn());
    weapons.add(summonerFactory.createShadowbindTome());
    
    // WARLOCK WEAPONS
    WarlockWeaponFactory warlockFactory = new WarlockWeaponFactory();
    weapons.add(warlockFactory.createEbonflareStaff());
    weapons.add(warlockFactory.createSoulrenderStaff());
    
    return weapons;
  }

  // ETHEREAL EQUIPMENT
  public static ArrayList<Equipment> getEtherealArmor() {
    ArrayList<Equipment> armor = new ArrayList<>();
    ArmorFactory factory = new ArmorFactory();
    
    armor.add(factory.createSolarflareSolarion());
    armor.add(factory.createDamnationWraithguard());
    armor.add(factory.createAurorionWing());
    armor.add(factory.createAnyxionShroud());
    
    return armor;
  }

  public static ArrayList<Equipment> getEtherealAccessories() {
    ArrayList<Equipment> accessories = new ArrayList<>();
    AccessoryFactory factory = new AccessoryFactory();
    
    accessories.add(factory.createAstralineHoops());
    accessories.add(factory.createHorianwalkGreaves());
    accessories.add(factory.createEclipsiumMantle());
    accessories.add(factory.createAstranforgedGauntlets());
    accessories.add(factory.createSpiritbinderPendant());
    accessories.add(factory.createEquinoxCuffs());
    
    return accessories;
  }

  public static ArrayList<Equipment> getEtherealWeapons() {
    ArrayList<Equipment> weapons = new ArrayList<>();
    
    // WARRIOR WEAPONS
    WarriorWeaponFactory warriorFactory = new WarriorWeaponFactory();
    weapons.add(warriorFactory.createLionheartClaymore());
    weapons.add(warriorFactory.createEssenclysticSkullsplitter());
    
    // MAGE WEAPONS
    MageWeaponFactory mageFactory = new MageWeaponFactory();
    weapons.add(mageFactory.createLuminousSpire());
    weapons.add(mageFactory.createChaosveilCatalyst());
    weapons.add(mageFactory.createEterniumSoulspire());
    
    // ARCHER WEAPONS
    ArcherWeaponFactory archerFactory = new ArcherWeaponFactory();
    weapons.add(archerFactory.createAetherstringVanguard());
    weapons.add(archerFactory.createSoulpiercerArbalest());
    weapons.add(archerFactory.createBloodmoonReaver());
    
    // TANK WEAPONS
    TankWeaponFactory tankFactory = new TankWeaponFactory();
    weapons.add(tankFactory.createHeavensunderMaul());
    weapons.add(tankFactory.createSeraphicBulwark());
    weapons.add(tankFactory.createAegisOfTheTitans());
    
    // ROGUE WEAPONS
    RogueWeaponFactory rogueFactory = new RogueWeaponFactory();
    weapons.add(rogueFactory.createDreadveilKnives());
    weapons.add(rogueFactory.createGloombiteTalons());
    weapons.add(rogueFactory.createVeilpiercerChakrams());
    
    // HEALER WEAPONS
    HealerWeaponFactory healerFactory = new HealerWeaponFactory();
    weapons.add(healerFactory.createEthereonSanctifier());
    weapons.add(healerFactory.createSoulweaverAegis());
    weapons.add(healerFactory.createLuminalNexus());
    
    // CLERIC WEAPONS
    ClericWeaponFactory clericFactory = new ClericWeaponFactory();
    weapons.add(clericFactory.createAurealiumLuminar());
    weapons.add(clericFactory.createCelestivigilSeraphim());
    
    // SUMMONER WEAPONS
    SummonerWeaponFactory summonerFactory = new SummonerWeaponFactory();
    weapons.add(summonerFactory.createSoulforgeLexicon());
    weapons.add(summonerFactory.createEffigyOfTheDamned());
    
    // WARLOCK WEAPONS
    WarlockWeaponFactory warlockFactory = new WarlockWeaponFactory();
    weapons.add(warlockFactory.createDoombringerSigil());
    
    return weapons;
  }

  // ASC EQUIPMENT
  public static ArrayList<Equipment> getAscArmor() {
    ArrayList<Equipment> armor = new ArrayList<>();
    ArmorFactory factory = new ArmorFactory();
    
    armor.add(factory.createJudgmentAscSkin());
    
    return armor;
  }

  public static ArrayList<Equipment> getAscAccessories() {
    ArrayList<Equipment> accessories = new ArrayList<>();
    AccessoryFactory factory = new AccessoryFactory();
    
    accessories.add(factory.createEternityAscMark());
    accessories.add(factory.createOminousAscCatalyst());
    
    return accessories;
  }

  public static ArrayList<Equipment> getAscWeapons() {
    ArrayList<Equipment> weapons = new ArrayList<>();
    
    // WARRIOR WEAPONS
    WarriorWeaponFactory warriorFactory = new WarriorWeaponFactory();
    weapons.add(warriorFactory.createAscWyngardeBlade());
    
    // MAGE WEAPONS
    MageWeaponFactory mageFactory = new MageWeaponFactory();
    weapons.add(mageFactory.createAscMagusAeonPrism());
    
    // ARCHER WEAPONS
    ArcherWeaponFactory archerFactory = new ArcherWeaponFactory();
    weapons.add(archerFactory.createAscAvarinPinaka());
    
    // TANK WEAPONS
    TankWeaponFactory tankFactory = new TankWeaponFactory();
    weapons.add(tankFactory.createAscTarkoitusvoimaPavise());
    
    // ROGUE WEAPONS
    RogueWeaponFactory rogueFactory = new RogueWeaponFactory();
    weapons.add(rogueFactory.createAscRhaenKris());
    
    // HEALER WEAPONS
    HealerWeaponFactory healerFactory = new HealerWeaponFactory();
    weapons.add(healerFactory.createAscHalienRod());
    
    // CLERIC WEAPONS
    ClericWeaponFactory clericFactory = new ClericWeaponFactory();
    weapons.add(clericFactory.createAscCaeloraCenser());
    
    // SUMMONER WEAPONS
    SummonerWeaponFactory summonerFactory = new SummonerWeaponFactory();
    weapons.add(summonerFactory.createAscSangreHeart());
    
    // WARLOCK WEAPONS
    WarlockWeaponFactory warlockFactory = new WarlockWeaponFactory();
    weapons.add(warlockFactory.createAscWrynnorTome());
    
    return weapons;
  }
}
