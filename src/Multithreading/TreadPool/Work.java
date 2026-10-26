package Multithreading.TreadPool;

public class Work implements Runnable{
    private final int id;

    Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Work " + id + " was completed");
    }
}
