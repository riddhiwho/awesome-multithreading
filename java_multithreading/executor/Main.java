package java_multithreading.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main{

    private static long factorial(int n){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        long result=1;
        for(int i=1; i<=n; i++){
            result*=i;
        }
        return result;
    }

    // public static void main(String[] args) {
    //     long startTime = System.currentTimeMillis();
    //     for(int i=1; i<10; i++){
    //         System.out.println(factorial(i));
    //     }
    //     System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    // }

    // public static void main(String[] args) {
    //     long startTime = System.currentTimeMillis();
    //     Thread[] threads = new Thread[9];
    //     for(int i=1; i<10; i++){
    //         int finalI=i;
    //         threads[i-1] = new Thread(
    //             () -> {
    //                 long result = factorial(finalI);
    //                 System.out.println(result);
    //             }
    //         );
    //         threads[i-1].start();
    //     }

    //     for(Thread thread : threads){
    //         try{
    //             thread.join();
    //         }catch(InterruptedException e){
    //             e.printStackTrace();
    //         }
    //     }

    //     System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    // }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for(int i=1; i<10; i++){
            int finalI=i;
            executorService.submit(() -> {
                long result = factorial(finalI);
                System.out.println(result);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Total time: " + (System.currentTimeMillis() - startTime));
    }

}