package java_multithreading;

public class World extends Thread {
    // RUNNING
    @Override
    public void run(){
        for(; ;){
            System.out.println(Thread.currentThread().getName());
            // System.out.println("World");
        }
    }
}


/**
 * A new class World is created that extends the Thread class.
 * The run method is overriden to define the code that constitutes the new thread.
 * start method is called to initiate the new thread.
 */