package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;

import com.infinityfortress.actions.Action;

public class SubActionComponent extends SelectionUI {

    private final StringBuilder choices;
    private final int[][] choiceCoords;

    public SubActionComponent(ArrayList<Action> subActions) {
        if (subActions.isEmpty()) {
            this.choices = new StringBuilder();
            this.choiceCoords = new int[0][0];
        } else {
            StringBuilder frame = new StringBuilder();
            int width = 111;
            int startX = 4, startY = 26;
            int[] sizes = new int[subActions.size()];
            int totalSize = 0;
            for (int i = 0; i < subActions.size(); i++) {
                sizes[i] = subActions.get(i).getName().length() + 4;
                totalSize += sizes[i];
            }
            int space = (width - totalSize) / (subActions.size() + 1);
            int spaceBetween = Math.max(3, space / 2);
            int padding = (width - totalSize - spaceBetween * (subActions.size() - 1)) / 2;
            int[][] coords = new int[subActions.size()][4];

            int prefix = padding + startX;
            frame.append("\033[").append(startY + 3).append(";").append(startX + 1).append("H")
                    .append(" ".repeat(padding));
            for (int i = 0; i < coords.length; i++) {
                frame.append("  ").append(subActions.get(i).getName()).append("  ");
                if (i < coords.length - 1) {
                    frame.append(" ".repeat(spaceBetween));
                }

                coords[i] = new int[] { startY + 2, startY + 4, prefix, sizes[i] + prefix + 1 };
                prefix += (sizes[i] + spaceBetween);
            }
            frame.append(" ".repeat(padding));
            this.choices = frame;
            this.choiceCoords = coords;
        }
    }

    @Override
    public StringBuilder displayChoices() {
        // System.out.print(choices.toString());
        return choices;
    }

    @Override
    public StringBuilder updateChoice(int choice) {
        StringBuilder frame = new StringBuilder();

        String[] choiceIndicators = { "┌", "┐", "└", "┘" };
        for (int i = 0; i < this.choiceCoords.length; i++) {
            for (int j = 0; j < choiceIndicators.length; j++) {
                if (i == choice) {
                    frame.append("\033[").append(this.choiceCoords[i][j / 2]).append(";")
                            .append(this.choiceCoords[i][j % 2 + 2]).append("H").append(choiceIndicators[j]);
                } else {
                    frame.append("\033[").append(this.choiceCoords[i][j / 2]).append(";")
                            .append(this.choiceCoords[i][j % 2 + 2]).append("H").append(" ");
                }
            }
        }
        // System.out.print(frame.toString());
        return frame;
    }

    @Override
    public void display() {
        System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()).append(updateChoice(0)));
    }

    @Override
    public StringBuilder getSelection() {
        return (new StringBuilder().append(getSkeleton()).append(displayChoices()));
    }

}
