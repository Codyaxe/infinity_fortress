package com.infinityfortress.ui.GachaMenu;

import com.infinityfortress.utils.Utils;

import java.util.concurrent.atomic.AtomicInteger;

import com.infinityfortress.utils.Animate;
import com.infinityfortress.utils.ArtManager;

import java.util.HashMap;
import java.util.Map;

public class MainGachaUI {

    private int gems;
    
    private final Map<String, Integer> initialIndex = Map.of (
      "c", 1,
      "w", 2,
      "ar", 3,
      "ac", 4
    );

    private final Map<String, AtomicInteger> bannerIndex = new HashMap<>(
      Map.of(
        "c", new AtomicInteger(1),
        "w",new AtomicInteger(2),
        "ar", new AtomicInteger(3),
        "ac", new AtomicInteger(4)
      )
    );

    public MainGachaUI(int gems) {
        this.gems = gems;
        System.out.print(Utils.getInnerBorder().toString());
        display();
        initializeBannerAnimations();
    }

    public final void display() {
        System.out.print(
                Utils.getInnerBorder()
                        
                        .append(getBannerBorderCenter())
                        .append(showGems(true))
                        .toString());
    }

    public final void displayBanner(int currBanner) {
      bannerIndex.replaceAll((k,v)->{
        v.set(initialIndex.get(k)-currBanner);
        return v;
      });

      System.out.print(
        getBannerTitle(currBanner).append(getPullOptions(-1))
        .append(bannerIndex.get("c").get()==1? getBannerBorderLeft(false): getBannerBorderLeft(true))
        .append(bannerIndex.get("ac").get()==1? getBannerBorderRight(false): getBannerBorderRight(true))
        .toString()
      );
    }

    public final void displayPullOptions(int choice) {
      bannerIndex.replaceAll((k,v)->{
        if (v.get()!=1) {
          v.set(-1);
        }
        return v;
      });
        System.out.print(
                getPullOptions(choice).append(getBannerTitle(-1))
                        .append(getBannerBorderLeft(false))
                        .append(getBannerBorderRight(false))
                        .toString()
        );
    }

    public final void displayPullingUI() {
      bannerIndex.replaceAll((k,v)->{
        v.set(-1);
        return v;
      });
      System.out.print(
        getPullOptions(-1)
        .append(getBannerTitle(-1))
        .append(showGems(false))
        .toString()
      );
    }

