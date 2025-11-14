package com.infinityfortress.Music;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class PlaySound {

    private Clip clip;

    public void playMusic(String fileName) {
        try {
            File musicPath = null;
            
            // Try multiple locations for the music file
            String[] possiblePaths = {
                fileName, // Current directory
                "src/main/java/com/infinityfortress/Music/" + fileName, // Maven source path
                "src/main/resources/" + fileName, // Maven resources (recommended)
                System.getProperty("user.dir") + "/src/main/java/com/infinityfortress/Music/" + fileName
            };
            
            // Try each path until we find the file
            for (String path : possiblePaths) {
                File testFile = new File(path);
                if (testFile.exists()) {
                    musicPath = testFile;
                    break;
                }
            }
            
            // Also try as a resource (works in JAR files)
            if (musicPath == null || !musicPath.exists()) {
                try {
                    var resourceUrl = getClass().getResource("/" + fileName);
                    if (resourceUrl == null) {
                        resourceUrl = getClass().getResource(fileName);
                    }
                    if (resourceUrl != null) {
                        musicPath = new File(resourceUrl.toURI());
                    }
                } catch (Exception e) {
                    // Resource loading failed, continue with file-based approach
                }
            }
            
            if (musicPath != null && musicPath.exists()) {
                // Stop current music if playing
                stopMusic();
                
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                System.out.println("Playing: " + fileName);
            } else {
                System.out.println("Music file not found: " + fileName);
                System.out.println("Searched in multiple locations including resources");
            }
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
            System.out.println("Music stopped.");
        }
    }

    public static void main(String[] args) {
        PlaySound bgm = new PlaySound();

        // Run music in background
        new Thread(() -> bgm.playMusic("SB.wav")).start();

        // Example game loop simulation
        System.out.println("Game Start!");
        for (int i = 100; i >= 1; i--) {
            System.out.println("Game ruHGnning... " + i);
            try {
                Thread.sleep(1000); // Simulate gameplay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        bgm.stopMusic();
    }
}
