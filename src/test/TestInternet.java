package test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class TestInternet {
    public static void main(String[] args) {
        String urlAddress = "https://medoc.ua/code/download/e97b619bee9c3f8949fed17c1bd0a344.txt";
        String fileName = "forWriting.html";

        // Get the current working directory
        String workingDir = System.getProperty("user.dir");

        try {
            writeHTMLFromURL(urlAddress, workingDir + File.separator + fileName);
            System.out.println("HTML content successfully written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static void writeHTMLFromURL(String urlAddress, String fileName) throws IOException {
        URL url = new URL(urlAddress);
        URLConnection urlConnection = url.openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line);
            writer.newLine();
        }

        // Close resources
        reader.close();
        writer.close();
    }
}