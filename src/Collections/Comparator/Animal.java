package Collections.Comparator;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
    private int id;
    private String name;

    public Animal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;
        return id == animal.id && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Animal o) {
        if (this.id > o.id) return -1;
        if (this.id < o.id) return 1;
        return 0;
    }
}
