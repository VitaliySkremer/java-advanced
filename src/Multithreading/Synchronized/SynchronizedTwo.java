package Multithreading.Synchronized;

public class SynchronizedTwo {
    static void main() {
        Worker worker = new Worker();
        try {
            worker.main();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
