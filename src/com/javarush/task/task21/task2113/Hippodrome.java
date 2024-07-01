package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Rita", 3, 0));
        horses.add(new Horse("Alice", 3, 0));
        horses.add(new Horse("Eiliin", 3, 0));
        game = new Hippodrome(horses);
        for (int race = 0; race < 15; race++) { // Run the race 10 times
            game.run();
            System.out.println("End of race " + (race + 1));
        }

        game.printWinner();
    }

    public void run() {
        move(); // Move the horses
        print(); // Print the horses' positions
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        return getHorses().stream()
                .max(Comparator.comparing(Horse::getDistance)).get();
    }

    public void printWinner() {
        System.out.printf("Winner is %s!", getWinner().getName());
    }
}
