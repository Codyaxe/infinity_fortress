package com.infinityfortress.ui.BattleMenu;

import java.util.ArrayList;
import java.util.List;

public class PrintComponent extends SelectionUI {

    private final StringBuilder content;
    private final int width = 111;
    private final int startX = 4;
    private final int startY = 26;

    public PrintComponent(String text) {
        int boxHeight = 5;
        List<String> wrapped = wrap(text, width);
        StringBuilder frame = new StringBuilder();

        int verticalPadding = (boxHeight - wrapped.size()) / 2;
        int currentY = startY + 1 + verticalPadding;

        for (String line : wrapped) {
            String centered = center(line, width);
            int xPos = startX + 1;
            frame.append("\033[").append(currentY).append(";").append(xPos).append("H");
            frame.append(centered);
            currentY++;
        }

        this.content = frame;
    }

    private String center(String text, int contentWidth) {
        if (text.length() >= contentWidth)
            return text.substring(0, contentWidth);
        int leftPadding = (contentWidth - text.length()) / 2;
        int rightPadding = contentWidth - text.length() - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);
    }

    private List<String> wrap(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        StringBuilder line = new StringBuilder();

        for (String word : text.split(" ")) {
            if (line.length() + word.length() + 1 > maxWidth) {
                if (line.length() > 0) {
                    lines.add(line.toString());
                    line = new StringBuilder(word);
                } else {
                    lines.add(word.substring(0, maxWidth));
                    line = new StringBuilder(word.substring(maxWidth));
                }
            } else {
                if (line.length() > 0)
                    line.append(" ");
                line.append(word);
            }
        }

        if (line.length() > 0)
            lines.add(line.toString());

        return lines;
    }

    @Override
    public StringBuilder displayChoices() {
        return content;
    }

    @Override
    public StringBuilder updateChoice(int choice) {
        return new StringBuilder();
    }

    @Override
    public void display() {
        System.out.print(new StringBuilder().append(getSkeleton()).append(displayChoices()));
    }

    @Override
    public StringBuilder getSelection() {
        return new StringBuilder().append(getSkeleton()).append(displayChoices());
    }
}
