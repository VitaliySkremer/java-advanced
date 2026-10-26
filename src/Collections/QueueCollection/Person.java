package Collections.QueueCollection;

public class Person implements Comparable<Person> {
    private int id;

    public Person(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if(id > o.getId()) return 1;
        if(id < o.getId()) return -1;
        return 0;
    }
}
