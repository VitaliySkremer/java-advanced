package Regex;

import java.util.Arrays;

public class Regex {
    static void main() {
        String a = "Hello124124worldf2342352frsfgsg4325345gfdsg";
        String[] arr = a.split("\\d+");
        System.out.println(Arrays.toString(arr));

        String b = "Hello2345325world123fsfserfg";
        System.out.println(b.replaceAll("\\d+", " "));
    }
}
