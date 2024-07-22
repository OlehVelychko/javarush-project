package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    /**
     * Calculates the total order cooking time
     *
     * @return total cooking time
     */
    public int getTotalCookingTime() {
        int cookingTime = 0;
        for (Dish dish : dishes) {
            cookingTime += dish.getDuration();
        }
        return cookingTime;
    }

    @Override
    public String toString() {
        return String.format("Your order: %s of %s, cooking time %dmin",
                dishes, tablet.toString(), getTotalCookingTime());
    }

    /**
     * Checks if there are elements in the list
     *
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return dishes.isEmpty();
    }
}
