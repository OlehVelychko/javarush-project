package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp2 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server2 started...");
            while (true) {
                try (Socket socket = server.accept();
                     BufferedReader reader = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(
                             new OutputStreamWriter(socket.getOutputStream())))
                {
                    System.out.println("Client connected");
                    String request = reader.readLine();
                    String response = String.format("Hello, your request = %s", request);
                    Thread.sleep(500);
                    System.out.println(response);
                    writer.write(response);
                    writer.newLine();
                    writer.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}