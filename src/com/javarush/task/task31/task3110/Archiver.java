package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please enter full archive path...");
            String fullArchivePath = reader.readLine();

            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(fullArchivePath));

            System.out.println("Please enter path to file...");
            String pathToFile = reader.readLine();

            zipFileManager.createZip(Paths.get(pathToFile));
        } catch (IOException e) {
            System.out.println("IOE");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            e.printStackTrace();
        }

    }
}
