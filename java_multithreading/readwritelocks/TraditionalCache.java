package java_multithreading.readwritelocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TraditionalCache {
    private final Map<String, String> cache = new HashMap<>();
    private final ReentrantLock lock = new ReentrantLock();

    public String get(String key){
        lock.lock();
        try{
            // Even reads require exclusive access
            return cache.get(key);
        }finally{
            lock.unlock();
        }
    }

    public void put(String key, String value){
        lock.lock();
        try{
            cache.put(key, value);
        }finally{
            lock.unlock();
        }
    }
}


/*
 * In this traditional approach, even read operations require exclusive access,
 * which severely limits concurrency when you have many readers and few writers.
 */