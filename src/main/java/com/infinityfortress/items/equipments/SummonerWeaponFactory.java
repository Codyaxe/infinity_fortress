package com.infinityfortress.items.equipments;

import com.infinityfortress.items.ItemRarity;

public class SummonerWeaponFactory {
    public Equipment createGlimmeringTotem() {
        return new Equipment("Glimmering Totem", "Weapon", "Summoner", 7, 2, 0, 1, 0, 0, 4,
                "A humble totem that whispers guidance to fledgling summoners, awakening faint echoes of the spirits it channels.",
                ItemRarity.FORGED);
    }

    public Equipment createWhisperingCodex() {
        return new Equipment("Whispering Codex", "Weapon", "Summoner", 11, 3, 0, 2, 0, 0, 6,
                "Ancient pages hum softly, sharing secrets of the beyond with those daring enough to read its veiled words.",
                ItemRarity.FORGED);
    }

    public Equipment createStarwovenGrimoire() {
        return new Equipment("Starwoven Grimoire", "Weapon", "Summoner", 16, 5, 0, 3, 0, 0, 8,
                "Celestial patterns etched in its cover guide summoners to weave powerful, fleeting starlight into their minions.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createArcsainIdol() {
        return new Equipment("Arcsain Idol", "Weapon", "Summoner", 19, 6, 0, 4, 0, 0, 9,
                "Carved from rare etherwood, it pulses with latent magic, encouraging spirits to rally at the summoner’s will.",
                ItemRarity.ENCHANTED);
    }

    public Equipment createTotemOfTheDawn() {
        return new Equipment("Totem of the Dawn", "Weapon", "Summoner", 23, 8, 0, 5, 0, 0, 10,
                "A radiant totem imbued with the first light of day, invigorating summoned allies with renewed strength and hope.",
                ItemRarity.MYSTIC);
    }

    public Equipment createShadowbindTome() {
        return new Equipment("Shadowbind Tome", "Weapon", "Summoner", 26, 10, 0, 6, 0, 0, 10,
                "Dark ink seeps with binding spells, compelling spirits to obey the summoner’s command with ruthless precision.",
                ItemRarity.MYSTIC);
    }

    public Equipment createSoulforgeLexicon() {
        return new Equipment("Soulforge Lexicon", "Weapon", "Summoner", 28, 12, 0, 7, 0, 0, 9,
                "Each word etched into its pages burns with the fire of creation, empowering minions beyond mortal limits.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createEffigyOfTheDamned() {
        return new Equipment("Effigy of the Damned", "Weapon", "Summoner", 28, 8, 0, 5, 0, 0, 15,
                "Cursed and feared, it draws upon condemned spirits, magnifying the summoner’s luck while sowing despair among enemies.",
                ItemRarity.ETHEREAL);
    }

    public Equipment createAscSangreHeart() {
        return new Equipment("Asc Sangre Heart", "Weapon", "Summoner", 35, 5, 5, 15, 0, 0, 10,
                "The pulse of the void incarnate—it beats in harmony with creation itself, summoning echoes of beings that predate reality.",
                ItemRarity.ASC);
    }
}
