package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private static int currentPriority = Thread.MIN_PRIORITY; // начальный приоритет

    // Блокировка для синхронизации доступа к приоритетам
    private static final Object lock = new Object();

    // Конструкторы
    public MyThread() {
        super();
        setCyclicPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setCyclicPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setCyclicPriority();
    }

    public MyThread(String name) {
        super(name);
        setCyclicPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setCyclicPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setCyclicPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setCyclicPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setCyclicPriority();
    }

    // Метод для циклической установки приоритета
    private void setCyclicPriority() {
        synchronized (lock) {
            int priority = currentPriority;
            currentPriority = (currentPriority % Thread.MAX_PRIORITY) + 1;

            if (getThreadGroup() != null) {
                // Проверка максимального приоритета группы
                priority = Math.min(priority, getThreadGroup().getMaxPriority());
            }

            setPriority(priority);
        }
    }
}
