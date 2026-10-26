package Multithreading.ProducerConsumer;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitNotify {
    static void main() {
        WaitAndNotify wn = new WaitAndNotify();

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            try {
                wn.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadPool.submit(() -> {
            try {
                wn.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.shutdown();
    }

    static class WaitAndNotify {
        public void producer() throws InterruptedException {
            synchronized (this) {
                System.out.println("Producer thread started...");
                wait();
                System.out.println("Producer thread resumed...");
            }
        }

        public void consumer() throws InterruptedException {
            Thread.sleep(2000);

            Scanner scanner = new Scanner(System.in);

            synchronized (this) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine();
                notify();

                Thread.sleep(5000);
            }
        }
    }
}
