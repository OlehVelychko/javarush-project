package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        new java.io.FileReader("xxx").read();
    }

    public static void main(String[] args) {

    }
}
