package Multithreading.Synchronized;

import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class Worker {
    private final List<Integer> list1 = new ArrayList<>();
    private final List<Integer> list2 = new ArrayList<>();

    public void addToListOne() {
        for (int i = 0; i < 10000000; i++) {
            list1.add(ThreadLocalRandom.current().nextInt());
        }
    }

    public void addToListTwo() {
        for (int i = 0; i < 10000000; i++) {
            list2.add(ThreadLocalRandom.current().nextInt());
        }
    }

    public void work() {
        addToListOne();
        addToListTwo();
    }

    public void main() throws InterruptedException {
        long before = System.currentTimeMillis();

        Thread thread1 = new Thread(this::addToListOne);
        Thread thread2 = new Thread(this::addToListTwo);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

//        work();

        long after = System.currentTimeMillis();

        System.out.println("Конец: " + (after - before));

        System.out.println(list1.size());
        System.out.println(list2.size());
    }
}
