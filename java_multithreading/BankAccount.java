package java_multithreading;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

    private final Lock lock = new ReentrantLock();

    public void withdraw(int amount){
        try{
            System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " attempting to hold the lock");
            if(lock.tryLock(15000, TimeUnit.MILLISECONDS)){
                System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " attempting to withdraw: " + amount);
                if(balance>=amount){
                    System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                    try{
                        Thread.sleep(10000);
                        balance-=amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Current balance: " + balance);
                    }catch(Exception e){
                        Thread.currentThread().interrupt();
                    }
                    finally{
                        lock.unlock();
                    }
                    
                }else{
                    System.out.println(Thread.currentThread().getName() + " insufficient balance.");
                }
            }else{
                System.out.println(LocalTime.now() + " - " + Thread.currentThread().getName() + " couldn't acquire lock.");
            }
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        
    }
}
