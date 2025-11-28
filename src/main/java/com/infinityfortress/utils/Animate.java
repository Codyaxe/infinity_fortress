package com.infinityfortress.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.Random;
import java.util.Arrays;
import java.util.Collections;

/**
 * Animation handler that supports multiple concurrent animations with unique
 * IDs
 */
public class Animate {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
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
    public static void gachaBlock(String id, ArrayList<String[]> asciiArts, int finalArtIndex, int startX, int startY) {
        try {
            if (activeAnimations.containsKey(id) || asciiArts.isEmpty()) {
                return;
            }
            activeAnimations.put(id, new AnimationData(null, null, new AtomicBoolean(true)));
            InputHandler.disableListener();

            int duration = 5000, cycles = 5, height = asciiArts.get(0).length;
            final long startTime = System.currentTimeMillis();

            ArrayList<String[]> baseArts = new ArrayList<>();
            for (int i = 0; i < cycles; i++) {
                baseArts.addAll(asciiArts);
            }

            Collections.shuffle(baseArts);
            baseArts.add(0, asciiArts.get(finalArtIndex));
            asciiArts = baseArts;

            ArrayList<String> scrollBuffer = new ArrayList<>();

            for (int artIdx = 0; artIdx < asciiArts.size(); artIdx++) {
                String[] art = asciiArts.get(artIdx);
                for (String line : art) {
                    scrollBuffer.add(line != null ? line : "");
                }
            }

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
            Thread.currentThread().interrupt();
        } finally {
            stopAnimation(id);
            InputHandler.enableListener();
        }
    }

    public static void gachaIdle(String id, ArrayList<String[]> asciiArts, AtomicInteger startX, AtomicInteger startY) {
      try {
            // input validation
            if (id.isBlank() || asciiArts==null || asciiArts.isEmpty()) {
              throw new Exception("Invalid Parameters for Gacha Idle Animation");
            }

            // check if art is empty
            if (asciiArts.isEmpty()) {
                throw new Exception("Animation with ID already active or no ASCII art provided");
            }

            if (activeAnimations.containsKey(id)) return;

            AtomicInteger artHeight = new AtomicInteger(asciiArts.get(0).length);
            AtomicInteger artWidth = new AtomicInteger(asciiArts.get(0)[0].length());
            ArrayList<String> artScroll = new ArrayList<>();
            for (String[] art : asciiArts) {
              for (String line: art) {
                artScroll.add(line != null ? line : "");
              }
              artScroll.add(" ".repeat(artWidth.get()));
            }
            
            // Add first art at the end to create seamless loop
            for (String line: asciiArts.get(0)) {
              artScroll.add(line != null ? line : "");
            }
            // artScroll.add(" ".repeat(artWidth.get()));
            Random rand = new Random();
            AtomicInteger frameIndex = new AtomicInteger(rand.nextInt(0, artScroll.size() - artHeight.get()));
            
            ScheduledFuture<?> task = scheduler.scheduleAtFixedRate(() -> {
                StringBuilder frame = new StringBuilder();
                for (int i=0; i<artHeight.get(); i++) {
                    frame.append("\033[").append(startY.get() + i).append(";").append(startX.get()).append("H").append(artScroll.get(frameIndex.get() + i));
                }
                // Get current frame and cycle to next
                frameIndex.getAndUpdate(i -> (i - 1 + (artScroll.size()-artHeight.get())) % (artScroll.size()-artHeight.get()));
                System.out.print(frame.toString());
            }, 0, 1000/15, TimeUnit.MILLISECONDS);

            activeAnimations.put(id, new AnimationData(task, null, new AtomicBoolean(true)));
        } catch (Exception e) {
          StringBuilder frame = new StringBuilder();
          for (int i=0; i<18; i++) {
            frame.append("\033[").append(startY.get() + i).append(";").append(startX.get()).append("H").append(" ".repeat(45));
          }
          frame.append("\033[").append(startY.get() + 9).append(";").append(startX.get() + 20).append("H").append("ERROR");
          System.out.print(frame.toString());
        }
    }
}