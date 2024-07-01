package com.javarush.task.task40.task4006;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* 
Отправка GET-запроса через сокет
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://javarush.ru/social.html"));
    }

    public static void getSite(URL url) {
        String host = url.getHost();
        int port = 80;
        String path = url.getPath();
        String query = url.getQuery();

        try (Socket socket = new Socket(host, port);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter out = new PrintWriter(outputStream, true);
             InputStream inputStream = socket.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String request = "GET " + (path.isEmpty() ? "/" : path);
            if (query != null && !query.isEmpty()) {
                request += "?" + URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
            }
            request += " HTTP/1.1\r\n";
            request += "Host: " + host + "\r\n";
            request += "Connection: close\r\n";
            request += "\r\n";

            out.println(request);
            out.flush();

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}