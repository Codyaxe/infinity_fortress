package com.infinityfortress.Temp;

import java.util.Random;

import com.infinityfortress.Temp.Types.*;
import com.infinityfortress.equipments.Equipment;

import java.util.ArrayList;
import java.util.List;

public class EquipmentFactory {
    
    private static final Random random = new Random();
    
    // Weapon data arrays for each role
    private static final WeaponData[] WARRIOR_WEAPONS = {
        new WeaponData("Rustbite Longsword", 6, 0, 2, 4, 0, 0, 0, "A blade corroded yet deadly, its jagged edge bites deeper with every strike."),
        new WeaponData("Bonecrush Warspike", 8, 0, 3, 5, 0, 0, 0, "Forged from shattered bones of ancient beasts, it delivers crushing force with each thrust."),
        new WeaponData("Forgeborn Broadsword", 12, 0, 5, 7, 0, 0, 0, "Tempered in volcanic fires, it swings with relentless power and unyielding weight."),
        new WeaponData("Knight's Sabre", 16, 0, 7, 9, 0, 0, 0, "Etched with honor-bound runes, its gleam inspires courage in allies and fear in foes."),
        new WeaponData("Bloodforge Waraxe", 18, 0, 6, 12, 0, 0, 0, "Born in sacrificial flames, each swing drips with the echoes of past battles."),
        new WeaponData("Sentinel's Halberd", 21, 0, 7, 14, 0, 0, 0, "A weapon of defense and offense, it guards its wielder while punishing intruders."),
        new WeaponData("Kingsguard Bastionblade", 23, 0, 9, 14, 0, 0, 0, "Carved for royalty, its steel holds the might of an empire in every strike."),
        new WeaponData("Dragospire Earthgnasher", 25, 0, 8, 17, 0, 0, 0, "Fused with dragonbone, its bite crushes armor as easily as stone."),
        new WeaponData("Lionheart Claymore", 28, 0, 2, 20, 6, 0, 0, "Forged with valor, its swings embody the courage of lions long past."),
        new WeaponData("Essenclystic Skullsplitter", 28, 0, 3, 25, 0, 0, 0, "Born of forbidden pacts, it siphons life with every swing, leaving Warlocks' foes weakened and the wielder hungering for more essence.")
    };
    
    private static final WeaponData[] ARCHER_WEAPONS = {
        new WeaponData("Thornstrike Bow", 7, 0, 0, 4, 1, 2, 0, "Crafted from bramblewood, its arrows tear through armor like wild thorns through flesh."),
        new WeaponData("Windwhisper Slingshot", 9, 0, 0, 1, 4, 4, 0, "Its light frame bends air itself, sending pebbles swift and silent as a breeze."),
        new WeaponData("Emberroot Shortbow", 12, 0, 0, 5, 3, 4, 0, "Flames pulse beneath its bark, each shot leaving trails of burning cinders."),
        new WeaponData("Moonveil Longbow", 15, 0, 0, 4, 7, 4, 0, "Strung with lunar silk, its arrows shimmer with calm precision under moonlight."),
        new WeaponData("Stormpiercer Composite", 18, 0, 0, 6, 6, 6, 0, "Sparks crackle along its limbs, channeling thunder through every piercing release."),
        new WeaponData("Falcon's Pride", 20, 0, 0, 7, 8, 5, 0, "A hunter's companion bound by spirit, its aim never wavers even at impossible range."),
        new WeaponData("Sunflare Harbinger", 23, 0, 0, 9, 8, 6, 0, "Forged in dawnfire, it unleashes arrows blazing bright enough to blind the unworthy."),
        new WeaponData("Aetherstring Vanguard", 26, 0, 0, 8, 10, 7, 0, "Its ethereal string hums with power drawn from unseen winds and astral currents."),
        new WeaponData("Soulpiercer Arbalest", 30, 0, 0, 15, 5, 10, 0, "Each arrow carries immense spiritual weight; slower draw, deadlier impact."),
        new WeaponData("Bloodmoon Reaver", 30, 0, 0, 10, 10, 10, 0, "Under the crimson moon, its bolts feast upon the life force of its prey.")
    };
    
    private static final WeaponData[] MAGE_WEAPONS = {
        new WeaponData("Ashenwood Wand", 5, 2, 0, 3, 0, 0, 0, "Carved from charred oak imbued with lingering flame, channeling primal fire with every flick."),
        new WeaponData("Glimmerroot Staff", 8, 3, 0, 5, 0, 0, 0, "Grown beneath moonlight, its roots still hum with the whispers of arcane nature."),
        new WeaponData("Frostpetal Wand", 13, 5, 0, 8, 0, 0, 0, "A fragile bloom of frozen mana, releasing sharp bursts of winter's grace."),
        new WeaponData("Solaris Channeler", 15, 7, 0, 8, 0, 0, 0, "Forged in sunfire, it radiates warmth that burns away darkness and doubt."),
        new WeaponData("Runebound Staff", 19, 10, 0, 9, 0, 0, 0, "Every rune glows faintly, a silent hymn binding ancient wisdom to the wielder's will."),
        new WeaponData("Echoheart Focus", 20, 5, 0, 7, 5, 3, 0, "The crystal within hums with voices of past sorcerers, echoing forgotten incantations."),
        new WeaponData("Starcaller's Beacon", 23, 6, 0, 7, 5, 5, 0, "A celestial conduit that draws strength from constellations long erased from mortal maps."),
        new WeaponData("Oblivion Scepter", 26, -5, 5, 16, 5, 5, 0, "Its obsidian core consumes stray light, conjuring shadows that obey no master."),
        new WeaponData("Luminous Spire", 29, 14, 0, 15, 0, 0, 0, "A towering beacon of pure light magic, harnessed for unwavering power."),
        new WeaponData("Chaosveil Catalyst", 29, 10, 0, 14, -5, 10, 0, "Unstable energy swirls within, risking collapse for immense burst."),
        new WeaponData("Eternium Soulspire", 30, 5, 0, 10, 10, 5, 0, "Forged from the last fragment of timeless magic, it hums with eternity's pulse and bends mana to the caster's will.")
    };
    
