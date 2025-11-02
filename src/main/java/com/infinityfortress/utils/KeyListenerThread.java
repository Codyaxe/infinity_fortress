/*Hi! This is a universal key event listener thread. It lets the program detect any form of keypresses*/

package com.infinityfortress.utils;

import com.sun.jna.platform.win32.User32;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeyListenerThread extends Thread {
    private volatile boolean running = true;
    private volatile boolean ready = false;
    private final List<KeyEventListener> listeners = new ArrayList<>();
    private final Set<Integer> trackedKeys = new HashSet<>();
    private final Map<Integer, Boolean> keyStates = new HashMap<>();
    private int pollDelayMs = 50;

    // GetAsyncKeyState return value indicating key is pressed
    private static final short KEY_PRESSED = (short) 0x8000;

    // Virtual Key Codes - Common keys
    public static final int VK_RETURN = 0x0D;
    public static final int VK_ESCAPE = 0x1B;
    public static final int VK_SPACE = 0x20;
    public static final int VK_LEFT = 0x25;
    public static final int VK_UP = 0x26;
    public static final int VK_RIGHT = 0x27;
    public static final int VK_DOWN = 0x28;
    public static final int VK_SHIFT = 0x10;
    public static final int VK_CONTROL = 0x11;
    public static final int VK_ALT = 0x12;

    // Letter keys (A-Z)
    public static final int VK_A = 0x41;
    public static final int VK_B = 0x42;
    public static final int VK_C = 0x43;
    public static final int VK_D = 0x44;
    public static final int VK_E = 0x45;
    public static final int VK_F = 0x46;
    public static final int VK_G = 0x47;
    public static final int VK_H = 0x48;
    public static final int VK_I = 0x49;
    public static final int VK_J = 0x4A;
    public static final int VK_K = 0x4B;
    public static final int VK_L = 0x4C;
    public static final int VK_M = 0x4D;
    public static final int VK_N = 0x4E;
    public static final int VK_O = 0x4F;
    public static final int VK_P = 0x50;
    public static final int VK_Q = 0x51;
    public static final int VK_R = 0x52;
    public static final int VK_S = 0x53;
    public static final int VK_T = 0x54;
    public static final int VK_U = 0x55;
    public static final int VK_V = 0x56;
    public static final int VK_W = 0x57;
    public static final int VK_X = 0x58;
    public static final int VK_Y = 0x59;
    public static final int VK_Z = 0x5A;

    // Number keys (0-9)
    public static final int VK_0 = 0x30;
    public static final int VK_1 = 0x31;
    public static final int VK_2 = 0x32;
    public static final int VK_3 = 0x33;
    public static final int VK_4 = 0x34;
    public static final int VK_5 = 0x35;
    public static final int VK_6 = 0x36;
    public static final int VK_7 = 0x37;
    public static final int VK_8 = 0x38;
    public static final int VK_9 = 0x39;

    // Function keys (F1-F12)
    public static final int VK_F1 = 0x70;
    public static final int VK_F2 = 0x71;
    public static final int VK_F3 = 0x72;
    public static final int VK_F4 = 0x73;
    public static final int VK_F5 = 0x74;
    public static final int VK_F6 = 0x75;
    public static final int VK_F7 = 0x76;
    public static final int VK_F8 = 0x77;
    public static final int VK_F9 = 0x78;
    public static final int VK_F10 = 0x79;
    public static final int VK_F11 = 0x7A;
    public static final int VK_F12 = 0x7B;

    /**
     * Interface for handling key events
     */
    public interface KeyEventListener {
        /**
         * Called when a tracked key is pressed
         * 
         * @param keyCode The virtual key code of the pressed key
         */
        void onKeyPressed(int keyCode);

        /**
         * Called when a tracked key is released
         * 
         * @param keyCode The virtual key code of the released key
         */
        void onKeyReleased(int keyCode);
    }

    public KeyListenerThread() {
        setDaemon(true);
    }

    /**
     * Add a key event listener
     * 
     * @param listener The listener to add
     */
    public void addKeyEventListener(KeyEventListener listener) {
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    /**
     * Remove a key event listener
     * 
     * @param listener The listener to remove
     */
    public void removeKeyEventListener(KeyEventListener listener) {
        synchronized (listeners) {
            listeners.remove(listener);
        }
    }

    /**
     * Add a key to track
     * 
     * @param keyCode The virtual key code to track
     */
    public void trackKey(int keyCode) {
        synchronized (trackedKeys) {
            trackedKeys.add(keyCode);
            keyStates.put(keyCode, false);
        }
    }

    /**
     * Add multiple keys to track
     * 
     * @param keyCodes The virtual key codes to track
     */
    public void trackKeys(int... keyCodes) {
        synchronized (trackedKeys) {
            for (int keyCode : keyCodes) {
                trackedKeys.add(keyCode);
                keyStates.put(keyCode, false);
            }
        }
    }

    /**
     * Remove a key from tracking
     * 
     * @param keyCode The virtual key code to stop tracking
     */
    public void untrackKey(int keyCode) {
        synchronized (trackedKeys) {
            trackedKeys.remove(keyCode);
            keyStates.remove(keyCode);
        }
    }

    /**
     * Track all standard keys (A-Z, 0-9, common special keys)
     */
    public void trackAllStandardKeys() {
        synchronized (trackedKeys) {
            // Track all letters
            for (int i = VK_A; i <= VK_Z; i++) {
                trackedKeys.add(i);
                keyStates.put(i, false);
            }
            // Track all numbers
            for (int i = VK_0; i <= VK_9; i++) {
                trackedKeys.add(i);
                keyStates.put(i, false);
            }
            // Track common special keys
            trackKeys(VK_RETURN, VK_ESCAPE, VK_SPACE, VK_LEFT, VK_UP, VK_RIGHT, VK_DOWN,
                    VK_SHIFT, VK_CONTROL, VK_ALT);
            // Track function keys
            for (int i = VK_F1; i <= VK_F12; i++) {
                trackedKeys.add(i);
                keyStates.put(i, false);
            }
        }
    }

    /**
     * Set the polling delay in milliseconds
     * 
     * @param delayMs Delay between key state checks (default: 50ms)
     */
    public void setPollDelay(int delayMs) {
        this.pollDelayMs = Math.max(1, delayMs);
    }

    /**
     * Check if a key is currently pressed
     * 
     * @param keyCode The virtual key code to check
     * @return true if the key is pressed, false otherwise
     */
    public boolean isKeyPressed(int keyCode) {
        synchronized (keyStates) {
            return keyStates.getOrDefault(keyCode, false);
        }
    }

    @Override
    public void run() {
        // Clear any previous key states
        synchronized (trackedKeys) {
            for (int keyCode : trackedKeys) {
                User32.INSTANCE.GetAsyncKeyState(keyCode);
            }
        }

        // Add a small delay to avoid detecting keys from starting the program
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        // Signal that the listener is ready
        ready = true;

        while (running) {
            try {
                List<Integer> keysToCheck;
                synchronized (trackedKeys) {
                    keysToCheck = new ArrayList<>(trackedKeys);
                }

                // Check each tracked key
                for (int keyCode : keysToCheck) {
                    short keyState = User32.INSTANCE.GetAsyncKeyState(keyCode);
                    boolean isPressed = (keyState & KEY_PRESSED) != 0;

                    Boolean previousState;
                    synchronized (keyStates) {
                        previousState = keyStates.get(keyCode);
                    }

                    // Detect state changes
                    if (isPressed && !previousState) {
                        // Key was just pressed
                        synchronized (keyStates) {
                            keyStates.put(keyCode, true);
                        }
                        notifyKeyPressed(keyCode);
                    } else if (!isPressed && previousState) {
                        // Key was just released
                        synchronized (keyStates) {
                            keyStates.put(keyCode, false);
                        }
                        notifyKeyReleased(keyCode);
                    }
                }

                // To avoid busy waiting
                Thread.sleep(pollDelayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void notifyKeyPressed(int keyCode) {
        List<KeyEventListener> listenersCopy;
        synchronized (listeners) {
            listenersCopy = new ArrayList<>(listeners);
        }
        for (KeyEventListener listener : listenersCopy) {
            try {
                listener.onKeyPressed(keyCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyKeyReleased(int keyCode) {
        List<KeyEventListener> listenersCopy;
        synchronized (listeners) {
            listenersCopy = new ArrayList<>(listeners);
        }
        for (KeyEventListener listener : listenersCopy) {
            try {
                listener.onKeyReleased(keyCode);
            } catch (Exception e) {
                // Prevent listener exceptions from breaking the thread
                e.printStackTrace();
            }
        }
    }

    public boolean isReady() {
        return ready;
    }

    public void waitUntilReady() {
        while (!ready && running) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void stopListener() {
        running = false;
    }

    /**
     * Get a name for a key code
     * 
     * @param keyCode The virtual key code
     * @return The key name
     */
    public static String getKeyName(int keyCode) {
        if (keyCode >= VK_A && keyCode <= VK_Z) {
            return String.valueOf((char) keyCode);
        } else if (keyCode >= VK_0 && keyCode <= VK_9) {
            return String.valueOf((char) keyCode);
        } else if (keyCode >= VK_F1 && keyCode <= VK_F12) {
            return "F" + (keyCode - VK_F1 + 1);
        }

        switch (keyCode) {
            case VK_RETURN:
                return "ENTER";
            case VK_ESCAPE:
                return "ESC";
            case VK_SPACE:
                return "SPACE";
            case VK_LEFT:
                return "LEFT";
            case VK_UP:
                return "UP";
            case VK_RIGHT:
                return "RIGHT";
            case VK_DOWN:
                return "DOWN";
            case VK_SHIFT:
                return "SHIFT";
            case VK_CONTROL:
                return "CTRL";
            case VK_ALT:
                return "ALT";
            default:
                return "KEY_" + keyCode;
        }
    }
}