package Multithreading.ThreadSafedClass;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Connection {
    private static final Connection connection = new Connection();
    private int connectionsCount;
    private final Semaphore semaphore = new Semaphore(10);
    private ReentrantLock lock = new ReentrantLock();

    private Connection() {

    }

    public static Connection getConnection () {
        return connection;
    }

    public void work () throws InterruptedException {
        semaphore.acquire();
        try {
            doWork();
        } finally {
            semaphore.release();
        }
    }

    private void doWork () throws InterruptedException {
        lock.lock();
        connectionsCount++;
        System.out.println(connectionsCount);
        lock.unlock();

        Thread.sleep(5000);

        lock.lock();
        connectionsCount--;
        lock.unlock();
    }
}
