package java_multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    private final Lock lock = new ReentrantLock();

    public void outerFuncion(){
        lock.lock();
        try{
            System.out.println("outer func");
            innerFuncion();
        }finally{
            lock.unlock();
        }
    }

    public void innerFuncion(){
        lock.lock();
        try{
            System.out.println("inner func");
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantExample reentrantLock = new ReentrantExample();
        reentrantLock.outerFuncion();
    }
}
