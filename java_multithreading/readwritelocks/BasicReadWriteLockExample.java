package java_multithreading.readwritelocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BasicReadWriteLockExample {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    private String data = "initial data";

    public String readData(){
        readLock.lock();
        try{
            System.out.println("Reading: " + data);
            return data;
        }finally{
            readLock.unlock();
        }
    }

    public void writeData(String newData){
        writeLock.lock();
        try{
            System.out.println("Writing new data: " + newData);
            this.data=newData;
        }finally{
            writeLock.unlock();
        }
    }
}
