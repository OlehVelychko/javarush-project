package test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started...");
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
                    System.out.println("Client connected");
                    String request = reader.readLine();

                    // Construct HTTP response
                    String statusLine = "HTTP/1.1 200 OK\r\n";
                    String contentTypeHeader = "Content-Type: text/plain\r\n";
                    String responseBody = "Hello, your request was: " + request;

                    String httpResponse = statusLine +
                            contentTypeHeader +
                            "\r\n" +
                            responseBody;

                    // Send HTTP response
                    writer.write(httpResponse);
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
