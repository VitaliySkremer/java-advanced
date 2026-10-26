package Multithreading.ThreadSafedClass;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenRantLockClass {
    static void main() throws InterruptedException {
        Task task = new Task();

        Thread thread1 = new Thread(task::firstThread);
        Thread thread2 = new Thread(task::secondThread);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(task.getCount());
    }

    static class Task {
        private int count;
        private final Lock lock = new ReentrantLock();

        private void increment() {
            for (int i = 0; i < 10000; i++) {
                count++;
            }
        }

        public int getCount() {
            return this.count;
        }

        public void firstThread() {
            lock.lock();
            increment();
            lock.unlock();
        }

        public void secondThread() {
            lock.lock();
            increment();
            lock.unlock();
        }
    }
}
