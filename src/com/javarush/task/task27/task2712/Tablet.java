package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    /**
     * Tries to create the new order at this tablet and notifies cook and waiter
     *
     * @return user order
     */
    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            if (!order.isEmpty()) {
                ConsoleHelper.writeMessage(order.toString());
                this.setChanged();
                notifyObservers(order);
                int timeSecondsAdvertising = order.getTotalCookingTime() * 60;
                AdvertisementManager manager = new AdvertisementManager(timeSecondsAdvertising);
                manager.processVideos();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }

        return order;
    }

    @Override
    public String toString() {
//        return "Tablet{number=" + number + "}";
        return String.format("Tablet{number=%s}", number);
    }

}
