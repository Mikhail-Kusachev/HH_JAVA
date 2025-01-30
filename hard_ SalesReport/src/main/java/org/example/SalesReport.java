package org.example;

import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.util.TreeMap;

public class SalesReport {
    public static void main(String[] args) {
        System.out.print(generateReport("2023-02-05:Шляпа:4;2023-03-20:Кольцо:7;2023-04-25:Браслет:6;2023-04-26:Браслет:12"));
        System.out.print(generateReport("2023-01-15:Книга:10;2023-04-20:Флешка:5;2023-07-05:Наушники:8"));
        System.out.print(generateReport("2023-03-05:Коврик:6;2023-04-25:Бинокль:10;2023-05-10:Компас:8;2023-03-05:Коврик:6;2023-04-25:Бинокль:10;2023-05-10:Компас:8"));
    }

    public static String generateReport(String salesData) {
        TreeMap<String, Integer>[] report = new TreeMap[4];
        for (int i = 0; i < report.length; i++) {
            report[i] = new TreeMap<>();
        }

        String[] record = salesData.split(";");
        for (String s : record) {
            String[] field = s.split(":");
            int quarter = LocalDate.parse(field[0]).get(IsoFields.QUARTER_OF_YEAR);
            int value = report[quarter - 1].getOrDefault(field[1], 0) + Integer.parseInt(field[2]);
            report[quarter - 1].put(field[1], value);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < report.length; i++) {
            if (!report[i].isEmpty()) {
                builder.append("Q" + (i + 1) + ":\n");
                for (String s : report[i].keySet()) {
                    builder.append("- " + s + ": " + report[i].get(s) + "\n");
                }
            }
        }

        return builder.toString();
    }
}