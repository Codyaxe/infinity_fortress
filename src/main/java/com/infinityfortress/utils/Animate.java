package com.infinityfortress.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Animation handler that supports multiple concurrent animations with unique
 * IDs
 */
public class Animate {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
    private static final Map<String, AnimationData> activeAnimations = new ConcurrentHashMap<>();

    private static class AnimationData {

        public final ScheduledFuture<?> animationTask;
        public final ScheduledFuture<?> stopTask;
        public final AtomicBoolean state;

        public AnimationData(ScheduledFuture<?> animationTask, ScheduledFuture<?> stopTask, AtomicBoolean state) {
            this.animationTask = animationTask;
            this.stopTask = stopTask;
            this.state = state;
        }
    }

    /**
     * Starts a flashing animation with a unique ID (default 1.5 seconds, 140ms
     * interval)
     *
     * @param id Unique identifier for this animation
     * @param frame The frame to animate
     */
    public static void flash(String id, StringBuilder frame) {
        flash(id, frame, 1500, 140);
    }

    /**
     * Starts a flashing animation with a unique ID and custom timing
     *
     * @param id Unique identifier for this animation
     * @param frame The frame to animate
     * @param duration Duration of the flash in milliseconds
     * @param interval Interval between flash toggles in milliseconds
     */
    public static void flash(String id, StringBuilder frame, int duration, int interval) {
        if (activeAnimations.containsKey(id)) {
            return;
        }

        // Initial States
        AtomicBoolean animFlashState = new AtomicBoolean(false);
        final long start = System.currentTimeMillis();

        ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(() -> {
            long curr = System.currentTimeMillis() - start;

            // Check if duration has been reached
            if (curr >= duration) {
                stopAnimation(id);
                return;
            }

            // Do the flash animation
            StringBuilder newFrame = new StringBuilder();
            if (animFlashState.get()) {
                newFrame.append("\033[30;47m");
            }
            newFrame.append(frame).append("\033[0m");
            System.out.print(newFrame.toString());
            animFlashState.set(!animFlashState.get());

        }, 0, interval, TimeUnit.MILLISECONDS);

        activeAnimations.put(id, new AnimationData(task, null, animFlashState));
    }

