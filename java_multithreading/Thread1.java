package java_multithreading;

public class Thread1 extends Thread {
    private Counter counter;

    public Thread1(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run(){
        for(int i=0; i<1000; i++) counter.increment();
    }
}