    private static final WeaponData[] TANK_WEAPONS = {
        new WeaponData("Ironclad Shield", 5, 0, 4, 1, 0, 0, 0, "A steadfast shield of tempered steel, absorbing blows and anchoring defenders at the heart of battle."),
        new WeaponData("Warbreaker Hammer", 9, 0, 4, 5, 0, 0, 0, "A brutal hammer designed to shatter armor and bones alike, punishing those who dare approach."),
        new WeaponData("Bastion Gauntlets", 13, 0, 8, 7, 0, 0, 0, "Heavy gauntlets crafted for parries and blocks, turning enemy strikes into harmless echoes."),
        new WeaponData("Vanguard's Bulwark", 16, 0, 10, 6, 0, 0, 0, "An enchanted shield that bolsters allies' courage while deflecting attacks with uncanny precision."),
        new WeaponData("Oathforged Shield", 18, 0, 13, 3, 0, 0, 0, "Bound by solemn vows, it protects allies and embodies the resolve of its wielder."),
        new WeaponData("Stormhammer Gauntlets", 21, 0, 12, 9, 0, 0, 0, "Gauntlets crackling with lightning, smashing foes while guarding the frontline with electric force."),
        new WeaponData("Earthshatter Warhammer", 23, 0, 10, 13, 0, 0, 0, "A titan-forged hammer that shakes the battlefield, crushing armor and morale in equal measure."),
        new WeaponData("Sanctumbreaker Gauntlets", 26, 0, 13, 13, 0, 0, 0, "Crafted for sieges and champions, they punch through walls and enemy lines with devastating might."),
        new WeaponData("Heavensunder Maul", 28, 0, 10, 18, 0, 0, 0, "Wielded by chosen defenders, each swing reverberates with divine force, breaking the strongest of foes."),
        new WeaponData("Seraphic Bulwark", 28, 0, 18, 10, 0, 0, 0, "A radiant shield blessed by celestial power, inspiring allies and turning aside even the fiercest assaults."),
        new WeaponData("Aegis of the Titans", 30, 0, 20, 10, 0, 0, 0, "A legendary shield of unmatched might, unyielding against any assault and inspiring allies to defy fate itself.")
    };
    
    private static final WeaponData[] ROGUE_WEAPONS = {
        new WeaponData("Rustfang Dagger", 5, 1, 0, 1, 1, 0, 2, "A rusted blade concealing deadly sharpness, striking unseen and leaving foes to wonder what hit them."),
        new WeaponData("Shadowbite Claws", 9, 2, 0, 1, 1, 1, 4, "Forged in darkness, these claws tear flesh with silent precision, perfect for ambushes."),
        new WeaponData("Twinsteel Shivs", 11, 1, 0, 2, 1, 2, 5, "Paired blades for swift, twin strikes; each cut quick, silent, and merciless."),
        new WeaponData("Venomlash Daggers", 15, 4, 0, 1, 2, 1, 7, "Daggers coated in potent toxin, each slash drains life and sows fear."),
        new WeaponData("Bloodtrace Chakrams", 17, 3, 0, 1, 2, 4, 7, "Spinning with lethal precision in close quarters, each slash leaves a trail of crimson and fear."),
        new WeaponData("Whisperfang Blades", 20, 3, 0, 3, 1, 3, 10, "Silent as a shadow, sharp as a fang; every strike whispers death."),
        new WeaponData("Nightreaver Claws", 23, 3, 0, 4, 4, 3, 9, "Perfect for prowling predators, they slice silently and vanish before retaliation."),
        new WeaponData("Eclipsing Chakrams", 27, 4, 0, 5, 4, 4, 10, "Moon-forged discs whirling in deadly arcs, striking foes with shadowed elegance."),
        new WeaponData("Dreadveil Knives", 29, 0, 0, 5, 7, 10, 7, "Every slash siphons the essence of your foe, striking with lethal precision; only the most daring rogues can wield its ruthless edge."),
        new WeaponData("Gloombite Talons", 29, 6, 0, 7, 2, 7, 11, "Forged for the shadows, each claw strikes with cunning force; skill and timing amplify its deadly potential in every encounter."),
        new WeaponData("Veilpiercer Chakrams", 30, 2, 0, 3, 5, 5, 15, "Luck guides each spinning blade, slicing unseen through defenses; a rogue's touch makes the improbable strike inevitable.")
    };
    
    private static final WeaponData[] HEALER_WEAPONS = {
        new WeaponData("Sanctum Icon", 5, 3, 0, 2, 0, 0, 0, "A sacred emblem radiating calm, channeling restorative energy to mend wounds with gentle precision."),
        new WeaponData("Lifebloom Medallion", 8, 4, 0, 3, 0, 0, 1, "Infused with the essence of life, it subtly accelerates healing for allies within its soothing aura."),
        new WeaponData("Celestine Globe", 12, 6, 0, 4, 0, 0, 2, "Glowing with celestial light, it nurtures vitality and rejuvenates even the weariest of hearts."),
        new WeaponData("Verdant Crucible", 15, 8, 0, 5, 0, 0, 2, "A verdant vessel of nature's power, empowering the healer to mend grievous injuries swiftly."),
        new WeaponData("Moonlit Talisman", 19, 10, 0, 5, 0, 0, 4, "Bathed in silver light, its charm enhances the strength of restorative magic under any night sky."),
        new WeaponData("Aurora Sphere", 20, 9, 0, 5, 0, 0, 6, "Shimmering with prismatic hues, each pulse restores vigor to allies, weaving a veil of protection."),
        new WeaponData("Evergloam Sigil", 23, 12, 0, 6, 0, 0, 5, "A mystical sigil resonating with twilight energy, it bolsters the healer's command over life's flow."),
        new WeaponData("Radiant Pendant", 26, 14, 0, 6, 0, 0, 6, "Encased in radiant crystal, it channels pure restorative force, sustaining allies in the heat of battle."),
        new WeaponData("Ethereon Sanctifier", 29, 16, 0, 7, 0, 0, 6, "Forged from ethereal essence, it sanctifies wounds with unmatched potency, turning pain into fleeting whispers."),
        new WeaponData("Soulweaver Aegis", 30, 7, 0, 15, 0, 0, 8, "Threads of souls entwine within, subtly mending and empowering, binding life's fragility to the healer's will."),
        new WeaponData("Luminal Nexus", 30, 20, 0, 5, 0, 0, 5, "A nexus of pure light, it radiates restorative energy, guiding allies from the brink with unwavering grace.")
    };
    
