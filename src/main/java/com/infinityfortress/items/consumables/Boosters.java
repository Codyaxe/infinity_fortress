package com.infinityfortress.items.consumables;

import com.infinityfortress.items.ItemRarity;

public class Boosters {
    public Consumables createLesserFortitudeDraught() {
        return new Consumables("Lesser Fortitude Draught", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +4 DEF + 5% Target's DEF (1 turn)",
                "A rugged herbal brew that stiffens posture and steels the body against harm.",
                ItemRarity.FORGED);
    }

    public Consumables createFortitudeDraught() {
        return new Consumables("Fortitude Draught", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +8 DEF + 10% Target's DEF (1 turn)",
                "Strengthens natural defenses with a surge of disciplined resolve.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterFortitudeDraught() {
        return new Consumables("Greater Fortitude Draught", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +13 DEF + 16% Target's DEF (2 turns)",
                "An elite formula that envelops the drinker in a near-tangible aura of protection.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserStrengthTonic() {
        return new Consumables("Lesser Strength Tonic", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +5 STR + 5% Target's STR (1 turn)",
                "A fiery drink that ignites the muscles with a quick burst of raw power.",
                ItemRarity.FORGED);
    }

    public Consumables createStrengthTonic() {
        return new Consumables("Strength Tonic", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target's STR (1 turn)",
                "Favored by warriors; its forceful kick fuels strikes with renewed might.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterStrengthTonic() {
        return new Consumables("Greater Strength Tonic", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target's STR (2 turns)",
                "A powerful infusion that empowers every muscle fiber to unleash devastating power.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserSwiftnessElixir() {
        return new Consumables("Lesser Swiftness Elixir", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +3 SPD + 4% Target's SPD (1 turn)",
                "A light tonic that sharpens reflexes and quickens motion for a brief moment.",
                ItemRarity.FORGED);
    }

    public Consumables createSwiftnessElixir() {
        return new Consumables("Swiftness Elixir", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +6 SPD + 8% Target's SPD (1 turn)",
                "Enhances agility with a burst of accelerated momentum.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterSwiftnessElixir() {
        return new Consumables("Greater Swiftness Elixir", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 SPD + 13% Target's SPD (1 turn)",
                "A refined elixir that heightens speed, awareness, and step precision.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserPrecisionVial() {
        return new Consumables("Lesser Precision Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +2 CRIT CHANCE + 5% Target's CRIT CHANCE (2 turns)",
                "Clear as glass and twice as sharp — heightens focus enough to spot easy weaknesses.",
                ItemRarity.FORGED);
    }

    public Consumables createPrecisionVial() {
        return new Consumables("Precision Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +4 CRIT CHANCE + 10% Target's CRIT CHANCE (2 turns)",
                "Steadies the hand and sharpens instinct, allowing for cleaner, deadlier strikes.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterPrecisionVial() {
        return new Consumables("Greater Precision Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +6 CRIT CHANCE + 16% Target's CRIT CHANCE (3 turns)",
                "A concentrated brew that unlocks a near-clairvoyant sense for critical openings.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserMightSerum() {
        return new Consumables("Lesser Might Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +5 CRIT DMG + 7% Target's CRIT DMG (2 turns)",
                "A volatile mixture that empowers strikes with a sudden surge of destructive force.",
                ItemRarity.FORGED);
    }

    public Consumables createMightSerum() {
        return new Consumables("Might Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 CRIT DMG + 15% Target's CRIT DMG(2 turns)",
                "Channels brutal arcane force directly into one\'s blows, multiplying their impact.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterMightSerum() {
        return new Consumables("Greater Might Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 CRIT DMG + 24% Target's CRIT DMG(3 turns)",
                "A dangerously potent serum that turns ordinary attacks into catastrophic bursts of power.",
                ItemRarity.MYSTIC);
    }

    public Consumables createLesserFortunePotion() {
        return new Consumables("Lesser Fortune Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +3 LUCK + 5% Target's LUCK (3 turns)",
                "A flicker of charm in liquid form, swaying fate ever so slightly.",
                ItemRarity.FORGED);
    }

    public Consumables createFortunePotion() {
        return new Consumables("Fortune Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +6 LUCK + 10% Target\'s LUCK (3 turns)",
                "Warps chance in the drinker\'s favor, blessing every move with quiet luck.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterFortunePotion() {
        return new Consumables("Greater Fortune Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 LUCK + 16% Target's LUCK (3 turns)",
                "An alchemical marvel said to nudge destiny itself toward fortunate outcomes.",
                ItemRarity.MYSTIC);
    }

    public Consumables createElixirOfEndurance() {
        return new Consumables("Elixir of Endurance", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +8 DEF + 10% Target\'s DEF and +8 STR + 10% Target\'s STR (1 turn)",
                "A steady brew that reinforces the body, lending calm strength against incoming harm.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterElixirOfEndurance() {
        return new Consumables("Greater Elixir of Endurance", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +13 DEF + 16% Target\'s DEF and +13 STR + 16% Target\'s STR (2 turns)",
                "Power flows like tempered steel through the veins, forging resilience and raw might into one unyielding force.",
                ItemRarity.MYSTIC);
    }

    public Consumables createBrewOfReflexGuard() {
        return new Consumables("Brew of Reflex Guard", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +8 DEF + 10% Target\'s DEF and +6 SPD + 8% Target\'s SPD (1 turn)",
                "Light and sharp, it sharpens reaction and steadies form in a single breath.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterBrewOfReflexGuard() {
        return new Consumables("Greater Brew of Reflex Guard", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +13 DEF + 16% Target\'s DEF and +10 SPD + 13% Target\'s SPD (2 turns)",
                "A surge of instinct and fortified stance meld as one, creating reflexes swift enough to defy danger itself.",
                ItemRarity.MYSTIC);
    }

    public Consumables createSteadfastFortunePotion() {
        return new Consumables("Steadfast Fortune Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +8 DEF + 10% Target'\s DEF and +6 LUCK + 8% Target\'s LUCK (1 turn)",
                "A subtle charm that steadies the spirit while nudging fate gently in your favor.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterSteadfastFortunePotion() {
        return new Consumables("Greater Steadfast Fortune Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +13 DEF + 16% Target\'s DEF and +10 LUCK + 16% Target\'s LUCK (2 turns)",
                "Fortune anchors itself to your stance, weaving protection and blessed chance into your every step.",
                ItemRarity.MYSTIC);
    }

    public Consumables createIronResolveTonic() {
        return new Consumables("Iron Resolve Tonic", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target\'s STR and +8 DEF + 10% Target\'s DEF (1 turn)",
                "A grounded brew that hardens resolve, strengthening muscle and will alike.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterIronResolveTonic() {
        return new Consumables("Greater Iron Resolve Tonic", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target\'s STR and +13 DEF + 16% Target\'s DEF (2 turns)",
                "Strength deepens, resolve calcifies — a union of force and fortitude unshaken by any threat.",
                ItemRarity.MYSTIC);
    }

    public Consumables createBattleRushElixir() {
        return new Consumables("Battle Rush Elixir", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target\'s STR and +6 SPD + 8% Target\'s SPD (1 turn)",
                "A brisk spark of vigor and motion, ideal for seizing control of the fight.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterBattleRushElixir() {
        return new Consumables("Greater Battle Rush Elixir", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target\'s STR and +13 DEF + 16% Target\'s DEF (2 turns)",
                "Raw strength fuses with blinding speed, turning momentum into a weapon all its own.",
                ItemRarity.MYSTIC);
    }

    public Consumables createTrueStrikeVial() {
        return new Consumables("True Strike Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target\'s STR and +4 Crit Chance + 10% Target\'s Crit Chance (2 turns)",
                "Focus narrows, aligning power with the certainty of a well-placed hit.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterTrueStrikeVial() {
        return new Consumables("Greater True Strike Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target\'s STR and +6 Crit Chance + 16% Target\'s Crit Chance (3 turns)",
                "Instinct and strength harmonize into lethal clarity, guiding each strike toward perfect opportunity.",
                ItemRarity.MYSTIC);
    }

    public Consumables createBerserkersWrathSerum() {
        return new Consumables("Berserker's Wrath Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target\'s STR and +10 Crit DMG + 15% Target\'s Crit DMG (2 turns)",
                "Stirs the spirit into fierce vigor, sharpening the force behind every blow.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterBerserkersWrathSerum() {
        return new Consumables("Greater Berserker's Wrath Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target\'s STR and +16 Crit DMG + 24% Target\'s Crit DMG (3 turns)",
                "A roaring surge of unleashed might, amplifying every strike into brutal, devastating impact.",
                ItemRarity.MYSTIC);
    }

    public Consumables createBoldFortuneDraught() {
        return new Consumables("Bold Fortune Draught", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 STR + 10% Target\'s STR and +6 LUCK + 10% Target\'s LUCK (2 turns)",
                "A hearty blend that emboldens strength while coaxing fortune to your side.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterBoldFortuneDraught() {
        return new Consumables("Greater Bold Fortune Draught", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 STR + 16% Target\'s STR and +10 LUCK + 16% Target\'s LUCK (3 turns)",
                "Strength surges, fate tilts — a reckless mix that turns boldness into advantage.",
                ItemRarity.MYSTIC);
    }

    public Consumables createFleetingGracePotion() {
        return new Consumables("Fleeting Grace Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +6 SPD + 8% Target\'s SPD and +6 LUCK + 10% Target\'s LUCK (2 turns)",
                "A light, airy potion that blesses the feet with quick steps and fortunate timing.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterFleetingGracePotion() {
        return new Consumables("Greater Fleeting Grace Potion", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 SPD + 13% Target\'s SPD and +10 LUCK + 16% Target\'s LUCK (3 turns)",
                "Movement drifts on wind and chance alike, creating grace that borders on the otherworldly.",
                ItemRarity.MYSTIC);
    }

    public Consumables createPerfectExecutionSerum() {
        return new Consumables("Perfect Execution Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +4 Crit Chance + 10% Target\'s Crit Chance and +10 Crit DMG + 15% Target\'s Crit DMG (2 turns)",
                "Refines instinct and power, bringing each decisive strike closer to perfection.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterPerfectExecutionSerum() {
        return new Consumables("Greater Perfect Execution Serum", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +6 Crit Chance + 16% Target\'s Crit Chance and +16 Crit DMG + 24% Target\'s Crit DMG (3 turns)",
                "Critical prowess ignites in full — deadly precision fused with unparalleled destructive force.",
                ItemRarity.MYSTIC);
    }

    public Consumables createFatalPrecisionVial() {
        return new Consumables("Fatal Precision Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +10 Crit DMG + 15% Target\'s Crit DMG and +4 Crit Chance + 10% Target\'s Crit Chance (2 turns)",
                "A focused tincture that enhances the accuracy and severity of decisive hits.",
                ItemRarity.ENCHANTED);
    }

    public Consumables createGreaterFatalPrecisionVial() {
        return new Consumables("Greater Fatal Precisin Vial", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +16 Crit DMG + 24% Target\'s Crit DMG and +6 Crit Chance + 16% Target\'s Crit Chance (3 turns)",
                "Critical mastery crystallizes, turning every opening into a moment of ruthless, explosive power.",
                ItemRarity.MYSTIC);
    }

    public Consumables createElixirOfMartialVigor() {
        return new Consumables("Elixir of Martial Vigor", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 DEF + 12% Target\'s DEF, +8 STR + 8% Target\'s STR, and +8 SPD + 8% Target\'s SPD (2 turns)",
                "Strength, defense, and quickness swirl together in perfect martial harmony.",
                ItemRarity.MYSTIC);
    }

    public Consumables createTonicOfFortunedValor() {
        return new Consumables("Tonic of Fortuned Valor", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 DEF + 12% Target\'s DEF, +8 STR + 8% Target\'s STR, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "A bold mixture that bolsters courage, power, and the blessings of luck.",
                ItemRarity.MYSTIC);
    }

    public Consumables createDraughtOfAgileGuardian() {
        return new Consumables("Draught of Agile Guardian", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 DEF + 12% Target\'s DEF, +8 SPD + 8% Target\'s SPD, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "Infuses the drinker with nimble steps, solid defense, and subtle fortune.",
                ItemRarity.MYSTIC);
    }

    public Consumables createElixirOfWarbornZeal() {
        return new Consumables("Elixir of Warborn Zeal", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 DEF + 8% Target\'s DEF, and +8 SPD + 8% Target\'s SPD (2 turns)",
                "Forged for relentless warriors — blends raw power, resilience, and speed.",
                ItemRarity.MYSTIC);
    }

    public Consumables createPotionOfArmoredFortune() {
        return new Consumables("Potion of Armored Fortune", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 DEF + 8% Target\'s DEF, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "Strengthened limbs and hardened armor meet a surge of fortunate energy.",
                ItemRarity.MYSTIC);
    }

    public Consumables createElixirOfCrimsonRush() {
        return new Consumables("Elixir of Crimson Rush", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 SPD + 8% Target\'s SPD, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "A blazing mix that fuels aggression, swiftness, and lucky opportunity.",
                ItemRarity.MYSTIC);
    }

    public Consumables createSerumOfUnchainedFury() {
        return new Consumables("Serum of Unchained Fury", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 Crit Chance + 8% Target\'s Crit Chance, and +8 Crit DMG + 8% Target\'s Crit DMG (2 turns)",
                "A violent convergence of raw strength and critical lethality.",
                ItemRarity.MYSTIC);
    }

    public Consumables createDraughtOfLuckyStrikes() {
        return new Consumables("Draught of Lucky Strikes", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 Crit Chance + 8% Target\'s Crit Chance, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "Attunes instinct and luck, guiding every blow toward vital spots.",
                ItemRarity.MYSTIC);
    }

    public Consumables createVialOfRuthlessGlory() {
        return new Consumables("Vial of Ruthless Glory", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 STR + 12% Target\'s STR, +8 Crit DMG + 8% Target\'s Crit DMG, and +8 LUCK + 8% Target\'s LUCK (2 turns)",
                "Amplifies raw force, fortune, and critical devastation in ruthless harmony.",
                ItemRarity.MYSTIC);
    }
    
    public Consumables createElixirOfGamblersEdge() {
        return new Consumables("Elixir of Gambler's Edge", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +12 LUCK + 12% Target\'s LUCK, +8 Crit Chance + 8% Target\'s Crit Chance, and +8 Crit DMG + 8% Target\'s Crit DMG (2 turns)",
                "A chaotic concoction that empowers those bold enough to wager everything on fate.",
                ItemRarity.MYSTIC);
    }

    public Consumables createDominionAscCrystal() {
        return new Consumables("Dominion Asc Crystal", "Booster", "Any", -1, 0, 0, 0, 5, 0, 0, 0, 0, 0,
                "Grants +20 to all stats and +20% Target\'s ALL STATS (3 turns)",
                "A radiant ascended shard that unleashes supreme power across every stat with unparalleled brilliance.",
                ItemRarity.MYSTIC);
    }
}