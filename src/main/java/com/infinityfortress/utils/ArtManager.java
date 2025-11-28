package com.infinityfortress.utils;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;

public class ArtManager {
  private static final Map<String, String[]> characterBank = Map.of(
    "mage", new String[] {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⣾⣶⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⡆⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⡋⠘⠛⢟⢧⣀⠀⠀⠀⠀⠀⠀⠀⢠⠃⠀⡇⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣄⠀⠀⠀⢠⣾⣿⣔⡂⡀⠀⠀⠀⠀⣺⡀⣰⠇⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⣘⠿⣢⣀⡤⡿⡛⡽⣿⣿⣥⡁⠂⡀⠀⣸⡳⠋  ",
        "⠀⠀⠀⠀⠀⣠⣶⣿⢷⢽⣿⣿⡿⡷⡽⣿⣾⣎⠛⣏⠂⠀⠀⣿⠁⠀  ",
        "⠀⠀⠀⠀⠀⢼⣾⣺⢭⣷⣗⡭⣫⣷⣝⣞⢾⡶⠀⠸⠀⠀⡸⠇⠀⠀  ",
        "⠀⠀⠀⠀⠀⢸⡾⡎⢿⣿⣿⣿⣿⣿⣿⢺⢽⣇⠀⠀⠀⠀⡕⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⢼⣻⠊⠸⣽⣽⣿⣿⣽⠅⠈⣯⡷⠀⠀⠀⣼⠃⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⢿⡏⠀⢠⢿⣿⣿⣿⡿⡅⠀⢸⡿⣣⠀⢠⠓⠀⠀⠀⠀  ",
        "   ⠀⣽⢷⠃⢠⣟⢟⣿⣿⢿⢾⣻⣄⠈⢯⣿⡀⡼⠁⠀⠀⠀⠀⠀ ",
        "   ⢐⣟⡇⢀⣯⣷⣿⣮⣻⣽⣾⣾⣽⡀⠸⣺⣧⠇⠀⠀⠀⠀⠀⠀ ",
        "   ⢸⢽⠀⢘⣵⣷⣿⣿⣿⣿⣿⢷⣯⡣⠀⣝⡟⠀⠀⠀⠀⠀⠀⠀ ",
        "   ⢘⡟⡇⢸⣿⢵⣿⣿⣿⣿⣿⣷⢻⣿⠠⣿⡍⠀⠀⠀⠀⠀⠀⠀ ",
        "   ⠈⠳⢸⠸⢧⡯⢿⣿⣿⣿⣻⣿⡝⣿⡅⡞⠃⠀⠀⠀⠀⠀⠀⠀ ",
        "      ⢸⡇⢺⣿⡘⢿⣿⣿⣿⣿⣿⡜⢯⠃⠀⠀⠀⠀⠀⠀⠀ ",
        "      ⠸⠁⠀⢻⣧⠈⢻⣿⣿⣿⣿⡯⣏⠂⠀⠀⠀⠀⠀⠀⠀ ",
        "       ⠀⠀⠀⠙⢧⠀⠉⠿⣾⣿⢽⣺⣷⣦⡀⠀⠀⠀⠀⠀ ",
        "        ⠀⠀⠀⠀⠁⠀⠀⠀⢑⠏⠛⠟⠟⠿⠻⠲⠐⠀⠀ ",
      },
    "warlock", new String[] {
        "  ⠀⠀⢀⡆⢀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "  ⠘⡄⢱⠹⣷⡏⢜⢠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⢀⡉⢻⣧⣿⣧⣿⣁⠄⠀⠀⠀⠀⠀⢀⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⢈⠭⣿⣿⣿⠻⢄⠀⠀⠀⠸⡀⢠⣿⣿⣿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣳⠀  ",
        "⠀⠀⠀⠏⣿⠝⠂⠀⠀⠀⠀⣴⠋⣼⣿⣿⣿⣏⠉⡇⠀⠀⠀⠀⠀⠀⢰⣾⡋⠠  ",
        "⠀⠀⠀⠀⣻⠀⠀⠀⠀⠀⠀⣻⣶⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⢰⢷⡿⠿⠆  ",
        "⠀⠀⠀⠨⣿⣇⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⣸⢈⢡⣀⠀  ",
        "⠀⠀⠀⠀⢹⢻⣷⣤⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⢀⢀⣴⣿⠾⠓⠁⠀  ",
        "⠀⠀⠀⠀⢸⣠⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⡟⠉⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⣯⣿⣿⣿⢋⣿⣿⣿⣿⣿⣿⣿⣿⡏⢿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⡇⠛⢹⠀⣼⢻⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢻⣿⡇⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢸⡃⠀⢨⣺⠑⢸⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⡇⠀⠐⠙⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⡇⠀⠈⠘⠠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⡇⠀⠀⠀⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢐⣷⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⢰⡇⠀⠀⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠨⡇⠀⢰⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⡀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠈⠓⠾⠿⠿⠿⠿⠿⠿⠿⠿⣿⣿⣿⡿⠿⠿⠿⠛⠂⠀⠀⠀⠀⠀⠀  ",
      },
    "cleric", new String[] {
        "  ⠀⠀⠠⠐⢀⠀⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "  ⠀⠀⠄⢿⣤⠠⠀⠀⠀⠀⢀⣤⡀⠀⠀⠀⠀⠀⠀⠀⡴⢤⡀⠀ ",
        "    ⠀⠘⣯⠀⠐⠀⠀⢀⣾⣗⣿⣧⠀⠀⠀⠀⠀⢸⠠⡂⡇⠀ ",
        "⠀⠀⠀⠀⠀⢀⣯⣷⡄⠀⠀⠀⢿⣿⣽⡃⠀⠀⠀⠀⠀⠘⣎⡴⠁⠀ ",
        "⠀⠀⠀⠀⠀⢸⢿⣿⣿⣢⣀⢸⡾⡿⣟⣧⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⣯⣿⣿⣿⣿⣟⣿⣟⡷⣗⣿⣥⡀⠀⠀⠀⠀⢹⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠉⠙⡻⣿⢿⣏⣷⣷⣽⡿⣿⣿⡀⠀⠀⠀⡕⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣽⡷⣿⣿⣿⢿⣺⣿⣫⣶⣶⣾⢽⡂⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⣠⣿⣿⣿⣯⡏⣿⣿⣿⣿⡽⣿⣿⣿⣷⡇⡇⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⣰⣷⣿⣿⣿⢷⣫⣿⣿⣿⣿⣻⣽⢿⣿⢿⠃⡇⠀⠀⠀ ",
        "⠀⠀⠀⠀⣼⢿⣿⣿⣿⣿⣯⣿⣯⣿⣿⣿⢽⣾⣿⣎⠋⠠⡇⠀⠀⠀ ",
        "⠀⠀⠀⣼⣿⣿⣿⣿⣿⣗⣿⣗⣿⣿⣿⣟⣾⣷⣿⡾⡄⢸⡂⠀⠀⠀ ",
        "⠀⠀⣼⣿⣽⣿⣿⣿⣿⣾⣿⢷⣿⣿⣿⡗⣿⣿⢾⣿⣷⢸⠂⠀⠀⠀ ",
        "⠀⢀⣿⣷⣿⣿⣿⣿⣳⣿⣿⣼⢽⣿⣿⡯⡇⣿⡿⣿⣻⣽⠀⠀⠀⠀ ",
        "⠀⠐⣿⡏⠙⠻⣿⣟⣿⣿⣟⣿⣿⣿⣿⣿⡧⣿⣿⠻⢼⣿⠀⠀⠀⠀ ",
        "⠀⠀⠻⡧⠀⠀⠈⣽⣿⣿⣟⢷⣿⣻⣿⣟⣿⣿⣿⡀⡾⢻⠀⠀⠀⠀ ",
        "⠀⠀⠀⠙⠀⠀⢰⣿⣿⣿⣿⣿⣼⣵⣳⣏⣶⣿⣿⡇⠁⢸⠀⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠈⠙⠙⣿⢿⢿⣿⣿⣿⣿⣿⣿⡿⠫⠀⡕⠀⠀⠀⠀ ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢴⢿⠓⠀⠈⠉⠉⠁⠀⠿⢿⢤⠀⡇⠀⠀⠀⠀ ",
        "                           ",
      },
    "summoner", new String[] {
        "⠀⠀⠀⠀⠀⠀⠀⠀⣾⢀⡀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀",
        "  ⠀⠀⠀⠀⠀⠀⣹⡷⠁⠀⠀⠀⣸⡿⠻⣿⡆⠀⠀⠀⠀",
        "  ⠀⠀⠀⠀⠠⣾⣿⠅⠀⠀⠀⠀⣼⠱⣷⣽⠇⠀⠀⠀⠀",
        "    ⠀⠀⣾⣿⠋⠀⣀⡀⠀⠠⣿⠀⠈⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⢹⣿⡄⣼⣿⣿⣧⢀⡗⠀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠸⣿⣿⣻⣿⣿⣿⢳⡇⠀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⢿⣿⣄⠀⠀⠀⠀⠀⠀",
        "    ⠀⠀⢰⣿⣿⣿⣿⣿⠏⡿⠀⣙⣿⣿⠀⠀⠀⠀⠀",
        "    ⠀⢄⣾⣿⣿⣿⣿⡏⣴⣷⣿⣿⠟⠁⠀⠀⠀⠀⠀",
        "    ⠀⣿⣿⣿⣿⣿⣿⣅⢺⠛⠙⠁⠀⠀⠀⠀⠀⠀⠀",
        "    ⠀⢹⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "   ⠀⠀⣺⣿⣿⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "   ⠀⠀⣺⣿⣿⣿⣿⡟⣿⣿⣞⣷⣀⠀⠀⠀⠀⠀⠀⠀",
        "     ⣺⣿⣿⡯⣿⣷⢸⣿⣿⣼⣿⡄⠀⠀⠀⠀⠀⠀",
        "    ⢠⣿⣿⣼⠇⢻⣿⣾⠙⣿⣿⣿⣧⠂⠀⠀⠀⠀⠀",
        "   ⠀⢸⣿⣿⡏⠀⠀⠛⣿⣆⢻⣿⣿⣿⡔⠀⠀⠀⠀⠀",
        "  ⠀⢀⡿⣿⣿⠀⠀⠀⢀⡏⠙⢆⢻⣿⡎⢿⣦⡀⡀⠀⠀",
        "⠀⠀⠘⣰⣿⣯⠀⠀⠀⢰⠇⠀⠨⡂⣿⣿⡀⠙⠓⠣⠆⠁ ",
        "⠀⠐⢿⡿⡿⠛⠁⠀⠀⠸⠁⠀⠐⠀⠻⢿⡿⠇⠀⠀⠀⠀ ",
      },
    "rogue", new String[] {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣞⣾⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣴⣻⣺⢾⢽⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⣔⡿⡜⣯⣟⡾⣲⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣵⣝⢇⣟⣞⡺⣽⣳⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡾⠞⣛⣾⡺⡧⡏⢾⡽⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣤⢾⢯⢏⢰⣳⣓⢏⡿⣆⠈⢫⡷⣃⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⣠⡠⣞⡯⠛⠈⣌⡷⣝⣝⢽⣽⣀⡈⣯⢷⢧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢀⡠⢴⠸⢜⠈⡱⠁⠀⣤⢼⣾⣺⣗⣯⢷⢳⡯⣇⠀⠀⠹⡝⡨⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⣀⣤⢮⠳⠙⠉⠀⠈⠀⠀⣀⣪⡯⣯⣺⢸⡾⣽⢽⡇⡹⣽⢲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "      ⠀⠀⠀⠀⠀⠀⠠⢖⡿⣽⢾⡽⣐⡾⡯⣯⢷⣻⣆⠽⣞⣷⡹⣽⣒⠲⠤⠤⠒⠒⠒⠒⠢⢀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⡽⡷⣕⣷⣻⡽⡯⣯⢷⡏⢯⣟⡾⣽⣺⢼⡯⣷⣳⣗⡿⠝⠷⢲⡄⠀⠀",
        "⠀⠀⠀⣀⠄⠀⠀⠀⠀⠀⠀⢀⠼⠝⡯⣟⡾⣵⠙⠀⠉⠫⣯⢳⣗⣟⣗⣯⡯⣯⢷⡳⡷⢧⢰⢆⠀⠛⠀⠀",
        "⠀⠀⢰⡇⠀⣴⢋⣁⡀⠀⠀⠀⠀⠀⣺⣽⡝⣼⢇⠀⠀⠀⠈⠃⡵⣯⢷⠳⡏⠫⢿⢄⠥⠤⣅⠉⠇⠀⢠⠀",
        "⠀⠲⡘⣗⡄⢳⣟⠊⠉⠲⣄⡀⠀⠀⣟⡎⢀⠛⠀⠀⠀⠀⠀⠀⠁⢻⡽⡄⠉⠒⠀⠉⠳⠀⢸⠆⠀⢀⡖⠀",
        "⠀⠀⠑⠪⢯⣗⣝⡳⠤⡄⡀⠀⢠⡼⡽⠂⠋⠀⠀⠀⠀⠀⠀⠀⢀⠀⣟⣗⣀⠀⠐⣄⣀⡴⣯⢴⠮⠋⠀⠀",
        "⠀⠀⠀⠐⠢⡭⣚⣗⣖⣢⡠⠤⢘⣒⣈⣠⡤⣼⠤⠀⠀⠀⡄⠀⢠⡇⠈⠚⠓⠓⣠⣗⡯⠿⢙⣉⠄⠊⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠉⠚⠽⠾⡽⠻⡳⣗⣟⣮⣭⣤⣤⢤⠴⠞⡃⠼⠓⠁⠤⠲⠮⠟⢗⠯⠟⠙⠁⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⠀⠁⠁⠑⠑⠒⠂⠀⠀⠊⠐⠓⠋⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
      },
    "archer", new String[] {
      "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⣲⠳⠀",
      "⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⢠⠎⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⡦⡀⠤⠀⠀⠠⢹⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⣀⣶⣿⣿⣿⣿⣿⣿⡿⣿⣝⢕⠀⠈⡠⠁⡸⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠻⣅⢳⡐⠀⠀⡇⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⣿⣿⣿⠢⠀⡝⠐⡀⢠⠃⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⣿⣿⡟⢿⣿⣿⣿⣿⣿⣄⠔⠀⠀⠀⡜⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠠⣾⣿⣿⡧⢈⣽⣿⣿⣿⣿⣿⣧⣄⠀⣸⠃⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠠⣄⠸⣿⣿⢢⣿⣿⣿⣿⣿⣿⣿⡝⠻⣿⡗⠀⠀⠀⠀⠀⠀⠀",
      "⠀⢄⣰⣤⣜⠄⢿⣿⣼⣿⣿⣿⣿⣿⣿⣿⣟⣠⠏⠀⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠓⠽⡻⢒⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠑⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⢀⣿⣿⠙⠻⠛⠛⠻⠻⠿⣿⣿⠿⠿⠿⠟⠛⠁⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⣸⣿⡇⠀⠀⠀⠀⠀⠀⢐⣿⣿⣤⣀⣢⠀⠀⠀⠀⠀⠀⠀",
      "⠀⠀⠀⠀⠀⠻⣿⠗⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠋⠁⠀⠀⠀⠀⠀⠀⠀",
      },
    "healer", new String[] {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⠀⠀",
        "⠀⠀⠤⠤⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣗⠀⠀",
        "⠀⢲⣶⣶⡼⠂⠀⠀⠀⠀⠀⠀⠀⣠⣶⣶⣶⡀⠀⠀⠀⠀⠀⢸⣿⡃⠀",
        "⠀⢼⣻⠋⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⣸⡟⠀⠀",
        "⠀⢀⣸⠅⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣇⣀⠀⠀⠀⣰⣿⡇⠀⠀",
        "⠈⠉⠛⠻⣦⡀⠀⠀⠀⢀⣠⣶⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⢿⠂⠀⠀",
        "⠀⠀⠀⠀⠘⢿⣶⣄⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠉⠉⠀⣺⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠈⠻⠿⠿⠛⢻⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⡿⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⣀⡀⡏⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣿⣿⣿⣿⣿⠆⠀⠙⢷⣧⡀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⡁⠀⠀⢸⡃⢽⡆⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢼⣿⣿⣿⣿⣿⣿⣿⣿⡅⠀⢀⣸⣧⠟⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⣿⣿⣿⣿⣿⣿⣿⣿⡅⠀⢼⣹⠂⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢽⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠈⣿⢷⡄⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣷⠀⣀⣿⠾⠁⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⣿⡇⣼⠋⡇⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠹⢷⣧⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⢸⡍⢷⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠟⣿⡟⠛⠛⣿⡏⠉⠀⠀⣸⠆⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣰⣿⡇⠀⠀⠻⢿⣶⡄⠀⠸⠁⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⠛⠁⠀⠀⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀",
      },
    "tank", new String[] {
        "           ⠀⠀⠀⠀⣤⠀⠀⠀⠀⣶⣆⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "         ⠀⠀⠀⠀⠀⣼⣿⣧⠀⠀⣾⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀ ",
        "         ⣀⣀⠀⠀⣸⡏⠀⠹⣇⣼⢏⣠⣤⣖⡀⠀⠀⠀⠀⠀⠀  ",
        "        ⠱⣿⣿⣿⣷⣿⣥⣦⣤⣿⣿⣿⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀ ",
        "         ⠾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⣭⡀⠀⠀⠀⠀⠀",
        "        ⠀⠉⠽⣿⣿⣿⣿⣿⣿⣿⣿⣟⣟⣷⠁⣰⣿⣧⠀⠀⠀⠀⠀ ",
        "       ⠀⠀⠀⡈⣿⣿⣿⣿⣿⣿⡿⡝⠹⣿⣷⣼⣿⣿⣿⣡⠤⠊⠀⠀ ",
        "     ⠀⠀⠀⠀⠀⠀⣿⢿⣿⣿⣿⣿⣾⣾⣇⠀⠉⣿⣿⣿⣿⣿⣷⣤⠀⣀⠄",
        "   ⠀⠀⠀⠀⠀⠀⠀⡯⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣼⣿⣿⣿⣿⣿⣿⣯⠀⠀ ",
        " ⠀⠀⠀⠀⠀⠀⠀⠠⣗⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠁⠀  ",
        " ⠀⠀⠀⠀⠀⠀⢀⣞⢹⣿⣿⣿⣿⣿⣿⣿⣿⣝⠋⣿⣿⡿⣿⡿⠟⠀⠙⠀⠀  ",
        " ⠀⠀⢀⣤⣀⣠⣿⠁⣾⣿⣿⣿⣿⣟⣿⣿⣿⣷⠀⠉⠙⠁⠈⠁⠀⠀⠀⠀⠀  ",
        " ⠀⢠⣿⣿⣿⣿⣷⡀⢹⣿⣿⡿⣿⣵⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⣠⣿⣿⣿⣿⣿⡿⠀⠹⣿⣿⣻⣿⡗⣿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠐⣻⣿⣿⣿⣿⡿⠁⠀⠀⣿⣿⣯⣿⡇⢻⣿⢿⢯⣿⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠈⠙⠿⣿⡿⠁⠀⠀⠀⢿⣿⣿⠺⣿⠀⡏⣿⣿⣿⡏⠀⠀⠀⠀       ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⠀⠋⠀⠀⠘⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡿⠀⠀⠀⠀⠀⠘⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣿⣿⡿⠀⠀⠀⠀⠀⠀⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠊⠋⠋⠁⠀⠀⠀⠀⠀⠀⠀⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀  ",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀  ",
      },
    "warrior", new String[] {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡮⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⡯⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣹⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠀⠀⠀⠀⠀⢠⡗⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⢽⣻⣄⣄⣤⣤⢼⡂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⣯⣟⣖⠨⡾⡞⣯⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣲⣲⣤⡈⣶⣞⡾⡄⠛⢒⣷⣻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⣰⢿⣽⣳⡯⡧⣷⢯⣟⡗⣈⣶⣻⠂⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠠⣿⢽⠞⡇⠁⠀⠉⣟⣾⡳⠟⡚⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀⢘⢷⣤⣠⣷⣻⡎⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣟⣾⣳⣟⣞⣷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣞⣷⣻⣞⣷⣻⣞⣷⣻⣞⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠺⣗⣟⡾⡾⡎⠀⠈⠺⣳⣻⢾⣵⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣮⢿⣽⡻⠀⠀⠀⠀⠀⠙⠽⣾⢽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢿⡽⡾⠁⠀⠀⠀⠀⠀⠀⠀⣹⣟⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣟⡯⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢟⣾⡂⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⣠⢾⡳⠏⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢺⢷⡀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⢀⣴⠟⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣇⡀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⣟⣾⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠫⠻⠱⠢⠀⠀⠀⠀",
      },
    "solarium silks", new String[] {
        "⠀⠀⠀⠀⢰⣿⡛⠛⠛⣻⡆⠀⠀⠀⠀",
        "⠀⠀⣀⡤⠼⣌⣻⣄⣾⣩⡿⠶⣤⣀⠀",
        "⠀⠈⡿⣦⣄⡈⠛⣿⡟⢁⣠⣴⣿⠃⠀",
        "⠀⢸⡇⢡⠉⠙⠻⣦⠿⠋⠁⡸⢹⡄⠀",
        "⠀⢸⡇⠈⣇⡀⠀⣿⠀⠀⢰⠇⢸⡇⠀",
        "⠀⢸⡇⠀⢹⠙⠷⣿⡾⠋⣽⠀⢸⡇⠀",
        "⠀⢸⡇⠀⡿⠙⢦⣿⡔⠀⢹⡀⠸⣿⠀",
        "⠀⣾⠃⢸⠇⠀⠈⣿⠀⠀⠈⣧⠀⣿⠀",
        "⢠⣿⣦⡿⠀⠀⠀⣽⠀⠀⠀⢿⣴⢿⣇",
        "⠾⣅⢸⠇⠀⠀⠀⣿⡇⠀⠀⠸⣯⣴⠟",
        "⠀⠈⣿⠀⠀⠀⢰⠏⡇⠀⠀⠀⣿⡁⠀",
        "⠀⢰⡇⠀⠀⠀⢸⠀⣿⠀⠀⠀⢸⡇⠀",
        "⠀⣼⡇⠀⠀⠀⣿⠀⣿⠀⠀⠀⠈⣷⠀",
        "⠀⣿⠀⢀⣤⡤⣿⠀⣿⠶⣤⡀⠀⣿⠀",
        "⠀⣿⣰⠟⣡⣴⠿⠀⠿⣤⣈⠻⣦⢸⡇",
        "⢠⣿⠏⣴⠋⠀⠀⠀⠀⠀⠙⣷⡘⢿⡇",
        "⢸⣧⡾⠃⠀⠀⠀⠀⠀⠀⠀⠈⢿⣾⡇",
        "⠈⠛⠓⠶⣦⣤⣤⣤⣤⣤⠴⠶⠛⠉⠁",
    }
  );


