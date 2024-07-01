package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        try (ServerSocket server = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server is running...");
            while (true) {
                new Handler(server.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection value : connectionMap.values()) {
            try {
                value.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("The message couldn't be send");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message receive;
            do {
                connection.send(new Message(MessageType.NAME_REQUEST, "Enter your name"));
                receive = connection.receive();
                ConsoleHelper.writeMessage("Message from " + socket.getRemoteSocketAddress() + ". Message type doesn't match protocol.");
            } while (!receive.getType().equals(MessageType.USER_NAME) ||
                    receive.getData() == null ||
                    "".equals(receive.getData()) ||
                    connectionMap.containsKey(receive.getData()));
            connectionMap.put(receive.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED, "Your name is accepted"));
            return receive.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            connectionMap.forEach((key, value) -> {
                if (!key.equals(userName)) {
                    try {
                        connection.send(new Message(MessageType.USER_ADDED, key));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();

                if (message.getType() == MessageType.TEXT) {
                    String data = message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + data));
                } else {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("The connection with " + socket.getRemoteSocketAddress() + " is established.");
            try (Connection connection = new Connection(socket))
            {
                String newUser = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUser));
                notifyUsers(connection, newUser);
                serverMainLoop(connection, newUser);

                connectionMap.remove(newUser);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUser));
                ConsoleHelper.writeMessage("The connection with remote address is closed.");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating with remote address.");
            }
        }
    }
}