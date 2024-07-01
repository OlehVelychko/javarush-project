package com.javarush.task.task26.task2613;

public enum Operation {
    LOGIN,
    INFO,
    DEPOSIT,
    WITHDRAW,
    EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i) {
        if (i == null || i < 1 || i > 4) {
            throw new IllegalArgumentException("Invalid ordinal number " + i);
        }
        if (i == 0) {
            throw new IllegalArgumentException("Operation LOGIN is not allowed");
        }
        return values()[i - 1];
    }
}
