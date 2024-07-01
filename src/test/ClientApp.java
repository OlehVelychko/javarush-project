package test;

import java.io.*;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8080);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            writer.write("Hi, I'm client!");
            writer.newLine();
            writer.flush();
            String response = reader.readLine();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
