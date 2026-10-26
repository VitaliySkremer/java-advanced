package Multithreading.ThreadSafedClass;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreClass {
    static void main() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(30);

        Connection connection = Connection.getConnection();
        for (int i = 0; i < 30; i++) {
            executorService.submit(() -> {
                try {
                    connection.work();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
    }
}
