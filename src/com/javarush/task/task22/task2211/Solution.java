package com.javarush.task.task22.task2211;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
//            System.out.println("Usage: java Solution <input_file> <output_file>");
            return;
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFileName), "Windows-1251"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}
