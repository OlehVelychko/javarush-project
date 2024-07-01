package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        double rand = Math.random();
        distance += speed *rand;
    }

    public void print() {
        int dots = (int) Math.floor(distance);
        for (int i = 0; i < dots; i++) {
            System.out.print(".");
        }
        System.out.print(getName());
        System.out.println();
    }
}
