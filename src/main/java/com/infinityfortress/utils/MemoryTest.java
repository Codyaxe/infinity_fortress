package com.infinityfortress.utils;

public class MemoryTest {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();

        // Force garbage collection
        System.gc();
        Thread.sleep(1000);

        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory before thread: " + (memoryBefore / 1024 / 1024) + " MB");

        KeyListenerThread listener = new KeyListenerThread();
        listener.trackAllStandardKeys();
        listener.start();
        listener.waitUntilReady();

        Thread.sleep(5000);

        System.gc();
        Thread.sleep(1000);
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after thread: " + (memoryAfter / 1024 / 1024) + " MB");
        System.out.println("Difference: " + ((memoryAfter - memoryBefore) / 1024 / 1024) + " MB");

        listener.stopListener();

        System.gc();
        Thread.sleep(1000);
        memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("\n--- Testing with just 5 keys ---");
        System.out.println("Memory before: " + (memoryBefore / 1024 / 1024) + " MB");

        KeyListenerThread listener2 = new KeyListenerThread();
        listener2.trackKeys(KeyListenerThread.VK_W, KeyListenerThread.VK_A,
                KeyListenerThread.VK_S, KeyListenerThread.VK_D,
                KeyListenerThread.VK_SPACE);
        listener2.start();
        listener2.waitUntilReady();
        Thread.sleep(5000);

        System.gc();
        Thread.sleep(1000);
        memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory after: " + (memoryAfter / 1024 / 1024) + " MB");
        System.out.println("Difference: " + ((memoryAfter - memoryBefore) / 1024 / 1024) + " MB");

        listener2.stopListener();
    }
}