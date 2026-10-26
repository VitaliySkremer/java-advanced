package Annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    static void main() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner = new Scanner(System.in);
        Class classObject1 = Class.forName(scanner.next());
        Class classObject2 = Class.forName(scanner.next());
        String method = scanner.next();

        Method method1 = classObject1.getMethod(method, classObject2);

        Object obj1 = classObject1.newInstance();
        Object obj2 = classObject2.getConstructor(String.class).newInstance("String value");

        method1.invoke(obj1, obj2);

        System.out.println(obj1);
    }
}
