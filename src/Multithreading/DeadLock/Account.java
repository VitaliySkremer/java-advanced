package Multithreading.DeadLock;

public class Account {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withDraw(int amount) {
        balance -= amount;
    }

    public static void transfer(Account drawAcc, Account depAcc, int amount) {
        drawAcc.withDraw(amount);
        depAcc.deposit(amount);
    }

    public static int getTotalBalance(Account ...accounts) {
        int balance = 0;

        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    public int getBalance() {
        return this.balance;
    }
}
