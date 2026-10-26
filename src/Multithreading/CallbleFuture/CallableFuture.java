package Multithreading.CallbleFuture;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    static void main() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Starting three");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Finished three");

            Random random = new Random();
            return random.nextInt(10);
        });

        try {
            int result = future.get();

            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    public static int calculate() {
        return 5 + 10;
    }
}
