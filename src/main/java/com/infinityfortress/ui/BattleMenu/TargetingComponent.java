package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;
import java.util.stream.Collectors;

import com.infinityfortress.characters.NCharacter;

public class TargetingComponent extends SelectionUI {

    private final StringBuilder choices;
    private final int[][] choiceCoords;

    // Minimum targets: 1
    public TargetingComponent(ArrayList<NCharacter> targets) {
        targets = targets.stream().filter(t -> t != null && !t.isDead())
                .collect(Collectors.toCollection(ArrayList::new));

        if (targets.isEmpty()) {
            this.choices = new StringBuilder();
            this.choiceCoords = new int[0][0];
            return;
        }

        StringBuilder frame = new StringBuilder();
        int width = 111, startX = 4, startY = 26 + (-(targets.size() - 1) / 3);
        int[][] coords = new int[targets.size()][4];

        // Layout targets in rows of 3
        int rowCount = (targets.size() + 2) / 3;
        for (int row = 0; row < rowCount; row++) {
            int rowStart = row * 3;
            int rowEnd = Math.min(rowStart + 3, targets.size());

            layoutRow(
                    frame,
                    new ArrayList<>(targets.subList(rowStart, rowEnd)),
                    startY + 3 + (row * 2),
                    startX,
                    width,
                    coords,
                    rowStart);
        }

        this.choices = frame;
        this.choiceCoords = coords;
    }

    private void layoutRow(StringBuilder frame, ArrayList<NCharacter> rowTargets, int yPos, int startX, int width,
            int[][] coords, int coordOffset) {
        // Calculate sizes and spacing
        int totalSize = rowTargets.stream().mapToInt(t -> t.getName().length() + 4).sum();
        int spaceBetween = Math.max(3, (width - totalSize) / (rowTargets.size() + 1) / 2);
        int padding = (width - totalSize - spaceBetween * (rowTargets.size() - 1)) / 2;

        // Build row content
        frame.append("\033[").append(yPos).append(";").append(startX + 1).append("H").append(" ".repeat(padding));

        int prefix = padding + startX;
        for (int i = 0; i < rowTargets.size(); i++) {
            String name = rowTargets.get(i).getName();
            frame.append("  ").append(name).append("  ");
            if (i < rowTargets.size() - 1)
                frame.append(" ".repeat(spaceBetween));

            coords[coordOffset + i] = new int[] { yPos - 1, yPos + 1, prefix, prefix + name.length() + 5 };
            prefix += name.length() + 4 + spaceBetween;
        }
        frame.append(" ".repeat(padding));
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
            int yCoord2 = this.choiceCoords[i][1];
            int leftX = this.choiceCoords[i][2];
            int rightX = this.choiceCoords[i][3];

            String luChar = (i == choice) ? "┌" : " ";
            String ruChar = (i == choice) ? "┐" : " ";
            String ldChar = (i == choice) ? "└" : " ";
            String rdChar = (i == choice) ? "┘" : " ";

            frame.append("\033[").append(yCoord).append(";").append(leftX).append("H").append(luChar);
            frame.append("\033[").append(yCoord).append(";").append(rightX).append("H").append(ruChar);
            frame.append("\033[").append(yCoord2).append(";").append(leftX).append("H").append(ldChar);
            frame.append("\033[").append(yCoord2).append(";").append(rightX).append("H").append(rdChar);
        }
        return frame;
    }// └ ┌ ─ │ ┐ ┘

    @Override
    public void display() {
        System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()).append(updateChoice(0)));
    }

    @Override
    public StringBuilder getSelection() {
        return new StringBuilder().append(getSkeleton()).append(displayChoices());
    }

}
