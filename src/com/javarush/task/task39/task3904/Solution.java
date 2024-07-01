package com.javarush.task.task39.task3904;

/*
Лестница
*/

public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("The number of possible ascents for " + n + " steps is: " + numberOfPossibleAscents(n));
    }

    public static long numberOfPossibleAscents(int n) {
        if (n < 0) {
            return 0;
        }

        // Создаем массив для хранения количества способов добраться до каждой ступеньки
        long[] dp = new long[n + 1];

        // Инициализируем базовые случаи
        dp[0] = 1; // Если ступенек нет, то есть один способ добраться

        // Вычисляем количество способов для каждой ступеньки
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Для текущей ступеньки можно добраться с предыдущей за один шаг
            if (i >= 2) {
                dp[i] += dp[i - 2]; // Для текущей ступеньки можно добраться с предпредыдущей за два шага
            }
            if (i >= 3) {
                dp[i] += dp[i - 3]; // Для текущей ступеньки можно добраться с предпредпредыдущей за три шага
            }
        }

        return dp[n];
    }

}

