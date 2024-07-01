package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestInternetHTTP {
    public static void main(String[] args) {
        String urlAddress = "https://medoc.ua/code/download/e97b619bee9c3f8949fed17c1bd0a344.txt";
        URL url;
        HttpURLConnection connection = null;
        InputStreamReader inputStreamReader;
        BufferedReader reader;
        try {
            url = new URL(urlAddress);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                inputStreamReader = new InputStreamReader(connection.getInputStream());
                reader = new BufferedReader(inputStreamReader);
                String line;

                System.out.println(connection.getContentType());
                /*while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }*/
            } else {
                System.out.printf("An error occurs %s", connection.getResponseCode());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}