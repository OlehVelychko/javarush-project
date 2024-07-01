package com.javarush.task.task39.task3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws ParseException {
        LogParser logParser = new LogParser(Paths.get("/Users/narsil/javarush/3081770/" +
                "javarush-project/src/com/javarush/task/task39/task3913/logs"));

//        System.out.println(logParser.getAllUsers());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date afterDate = simpleDateFormat.parse("11.11.2013 19:45:25");
        Date beforeDate = simpleDateFormat.parse("21.10.2025 19:45:25");

//        System.out.println(logParser.getNumberOfUsers(afterDate, beforeDate));

        /*Date result = logParser.getDateWhenUserLoggedFirstTime("Eduard Petrovich Morozko", afterDate, beforeDate);
        String formattedDate = simpleDateFormat.format(result);
        System.out.println(formattedDate);*/

//        System.out.println(logParser.execute("get date"));

    }
}