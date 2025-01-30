package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SignificantTemperatureDrop {
    public static void main(String[] args) {
        System.out.println(findDrop("0 5 2 7 4 1"));
        System.out.println(findDrop("10 8 6 4 2 0 -2 -4"));
        System.out.println(findDrop("10"));
        System.out.println(findDrop("10 5 0 -5 -10 -15 -20"));
    }

    public static String findDrop(String input) {
        String[] words = input.split(" ");
        List<Integer> nums = new ArrayList<Integer>();
        List<Integer> dropIndex = new ArrayList<>();

        for (String word : words) {
            try { nums.add(Integer.parseInt(word));}
            catch (NumberFormatException e) {}
        }

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i-1) - nums.get(i) >= 3) {
                dropIndex.add(i);
            }
        }
        if (dropIndex.size() == 0) { return "Нет"; }

        return dropIndex.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}