package java_multithreading;

public class SynchronisationThreads {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread1 t1 = new Thread1(counter);
        Thread1 t2 = new Thread1(counter);

        t1.start();
        t2.start(); 

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(counter.getCount());
        
    }
}
