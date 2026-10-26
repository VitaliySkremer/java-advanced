package Multithreading.Synchronized;

public class Synchronized {
    private int counter;

    static void main() throws InterruptedException {
        Synchronized sync = new Synchronized();
        sync.doWork();
    }

    public synchronized void increment() {
        counter++;
    }

    public void doWork() throws InterruptedException {
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {
                    increment();
                }
            }
        };

        Thread[] listThread = new Thread[4];

        for (int i = 0; i < listThread.length; i++) {
            listThread[i] = new Thread(runner);
            listThread[i].start();
        }

        for (Thread thread : listThread) {
            thread.join();
        }

        System.out.println(counter);
    }
}
