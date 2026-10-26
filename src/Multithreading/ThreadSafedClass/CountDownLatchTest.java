package Multithreading.ThreadSafedClass;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    static void main() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
            executorService.submit(new Processor(i, countDownLatch));
        }

        executorService.shutdown();

        System.out.println("Press enter to count down");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            countDownLatch.countDown();
        }
    }

    static class Processor implements Runnable {
        private final CountDownLatch countDownLatch;
        private int id;

        Processor(int id, CountDownLatch countDownLatch) {
            this.id = id;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Thread " + id + " is proceeding");
        }
    }
}
