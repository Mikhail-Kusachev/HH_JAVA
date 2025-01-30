package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(processEmployeeData("Иван,28,Инженер;Олег,34,HR;Денис,45,Маркетинг;Анна,30,Инженер;Борис,24,HR"));
        System.out.println(processEmployeeData("Иван,28,Инженер;Олег,34,HR;Василиса,68,Секретарша;Денис,45,Маркетинг;Анна,30,Инженер;Борис,24,HR"));
        System.out.println(processEmployeeData("Иван,28,Инженер;Олег,35,HR"));
    }

    public static String processEmployeeData(String input) {
        String result = "";
        String[] data = input.split("[,;]");
        List<Integer> ages = new ArrayList<Integer>();
        for (String s : data) {
            if (s.matches("\\d+")) {
                ages.add(Integer.parseInt(s));
            }
        }

        Collections.sort(ages);

        if (ages.size() % 2 == 0) {
            Integer ageA = ages.get(ages.size() / 2 - 1);
            Integer ageB = ages.get(ages.size() / 2);
            Double medianAge = (double) (ageB + ageA) / 2;
            result = Integer.toString((int) Math.round(medianAge));
        } else {
            result = Integer.toString(ages.get(ages.size() / 2));
        }

        return ages.getFirst() + " " + result + " " + ages.getLast();
    }
}