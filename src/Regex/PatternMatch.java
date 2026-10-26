package Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {
    static void main() {
        String text = "test@mail.ru fasdf john@yandex.ru sdg sdgfgd tim@yahoo.com";
        Pattern email = Pattern.compile("([a-zA-Z0-9]+)@(\\w+)\\.(com|ru)");
        Matcher matcher = email.matcher(text);

        List<String> emailList = new ArrayList<>();

        while (matcher.find()) {
            emailList.add(matcher.group());
        }

        System.out.println(emailList);
    }
}
