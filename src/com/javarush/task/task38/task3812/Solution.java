/*
package com.javarush.task.task38.task3812;

*/
/*
Обработка аннотаций
*//*


public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest annotation = c.getAnnotation(PrepareMyTest.class);
            String[] fullyQualifiedNames = annotation.fullyQualifiedNames();
            for (String fullyQualifiedName : fullyQualifiedNames) {
                System.out.println(fullyQualifiedName);
            }
            return true;
        }
        return false;
    }

    public static boolean printValues(Class<?> c) {
        if (c.isAnnotationPresent(PrepareMyTest.class)) {
            PrepareMyTest annotation = c.getAnnotation(PrepareMyTest.class);
            Class<?>[] classes = annotation.value();
            for (Class<?> aClass : classes) {
                System.out.println(aClass.getSimpleName());
            }
            return true;
        }
        return false;
    }
}
*/
