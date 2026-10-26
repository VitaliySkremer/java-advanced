package Collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMapCollection {
    void main() {
        Map<Integer, String> hashMap = new HashMap<>(); //не гарантирует порядок
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>(); // гарантируется порядок добавления по ключу
        Map<Integer, String> treeMap = new TreeMap<>(); // сортируется по ключу при добавлении

//        Map<String, String> treeMapStr = new TreeMap<>();
//        treeMapStr.put("AE", "E");
//        treeMapStr.put("AC", "A");
//        treeMapStr.put("AB", "B");
//        treeMapStr.put("C", "C");
//        treeMapStr.put("D", "D");
//
//        for (Map.Entry<String, String> entry : treeMapStr.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        testMap(hashMap);
        testMap(linkedHashMap);
        testMap(treeMap);
    }

    static void testMap(Map<Integer, String> map) {
        map.put(39, "Bob");
        map.put(23, "Mike");
        map.put(34, "Tom");
        map.put(53, "Rob");
        map.put(0, "Angel");
        map.put(1500, "Alice");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
