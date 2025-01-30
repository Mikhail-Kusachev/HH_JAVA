package org.example;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(checkPalindrome("1234567890asdfghjkl"));
        System.out.println(checkPalindrome("тУт как Тут"));
    }

    public static String checkPalindrome(String input) {
        input = input.toLowerCase();
        input = input.replaceAll(" ", "");
        String reverse = "";
        for (int i = 0; i < input.length(); i++) {
            reverse = reverse + input.charAt(input.length() - 1 - i);
        }
        return input.equals(reverse) ? "Палиндром" : "Не палиндром";
    }
}