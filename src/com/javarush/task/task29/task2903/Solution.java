package com.javarush.task.task29.task2903;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ThreadLocalRandom;

/* 
И еще раз рефакторинг Ӏ Java Multithreading: 9 уровень, 5 лекция
*/

public class Solution {
    public static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(getRunnable(i, concurrentMap)).start();
        }
        sleepOneSecond();
    }

    private static void sleepOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable getRunnable(final int i, final ConcurrentMap<Integer, String> concurrentMap) {
        return new Runnable() {
            @Override
            public void run() {
                final String name = "Thread #" + i;
                int randomInt = RANDOM.nextInt(20);
                String text = name + " вставил запись для " + randomInt;

                // previousEntry is null for new entries
                /* Instead of setting it to null, call concurrentMap.someMethod(randomInt, text) */
                concurrentMap.putIfAbsent(randomInt, text);

                if (concurrentMap.containsKey(randomInt)) {
                    System.out.println(name + " хочет обновить " + randomInt + ", однако уже " + concurrentMap.get(randomInt));
                } else {
                    System.out.println(text);
                }
            }
        };
    }
}
