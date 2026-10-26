package Collections.Comparator;

import java.util.*;
import java.util.stream.Stream;

public class Comparator {
    void main() {
//        List<Person> list = new ArrayList<>();
//        list.add(new Person(1, "Bob"));
//        list.add(new Person(2, "Alice"));
//        list.add(new Person(3, "Tom"));
//        list.add(new Person(4, "Robert"));
//        list.add(new Person(5, "Juane"));
//
//        list.sort(new java.util.Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if (o1.getId() > o2.getId()) return -1;
//                if (o1.getId() < o2.getId()) return  1;
//                return 0;
//            }
//        });
//
//        System.out.println(list);

//        List<String> animals = new ArrayList<>();
//        animals.add("cat");
//        animals.add("dog");
//        animals.add("frog");
//        animals.add("mouse");
//        animals.add("bird");
//
//        animals.sort(new StringLengthComparator());
//        System.out.println(animals);
//
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(0);
//        numbers.add(-100);
//        numbers.add(100444);
//        numbers.add(23);
//        numbers.add(467);
//
//        numbers.sort(new IntegerComparator(true));
//        System.out.println(numbers);

        Stream<String> streamStr = Stream.of("dog", "cat");
        String[] arrStr = streamStr.peek(System.out::println).toArray(String[]::new);

        Arrays.sort(arrStr, (o1, o2) -> 0);
    }

    private static void addElements(Collection<Animal> collection) {
        collection.add(new Animal(1, "cat"));
        collection.add(new Animal(2, "dog"));
        collection.add(new Animal(3, "frog"));
        collection.add(new Animal(4, "mouse"));
        collection.add(new Animal(5, "bird"));
    }
}