    private static final WeaponData[] SUMMONER_WEAPONS = {
        new WeaponData("Glimmering Totem", 7, 2, 0, 1, 0, 0, 4, "A humble totem that whispers guidance to fledgling summoners, awakening faint echoes of the spirits it channels."),
        new WeaponData("Whispering Codex", 11, 3, 0, 2, 0, 0, 6, "Ancient pages hum softly, sharing secrets of the beyond with those daring enough to read its veiled words."),
        new WeaponData("Starwoven Grimoire", 16, 5, 0, 3, 0, 0, 8, "Celestial patterns etched in its cover guide summoners to weave powerful, fleeting starlight into their minions."),
        new WeaponData("Arcsain Idol", 19, 6, 0, 4, 0, 0, 9, "Carved from rare etherwood, it pulses with latent magic, encouraging spirits to rally at the summoner's will."),
        new WeaponData("Totem of the Dawn", 23, 8, 0, 5, 0, 0, 10, "A radiant totem imbued with the first light of day, invigorating summoned allies with renewed strength and hope."),
        new WeaponData("Shadowbind Tome", 26, 10, 0, 6, 0, 0, 10, "Dark ink seeps with binding spells, compelling spirits to obey the summoner's command with ruthless precision."),
        new WeaponData("Soulforge Lexicon", 28, 12, 0, 7, 0, 0, 9, "Each word etched into its pages burns with the fire of creation, empowering minions beyond mortal limits."),
        new WeaponData("Effigy of the Damned", 28, 8, 0, 5, 0, 0, 15, "Cursed and feared, it draws upon condemned spirits, magnifying the summoner's luck while sowing despair among enemies."),
        new WeaponData("Asc Void Heart", 40, 15, 5, 10, 0, 0, 10, "A rare artifact of forbidden design, it twists the void itself, calling forth titanic entities whose loyalty is as fleeting as their summoned power.")
    };
    
    private static final WeaponData[] CLERIC_WEAPONS = {
        new WeaponData("Sanctum Mace", 6, 1, 0, 1, 0, 0, 4, "A simple yet holy weapon, it channels the light of the sanctuary to mend wounds and bolster faith."),
        new WeaponData("Dawnspire Censer", 9, 3, 0, 2, 0, 0, 4, "Its incense burns with the first light of dawn, uplifting allies and purging darkness from their spirits."),
        new WeaponData("Radiant Scepter", 10, 2, 0, 3, 0, 0, 5, "Each strike releases a pulse of divine energy, healing the faithful and smiting the unworthy."),
        new WeaponData("Luminal Rod", 13, 4, 0, 4, 0, 0, 5, "Glowing softly, it bridges mortal hands and celestial power, guiding prayers into potent restoration."),
        new WeaponData("Halobrand Mace", 14, 3, 0, 5, 0, 0, 6, "Forged in sacred fires, it carries a halo of power, strengthening the resolve of those it defends."),
        new WeaponData("Lumenic Aegis", 17, 4, 0, 6, 0, 0, 7, "A protective emblem, radiating light that shields companions while nourishing their vitality."),
        new WeaponData("Auric Medallion", 19, 4, 0, 6, 0, 0, 9, "Gleaming with golden energy, it inspires courage and invigorates allies through the faith it embodies."),
        new WeaponData("Blessed Crucible", 21, 5, 0, 7, 0, 0, 9, "Imbued with sanctified essence, it channels restorative magic, mending wounds and fortifying spirits alike."),
        new WeaponData("Solstice Warrod", 23, 5, 0, 8, 0, 0, 10, "Harnessing the zenith of sunlight, it empowers healing strikes and invigorates the weary."),
        new WeaponData("Aetherium Gavel", 25, 3, 0, 9, 0, 0, 13, "A majestic instrument of divine judgement, strengthening resolve and empowering miracles beyond the ordinary."),
        new WeaponData("Divine Phylactery", 27, 8, 0, 7, 0, 0, 12, "Encased in sacred relics, it amplifies blessings and anchors the faith of those nearby."),
        new WeaponData("Aurealium Luminar", 30, 7, 0, 5, 0, 0, 18, "Mace and amulet combined, it radiates celestial might, harmonizing strength and luck to aid allies."),
        new WeaponData("Celestivigil Seraphim", 30, 12, 0, 5, 0, 0, 13, "Wielding both mace and amulet, it channels seraphic grace, offering divine protection and potent restoration.")
    };
    
