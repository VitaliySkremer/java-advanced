package Multithreading.TreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TreadPool {
    static void main() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.submit(new Work(i));
        }

        executorService.shutdown();

        System.out.println("All task submitted");

        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
