package Lambda.MyComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyComparator {
    static void main() {
        List<String> list = new ArrayList<>();

        list.add("Bob");
        list.add("Alice");
        list.add("Mike");
        list.add("Jorge");
        list.add("Adolf");

        Comparator<String> comparator = (o1, o2) -> {
            if(o1.length() == o2.length()) return 0;
            return o1.length() > o2.length() ? 1 : -1;
        };

        list.sort(comparator);

        System.out.println(list);
    }
}
