package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();

        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        if (len1 == len2) {
            int diffCount = 0;
            for (int i = 0; i < len1; i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
            return true;
        } else {
            String shorter = len1 < len2 ? first : second;
            String longer = len1 < len2 ? second : first;
            int index1 = 0;
            int index2 = 0;
            boolean foundDiff = false;
            while (index1 < shorter.length() && index2 < longer.length()) {
                if (shorter.charAt(index1) != longer.charAt(index2)) {
                    if (foundDiff) {
                        return false;
                    }
                    foundDiff = true;
                    if (len1 == len2) {
                        index1++;
                    }
                } else {
                    index1++;
                }
                index2++;
            }
            return true;
        }
    }

}
