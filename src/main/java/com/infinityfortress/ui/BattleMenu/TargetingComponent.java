package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;

import com.infinityfortress.characters.NCharacter;

public class TargetingComponent extends SelectionUI {

    private final StringBuilder choices;
    private final int[][] choiceCoords;

    public TargetingComponent(ArrayList<NCharacter> targets) {
        if (targets.isEmpty()) {
            this.choices = new StringBuilder();
            this.choiceCoords = new int[0][0];
        } else {
            StringBuilder frame = new StringBuilder();
            int width = 111, startX = 4, startY = 26;
            int rows = (targets.size() + 2) / 3;
            int[][] coords = new int[targets.size()][4];

            int maxSize = 0;
            for (NCharacter target : targets) {
                maxSize = Math.max(maxSize, target.getName().length() + 4);
            }

            int targetWidth = maxSize;
            int spacing = (width - (3 * targetWidth)) / 4;

            for (int row = 0; row < rows; row++) {
                int yPos = startY + 1 + (row * 2);
                for (int col = 0; col < 3; col++) {
                    int index = row * 3 + col;
                    if (index >= targets.size())
                        break;

                    int xPos = startX + spacing + col * (targetWidth + spacing);
                    String targetName = targets.get(index).getName();
                    int padding = (targetWidth - targetName.length()) / 2;

                    frame.append("\033[").append(yPos).append(";").append(xPos).append("H");
                    frame.append(" ".repeat(padding)).append(targetName)
                            .append(" ".repeat(targetWidth - targetName.length() - padding));

                    coords[index] = new int[] { yPos, yPos, xPos, xPos + targetWidth - 1 };
                }
            }

            this.choices = frame;
            this.choiceCoords = coords;
        }
    }

    @Override
    public StringBuilder displayChoices() {
        return choices;
    }

    @Override
    public StringBuilder updateChoice(int choice) {
        StringBuilder frame = new StringBuilder();

        for (int i = 0; i < this.choiceCoords.length; i++) {
            int yCoord = this.choiceCoords[i][0];
            int leftX = this.choiceCoords[i][2];
            int rightX = this.choiceCoords[i][3];

            String leftChar = (i == choice) ? "[" : " ";
            String rightChar = (i == choice) ? "]" : " ";

            frame.append("\033[").append(yCoord).append(";").append(leftX).append("H").append(leftChar);
            frame.append("\033[").append(yCoord).append(";").append(rightX).append("H").append(rightChar);
        }
        return frame;
    }

    @Override
    public void display() {
        System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()).append(updateChoice(0)));
    }

    @Override
    public StringBuilder getSelection() {
        return new StringBuilder().append(getSkeleton()).append(displayChoices());
    }

}
