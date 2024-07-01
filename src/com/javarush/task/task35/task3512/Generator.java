package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> type;

    public Generator(Class<T> type) {
        this.type = type;
    }

    T newInstance() throws InstantiationException, IllegalAccessException {
        return type.newInstance();
    }
}
