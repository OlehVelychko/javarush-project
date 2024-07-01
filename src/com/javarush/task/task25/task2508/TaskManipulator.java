package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread currentThread;

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void start(String threadName) {
        currentThread = new Thread(this);
        currentThread.setName(threadName);
        currentThread.start();
    }

    @Override
    public void stop() {
        if (currentThread != null) {
            currentThread.interrupt();
        }
    }
}
