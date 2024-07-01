package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // /Users/narsil/Documents/my Java/for Test/task3605
        if (args.length < 1) {
            System.out.println("Please provide the file name as a command line argument");
            return;
        }

        String filePath = args[0];
        TreeSet<Character> treeSet = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                char[] symbols = line.toCharArray();
                for (char symbol : symbols) {
                    if (Character.isAlphabetic(symbol)) {
                        treeSet.add(symbol);
                    }
                }
            }
        }

        int count = 0;

        for (Character symbol : treeSet) {
            if (count < 5) {
                System.out.print(symbol);
                count++;
            } else {
                break;
            }
        }
    }
}
