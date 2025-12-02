package com.infinityfortress.ui.PathMenu;

import java.util.ArrayList;

import com.infinityfortress.utils.ArtManager;
import com.infinityfortress.utils.Utils;

class Path {
  String name;
  String description;
  StringBuilder frame;
  int[] coords;

  public Path(String name, String description, int[] coords) {
    String[] art = ArtManager.getFormattedArt(name, 35, 16);
    StringBuilder frame = new StringBuilder();
    int width = 35, height = 18;
    
    frame.append("\033[").append(coords[0]).append(";").append(coords[1]).append("H┌").append("─".repeat(width)).append("┐");
    for (int i=0; i<height; i++) {
      frame.append("\033[").append(coords[0] + 1 + i).append(";").append(coords[1]).append("H│");
      if (i < height-2) {
        frame.append(art[i]);
      } else if (i == height-2) {
        frame.append("─".repeat(width));
      } else {
        frame.append(Utils.center(name, width));
      }
      frame.append("│");
    }
    frame.append("\033[").append(coords[0] + height + 1).append(";").append(coords[1]).append("H└").append("─".repeat(width)).append("┘");
    this.name = name;
    this.description = description;
    this.frame = frame;
  }
};

public class PathUI {
  private final Path[] paths;
  
  public PathUI(int a, int b) {
    ArrayList<Path> pathList = new ArrayList<>();
    pathList.add(new Path("Aindrajalika Gate", "A foreboding passage marked by ancient markings. Beyond this gate, enemies are fiercer but the spoils of victory are much greater.", new int[] {7, 20}));
    pathList.add(new Path("Wardkeeper's Refuge", "A tranquil alcove bathed in warm light where weary travelers can rest, recover their strength, and ready themselves for the road ahead.", new int[] {7, 63}));
    pathList.add(new Path("The Hollow Signpost", "An abandoned, shifting shopfront crafted from impossible stillness and splintered wood.", new int[] {7, 63}));
    
    // Pick random 2 paths
    this.paths = new Path[] { pathList.get(a), pathList.get(b) };

    // Initialize UI
    StringBuilder frame = new StringBuilder();
  
    // Inner Frame
    frame.append("\033[3;4H┌").append("─".repeat(111)).append("┐");
    for (int i = 0; i < 27; i++)
      frame.append("\033[").append(i + 4).append(";4H│").append(" ".repeat(111)).append("│");
    frame.append("\033[31;4H└").append("─".repeat(111)).append("┘");
    
    int startX = 5, startY = 4;
    frame.append("\033[").append(startY+1).append(";").append(startX).append("H").append(Utils.center("A FORK HAS APPEARED BEFORE YOU", 111));
    frame.append(this.paths[0].frame).append(this.paths[1].frame);

    Utils.initiallizeBorders();
    System.out.print(frame.toString());
  }
  
  public StringBuilder getFrame(int curr) {
    return this.paths[curr].frame;
  }

  public void updateChoice(int choice) {
    StringBuilder frame = new StringBuilder();
    int startX = 25, startY = 28, width = 71;
    
    String text = switch (choice) {
      case 0 -> this.paths[0].description;
      case 1 -> this.paths[1].description;
      default -> "The sound of footsteps comes to a halt — two paths diverge before you, each holding its own fate.";
    };
    
    String[] infoLine = Utils.createTextGrid(2, width, text);
    for (int i = 0; i < infoLine.length; i++) {
      frame.append("\033[").append(startY+i).append(";").append(startX).append("H").append(Utils.center(infoLine[i], width));
    }
    
    if (choice>=0) {
      int[] choices = new int[] {18, 61};
      int w=35, h=18;

      for (int i=0; i<choices.length; i++) {
        if (i==choice) {
          frame.append("\033[6;").append(choices[i]).append("H┌").append("─".repeat(w + 4)).append("┐");
          for (int j=0; j<h+2; j++) {
            frame.append("\033[").append(7 + j).append(";").append(choices[i]).append("H│");
            frame.append("\033[").append(7 + j).append(";").append(choices[i] + w + 5).append("H│");
          }
          frame.append("\033[").append(7+h+2).append(";").append(choices[i]).append("H└").append("─".repeat(w+4)).append("┘");
        } else {
          frame.append("\033[6;").append(choices[i]).append("H ").append(" ".repeat(w+4)).append(" ");
          for (int j=0; j<h+2; j++) {
            frame.append("\033[").append(7 + j).append(";").append(choices[i]).append("H ");
            frame.append("\033[").append(7 + j).append(";").append(choices[i] + w + 5).append("H ");
          }
          frame.append("\033[").append(7 + h + 2).append(";").append(choices[i]).append("H ").append(" ".repeat(w+4)).append(" ");
        }
      }
    }
    
    // return frame;
    System.out.print(frame.toString());
  }
}
//117

// Rampart Market
// Wardkeeper’s Refuge
// Shade Gate
// Aindrajalika Gate


// 27: 35