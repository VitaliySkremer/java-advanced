package Collections;

import java.util.Objects;

public class Person {
    private int id;
    private String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /*
        Контракт hashCode() equals()
        1) проверяем hashcode() у 2 объекто: если хэщи разные -> то объекты разные
        2) если хэши одинаковые -> то мы проверяем equals() точно ли объекты одинаковые
        3) есл и equals() говорит true то 2 объекта одинаковые
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Objects.hashCode(name);
        return result;
    }
}
