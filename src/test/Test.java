package test;

import org.jetbrains.annotations.NotNull;

import java.util.List;

class Test {
    public static void main(String[] args) {
        getFruits(getFruits(List.of("Apple", "Banana", "Orange"))).add("dg");

        isAnimal("Eiliin", 8, 100);

    }

    private static @NotNull List<String> getFruits(List<String> stringList) {
        return stringList;
    }

    public static boolean isAnimal(String name, int age, long life1) {
        return isAnimal(life1, age, name);
    }

    public static boolean isAnimal(long life, int age, String name) {
        boolean extractBool = 5 > 8;
        if (extractBool) {
            System.out.println();
        }
        return true;
    }
}
