package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);

        System.out.println(getQuery(map));

    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                if (!isFirst) {
                    sb.append(" and ");
                } else {
                    isFirst = false;
                }
                sb.append(formatKeyValuePair(entry.getKey(), entry.getValue()));
            }
        }
        return sb.toString();
    }

    private static String formatKeyValuePair(String key, String value) {
        return key + " = '" + value + "'";
    }

}
