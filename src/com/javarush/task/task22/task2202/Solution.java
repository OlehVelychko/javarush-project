package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
    }

    public static String getPartOfString(String string) {
        if (string == null || string.isEmpty()) {
            throw new TooShortStringException();
        }

        int firstSpaceIndex = string.indexOf(' ');
        if (firstSpaceIndex == -1) {
            throw new TooShortStringException();
        }

        int fourthSpaceIndex = findNthOccurrence(string, ' ', 4);
        if (fourthSpaceIndex == -1) {
            throw new TooShortStringException();
        }

        int start = firstSpaceIndex + 1;
        int end = string.indexOf(' ', fourthSpaceIndex + 1);
        if (end == -1) {
            end = string.length();
        }

        if (start >= end) {
            throw new TooShortStringException();
        }

        return string.substring(start, end);
    }

    private static int findNthOccurrence(String string, char c, int n) {
        int index = string.indexOf(c);
        while (--n > 0 && index != -1) {
            index = string.indexOf(c, index + 1);
        }
        return index;
    }


    public static class TooShortStringException extends RuntimeException {
    }
}