    private final static String[] hardGate = {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⣰⣶⣶⣦⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⣀⠀⡀⠀⠀⣴⣿⠟⠛⠉⠉⠉⠉⠛⠻⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⣤⣠⣼⠁⢠⣷⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⣿⡆⠀⠒⢂⡀⠀⠀⠀",
        "⠀⠀⠀⠶⣶⡄⢀⣚⣛⠀⠀⠀⡀⠀⠀⠀⠀⢀⠀⠀⠈⣛⣚⡀⢃⡛⢃⠀⠀⠀",
        "⠀⠀⢤⣭⣍⡄⠈⢿⣻⠀⠀⢀⣿⣶⡄⢠⣴⣿⡀⠀⠈⣿⡿⠁⠌⠟⠨⠀⠀⠀",
        "⠀⠀⣨⢉⣵⣯⠀⣿⣿⠀⠀⢰⣍⡋⠀⠈⢙⣩⡆⠀⠀⣿⣿⠀⡗⠾⠟⠀⠀⠀",
        "⠀⠀⣨⣬⣭⣿⠀⡹⣿⠀⠀⠀⠻⣿⣿⣿⣿⠟⠀⠀⠀⣿⣯⠀⢿⠟⠸⠀⠀⠀",
        "⠀⠀⢉⣩⣭⣛⠀⣵⣿⠠⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⣿⣛⠀⣿⣿⣧⠀⠀⠀",
        "⠀⠀⢘⣀⣟⣟⠀⣾⣿⢰⠀⠀⠀⠰⠒⠓⠆⠀⠀⠀⡇⣿⣿⠀⣶⣶⡶⠀⠀⠀",
        "⠀⠀⠈⢛⣯⣻⠀⣿⣿⢸⠀⠀⠀⠹⢦⡴⠎⠀⠀⠀⡇⣿⣿⠀⣿⣶⠀⠀⠀⠀",
        "⠀⠀⠀⠘⢛⡛⠀⡾⣯⢸⠀⠀⠀⡄⢰⢀⢠⠀⠀⠀⡅⣿⣯⠀⠗⠁⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⢐⣚⣻⣻⠀⠠⠀⡥⢸⠊⢸⠰⠀⡀⣿⣷⣒⠂⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠂⠀⠘⠿⣿⣿⣀⣐⣒⣓⣾⣒⣾⣒⣒⣀⣿⣿⠟⠇⠀⠀⠄⠀⠀⠀",
        "⠀⠀⠀⣠⣴⣤⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣴⣶⣦⠄⠀⠀⠀",
        "⠀⠀⠀⠀⠁⠈⠃⠺⠋⠟⠻⠿⠿⠽⠿⠿⠹⠟⠛⠛⠚⠛⠈⠛⠀⠀⠀⠀⠀⠀",};

