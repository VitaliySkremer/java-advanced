package Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListCollection {
    void main() {
        List<Integer> list = new LinkedList<>();
        // [1] -> [2] -> [3] -> [4]

        List<Integer> arayList = new ArrayList<>();
        //[1][2][3][4]

//        measureTime(list);          //Добавляетв конец медленней    считывает медленней     добавление в начало быстрее
//        measureTime(arayList);      //Добавляет в конец быстрей     считывает быстрей       добавление в начало медленней

        MyLinkedList<Integer> myList = new MyLinkedList<>();

        myList.add(2);
        myList.add(3);
        myList.add(20);
        myList.add(10);

        System.out.println(myList.getSize());
        System.out.println(myList);
        System.out.println(myList.get(0));

        myList.remove(3);
        System.out.println(myList);
    }

    private static void measureTime(List<Integer> list) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            list.addFirst(i);
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