    private static final WeaponData[] WARLOCK_WEAPONS = {
        new WeaponData("Ashen Cursed Scroll", 8, 4, 0, 2, 0, 0, 2, "Smolders with lingering ashes, each word sapping vitality from those foolish enough to read it."),
        new WeaponData("Shadowbound Cursed Scroll", 10, 4, 0, 3, 0, 0, 3, "Shadows coil around its pages, whispering forbidden secrets that bend the weak to the warlock's will."),
        new WeaponData("Withered Cursed Scroll", 13, 3, 0, 5, 0, 0, 5, "Ancient and brittle, yet each line drains life with an unwavering hunger for souls."),
        new WeaponData("Nightfall Codex", 16, 5, 0, 7, 0, 0, 4, "Darkness seeps from its cover, commanding the unseen and calling forth ephemeral dread."),
        new WeaponData("Phantom Codex", 19, 6, 0, 7, 0, 0, 6, "Ghostly ink etches fates unknown, summoning spirits to haunt and serve the cunning warlock."),
        new WeaponData("Obsivious Codex", 21, 9, 0, 5, 0, 0, 7, "Its cursed scripts ensnare minds, guiding unfortunate souls into unseen perils."),
        new WeaponData("Ebonflare Staff", 24, 8, 0, 8, 0, 0, 8, "Dark flames surge along its shaft, burning with power to dominate the battlefield."),
        new WeaponData("Soulrender Staff", 27, 9, 0, 6, 0, 0, 12, "Pulses with tormented energy, tearing essence from the living and feeding the warlock's might."),
        new WeaponData("Doombringer Sigil", 30, 8, 0, 7, 0, 0, 15, "An emblem of annihilation, it bends reality itself to summon devastation upon enemies.")
    };
    
    // Armor data arrays
    private static final WeaponData[] ARMOR_PIECES = {
        // Light Armor (Tier 1-2)
        new WeaponData("Leather Vest", 8, 0, 12, 2, 0, 0, 3, "Simple leather protection for agile fighters."),
        new WeaponData("Studded Leather", 12, 0, 15, 3, 2, 0, 2, "Reinforced with metal studs for extra protection."),
        new WeaponData("Ranger's Cloak", 15, 2, 8, 1, 0, 0, 8, "A forest-green cloak that blends with nature."),
        new WeaponData("Shadow Weave", 18, 3, 6, 2, 5, 0, 10, "Dark fabric that seems to absorb light."),
        
        // Medium Armor (Tier 2-3)
        new WeaponData("Chainmail Hauberk", 16, 0, 22, 5, 0, 0, 1, "Interlocked rings provide solid defense."),
        new WeaponData("Scale Armor", 20, 0, 25, 7, 0, 0, 2, "Overlapping scales like a dragon's hide."),
        new WeaponData("Mystic Robes", 22, 8, 12, 3, 3, 3, 6, "Flowing robes imbued with magical energy."),
        new WeaponData("Elven Chain", 25, 2, 18, 4, 4, 2, 8, "Lightweight yet strong, crafted by elven smiths."),
        
        // Heavy Armor (Tier 3-4)
        new WeaponData("Plate Mail", 24, 0, 35, 8, 0, 0, 0, "Full body protection of tempered steel."),
        new WeaponData("Knight's Armor", 28, 0, 40, 10, 2, 0, 3, "Ceremonial armor worn by noble knights."),
        new WeaponData("Dragon Scale Mail", 30, 5, 32, 12, 5, 5, 8, "Forged from ancient dragon scales, legendary protection."),
        new WeaponData("Celestial Aegis", 30, 10, 38, 8, 3, 3, 12, "Divine armor blessed by celestial beings.")
    };
    
    // Accessory data arrays
    private static final WeaponData[] ACCESSORY_PIECES = {
        // Rings
        new WeaponData("Iron Ring", 5, 1, 2, 1, 0, 0, 1, "A simple iron band with minor enchantments."),
        new WeaponData("Ring of Might", 10, 0, 3, 8, 0, 0, 0, "Increases the wearer's physical strength."),
        new WeaponData("Mana Ring", 12, 15, 0, 0, 0, 0, 3, "Pulses with arcane energy."),
        new WeaponData("Ring of Fortune", 15, 0, 0, 0, 0, 0, 15, "Brings luck to its wearer."),
        new WeaponData("Crimson Band", 18, 3, 5, 6, 8, 5, 2, "A blood-red ring of unknown origin."),
        new WeaponData("Ethereal Loop", 25, 8, 8, 5, 5, 8, 10, "Shimmers between dimensions."),
        new WeaponData("Ring of the Ancients", 30, 12, 10, 12, 10, 10, 15, "A legendary artifact of immense power."),
        
        // Amulets
        new WeaponData("Bone Amulet", 6, 2, 1, 2, 0, 0, 2, "Carved from monster bone, provides minor protection."),
        new WeaponData("Crystal Pendant", 11, 8, 3, 1, 0, 0, 4, "A clear crystal that focuses magical energy."),
        new WeaponData("Guardian's Medallion", 16, 0, 15, 3, 0, 0, 5, "Protects against physical harm."),
        new WeaponData("Sorcerer's Charm", 20, 12, 2, 2, 6, 6, 6, "Enhances magical abilities."),
        new WeaponData("Heart of the Mountain", 24, 5, 20, 10, 0, 0, 8, "Contains the strength of ancient peaks."),
        new WeaponData("Void Shard", 28, 10, 5, 8, 12, 12, 5, "A fragment from the space between worlds."),
        new WeaponData("Divine Relic", 30, 15, 12, 8, 8, 8, 12, "A holy artifact of incredible power.")
    };
    
    // Add other weapon arrays for Tank, Rogue, Healer, Summoner, Cleric, Warlock...
    
    // Factory methods
    public static EquipmentTemp createRandomWeapon(String role) {
        WeaponData[] weapons = getWeaponsByRole(role);
        if (weapons.length == 0) return createDefaultWeapon();
        
        WeaponData weaponData = weapons[random.nextInt(weapons.length)];
        return createEquipmentFromData(weaponData);
    }
    
