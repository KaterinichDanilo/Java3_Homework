package Homework7;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {
    private static final int MAX_BS = 1;
    private static final int MAX_AS = 1;

    public static void start (Class cl) throws InvocationTargetException, IllegalAccessException {
        try {
            if (!ifSuitesLessOne(MAX_AS, cl)) {
                throw new RuntimeException("You have more then one @AfterSuite or @BeforeSuite annotations");
            }
            Method [] methods = cl.getDeclaredMethods();
            List<Method> sortedMethods = sortMethods(methods);
            for (Method m : methods) {
                if (m.isAnnotationPresent(BeforeSuite.class)) {
                    sortedMethods.add(0, m);
                } else if (m.isAnnotationPresent(AfterSuite.class)) {
                    sortedMethods.add(sortedMethods.size(), m);
                }
            }

            runMethods(sortedMethods);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }


    }

    private static boolean ifSuitesLessOne(int max, Class cl) {
        int counterAfterSuite = 0;
        int counterBeforeSuite = 0;
        for (Method m : cl.getDeclaredMethods()) {
            if (m.isAnnotationPresent(AfterSuite.class)) {
                counterAfterSuite ++;
            }
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                counterBeforeSuite ++;
            }
        }
        return (counterAfterSuite <= max && counterBeforeSuite <= max);
    }

    private static List<Method> sortMethods(Method [] methods) {
        List<Method> sortedMethods = new ArrayList<>();

        for (Method m : methods) {
            if (m.isAnnotationPresent(Test.class)) {
                sortedMethods.add(m);
            }
        }
        sortedMethods.sort(Comparator.comparing(o -> o.getAnnotation(Test.class).priority()));
        return sortedMethods;
    }

    private static void runMethods(List<Method> sortedMethods) throws InvocationTargetException, IllegalAccessException {
        for (Method method : sortedMethods) {
            method.invoke(null );
        }
    }
}
