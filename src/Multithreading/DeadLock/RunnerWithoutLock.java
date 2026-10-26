package Multithreading.DeadLock;

import java.util.Random;

public class RunnerWithoutLock {
    private final AccountWIthLock account1 = new AccountWIthLock();
    private final AccountWIthLock account2 = new AccountWIthLock();


    public void firstThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            AccountWIthLock.transfer(account1, account2, random.nextInt(100));
        }
    }

    public void secondThread() {
        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            AccountWIthLock.transfer(account2, account1, random.nextInt(100));
        }
    }

    public void finished() {
        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        System.out.println("Total balance: " + AccountWIthLock.getTotalBalance(account1, account2));
    }
}
