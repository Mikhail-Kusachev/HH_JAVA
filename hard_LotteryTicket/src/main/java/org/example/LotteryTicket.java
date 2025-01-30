package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTicket {
    public static void main(String[] args) {
        System.out.println(countDigits("13133"));
        System.out.println(countDigits(""));
        System.out.println(countDigits("99999"));
        System.out.println(countDigits("99"));
        System.out.println(countDigits("13123"));
    }

    public static String countDigits(String digits) {
        Map<Character, Integer> result = new LinkedHashMap<>();

        for (char c : digits.toCharArray()) {
            result.put(c, result.getOrDefault(c, 1) + 1);
        }

        return result.entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(","));
    }
}