    /**
     * Starts a blocking flashing animation that waits until completion This
     * method will NOT return until the animation is finished
     *
     * @param id Unique identifier for this animation
     * @param frame The frame to animate
     * @param duration Duration of the flash in milliseconds
     * @param interval Interval between flash toggles in milliseconds
     */
    public static void flashBlock(String id, StringBuilder frame, int duration, int interval) {
        if (activeAnimations.containsKey(id)) {
            return;
        }

        // Mark as active (for status checking)
        AtomicBoolean animFlashState = new AtomicBoolean(false);
        activeAnimations.put(id, new AnimationData(null, null, animFlashState));
        InputHandler.disableListener();

        final long startTime = System.currentTimeMillis();

        try {
            while (true) {
                long elapsed = System.currentTimeMillis() - startTime;

                // Check if duration has been reached
                if (elapsed >= duration) {
                    break;
                }

                // Do the flash animation
                StringBuilder newFrame = new StringBuilder();
                if (animFlashState.get()) {
                    newFrame.append("\033[30;47m");
                }
                newFrame.append(frame).append("\033[0m");
                System.out.print(newFrame.toString());
                animFlashState.set(!animFlashState.get());

                // Wait for the interval
                Thread.sleep(interval);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // Clean up
            activeAnimations.remove(id);
            System.out.print("\033[0m"); // Reset colors
            InputHandler.enableListener();
        }
    }

    /**
     * Starts a blocking flashing animation with default timing (1.5 seconds,
     * 140ms interval) This method will NOT return until the animation is
     * finished
     *
     * @param id Unique identifier for this animation
     * @param frame The frame to animate
     */
    public static void flashBlock(String id, StringBuilder frame) {
        flashBlock(id, frame, 1500, 140);
    }

    /**
     * Stop a specific animation by ID
     *
     * @param id The ID of the animation to stop
     */
    public static void stopAnimation(String id) {
        AnimationData animData = activeAnimations.remove(id);
        if (animData != null) {
            if (animData.animationTask != null) {
                animData.animationTask.cancel(true);
            }
            if (animData.stopTask != null) {
                animData.stopTask.cancel(true);
            }
            animData.state.set(false);
            System.out.print("\033[0m"); // Reset colors
        }
    }

    /**
     * Stop all active animations
     */
    public static void stopAllAnimations() {
        // Get all IDs to avoid concurrent modification
        String[] ids = activeAnimations.keySet().toArray(new String[activeAnimations.size()]);
        for (String id : ids) {
            stopAnimation(id);
        }
    }

    /**
     * Check if an animation with the given ID is currently running
     *
     * @param id The animation ID to check
     * @return returns if animation is active
     */
    public static boolean isAnimationActive(String id) {
        return activeAnimations.containsKey(id);
    }

    /**
     * Get the number of currently active animations
     *
     * @return Number of active animations
     */
    public static int getActiveAnimationCount() {
        return activeAnimations.size();
    }

    /**
     * Creates a blocking vertical scrolling gacha animation with deceleration
     * This method will NOT return until the animation is finished
     *
     * @param id Unique identifier for this animation
     * @param asciiArts ArrayList of String arrays containing ASCII art frames
     * @param finalArtIndex Index of the art to land on (-1 for random)
     */
    public static void gachaBlock(String id, String[][] asciiArts, String[] chosenArt, int startX, int startY) {
        try {
            if (activeAnimations.containsKey(id) || asciiArts.length==0) {
                return;
            }
            activeAnimations.put(id, new AnimationData(null, null, new AtomicBoolean(true)));
            InputHandler.disableListener();

            int duration = 5000, cycles = 5, height = asciiArts[0].length;
            final long startTime = System.currentTimeMillis();

            ArrayList<String[]> baseArts = new ArrayList<>();
            for (int i = 0; i < cycles; i++) {
                baseArts.addAll(new ArrayList<>(Arrays.asList(asciiArts)));
            }

            Collections.shuffle(baseArts);
            baseArts.add(0, chosenArt);

            ArrayList<String> scrollBuffer = new ArrayList<>();

            for (int artIdx = 0; artIdx < baseArts.size(); artIdx++) {
                String[] art = baseArts.get(artIdx);
                for (String line : art) {
                    scrollBuffer.add(line != null ? line : "");
                }
            }
            // int tempDx=1;
            // for (String[] art : asciiArts) {
            //   System.out.print("\033[" + tempDx++ + ";1H" + art.length);
            // }

            while (true) {
                StringBuilder frame = new StringBuilder();
                long elapsed = System.currentTimeMillis() - startTime;

                // Calculate position with deceleration
                double progress = (double) elapsed / duration;
                double easedProgress = Math.sqrt(1 - Math.pow(progress - 1, 2));

                int scrollStart = scrollBuffer.size() - height;
                int scrollPosition = Math.max(0, (int) (scrollStart - (easedProgress * scrollStart)));

                for (int i = 0; i < height; i++) {
                    int lineIndex = (scrollPosition + i) % scrollBuffer.size();
                    if (lineIndex < scrollBuffer.size()) {
                        frame.append("\033[").append(startY + i).append(";").append(startX).append("H").append(scrollBuffer.get(lineIndex));
                    } else {
                        frame.append("\033[").append(startY + i).append(";").append(startX).append("H").append("-".repeat(45));
                    }
                }
                System.out.print(frame.toString());

                if (elapsed >= duration && progress >= 1) {
                    break;
                }
                Thread.sleep(16); // ~60fps
            }
        } catch (InterruptedException e) {
            CustomException ce = new CustomException(e);
            ce.renderException();
            Thread.currentThread().interrupt();
        } finally {
            InputHandler.enableListener();
            stopAnimation(id);
        }
    }

    public static void gachaIdle(String id, String[][] asciiArts, AtomicInteger startX) {
      int[] bannerCoords = { 5, 38, 93 };
      int[] widthAtX = { 23, 45, 23 };
      int artHeight = 18;
      int startY = 8;
      int fpms = 1000/15;
      try {
          // input validation
          if (id.isBlank() || asciiArts==null || asciiArts.length==0) throw new Exception("Invalid Parameters for Gacha Idle Animation");
            
            if (startX == null) throw new Exception("Invalid startX AtomicInteger for Gacha Idle Animation");

            if (activeAnimations.containsKey(id)) throw new Exception("Animation with ID already active: " + id);

            ArrayList<String> artScroll = new ArrayList<>();

            for (String[] art : asciiArts) {
              for (String line: ArtManager.formatArt(art, widthAtX[1], artHeight)) {
                artScroll.add(line != null ? line : "");
              }
              artScroll.add(" ".repeat(widthAtX[1]));
            }
            
            // Add first art at the end to create seamless loop
            for (String line: ArtManager.formatArt(asciiArts[0], widthAtX[1], artHeight)) {
              artScroll.add(line != null ? line : "");
            }

            Random rand = new Random();
            AtomicInteger frameIndex = new AtomicInteger(rand.nextInt(0, artScroll.size() - artHeight));
            
            ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(() -> {
              String[] temp = artScroll.subList(frameIndex.get(), frameIndex.get() + artHeight).toArray(String[]::new);
              String[] artFrame = switch (startX.get()) {
                case 0 -> ArtManager.formatArtRightAlign(temp, widthAtX[0], artHeight);
                case 1 -> ArtManager.formatArt(temp, widthAtX[1], artHeight);
                case 2 -> ArtManager.formatArtLeftAlign(temp, widthAtX[2], artHeight);
                default -> new String[0];
              };
              
              // Don't render if art frame is invisible
              if (artFrame.length == 0) {
                return;
              }
              
              StringBuilder frame = new StringBuilder();
              for (int i=0; i<artFrame.length; i++) {
                frame.append("\033[").append(startY + i).append(";").append(bannerCoords[startX.get()]).append("H").append(artFrame[i]);
              }
              frameIndex.getAndUpdate(i-> ( i-1+ (artScroll.size()- artHeight) ) % (artScroll.size()- artHeight));
              System.out.print(frame.toString());
            }, 0, fpms, TimeUnit.MILLISECONDS);

            activeAnimations.put(id, new AnimationData(task, null, new AtomicBoolean(true)));
        } catch (Exception e) {
            try {
              StringBuilder frame = new StringBuilder();
              for (int i=0; i<artHeight; i++) {
                frame.append("\033[").append(startY + i).append(";").append(bannerCoords[Math.min(2,Math.max(0, startX.get()))]).append("H").append(" ".repeat(widthAtX[Math.min(2,Math.max(0, startX.get()))]));
              }
              System.out.print(frame.toString());
            } catch (Exception ex) {}
            CustomException ce = new CustomException(e);
            ce.renderException();
        }
      }
}