    public static EquipmentTemp createRandomWeaponByTier(String role, int tier) {
        WeaponData[] weapons = getWeaponsByRole(role);
        if (weapons.length == 0) return createDefaultWeapon();
        
        // Tier 1: value 5-12, Tier 2: 13-20, Tier 3: 21-28, Tier 4: 29-30
        List<WeaponData> tierWeapons = new ArrayList<>();
        for (WeaponData weapon : weapons) {
            if (isInTier(weapon.value, tier)) {
                tierWeapons.add(weapon);
            }
        }
        
        if (tierWeapons.isEmpty()) return createRandomWeapon(role);
        
        WeaponData weaponData = tierWeapons.get(random.nextInt(tierWeapons.size()));
        return createEquipmentFromData(weaponData);
    }
    
    public static ArrayList<EquipmentTemp> createRandomEquipmentCollection() {
        // Generate random amount between 8-25 total equipment pieces
        int equipmentCount = 8 + random.nextInt(18); // 8 + (0-17) = 8-25
        ArrayList<EquipmentTemp> equipmentCollection = new ArrayList<>();
        
        // Equipment type distribution (roughly balanced)
        // 40% weapons, 35% armor, 25% accessories
        int weaponCount = (int) (equipmentCount * 0.4);
        int armorCount = (int) (equipmentCount * 0.35);
        int accessoryCount = equipmentCount - weaponCount - armorCount;
        
        // All available roles for weapon selection
        String[] roles = {"warrior", "archer", "mage", "tank", "rogue", "healer", "summoner", "cleric", "warlock"};
        
        // Add weapons
        for (int i = 0; i < weaponCount; i++) {
            String randomRole = roles[random.nextInt(roles.length)];
            EquipmentTemp randomWeapon = createRandomWeapon(randomRole);
            equipmentCollection.add(randomWeapon);
        }
        
        // Add armor pieces
        for (int i = 0; i < armorCount; i++) {
            EquipmentTemp randomArmor = createRandomArmor();
            equipmentCollection.add(randomArmor);
        }
        
        // Add accessories
        for (int i = 0; i < accessoryCount; i++) {
            EquipmentTemp randomAccessory = createRandomAccessory();
            equipmentCollection.add(randomAccessory);
        }
        
        // Shuffle the collection for variety
        java.util.Collections.shuffle(equipmentCollection);
        
        return equipmentCollection;
    }
    
    public static EquipmentTemp createRandomArmor() {
        WeaponData armorData = ARMOR_PIECES[random.nextInt(ARMOR_PIECES.length)];
        return createArmorFromData(armorData);
    }
    
    public static EquipmentTemp createRandomAccessory() {
        WeaponData accessoryData = ACCESSORY_PIECES[random.nextInt(ACCESSORY_PIECES.length)];
        return createAccessoryFromData(accessoryData);
    }
    
    private static WeaponData[] getWeaponsByRole(String role) {
        return switch (role.toLowerCase()) {
            case "warrior" -> WARRIOR_WEAPONS;
            case "archer" -> ARCHER_WEAPONS;
            case "mage" -> MAGE_WEAPONS;
            case "tank" -> TANK_WEAPONS;
            case "rogue" -> ROGUE_WEAPONS;
            case "healer" -> HEALER_WEAPONS;
            case "summoner" -> SUMMONER_WEAPONS;
            case "cleric" -> CLERIC_WEAPONS;
            case "warlock" -> WARLOCK_WEAPONS;
            default -> new WeaponData[0];
        };
    }
    
    private static boolean isInTier(int value, int tier) {
        return switch (tier) {
            case 1 -> value >= 5 && value <= 12;
            case 2 -> value >= 13 && value <= 20;
            case 3 -> value >= 21 && value <= 28;
            case 4 -> value >= 29;
            default -> false;
        };
    }
    
    private static RarityType determineRarity(int value) {
        if (value >= 25) return RarityType.ETHEREAL;
        if (value >= 18) return RarityType.MYSTIC;
        if (value >= 12) return RarityType.ENCHANTED;
        return RarityType.FORGED;
    }
    
    private static EquipmentTemp createEquipmentFromData(WeaponData data) {
        // Create BaseStat object from weapon data
        BaseStat weaponStats = new BaseStat(
            data.value,      // HP (using value as base HP for weapons)
            data.mp,         // MP
            data.defense,    // DEF
            data.strength,   // STR
            data.critChance, // CC (Crit Chance)
            data.critDamage, // CD (Crit Damage)
            data.luck        // LCK
        );
        
        // Determine rarity based on weapon value
        RarityType rarity = determineRarity(data.value);
        
        return new EquipmentTemp(
            data.name,
            weaponStats,
            rarity,
            EquipmentType.WEAPON,
            data.flavorText,
            "A powerful weapon forged for battle."
        );
    }
    
    private static EquipmentTemp createArmorFromData(WeaponData data) {
        // Create BaseStat object from armor data
        BaseStat armorStats = new BaseStat(
            data.value,      // HP 
            data.mp,         // MP
            data.defense,    // DEF (primary stat for armor)
            data.strength,   // STR
            data.critChance, // CC (Crit Chance)
            data.critDamage, // CD (Crit Damage)
            data.luck        // LCK
        );
        
        // Determine rarity based on armor value
        RarityType rarity = determineRarity(data.value);
        
        return new EquipmentTemp(
            data.name,
            armorStats,
            rarity,
            EquipmentType.ARMOR,
            data.flavorText,
            "Protective armor crafted for defense."
        );
    }
    
