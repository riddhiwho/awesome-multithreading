package java_multithreading;

public class Test{
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}

/*
 * When a java program starts, one thread starts running immediately,
 * which is called the main thread. 
 * This thread is responsible for executing the main method of a program.
 */