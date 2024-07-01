package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        // Step 1: Find the median
        Integer[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        double median;
        int n = sortedArray.length;
        if (n % 2 == 0) {
            median = (sortedArray[n / 2 - 1] + sortedArray[n / 2]) / 2.0;
        } else {
            median = sortedArray[n / 2];
        }

        // Step 2: Sort by distance from median
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                double distA = Math.abs(a - median);
                double distB = Math.abs(b - median);
                if (distA != distB) {
                    return Double.compare(distA, distB);
                } else {
                    return Integer.compare(a, b);
                }
            }
        });

        return array;
    }
}
