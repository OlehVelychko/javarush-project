package test;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class TestMail {
    public static void main(String[] args) {
        // Установка параметров для подключения к серверу
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // Укажи свои учетные данные для отправки письма
        final String username = "alligator3105@gmail.com";
        final String password = "vtht nqfo yebn hhyb";

        // Создание сессии
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Создание сообщения
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("alligator3105@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("stalone@gmail.com"));
            message.setSubject("тестовое письмо!");
            message.setSentDate(new Date());
            message.setText("Asta la vista, baby!");

            // Подключение и отправка сообщения
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", 465, username, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();

            System.out.println("Письмо отправлено успешно!");
        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке письма: " + e.getMessage());
        }
    }
}