    private final static String[] fire = {
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠀⠀⠀⠠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡇⠀⡀⠀⢰⢧⠀⠚⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠱⣀⢠⢀⢀⠇⢇⢔⠀⠀⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡄⠀⠀⢠⢹⢀⡆⠎⣈⠂⡔⠙⠊⠀⠰⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠄⠀⡘⢜⠇⠰⠁⡈⠄⠡⠰⠑⡄⢆⢇⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⣀⡆⡆⠀⣑⠘⠊⠀⠀⠀⠣⠁⠘⠁⣋⣘⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⡀⠠⠙⠥⣕⣡⠡⠀⠀⠠⢄⠂⡇⠄⠆⢘⠣⣛⣏⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⢀⠀⠑⢠⣶⣷⣤⠑⢭⠈⡄⠈⡀⠄⢃⢡⠄⠀⢨⢳⣿⣿⣆⣠⣴⣦⠀⠄⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡦⠜⢿⣿⣿⣯⡿⡤⢞⠩⠲⣁⡎⡎⠀⠀⠤⠸⡉⣏⣠⣶⣮⣿⡇⠄⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⢀⡠⢤⢤⣾⣿⣾⣷⡿⢛⠻⡉⢤⣂⣵⣴⣏⢧⡀⢨⠵⡢⢄⣴⣿⣿⣿⡿⢯⣁⠀⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⣠⡞⠉⠡⣼⣝⣟⣁⣘⣌⣦⣵⣾⣿⣟⠻⢿⣿⣜⣗⣶⣦⣄⣐⣀⠹⡿⠿⣿⡖⠮⠁⣒⣒⢤⢄⠀⠀⠀",
        "⠐⠒⠟⣿⢟⣾⣿⣮⣯⣾⡿⣾⣿⣿⣟⣿⠿⢾⡍⠟⡼⠁⢐⠽⣿⢿⣿⣶⣥⣹⣿⣿⣷⣷⣦⢀⣄⣀⡨⡇⠀⠀",
        "⠀⠀⠴⠾⠉⣷⠶⡟⠋⠤⢍⣤⣽⣛⠻⣅⡈⣀⣈⣻⣳⣌⠈⠠⠊⢻⣿⣿⣿⣿⣿⡟⣛⣿⡿⢿⠿⠛⠻⠛⠛⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠛⠒⣺⡿⠛⠻⠵⣦⠬⠿⠿⠿⠿⠿⠿⠿⠿⠿⢛⡻⠟⠟⠃⠁⠩⠿⠉⠈⠀⠀⠀⠀⠀⠀⠀",
        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",};

      private static final Map<String, String[]> itemBank = Map.of(

        "PotionA", new String[] {
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠠⡶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣘⣹⡆⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⣧⠀⠞⠛⠛⠡⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣖⡤⣤⡘⠃⢮⠆⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢲⠷⢿⣿⣿⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢌⣛⣠⣿⣶⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠹⢿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠊⠀⢤⡄⡀⠩⡙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠄⠒⠉⠁⣀⣀⡀⠰⠶⢰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠉⣠⠂⠀⣲⣦⣜⣛⡧⣦⣄⣈⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⢰⢀⡾⠁⡠⠛⠿⢿⣿⣿⣿⣿⣿⣿⡌⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣇⣰⣷⣦⣿⣿⣿⣿⣿⣿⣿⣿⣷⡘⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣯⣿⣿⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⠇⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢫⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣿⣿⣿⣿⣿⣿⣿⠟⡫⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⠿⣿⡟⢋⠔⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        },
        "PotionB", new String[] {
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠖⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⢩⡆⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠯⢇⠠⠞⠚⠃⢡⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⣒⠤⢄⡘⠁⠎⠆⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⢒⠦⢃⡞⣘⢮⡵⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢎⡌⡰⣉⠲⣍⣚⢡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠨⢱⢣⢯⢜⡸⠂⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠊⠀⢦⡁⠢⢌⡘⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠐⠊⢡⠐⡌⣒⠠⡘⠇⢢⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⠁⡴⠈⢀⣃⠮⣐⡉⠦⣱⣌⡂⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⢘⡀⡟⠀⡄⢓⠸⠲⣍⡿⣳⡜⣧⢻⡄⢆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⢢⣙⢆⡰⡘⢦⣉⢗⡮⣝⢳⣻⣼⢣⢶⠈⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⢰⣚⢆⣱⣋⢶⡹⣎⢷⡳⣦⢷⣚⢧⣞⠃⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠰⢸⡇⢶⣳⢾⣽⡹⢆⣻⣥⠟⣎⡳⢎⡸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢣⢿⡨⣽⣻⠾⣽⢯⡗⣏⢫⠴⣉⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠨⣜⢳⣔⠫⠟⣏⢻⡜⠜⡡⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠳⡚⠿⢛⡚⢃⠔⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
          "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀",
        }
      );




    /**
     * Formats raw ASCII art to fit within specified width and height, centering the art.
     * When art is too wide, cuts equally from both sides to preserve the center.
     */
    /**
     * Formats raw ASCII art to fit within specified width and height, centering the art.
     * When art is too wide, cuts equally from both sides to preserve the center.
     */
    private static String[] formatArt(String[] rawArt, int width, int height) {
        try {
            // If no art found, return empty array
            if (rawArt.length == 0) {
                String[] result = new String[height];
                for (int i = 0; i < height; i++) {
                    result[i] = " ".repeat(width);
                }
                return result;
            }

            String[] result = new String[height];
            Arrays.fill(result, " ".repeat(width));
            int paddingTop, paddingBottom, paddingLeft = rawArt[0].length(), paddingRight;

            for (String line : rawArt) {
                if (line.length() != paddingLeft) {
                    return new String[0];
                }
            }

            // Calculate padding to center the art
            paddingTop = (int) ((float) (height - rawArt.length) / 2);
            paddingLeft = (int) ((float) (width - rawArt[0].length()) / 2);
            paddingBottom = height - paddingTop;
            paddingRight = width - paddingLeft;

            for (int i = 0, j = 0; i < height; i++) {
                if (i < paddingTop || i >= paddingBottom) {
                    // Pad top and bottom
                    result[i] = " ".repeat(width);
                    continue;
                }
                String line = rawArt[j++];
                if (paddingLeft > 0) {
                    // Pad left
                    line = Utils.center(line, width);
                } else {
                    // Trim left
                    line = line.substring(-paddingLeft, paddingRight);
                }
                result[i] = line;
            }

            return result;
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    /**
     * Formats raw ASCII art to fit within specified width and height, cutting from the right side when too wide.
     * Favors preserving the left side of the art.
     */
    private static String[] formatArtLeftAlign(String[] rawArt, int width, int height) {
        try {
            // If no art found, return empty array
            if (rawArt.length == 0) {
                throw new Exception("No Art Found");
            }
            
            // Throw when inconsistent width length
            for (String line : rawArt) {
                if (line.length() != rawArt[0].length()) {
                    throw new Exception("Inconsistent line lengths in art");
                }
            }

            // Calculate vertical padding to center the art vertically
            int paddingTop = (int) ((float) (height - rawArt.length) / 2);
            int paddingBottom = height - paddingTop;
            
            String[] result = new String[height];
            for (int i = 0, j = 0; i < height; i++) {
                if (i < paddingTop || i >= paddingBottom) {
                    // Pad top and bottom
                    result[i] = " ".repeat(width);
                    continue;
                }
                result[i] = Utils.rightAlign(Utils.leftAlign(rawArt[j++], rawArt[0].length()/2), width);
            }

            return result;
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    /**
     * Formats raw ASCII art to fit within specified width and height, cutting from the left side when too wide.
     * Favors preserving the right side of the art.
     */
    private static String[] formatArtRightAlign(String[] rawArt, int width, int height) {
        try {
            // If no art found, return empty array
            if (rawArt.length == 0) {
                throw new Exception("No Art Found");
            }
            
            // Throw when inconsistent width length
            for (String line : rawArt) {
                if (line.length() != rawArt[0].length()) {
                    throw new Exception("Inconsistent line lengths in art");
                }
            }
            
            // Calculate vertical padding to center the art vertically
            int paddingTop = (int) ((float) (height - rawArt.length) / 2);
            int paddingBottom = height - paddingTop;
            
            String[] result = new String[height];
            for (int i = 0, j = 0; i < height; i++) {
                if (i < paddingTop || i >= paddingBottom) {
                    // Pad top and bottom
                    result[i] = " ".repeat(width);
                    continue;
                }
                result[i] = Utils.leftAlign(Utils.rightAlign(rawArt[j++], rawArt[0].length()/2), width);
            }

            return result;
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    /**
     * Gets formatted ASCII art by name with center alignment (default behavior).
     * When art is too wide, cuts equally from both sides to preserve the center.
     * Available arts: "Wardkeeper's Refuge", "Aindrajalika Gate", "cleric", "summoner", "rogue", "archer", "healer", "tank", "warrior", "mage", "warlock"
     * @param name Name of the art
     * @param width Desired width
     * @param height Desired height
     * @return returns center-aligned ASCII art as a String array
     */
    static public String[] getFormattedArt(String name, int width, int height) {
        try {
            return formatArt(characterBank.get(name.toLowerCase()), width, height);
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    /**
     * Gets formatted ASCII art by name with left alignment.
     * When art is too wide, cuts from the right side to preserve the left portion.
     * Available arts: "Wardkeeper's Refuge", "Aindrajalika Gate", "cleric", "summoner", "rogue", "archer", "healer", "tank", "warrior", "mage", "warlock"
     * @param name Name of the art
     * @param width Desired width
     * @param height Desired height
     * @return returns left-aligned ASCII art as a String array
     */
    static public String[] getFormattedArtLeftAlign(String name, int width, int height) {
        try {
            return formatArtLeftAlign(characterBank.get(name.toLowerCase()), width, height);
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    /**
     * Gets formatted ASCII art by name with right alignment.
     * When art is too wide, cuts from the left side to preserve the right portion.
     * Available arts: "Wardkeeper's Refuge", "Aindrajalika Gate", "cleric", "summoner", "rogue", "archer", "healer", "tank", "warrior", "mage", "warlock"
     * @param name Name of the art
     * @param width Desired width
     * @param height Desired height
     * @return returns right-aligned ASCII art as a String array
     */
    static public String[] getFormattedArtRightAlign(String name, int width, int height) {
        try {
            return formatArtRightAlign(characterBank.get(name.toLowerCase()), width, height);
        } catch (Exception e) {
            String[] art = new String[height];
            Arrays.fill(art, " ".repeat(width));
            return art;
        }
    }

    static public ArrayList<String[]> getAllFormattedArt(String type, int width, int height) {
        ArrayList<String[]> list = new ArrayList<>();
        for (String[] art : switch(type.toLowerCase()) {
            case "items" -> itemBank.values();
            default -> characterBank.values();
        }) {
          list.add(formatArtLeftAlign(art, width, height));
        }
        return list;
    }
    
    static public ArrayList<String[]> getAllLeftAlignedArt(String type, int width, int height) {
        ArrayList<String[]> list = new ArrayList<>();
        
        for (String[] art : switch(type.toLowerCase()) {
            case "items" -> itemBank.values();
            default -> characterBank.values();
        }) {
          list.add(formatArtLeftAlign(art, width, height));
        }
        return list;
    }
    
    static public ArrayList<String[]> getAllRightAlignedArt(String type, int width, int height) {
        ArrayList<String[]> list = new ArrayList<>();
        for (String[] art : switch(type.toLowerCase()) {
            case "items" -> itemBank.values();
            default -> characterBank.values();
        }) {
          list.add(formatArtLeftAlign(art, width, height));
        }
        return list;
    }



    /**
     * Gets ASCII art by name. Available arts: "Wardkeeper's Refuge",
     * "Aindrajalika Gate", "cleric", "summoner", "rogue", "archer", "healer",
     * "tank", "warrior", "mage", "warlock"
     */
    static public String[] getCharacterArt(String name) {
        return characterBank.get(name.toLowerCase());
    }
}

// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣴⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⣸⣿⣿⣫⠄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢶⣶⣉⢇⣤⣿⣿⣾⡿⣷⣌⢐⣶⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⢹⣿⣿⣿⣿⣿⣷⢾⣿⣿⣿⣿⣧⣀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⣠⣷⣳⢯⣿⣿⣿⣿⣿⣮⢻⣿⣿⣿⣿⣿⣍⠻⠢⢄⡀⠀⠀
// ⠀⠀⠀⠀⠀⢀⣾⣿⣧⢣⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢽⣷⣀⠀⠺⢄⠀
// ⠀⠀⠀⢀⡔⣻⣿⢫⢧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⢳⡙⠷⣄⣰⠆
// ⠀⢠⣼⣿⣞⣿⡏⣾⡞⠋⠿⠿⢏⣿⣿⣿⣿⣿⡇⠉⠛⠿⠿⣿⡄⢳⣄⣭⠁⠁
// ⠠⠟⠃⢿⡟⣱⢧⣿⠀⠀⠀⣸⣾⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠈⡏⠀⢿⡿⠀⠀
// ⠀⠀⠠⠾⡻⣿⠨⣿⠀⠀⢠⣿⠏⣿⣿⣿⣿⣿⣿⡅⠀⠀⠀⠀⠇⠆⠈⣃⠀⠀
// ⠀⠀⠀⠀⠀⢹⡇⠇⡄⠀⢸⡟⡘⣿⣿⣿⡏⢿⣿⣿⣤⠀⠀⠀⠠⢸⣠⠋⠀⠀
// ⠀⠀⠀⠀⠀⠘⢷⣤⢏⠀⣸⢃⢰⣿⣿⣿⡇⢸⣿⡿⠗⠳⡀⠀⠀⡟⣋⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠈⠉⠒⠃⣏⢸⠀⢻⣿⢿⣇⠸⣿⡏⠈⢦⡼⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⢿⣄⠘⢿⡄⠉⠺⢻⡏⣴⣞⠧⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠻⠯⠬⣿⣦⡀⢸⡿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣷⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
// ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
