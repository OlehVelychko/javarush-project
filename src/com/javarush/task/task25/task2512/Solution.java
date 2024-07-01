package com.javarush.task.task25.task2512;

/*
Живем своим умом
*/

import java.util.LinkedList;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        LinkedList<String> exceptions = new LinkedList<>();
        Throwable current = e;

        while (current != null) {
            exceptions.addFirst(current.getClass().getName() + ": " + current.getMessage());
            current = current.getCause();
        }

        for (String exception : exceptions) {
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    throw new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.setUncaughtExceptionHandler(solution);
        thread.start();
    }
}
