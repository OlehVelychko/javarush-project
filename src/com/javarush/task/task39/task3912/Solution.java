package com.javarush.task.task39.task3912;

/* 
Максимальная площадь
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Создаем новую матрицу для хранения длины максимального квадрата
        int[][] dp = new int[rows][cols];
        int maxSquareLen = 0;

        // Заполняем первую строку и первый столбец новой матрицы
        for (int i = 0; i < rows; i++) {
            dp[i][0] = matrix[i][0];
            maxSquareLen = Math.max(maxSquareLen, dp[i][0]);
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
            maxSquareLen = Math.max(maxSquareLen, dp[0][j]);
        }

        // Заполняем остальные ячейки новой матрицы
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxSquareLen = Math.max(maxSquareLen, dp[i][j]);
                }
            }
        }

        // Возвращаем площадь самого большого квадрата из единиц
        return maxSquareLen * maxSquareLen;
    }
}
