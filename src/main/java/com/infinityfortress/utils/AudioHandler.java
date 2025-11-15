package com.infinityfortress.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public class AudioHandler {
    private static final ExecutorService audioExecutor = Executors.newCachedThreadPool();
    private static final Map<String, byte[]> audioCache = new HashMap<>();
    private static final Map<String, AudioFormat> formatCache = new HashMap<>();

    // Debouncing: track last play time for each sound
    private static final Map<String, AtomicLong> lastPlayTime = new ConcurrentHashMap<>();
    private static final long MIN_PLAY_INTERVAL_MS = 50; // Minimum 50ms between same sounds

    // Track the currently playing clip (for intro music that can be stopped)
    private static Clip currentClip;

    public static void play(String filePath) {
        // Debounce: Skip if same sound played too recently
        AtomicLong lastTime = lastPlayTime.computeIfAbsent(filePath, k -> new AtomicLong(0));
        long currentTime = System.currentTimeMillis();
        long last = lastTime.get();

        if (currentTime - last < MIN_PLAY_INTERVAL_MS) {
            return;
        }

        lastTime.set(currentTime);

        audioExecutor.execute(() -> {
            try {
                // Load audio data from cache or file
                byte[] audioData = audioCache.get(filePath);
                AudioFormat format = formatCache.get(filePath);

                if (audioData == null) {
                    AudioData data = loadAudioData(filePath);
                    if (data == null) {
                        return;
                    }
                    audioData = data.audioBytes;
                    format = data.format;
                    audioCache.put(filePath, audioData);
                    formatCache.put(filePath, format);
                }

                // Create a new clip for each playback (allows overlapping sounds)
                ByteArrayInputStream byteStream = new ByteArrayInputStream(audioData);
                AudioInputStream audioStream = new AudioInputStream(byteStream, format,
                        audioData.length / format.getFrameSize());

                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });

                clip.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private static class AudioData {
        byte[] audioBytes;
        AudioFormat format;

        AudioData(byte[] audioBytes, AudioFormat format) {
            this.audioBytes = audioBytes;
            this.format = format;
        }
    }

    private static AudioData loadAudioData(String filePath) {
        try {
            InputStream inputStream = AudioHandler.class.getClassLoader()
                    .getResourceAsStream(filePath);

            if (inputStream == null) {
                System.err.println("Audio file not found: " + filePath);
                return null;
            }

            BufferedInputStream bufferedStream = new BufferedInputStream(inputStream);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedStream);
            AudioFormat format = audioStream.getFormat();

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[4096];
            int bytesRead;
            while ((bytesRead = audioStream.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, bytesRead);
            }
            audioStream.close();
            return new AudioData(buffer.toByteArray(), format);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void playSelect() {
        play("audio/select.wav");
    }

    public static void playEnter() {
        play("audio/enter.wav");
    }

    public static void playBack() {
        play("audio/back.wav");
    }

    public static void playBattle() {
        play("audio/battle.wav");
    }

    public static void playIntro() {
        audioExecutor.execute(() -> {
            try {
                byte[] audioData = audioCache.get("audio/infinity_fortress.wav");
                AudioFormat format = formatCache.get("audio/infinity_fortress.wav");

                if (audioData == null) {
                    AudioData data = loadAudioData("audio/infinity_fortress.wav");
                    if (data == null) {
                        return;
                    }
                    audioData = data.audioBytes;
                    format = data.format;
                    audioCache.put("audio/infinity_fortress.wav", audioData);
                    formatCache.put("audio/infinity_fortress.wav", format);
                }

                synchronized (AudioHandler.class) {
                    if (currentClip != null) {
                        try {
                            currentClip.stop();
                            currentClip.close();
                        } catch (Exception ignored) {
                        }
                    }

                    // Create intro clip and track it
                    ByteArrayInputStream byteStream = new ByteArrayInputStream(audioData);
                    AudioInputStream audioStream = new AudioInputStream(byteStream, format,
                            audioData.length / format.getFrameSize());

                    currentClip = AudioSystem.getClip();
                    currentClip.open(audioStream);

                    final Clip introClip = currentClip;
                    currentClip.addLineListener(event -> {
                        if (event.getType() == LineEvent.Type.STOP) {
                            introClip.close();
                        }
                    });

                    currentClip.start();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void stopIntro() {
        synchronized (AudioHandler.class) {
            if (currentClip != null) {
                try {
                    currentClip.stop();
                    currentClip.close();
                } catch (Exception ignored) {
                }
                currentClip = null;
            }
        }
    }
}