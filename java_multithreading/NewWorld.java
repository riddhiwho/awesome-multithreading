package java_multithreading;

public class NewWorld implements Runnable {
    @Override
    public void run(){
        for(; ;){
            System.out.println(Thread.currentThread().getName());
            // System.out.println("World");
        }
    }
}
