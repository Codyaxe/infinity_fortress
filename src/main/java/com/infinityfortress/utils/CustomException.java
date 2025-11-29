package com.infinityfortress.utils;

public class CustomException extends Exception {
    private int width=119, height=31;
    public CustomException(String message) {
        super(message);
    } 

    public CustomException(Exception e) {
        super(e.getMessage() + "\n" + getStackTraceInfo(e));
    }
  
    private static String getStackTraceInfo(Exception e) {
        if (e == null || e.getStackTrace().length == 0) return "";
        StringBuilder trace = new StringBuilder();
        for (StackTraceElement elem : e.getStackTrace()) {
          String[] part = elem.getClassName().split("\\.");
          if (part.length == 0) continue;
            trace.append("at ")
                // .append(part[part.length-1]).append(".")
                // .append(elem.getMethodName()).append("(")
                .append(elem.getFileName()).append(":")
                .append(elem.getLineNumber()).append("\n");
        }
        return trace.toString();
    }
  
    public void renderException() {
        InputHandler.enableListener();
        StringBuilder frame = new StringBuilder();
        
        
        String[] lines = Utils.createExceptionGrid(this.getMessage());
        int boxWidth = lines[0].length() + 8;
        int boxHeight = lines.length;

        int startX = (width - boxWidth) / 2 + 1;
        int startY = (height - (boxHeight+6)) / 2 + 1;
        
        // Draw top border
        frame.append("\033[").append(startY++).append(";").append(startX).append("H┌").append("─".repeat(boxWidth)).append("┐");
        frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append(Utils.center("EXCEPTION", (boxWidth))).append("│");
        
        for (int i = 0; i < 2; i++) {
          frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append((" ".repeat(boxWidth))).append("│");
        }

        frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append(Utils.center(lines[0], boxWidth)).append("│");
        frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append(" ".repeat(boxWidth)).append("│");
        for (int i = 1; i < lines.length; i++) {
          frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append(Utils.center(lines[i], boxWidth)).append("│");
        }
        for (int i = 0; i < 2; i++) {
          frame.append("\033[").append(startY++).append(";").append(startX).append("H│").append((" ".repeat(boxWidth))).append("│");
        }
        
        // Draw bottom border
        frame.append("\033[").append(startY++).append(";").append(startX).append("H└").append("─".repeat(boxWidth)).append("┘");
        
        System.out.print(frame.toString());
        InputHandler.waitForInput();
    }
}
