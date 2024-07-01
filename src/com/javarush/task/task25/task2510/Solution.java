package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    public Solution() {
        setUncaughtExceptionHandler(new SolutionUncaughtExceptionHandler());
    }

    public static void main(String[] args) {
        // Пример для тестирования
        Thread thread = new Solution();
        thread.start();
        throw new RuntimeException("This is a test exception");
    }

    private static class SolutionUncaughtExceptionHandler implements UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            if (e instanceof Error) {
                System.out.println("Нельзя дальше работать");
            } else if (e instanceof Exception) {
                System.out.println("Надо обработать");
            } else {
                System.out.println("Поживем - увидим");
            }
        }
    }
}
