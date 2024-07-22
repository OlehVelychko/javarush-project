package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    /**
     * Creates all dish names string from enumeration
     *
     * @return string dish names
     */
    public static String allDishesToString() {
        StringBuilder dishes = new StringBuilder();
        for (Dish dish : Dish.values()) {
            dishes.append(dish + ", ");
        }

        return dishes.length() > 0 ?  dishes.substring(0, dishes.length() - 2) : "";
    }
}
