package com.javarush.task.task38.task3804;

public class ExceptionsFactory {
    public static Throwable getException(Enum<?> message) {
        if (message == null) {
            return new IllegalArgumentException();
        }

        String formattedMessage = message.name().replace('_', ' ');
        formattedMessage = formattedMessage.substring(0, 1).toUpperCase() + formattedMessage.substring(1).toLowerCase();

        switch (message.getClass().getSimpleName()) {
            case "ApplicationExceptionMessage":
                return new Exception(formattedMessage);
            case "DatabaseExceptionMessage":
                return new RuntimeException(formattedMessage);
            case "UserExceptionMessage":
                return new Error(formattedMessage);
            default:
                return new IllegalArgumentException();
        }
    }
}
