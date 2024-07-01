package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private final Thread targetThread;

    public LoggingStateThread(Thread targetThread) {
        this.targetThread = targetThread;
    }

    @Override
    public void run() {
        State currentState = targetThread.getState();
        System.out.println(currentState);

        while (currentState != State.TERMINATED) {
            State newState = targetThread.getState();
            if (newState != currentState) {
                System.out.println(newState);
                currentState = newState;
            }
        }
    }
}
