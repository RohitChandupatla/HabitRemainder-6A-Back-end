package com.northwest.habit_reminder.util;

public class CommonUtils {
    public static int getRandomNumber(long min, long max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
