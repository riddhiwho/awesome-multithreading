package java_multithreading;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable task = new Runnable() {
            @Override
            public void run(){
                account.withdraw(50);
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();

        // try{
        //     t1.join();
        //     t2.join();
            
        // }catch(Exception e){
        //     e.printStackTrace();
        // }
        
        // Thread.currentThread();
        // try {
        //     Thread.sleep(20000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        
    }
}
