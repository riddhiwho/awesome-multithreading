package java_multithreading;

public class Hello {
    public static void main(String[] args) {

        // NEW
        // World world = new World();
        // RUNNABLE
        // world.start();

        NewWorld newWorld = new NewWorld();
        Thread t1 = new Thread(newWorld);
        t1.start();

        for(; ;){
            System.out.println(Thread.currentThread().getName());
            // System.out.println("Hello");
        }
    }
}
