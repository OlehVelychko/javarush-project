package com.javarush.task.task30.task3009;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(getRadix("112"));        // expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        // expected output: [6]
        System.out.println(getRadix("5321"));       // expected output: []
        System.out.println(getRadix("1A"));         // expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        int decimalNumber;

        // Validate the input
        try {
            decimalNumber = Integer.parseInt(number);
            if (decimalNumber < 0) {
                return result; // Return empty set for negative numbers
            }
        } catch (NumberFormatException e) {
            return result; // Return empty set for invalid numbers
        }

        // Check for each base from 2 to 36
        for (int base = 2; base <= 36; base++) {
            try {
                String baseRepresentation = Integer.toString(decimalNumber, base);
                if (isPalindrome(baseRepresentation)) {
                    result.add(base);
                }
            } catch (NumberFormatException e) {
                // Continue to next base if there is an error
            }
        }

        return result;
    }

    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
