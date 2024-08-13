package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int base;
        String value;

        if (s.startsWith("0x") || s.startsWith("0X")) {
            // Hexadecimal
            base = 16;
            value = s.substring(2); // Remove "0x"
        } else if (s.startsWith("0b") || s.startsWith("0B")) {
            // Binary
            base = 2;
            value = s.substring(2); // Remove "0b"
        } else if (s.startsWith("0") && s.length() > 1 && !s.startsWith("0x") && !s.startsWith("0b")) {
            // Octal
            base = 8;
            value = s.substring(1); // Remove leading "0"
        } else {
            // Decimal
            base = 10;
            value = s;
        }

        // Convert the value to decimal
        int decimalValue = Integer.parseInt(value, base);
        return Integer.toString(decimalValue);
    }
}
