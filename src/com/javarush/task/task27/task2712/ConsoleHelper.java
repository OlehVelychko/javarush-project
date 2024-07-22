package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleHelper {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Prints the message from the passed string
     *
     * @Params String message
     */
    public static void writeMessage(String message) {
        System.out.println(message);
    }

    /**
     * Reads the user inputted string line
     *
     * @return user inputted string line
     *
     * @throws IOException
     */
    public static String readString() throws IOException {
        return reader.readLine().trim();
    }

    /**
     * Offers the user a choice of dishes. Validates the user inputted string line and forms an order
     *
     * @return user order
     *
     * @throws IOException
     */
    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> order = new ArrayList<>();
        writeMessage("Пожалуйста, выберете блюдо из перечня:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда. Введите 'exit' для завершения заказа.");

        List<String> dishNames = Arrays.stream(Dish.values())
                .map(Dish::name)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        while (true) {
            String choice = readString();
            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            if (dishNames.contains(choice.toLowerCase())) {
                Dish dish = Dish.valueOf(choice.toUpperCase());
                order.add(dish);
                writeMessage(dish + " добавлено в заказ");
            } else {
                writeMessage("Такого блюда нет. Пожалуйста, выберите из списка.");
            }
        }

        return order;
    }
}
