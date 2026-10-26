package Lambda.CollectionsFunctions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsFunctions {
    static void main() {
//        int[] arr = new int[10];
//        List<Integer> list = new ArrayList<>();
//
//        fillArr(arr);
//        fillList(list);
//
//        arr = Arrays.stream(arr).map(item -> item * 2).toArray();
//        list = list.stream().map(item -> item * 2).toList();
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(list);
//
//        arr = Arrays.stream(arr)
//                .filter(item -> item >= 10)
//                .map((item) -> item * 2)
//                .toArray();
//        list = list.stream()
//                .filter(item -> item >= 10)
//                .toList();
//
//        System.out.println(Arrays.toString(arr));
//        System.out.println(list);
//
//        int sumArr = Arrays.stream(arr)
//                .reduce(0, Integer::sum);
//        int mulList = list.stream()
//                .reduce(1, (acc, item) -> acc * item);
//
//        System.out.println(sumArr);
//        System.out.println(mulList);
//
//        String[] arrStr = new String[5];
//
//        for (int i = 0; i < arrStr.length; i++) {
//            StringBuilder builder = new StringBuilder();
//            builder.repeat(String.valueOf(i), i);
//            arrStr[i] = builder.toString();
//        }
//
//        String strMax = Arrays.stream(arrStr)
//                .max(Comparator.comparingInt(String::length))
//                .get();
//
//        System.out.println(strMax);
//
//        Set<Integer> set = new HashSet<>();
//
//        set.add(2);
//
//        set = set.stream().map(item -> item * 2).collect(Collectors.toSet());
//
//        System.out.println(set);

        Stream<Phone> phoneStream = Stream.of(
                new Phone("Pixel 2", "Google", 500),
                new Phone("iPhone 8", "Apple", 450),
                new Phone("Nokia 9", "HMD Global", 150),
                new Phone("Galaxy S9", "Samsung", 300),
                new Phone("iPhone X", "Apple", 600)
        );

        Map<String, List<Phone>> phoneList = phoneStream
                .sorted(Comparator.comparingInt(Phone::getPrice))
                .collect(Collectors.groupingBy(Phone::getCompany));

        for (Map.Entry<String, List<Phone>> phone : phoneList.entrySet()) {
            System.out.println(phone.getKey());
            phone.getValue().forEach(Phone::showPhone);
            System.out.println();
        }
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }
}
