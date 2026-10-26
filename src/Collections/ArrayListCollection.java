package Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListCollection {
    void main() {
        List<Integer> list = new ArrayList<>();
        int[] arr = {1,2,3};

        System.out.println(Arrays.toString(arr));

        for(int i = 0; i < 100; i++) {
            list.add(i);
        }

        System.out.println(list);

        System.out.println("Первый элемент -> " + list.getFirst());
        System.out.println("Последний элемент -> " + list.getLast());
        System.out.println("Всего элементов -> " + list.size());

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        for (int item : list) {
            System.out.print(list.get(item) + " ");
        }
        System.out.println();

        list.remove(2);
        System.out.println(list);
    }
}
