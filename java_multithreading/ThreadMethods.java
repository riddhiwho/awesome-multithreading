package java_multithreading;

public class ThreadMethods extends Thread {

    // @Override
    // public void run(){
    //     // for(int i=0; i<5; i++){
    //     //     try {
    //     //         Thread.sleep(1000);
    //     //     } catch (InterruptedException e) {
    //     //         e.printStackTrace();
    //     //     }
    //     //     System.out.println("Thread is running...");
    //     // }

    //     try{
    //         Thread.sleep(5000);
    //     }catch(InterruptedException e){
    //         e.printStackTrace();
    //     }
       
    // }

    public ThreadMethods(String name){
        super(name);
    }

    // @Override
    // public void run(){
    //     for(int i=0; i<5; i++){
    //         String a = "";
    //         for(int j=0; j<10000; j++){
    //             a+="a";
    //         }
    //         System.out.println(Thread.currentThread().getName() + " - Priority: " + Thread.currentThread().getPriority() + " - count:" + i);
    //         try{
    //             Thread.sleep(100);
    //         }catch(Exception e){
    //             e.printStackTrace();
    //         }
    //     }
    // }

    // @Override
    // public void run(){
    //     try {
    //         Thread.sleep(1000);
    //         System.out.println("Thread is running");
    //     } catch (InterruptedException e) {
    //         System.out.println("Thread interrupted: " + e);
    //     }
    // }

    // @Override
    // public void run(){
    //     for(int i=0; i<5; i++){
    //         System.out.println(Thread.currentThread().getName() + " is running");
    //         Thread.yield();
    //     }
    // }

    @Override
    public void run(){
        while (true) {
            System.out.println("Hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // ThreadMethods t1 = new ThreadMethods();
        // t1.start();
        // t1.join();
        // System.out.println("Hello");

        // ThreadMethods harry = new ThreadMethods("Harry");
        // ThreadMethods hermione = new ThreadMethods("Hermione");
        // ThreadMethods ron = new ThreadMethods("Ron");
        
        // harry.setPriority(MAX_PRIORITY);
        // hermione.setPriority(NORM_PRIORITY);
        // ron.setPriority(MIN_PRIORITY);

        // harry.start();
        // hermione.start();
        // ron.start();

        // ThreadMethods t1 = new ThreadMethods("Harry");
        // t1.start();
        // t1.interrupt();


        // ThreadMethods harry = new ThreadMethods("harry");
        // ThreadMethods hermione = new ThreadMethods("hermione");

        // harry.start();
        // hermione.start();

        ThreadMethods t1 = new ThreadMethods("harry");
        t1.setDaemon(true);
        t1.start();
        System.out.println("main done");
    }
}

/*
 * Hello will be printed only after t1 terminates.
 */
