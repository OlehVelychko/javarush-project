package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        /*ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());*/

        for (int i = 0; i < 20; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    /**
     * The method creates password and transform this in byte sequence
     *
      * @return
     */
    public static ByteArrayOutputStream getPassword() {
        String stringPassword = createPassword();

        if (checkPassword(stringPassword)) {
            getPassword();
        }

        ByteArrayOutputStream byteArrayOutputStream = convertStringToByteArrayOutputStream(stringPassword);

        return byteArrayOutputStream;
    }

    /**
     * The method generates a random password includes digits and Latin letters
     *
     * @return String
     */
    /*public static String createPassword() {
        int lengthPassword = 8;

        boolean hasRandomLowerCase = false;
        boolean hasRandomUpperCase = false;
        boolean hasRandomDigit = false;

        StringBuilder builderPassword = new StringBuilder();

        Random random = new Random();

        while (!hasRandomLowerCase && !hasRandomUpperCase && !hasRandomDigit) {
            builderPassword.setLength(0);

            for (int i = 0; i < lengthPassword; i++) {
                if (random.nextBoolean()) {
                    int randomDigit = random.nextInt(10);
                    builderPassword.append(randomDigit);
                    hasRandomDigit = true;
                } else {
                    char randomChar = getRandomLatinLetter();
                    builderPassword.append(randomChar);
                    if (Character.isLowerCase(randomChar)) {
                        hasRandomLowerCase = true;
                    } else {
                        hasRandomUpperCase = true;
                    }
                }
            }
        }

        return builderPassword.toString();
    }*/
    public static String createPassword() {
        int lengthPassword = 8;
        StringBuilder builderPassword = new StringBuilder();
        Random random = new Random();
        builderPassword.setLength(0);

        for (int i = 0; i < lengthPassword; i++) {
            if (random.nextBoolean()) {
                int randomDigit = random.nextInt(10);
                builderPassword.append(randomDigit);
            } else {
                char randomChar = getRandomLatinLetter();
                builderPassword.append(randomChar);
            }
        }

        return builderPassword.toString();
    }

    /**
     *    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     * @param password String
     *
     * @return boolean
     */
    public static boolean checkPassword(String password) {
        boolean hasRandomLowerCase = false;
        boolean hasRandomUpperCase = false;
        boolean hasRandomDigit = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasRandomLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasRandomUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasRandomDigit = true;
            }
        }

        if (hasRandomLowerCase && hasRandomUpperCase && hasRandomDigit) {
            return true;
        }

        return false;
    }

    /**
     * The method generates a random letter of the Latin alphabet in different case
     *
     * @return char
     */
    public static char getRandomLatinLetter() {
        Random random = new Random();
        int randomNumber = random.nextInt(26);
        char randomLetter = (char) ('a' + randomNumber);

        if (random.nextBoolean()) {
            randomLetter = (char) ('A' + randomNumber);
        }

        return randomLetter;
    }

    /**
     * The method converts String in ByteArrayOutputStream
     *
     * @param input String
     * @return byteArrayOutputStream
     */
    public static ByteArrayOutputStream convertStringToByteArrayOutputStream(String input) {
        byte[] byteArray = input.getBytes(StandardCharsets.UTF_8);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(byteArray, 0, byteArray.length);

        return byteArrayOutputStream;
    }
}