    private static EquipmentTemp createAccessoryFromData(WeaponData data) {
        // Create BaseStat object from accessory data
        BaseStat accessoryStats = new BaseStat(
            data.value,      // HP
            data.mp,         // MP
            data.defense,    // DEF
            data.strength,   // STR
            data.critChance, // CC (Crit Chance)
            data.critDamage, // CD (Crit Damage)
            data.luck        // LCK (often primary stat for accessories)
        );
        
        // Determine rarity based on accessory value
        RarityType rarity = determineRarity(data.value);
        
        return new EquipmentTemp(
            data.name,
            accessoryStats,
            rarity,
            EquipmentType.ACCESSORY,
            data.flavorText,
            "A magical accessory with special properties."
        );
    }
    
    private static EquipmentTemp createDefaultWeapon() {
        BaseStat defaultStats = new BaseStat(1, 0, 0, 1, 0, 0, 0);
        return new EquipmentTemp(
            "Basic Weapon", 
            defaultStats, 
            RarityType.FORGED, 
            EquipmentType.WEAPON, 
            "A simple weapon.", 
            "A basic weapon for beginners."
        );
    }
    
    // Helper class to store weapon data
    private static class WeaponData {
        final String name;
        final int value, mp, defense, strength, critChance, critDamage, luck;
        final String flavorText;
        
        WeaponData(String name, int value, int mp, int defense, int strength, int critChance, int critDamage, int luck, String flavorText) {
            this.name = name;
            this.value = value;
            this.mp = mp;
            this.defense = defense;
            this.strength = strength;
            this.critChance = critChance;
            this.critDamage = critDamage;
            this.luck = luck;
            this.flavorText = flavorText;
        }
    }
}

