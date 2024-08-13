package com.javarush.task.task30.task3004;

import java.util.concurrent.RecursiveTask;

public class BinaryRepresentationTask extends RecursiveTask<String> {
    private final int x;

    public BinaryRepresentationTask(int x) {
        this.x = x;
    }

    @Override
    protected String compute() {
        int a = x % 2;
        int b = x / 2;

        String result = String.valueOf(a);

        if (b > 0) {
            BinaryRepresentationTask subTask = new BinaryRepresentationTask(b);
            subTask.fork(); // Fork the subtask
            return subTask.join() + result; // Join the result and append current digit
        }

        return result;
    }
}
