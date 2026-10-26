package Collections.QueueCollection;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueCollection {
    void main() {
        Person person1 = new Person(1);
        Person person2 = new Person(2);
        Person person3 = new Person(3);
        Person person4 = new Person(4);

        Queue<Person> queue = new LinkedList<>();
        queue.add(person2);
        queue.add(person1);
        queue.add(person4);
        queue.add(person3);

        queue.poll();

        System.out.println(queue);
    }
}
