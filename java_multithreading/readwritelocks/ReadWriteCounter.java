package java_multithreading.readwritelocks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    
    private int count = 0;
    
    public int getCount() {
        readLock.lock();
        try {
            return count;
        } finally {
            readLock.unlock();
        }
    }
    
    public void increment() {
        writeLock.lock();
        try {
            count++;
        } finally {
            writeLock.unlock();
        }
    }
    
    public void decrement() {
        writeLock.lock();
        try {
            count--;
        } finally {
            writeLock.unlock();
        }
    }
    
    public void reset() {
        writeLock.lock();
        try {
            count = 0;
        } finally {
            writeLock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter = new ReadWriteCounter();
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        // Start time for performance measurement
        long startTime = System.currentTimeMillis();
        
        // Create multiple reader threads (read-heavy workload)
        for (int i = 0; i < 8; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 100000; j++) {
                    int value = counter.getCount();
                    if (j % 10000 == 0) {
                        System.out.println("Reader " + threadId + " read: " + value);
                    }
                }
            });
        }
        
        // Create fewer writer threads
        for (int i = 0; i < 2; i++) {
            final int threadId = i;
            executor.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    if (j % 2 == 0) {
                        counter.increment();
                    } else {
                        counter.decrement();
                    }
                    
                    if (j % 100 == 0) {
                        System.out.println("Writer " + threadId + " updated counter to: " + counter.getCount());
                    }
                    
                    // Simulate some work
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            });
        }
        
        // Shutdown executor and wait for completion
        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
        
        long endTime = System.currentTimeMillis();
        System.out.println("\nFinal counter value: " + counter.getCount());
        System.out.println("Total time taken: " + (endTime - startTime) + " ms");
        
        // Reset counter to demonstrate reset functionality
        counter.reset();
        System.out.println("Counter after reset: " + counter.getCount());
    }
}
