package Multithreading;

import java.util.Scanner;

public class Multithreading {
    static void main() {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutdown();
    }
}
