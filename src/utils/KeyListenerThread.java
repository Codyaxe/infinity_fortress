package utils;

public class KeyListenerThread extends Thread {
    private volatile boolean running = true;
    private volatile boolean skipRequested = false;

    @Override
    public void run() {
        // Code
    }

    public boolean isSkipRequested() {
        return skipRequested;
    }

    public void stopListener() {
        running = false;
    }
}