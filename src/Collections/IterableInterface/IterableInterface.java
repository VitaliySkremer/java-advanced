package Collections.IterableInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IterableInterface {
    void main() {
        List<Integer> list = new LinkedList<>();

        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();

        int idx = 0;
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

            if (idx == 1) iterator.remove();

            idx++;
        }

        System.out.println(list);
    }
}