// Warrior Weapons	Rustbite Longsword	6	0	2	4	0	0	0	A blade corroded yet deadly, its jagged edge bites deeper with every strike.
// Warrior Weapons	Bonecrush Warspike	8	0	3	5	0	0	0	Forged from shattered bones of ancient beasts, it delivers crushing force with each thrust.
// Warrior Weapons	Forgeborn Broadsword	12	0	5	7	0	0	0	Tempered in volcanic fires, it swings with relentless power and unyielding weight.
// Warrior Weapons	Knight's Sabre	16	0	7	9	0	0	0	Etched with honor-bound runes, its gleam inspires courage in allies and fear in foes.
// Warrior Weapons	Bloodforge Waraxe	18	0	6	12	0	0	0	Born in sacrificial flames, each swing drips with the echoes of past battles.
// Warrior Weapons	Sentinel's Halberd	21	0	7	14	0	0	0	A weapon of defense and offense, it guards its wielder while punishing intruders.
// Warrior Weapons	Kingsguard Bastionblade	23	0	9	14	0	0	0	Carved for royalty, its steel holds the might of an empire in every strike.
// Warrior Weapons	Dragospire Earthgnasher	25	0	8	17	0	0	0	Fused with dragonbone, its bite crushes armor as easily as stone.
// Warrior Weapons	Lionheart Claymore	28	0	2	20	6	0	0	Forged with valor, its swings embody the courage of lions long past.
// Warrior Weapons	Essenclystic Skullsplitter	28	0	3	25	0	0	0	Born of forbidden pacts, it siphons life with every swing, leaving Warlocks’ foes weakened and the wielder hungering for more essence.
// Archer Weapons	Thornstrike Bow	7	0	0	4	1	2	0	Crafted from bramblewood, its arrows tear through armor like wild thorns through flesh.
// Archer Weapons	Windwhisper Slingshot	9	0	0	1	4	4	0	Its light frame bends air itself, sending pebbles swift and silent as a breeze.
// Archer Weapons	Emberroot Shortbow	12	0	0	5	3	4	0	Flames pulse beneath its bark, each shot leaving trails of burning cinders.
// Archer Weapons	Moonveil Longbow	15	0	0	4	7	4	0	Strung with lunar silk, its arrows shimmer with calm precision under moonlight.
// Archer Weapons	Stormpiercer Composite	18	0	0	6	6	6	0	Sparks crackle along its limbs, channeling thunder through every piercing release.
// Archer Weapons	Falcon’s Pride	20	0	0	7	8	5	0	A hunter’s companion bound by spirit, its aim never wavers even at impossible range.
// Archer Weapons	Sunflare Harbinger	23	0	0	9	8	6	0	Forged in dawnfire, it unleashes arrows blazing bright enough to blind the unworthy.
// Archer Weapons	Aetherstring Vanguard	26	0	0	8	10	7	0	Its ethereal string hums with power drawn from unseen winds and astral currents.
// Archer Weapons	Soulpiercer Arbalest	30	0	0	15	5	10	0	Each arrow carries immense spiritual weight; slower draw, deadlier impact.
// Archer Weapons	Bloodmoon Reaver	30	0	0	10	10	10	0	Under the crimson moon, its bolts feast upon the life force of its prey.
// Mage Weapons	Ashenwood Wand	5	2	0	3	0	0	0	Carved from charred oak imbued with lingering flame, channeling primal fire with every flick.
// Mage Weapons	Glimmerroot Staff	8	3	0	5	0	0	0	Grown beneath moonlight, its roots still hum with the whispers of arcane nature.
// Mage Weapons	Frostpetal Wand	13	5	0	8	0	0	0	A fragile bloom of frozen mana, releasing sharp bursts of winter’s grace.
// Mage Weapons	Solaris Channeler	15	7	0	8	0	0	0	Forged in sunfire, it radiates warmth that burns away darkness and doubt.
// Mage Weapons	Runebound Staff	19	10	0	9	0	0	0	Every rune glows faintly, a silent hymn binding ancient wisdom to the wielder’s will.
// Mage Weapons	Echoheart Focus	20	5	0	7	5	3	0	The crystal within hums with voices of past sorcerers, echoing forgotten incantations.
// Mage Weapons	Starcaller’s Beacon	23	6	0	7	5	5	0	A celestial conduit that draws strength from constellations long erased from mortal maps.
// Mage Weapons	Oblivion Scepter	26	-5	5	16	5	5	0	Its obsidian core consumes stray light, conjuring shadows that obey no master.
// Mage Weapons	Luminous Spire	29	14	0	15	0	0	0	A towering beacon of pure light magic, harnessed for unwavering power.
// Mage Weapons	Chaosveil Catalyst	29	10	0	14	-5	10	0	Unstable energy swirls within, risking collapse for immense burst.
// Mage Weapons	Eternium Soulspire	30	5	0	10	10	5	0	Forged from the last fragment of timeless magic, it hums with eternity’s pulse and bends mana to the caster’s will.
// Tank Weapons	Ironclad Shield	5	0	4	1	0	0	0	A steadfast shield of tempered steel, absorbing blows and anchoring defenders at the heart of battle.
// Tank Weapons	Warbreaker Hammer	9	0	4	5	0	0	0	A brutal hammer designed to shatter armor and bones alike, punishing those who dare approach.
// Tank Weapons	Bastion Gauntlets	13	0	8	7	0	0	0	Heavy gauntlets crafted for parries and blocks, turning enemy strikes into harmless echoes.
// Tank Weapons	Vanguard’s Bulwark	16	0	10	6	0	0	0	An enchanted shield that bolsters allies’ courage while deflecting attacks with uncanny precision.
// Tank Weapons	Oathforged Shield	18	0	13	3	0	0	0	Bound by solemn vows, it protects allies and embodies the resolve of its wielder.
// Tank Weapons	Stormhammer Gauntlets	21	0	12	9	0	0	0	Gauntlets crackling with lightning, smashing foes while guarding the frontline with electric force.
// Tank Weapons	Earthshatter Warhammer	23	0	10	13	0	0	0	A titan-forged hammer that shakes the battlefield, crushing armor and morale in equal measure.
// Tank Weapons	Sanctumbreaker Gauntlets	26	0	13	13	0	0	0	Crafted for sieges and champions, they punch through walls and enemy lines with devastating might.
// Tank Weapons	Heavensunder Maul	28	0	10	18	0	0	0	Wielded by chosen defenders, each swing reverberates with divine force, breaking the strongest of foes.
// Tank Weapons	Seraphic Bulwark	28	0	18	10	0	0	0	A radiant shield blessed by celestial power, inspiring allies and turning aside even the fiercest assaults.
// Tank Weapons	Aegis of the Titans	30	0	20	10	0	0	0	A legendary shield of unmatched might, unyielding against any assault and inspiring allies to defy fate itself.
// Rogue Weapons	Rustfang Dagger	5	1	0	1	1	0	2	A rusted blade concealing deadly sharpness, striking unseen and leaving foes to wonder what hit them.
// Rogue Weapons	Shadowbite Claws	9	2	0	1	1	1	4	Forged in darkness, these claws tear flesh with silent precision, perfect for ambushes.
// Rogue Weapons	Twinsteel Shivs	11	1	0	2	1	2	5	Paired blades for swift, twin strikes; each cut quick, silent, and merciless.
// Rogue Weapons	Venomlash Daggers	15	4	0	1	2	1	7	Daggers coated in potent toxin, each slash drains life and sows fear.
// Rogue Weapons	Bloodtrace Chakrams	17	3	0	1	2	4	7	Spinning with lethal precision in close quarters, each slash leaves a trail of crimson and fear.
// Rogue Weapons	Whisperfang Blades	20	3	0	3	1	3	10	Silent as a shadow, sharp as a fang; every strike whispers death.
// Rogue Weapons	Nightreaver Claws	23	3	0	4	4	3	9	Perfect for prowling predators, they slice silently and vanish before retaliation.
// Rogue Weapons	Eclipsing Chakrams	27	4	0	5	4	4	10	Moon-forged discs whirling in deadly arcs, striking foes with shadowed elegance.
// Rogue Weapons	Dreadveil Knives	29	0	0	5	7	10	7	Every slash siphons the essence of your foe, striking with lethal precision; only the most daring rogues can wield its ruthless edge.
// Rogue Weapons	Gloombite Talons	29	6	0	7	2	7	11	Forged for the shadows, each claw strikes with cunning force; skill and timing amplify its deadly potential in every encounter.
// Rogue Weapons	Veilpiercer Chakrams	30	2	0	3	5	5	15	Luck guides each spinning blade, slicing unseen through defenses; a rogue’s touch makes the improbable strike inevitable.
// Healer Weapons	Sanctum Icon	5	3	0	2	0	0	0	A sacred emblem radiating calm, channeling restorative energy to mend wounds with gentle precision.
// Healer Weapons	Lifebloom Medallion	8	4	0	3	0	0	1	Infused with the essence of life, it subtly accelerates healing for allies within its soothing aura.
// Healer Weapons	Celestine Globe	12	6	0	4	0	0	2	Glowing with celestial light, it nurtures vitality and rejuvenates even the weariest of hearts.
// Healer Weapons	Verdant Crucible	15	8	0	5	0	0	2	A verdant vessel of nature’s power, empowering the healer to mend grievous injuries swiftly.
// Healer Weapons	Moonlit Talisman	19	10	0	5	0	0	4	Bathed in silver light, its charm enhances the strength of restorative magic under any night sky.
// Healer Weapons	Aurora Sphere	20	9	0	5	0	0	6	Shimmering with prismatic hues, each pulse restores vigor to allies, weaving a veil of protection.
// Healer Weapons	Evergloam Sigil	23	12	0	6	0	0	5	A mystical sigil resonating with twilight energy, it bolsters the healer’s command over life’s flow.
// Healer Weapons	Radiant Pendant	26	14	0	6	0	0	6	Encased in radiant crystal, it channels pure restorative force, sustaining allies in the heat of battle.
// Healer Weapons	Ethereon Sanctifier	29	16	0	7	0	0	6	Forged from ethereal essence, it sanctifies wounds with unmatched potency, turning pain into fleeting whispers.
// Healer Weapons	Soulweaver Aegis	30	7	0	15	0	0	8	Threads of souls entwine within, subtly mending and empowering, binding life’s fragility to the healer’s will.
// Healer Weapons	Luminal Nexus	30	20	0	5	0	0	5	A nexus of pure light, it radiates restorative energy, guiding allies from the brink with unwavering grace.
// Summoner Weapons	Glimmering Totem	7	2	0	1	0	0	4	A humble totem that whispers guidance to fledgling summoners, awakening faint echoes of the spirits it channels.
// Summoner Weapons	Whispering Codex	11	3	0	2	0	0	6	Ancient pages hum softly, sharing secrets of the beyond with those daring enough to read its veiled words.
// Summoner Weapons	Starwoven Grimoire	16	5	0	3	0	0	8	Celestial patterns etched in its cover guide summoners to weave powerful, fleeting starlight into their minions.
// Summoner Weapons	Arcsain Idol	19	6	0	4	0	0	9	Carved from rare etherwood, it pulses with latent magic, encouraging spirits to rally at the summoner’s will.
// Summoner Weapons	Totem of the Dawn	23	8	0	5	0	0	10	A radiant totem imbued with the first light of day, invigorating summoned allies with renewed strength and hope.
// Summoner Weapons	Shadowbind Tome	26	10	0	6	0	0	10	Dark ink seeps with binding spells, compelling spirits to obey the summoner’s command with ruthless precision.
// Summoner Weapons	Soulforge Lexicon	28	12	0	7	0	0	9	Each word etched into its pages burns with the fire of creation, empowering minions beyond mortal limits.
// Summoner Weapons	Effigy of the Damned	28	8	0	5	0	0	15	Cursed and feared, it draws upon condemned spirits, magnifying the summoner’s luck while sowing despair among enemies.
// Summoner Weapons	Asc Void Heart	40	15	5	10	0	0	10	A rare artifact of forbidden design, it twists the void itself, calling forth titanic entities whose loyalty is as fleeting as their summoned power.
// Cleric Weapons	Sanctum Mace	6	1	0	1	0	0	4	A simple yet holy weapon, it channels the light of the sanctuary to mend wounds and bolster faith.
// Cleric Weapons	Dawnspire Censer	9	3	0	2	0	0	4	Its incense burns with the first light of dawn, uplifting allies and purging darkness from their spirits.
// Cleric Weapons	Radiant Scepter	10	2	0	3	0	0	5	Each strike releases a pulse of divine energy, healing the faithful and smiting the unworthy.
// Cleric Weapons	Luminal Rod	13	4	0	4	0	0	5	Glowing softly, it bridges mortal hands and celestial power, guiding prayers into potent restoration.
// Cleric Weapons	Halobrand Mace	14	3	0	5	0	0	6	Forged in sacred fires, it carries a halo of power, strengthening the resolve of those it defends.
// Cleric Weapons	Lumenic Aegis	17	4	0	6	0	0	7	A protective emblem, radiating light that shields companions while nourishing their vitality.
// Cleric Weapons	Auric Medallion	19	4	0	6	0	0	9	Gleaming with golden energy, it inspires courage and invigorates allies through the faith it embodies.
// Cleric Weapons	Blessed Crucible	21	5	0	7	0	0	9	Imbued with sanctified essence, it channels restorative magic, mending wounds and fortifying spirits alike.
// Cleric Weapons	Solstice Warrod	23	5	0	8	0	0	10	Harnessing the zenith of sunlight, it empowers healing strikes and invigorates the weary.
// Cleric Weapons	Aetherium Gavel	25	3	0	9	0	0	13	A majestic instrument of divine judgement, strengthening resolve and empowering miracles beyond the ordinary.
// Cleric Weapons	Divine Phylactery	27	8	0	7	0	0	12	Encased in sacred relics, it amplifies blessings and anchors the faith of those nearby.
// Cleric Weapons	Aurealium Luminar	30	7	0	5	0	0	18	Mace and amulet combined, it radiates celestial might, harmonizing strength and luck to aid allies.
// Cleric Weapons	Celestivigil Seraphim	30	12	0	5	0	0	13	Wielding both mace and amulet, it channels seraphic grace, offering divine protection and potent restoration.
// Warlock Weapons	Ashen Cursed Scroll	8	4	0	2	0	0	2	Smolders with lingering ashes, each word sapping vitality from those foolish enough to read it.
// Warlock Weapons	Shadowbound Cursed Scroll	10	4	0	3	0	0	3	Shadows coil around its pages, whispering forbidden secrets that bend the weak to the warlock’s will.
// Warlock Weapons	Withered Cursed Scroll	13	3	0	5	0	0	5	Ancient and brittle, yet each line drains life with an unwavering hunger for souls.
// Warlock Weapons	Nightfall Codex	16	5	0	7	0	0	4	Darkness seeps from its cover, commanding the unseen and calling forth ephemeral dread.
// Warlock Weapons	Phantom Codex	19	6	0	7	0	0	6	Ghostly ink etches fates unknown, summoning spirits to haunt and serve the cunning warlock.
// Warlock Weapons	Obsivious Codex	21	9	0	5	0	0	7	Its cursed scripts ensnare minds, guiding unfortunate souls into unseen perils.
// Warlock Weapons	Ebonflare Staff	24	8	0	8	0	0	8	Dark flames surge along its shaft, burning with power to dominate the battlefield.
// Warlock Weapons	Soulrender Staff	27	9	0	6	0	0	12	Pulses with tormented energy, tearing essence from the living and feeding the warlock’s might.
// Warlock Weapons	Doombringer Sigil	30	8	0	7	0	0	15	An emblem of annihilation, it bends reality itself to summon devastation upon enemies.