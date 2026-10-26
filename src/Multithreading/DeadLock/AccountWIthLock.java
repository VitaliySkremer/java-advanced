package Multithreading.DeadLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWIthLock {
    private int balance = 10000;

    private final Lock lock = new ReentrantLock();

    private static void takeLogs(Lock... locks) {
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

    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withDraw(int amount) {
        lock.lock();
        try {
            balance -= amount;
        } finally {
            lock.unlock();
        }
    }

    public static void transfer(AccountWIthLock from, AccountWIthLock to, int amount) {
        takeLogs(from.lock, to.lock);
        try {
            from.withDraw(amount);
            to.deposit(amount);
        } finally {
            from.lock.unlock();
            to.lock.unlock();
        }
    }

    public static int getTotalBalance(AccountWIthLock... accounts) {
        int balance = 0;

        for (AccountWIthLock account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    public int getBalance() {
        return this.balance;
    }
}
