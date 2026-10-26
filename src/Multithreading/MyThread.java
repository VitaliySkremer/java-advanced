package Multithreading;

public class MyThread extends Thread {
    private volatile boolean isRunning = true;

    public void run() {
        while (isRunning) {
            System.out.println("Hello");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void shutdown() {
        this.isRunning = false;
    }
}