    public final StringBuilder getPullOptions(int choice) {
        try {
            if (choice != 0 && choice != 1) {
                throw new Exception("Invalid Choice for Pull Options");
            }

            StringBuilder frame = new StringBuilder();
            int width = 12;
            String one = "ONE PULL";
            String ten = "TEN PULL";
            int[][] optionCoords = {
                {28, 30, 41, 54}, //ONE PULL
                {28, 30, 64, 77} //TEN PULL
            };
            String[] optionIndicators = {"┌", "┐", "└", "┘"};
            frame.append("\033[29;42H").append(Utils.center(one, width));
            frame.append("\033[29;65H").append(Utils.center(ten, width));
            for (int i = 0; i < optionIndicators.length; i++) {
                frame.append("\033[").append(optionCoords[choice][i / 2]).append(";").append(optionCoords[choice][2 + i % 2]).append("H").append(optionIndicators[i]);
                frame.append("\033[").append(optionCoords[1 - choice][i / 2]).append(";").append(optionCoords[1 - choice][2 + i % 2]).append("H").append(" ");
            }
            return frame;
        } catch (Exception e) {
            StringBuilder frame = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                frame.append("\033[").append(28 + i).append(";").append(30).append("H").append(" ".repeat(28 + 12 + 13 + 12));
            }
            return frame;
        }
    }

    public final StringBuilder getBannerTitle(int currBanner) {
        try {
            if (currBanner < 0 || currBanner > 3) {
                throw new Exception("Invalid Banner Index");
            }

            StringBuilder frame = new StringBuilder();
            int width = 111;
            String title = switch (currBanner) {
                case 0 ->
                    "Character";
                case 1 ->
                    "Weapon";
                case 2 ->
                    "Armor";
                case 3 ->
                    "Accessory";
                default ->
                    "Null";
            };
            
            frame.append("\033[5;5H").append(Utils.center("SHOP", 111));
            frame.append("\033[6;5H").append(Utils.center(title + " Banner", width));

            return frame;
        } catch (Exception e) {
            StringBuilder frame = new StringBuilder();
            frame.append("\033[5;5H").append(" ".repeat(111));
            frame.append("\033[6;5H").append(" ".repeat(111));
            return frame;
        }
    }

    public final StringBuilder getBannerBorderLeft(Boolean isVisble) {
        try {
            if (!isVisble) {
              throw new Exception("Left Banner Border Not Visible");
            }
            StringBuilder frame = new StringBuilder();
            int startY = 7, startX = 5, width = 23, height = 18;
            frame.append("\033[").append(startY).append(";").append(startX).append("H").append("─".repeat(width)).append("┐");
            for (int i = 0; i < height; i++) {
              frame.append("\033[").append(startY + 1 + i).append(";").append(startX + width).append("H│");
            }
            frame.append("\033[").append(startY + height + 1).append(";").append(startX).append("H").append("─".repeat(width)).append("┘");
            return frame;
          } catch (Exception e) {
            StringBuilder frame = new StringBuilder();
            int startY = 7, startX = 5, width = 23, height = 18;
            for (int i = 0; i < height + 2; i++) {
              frame.append("\033[").append(startY + i).append(";").append(startX).append("H").append(" ".repeat(width + 1));
            }
            return frame;
        }
    }

    public final StringBuilder getBannerBorderCenter() {
        StringBuilder frame = new StringBuilder();
        int startY = 7, startX = 37, width = 45, height = 18;
        frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width)).append("┐");
        for (int i = 0; i < height; i++) {
            frame.append("\033[").append(startY + 1 + i).append(";").append(startX).append("H│");
            frame.append("\033[").append(startY + 1 + i).append(";").append(startX + width + 1).append("H│");
        }
        frame.append("\033[").append(startY + height + 1).append(";").append(startX).append("H└").append("─".repeat(width)).append("┘");
        return frame;
    }

    public final StringBuilder getBannerBorderRight(Boolean isVisible) {
        try {
            if (!isVisible) {
                throw new Exception("Right Banner Border Not Visible");
            }
            StringBuilder frame = new StringBuilder();
            int startY = 7, startX = 92, width = 23, height = 18;
            frame.append("\033[").append(startY).append(";").append(startX).append("H┌").append("─".repeat(width));
            for (int i = 0; i < height; i++) {
                frame.append("\033[").append(startY + 1 + i).append(";").append(startX).append("H│");
            }
            frame.append("\033[").append(startY + height + 1).append(";").append(startX).append("H└").append("─".repeat(width));

            return frame;
        } catch (Exception e) {
            StringBuilder frame = new StringBuilder();
            int startY = 7, startX = 91, width = 24, height = 18;
            for (int i = 0; i < height + 2; i++) {
                frame.append("\033[").append(startY + i).append(";").append(startX).append("H").append(" ".repeat(width + 1));
            }
            return frame;
        }
    }

    private void initializeBannerAnimations() {
      bannerIndex.forEach((type, index)->{
        Animate.gachaIdle("banner-"+type, switch (type) {
          case "c" -> ArtManager.getAllRawCharacterArt();
          case "w" -> ArtManager.getAllRawWeaponArt();
          case "ar" -> ArtManager.getAllRawArmorArt();
          case "ac" -> ArtManager.getAllRawAccessoryArt();
          default -> new String[0][];
          }, index
        );
      });
    }

    public final StringBuilder showGems(Boolean show) {
        StringBuilder frame = new StringBuilder();
        int startY = 4, startX = 105, width = 10;

        frame.append("\033[").append(startY).append(";").append(startX).append("H").append(
          show?
          Utils.spaceBetween("GEMS: ", "" + this.gems, width):
          " ".repeat(width)
        );
        return frame;
    }
}
