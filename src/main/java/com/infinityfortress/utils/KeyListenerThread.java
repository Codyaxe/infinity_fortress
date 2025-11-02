/*For keyboard listening event purposes. 
You might need to read the code in this.*/

package com.infinityfortress.utils;

import com.sun.jna.platform.win32.User32;
import java.util.concurrent.CopyOnWriteArrayList;

public class KeyListenerThread extends Thread {
    private volatile boolean running = true;
    private volatile boolean ready = false;
    private final CopyOnWriteArrayList<KeyEventListener> listeners = new CopyOnWriteArrayList<>();

    // Array to track keys and key states
    private int[] trackedKeys = new int[256]; // Max virtual key codes
    private boolean[] keyStates = new boolean[256];
    private int trackedKeyCount = 0;
    private int pollDelayMs = 50;

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

    public interface KeyEventListener {
        void onKeyPressed(int keyCode);

        void onKeyReleased(int keyCode);
    }

    public KeyListenerThread() {
        setDaemon(true);
    }

    public void addKeyEventListener(KeyEventListener listener) {
        listeners.add(listener);
    }

    public void removeKeyEventListener(KeyEventListener listener) {
        listeners.remove(listener);
    }

    public synchronized void trackKey(int keyCode) {
        if (keyCode < 0 || keyCode >= 256) {
            return;
        }

        // Check if already tracked
        for (int i = 0; i < trackedKeyCount; i++) {
            if (trackedKeys[i] == keyCode)
                return;
        }

        trackedKeys[trackedKeyCount++] = keyCode;
        keyStates[keyCode] = false;
    }

    public void trackKeys(int... keyCodes) {
        for (int keyCode : keyCodes) {
            trackKey(keyCode);
        }
    }

    public synchronized void untrackKey(int keyCode) {
        for (int i = 0; i < trackedKeyCount; i++) {
            if (trackedKeys[i] == keyCode) {
                // Shift remaining keys
                System.arraycopy(trackedKeys, i + 1, trackedKeys, i, trackedKeyCount - i - 1);
                trackedKeyCount--;
                keyStates[keyCode] = false;
                return;
            }
        }
    }

    public void trackAllStandardKeys() {
        for (int i = VK_A; i <= VK_Z; i++) {
            trackKey(i);
        }

        for (int i = VK_0; i <= VK_9; i++) {
            trackKey(i);
        }

        trackKeys(VK_RETURN, VK_ESCAPE, VK_SPACE, VK_LEFT, VK_UP, VK_RIGHT, VK_DOWN,
                VK_SHIFT, VK_CONTROL, VK_ALT);
        for (int i = VK_F1; i <= VK_F12; i++) {
            trackKey(i);
        }

    }

    public void setPollDelay(int delayMs) {
        this.pollDelayMs = Math.max(1, delayMs);
    }

    public boolean isKeyPressed(int keyCode) {
        if (keyCode < 0 || keyCode >= 256) {
            return false;
        }

        return keyStates[keyCode];
    }

    @Override
    public void run() {
        // Clear any previous key states
        synchronized (this) {
            for (int i = 0; i < trackedKeyCount; i++) {
                User32.INSTANCE.GetAsyncKeyState(trackedKeys[i]);
            }
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        ready = true;

        while (running) {
            try {
                // No ArrayList allocation needed
                for (int i = 0; i < trackedKeyCount; i++) {
                    int keyCode = trackedKeys[i];
                    short keyState = User32.INSTANCE.GetAsyncKeyState(keyCode);
                    boolean isPressed = (keyState & KEY_PRESSED) != 0;
                    boolean previousState = keyStates[keyCode];

                    if (isPressed && !previousState) {
                        keyStates[keyCode] = true;
                        notifyKeyPressed(keyCode);
                    } else if (!isPressed && previousState) {
                        keyStates[keyCode] = false;
                        notifyKeyReleased(keyCode);
                    }
                }

                Thread.sleep(pollDelayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void notifyKeyPressed(int keyCode) {
        // CopyOnWriteArrayList doesn't need manual copying
        for (KeyEventListener listener : listeners) {
            try {
                listener.onKeyPressed(keyCode);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyKeyReleased(int keyCode) {
        for (KeyEventListener listener : listeners) {
            try {
                listener.onKeyReleased(keyCode);
            } catch (Exception e) {
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