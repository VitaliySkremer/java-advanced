package Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetCollection {
    void main() {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        test(hashSet);

        //union - объединение
        Set<Integer> setInt = new HashSet<>();
        setInt.add(0);
        setInt.add(1);
        setInt.add(2);
        setInt.add(3);
        setInt.add(4);
        setInt.add(5);

        Set<Integer> setInt2 = new HashSet<>();
        setInt2.add(2);
        setInt2.add(3);
        setInt2.add(4);
        setInt2.add(5);
        setInt2.add(6);
        setInt2.add(7);

        Set<Integer> union = new HashSet<>(setInt);
        union.addAll(setInt2);

        System.out.println(union);

        //intersection - пересечение
        Set<Integer> intersection = new HashSet<>(setInt);
        intersection.retainAll(setInt2);

        System.out.println(intersection);

        // difference - разность
        Set<Integer> diff = new HashSet<>(setInt);
        diff.removeAll(setInt2);

        System.out.println(diff);
    }

    static void test(Set<String> set) {
        set.add("Alice");
        set.add("Bob");
        set.add("Mike");
        set.add("Red");
        set.add("Donald");
        set.add("Alice");
    }
}
