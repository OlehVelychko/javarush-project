package com.javarush.task.task27.task2704;

/* 
Модификаторы и deadlock
*/

public class Solution {
    private final String field;

    public Solution(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    public synchronized void sout(Solution solution) {
        System.out.println(Thread.currentThread().getName() + " ждёт " + solution.getField()); // my adding
        System.out.format("111:  %s: %s %n", this.field, solution.getField());
        System.out.println(); // my adding
        solution.sout2(this);
    }

    public synchronized void sout2(Solution solution) {
        System.out.println(Thread.currentThread().getName() + " ждёт " + solution.getField()); // my adding
        System.out.format("222:  %s: %s %n", this.field, solution.getField());
        System.out.println(); // my adding
        solution.sout(this);
    }

    public static void main(String[] args) {
        final Solution solution = new Solution("first");
        final Solution solution2 = new Solution("second");

        new Thread(new Runnable() {
            public void run() {
                solution.sout(solution2);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                solution2.sout(solution);
            }
        }).start();

    }
}
