package com.javarush.task.task39.task3908;

/* 
Возможен ли палиндром?
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean isPalindromePermutation(String s) {
        // Приводим строку к нижнему регистру и удаляем пробелы
        s = s.toLowerCase().replaceAll("\\s+", "");

        // Создаем хэш-таблицу для подсчета количества встречающихся символов
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Подсчитываем количество символов с нечетным количеством встреч
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // Палиндром из символов строки возможен, если количество символов с нечетным количеством встреч меньше или равно 1
        return oddCount <= 1;
    }
}
