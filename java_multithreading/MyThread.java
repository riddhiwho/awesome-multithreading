package java_multithreading;

public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("RUNNING");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());

        Thread.sleep(2000);
        System.out.println(t1.getState());

        t1.join();
        System.out.println(t1.getState());
    }

}
