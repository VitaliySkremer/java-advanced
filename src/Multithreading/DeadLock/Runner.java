package Multithreading.DeadLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
    private final Account account1 = new Account();
    private final Account account2 = new Account();

    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    private void takeLogs(Lock... locks) {
        boolean[] locksAcquired = new boolean[locks.length];

        while (true) {
            int lockedCount = 0;

            for (int i = 0; i < locksAcquired.length; i++) {
                locksAcquired[i] = locks[i].tryLock();

                if (locksAcquired[i]) {
                    lockedCount++;
                }
            }

            if (lockedCount == locksAcquired.length) {
                return;
            }

            for (int i = 0; i < locks.length; i++) {
                if (locksAcquired[i]) {
                    locks[i].unlock();
                }
            }
        }
    }

    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            takeLogs(lock1, lock2);

            try {
                Account.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            takeLogs(lock2, lock1);

            try {
                Account.transfer(account2, account1, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance: " + Account.getTotalBalance(account1, account2));
    }
}
