package Regex;

public class MyRegex {
    static void main() {
        /*
            \\d - одна цифра
            + - 1 или более
            * - 0 или более
            ? - 0 или 1 символов до

            \\w - одна буква [a-zA-Z]

            (- | \\+ | !) - множество через | или (-+!)

            [a-zA-Z] - все английские буквы
            [0-9] - все цифры
            [^abc] - все символы кроме a b c

            . - любой символ

            {2} - разрешено столько то цифр
            {2, } - 2 или более
            {2, 4} - от 2 до 4
         */

        String regex = "[-+]?\\d+";

        String a = "-123";
        String b = "24124";
        String c = "+123";
        System.out.println(a.matches(regex));
        System.out.println(b.matches(regex));
        System.out.println(c.matches(regex));

        String regex1 = "[a-zA-Z]+\\d+";
        String a1 = "aw123";
        System.out.println(a1.matches(regex1));

        String regex2 = "[^abc]*";
        String e = "Hello";
        String d = "asdf";
        System.out.println(e.matches(regex2));
        System.out.println(d.matches(regex2));

        String url = "https://www.google.com";
        String url2 = "http://www.yandex.ru";
        System.out.println(url.matches("http(s)?://(w){3}\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http(s)?://(w){3}\\..+\\.(com|ru)"));
    }
}
