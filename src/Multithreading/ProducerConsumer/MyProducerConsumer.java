package Multithreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyProducerConsumer {
    static void main() {
        ProducerConsumer pc = new ProducerConsumer();
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        threadPool.submit(() -> {
            try {
                pc.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadPool.submit(() -> {
            try {
                pc.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadPool.shutdown();
    }

    static class ProducerConsumer {
        private final Queue<Integer> queue = new LinkedList<>();
        private final int LIMIT = 10;
        private final Object lock = new Object();

        public void producer() throws InterruptedException {
            Random random = new Random();

            for (;;) {
                synchronized (lock) {
                    if (queue.size() == LIMIT) {
                        lock.wait();
                    }

                    queue.add(random.nextInt(10));
                    lock.notify();
                }
            }

        }

        public void consumer() throws InterruptedException {
            for (;;) {
                synchronized (lock) {
                    if (queue.isEmpty()) {
                        lock.wait();
                    }

                    int value = queue.poll();
                    System.out.println(value);
                    System.out.println("Size " + queue.size());
                    if(queue.size() == 5) {
                        lock.notify();
                    }
                }

                Thread.sleep(1000);
            }
        }
    }
}
