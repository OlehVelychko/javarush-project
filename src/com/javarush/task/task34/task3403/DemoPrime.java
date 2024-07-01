package com.javarush.task.task34.task3403;

public class DemoPrime {
    public static void main(String[] args) {
        DemoPrime demoPrime = new DemoPrime();
        demoPrime.getDemo(132);
    }

    public void getDemo(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                getDemo(n / i);
                return;
            }
        }
        System.out.print(n + " ");
    }
}