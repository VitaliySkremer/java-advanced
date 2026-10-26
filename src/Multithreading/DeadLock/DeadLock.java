package Multithreading.DeadLock;

public class DeadLock {
    static void main() throws InterruptedException {
        Runner runner = new Runner();
        RunnerWithoutLock runnerWithoutLock = new RunnerWithoutLock();

        Thread thread1 = new Thread(runnerWithoutLock::firstThread);
        Thread thread2 = new Thread(runnerWithoutLock::secondThread);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runnerWithoutLock.finished();
    }
}
