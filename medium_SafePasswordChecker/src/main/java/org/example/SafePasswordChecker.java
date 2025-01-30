package org.example;

public class SafePasswordChecker {
    private static final String specialChars = "!@#$%^&*()_+";

    public static void main(String[] args) {
        System.out.println(findSafePassword("Password1 Pass@word 12345 pass!word Passw@rd Password1!"));
        System.out.println(findSafePassword("Password1 Pass@word 12345 pass!word"));
        System.out.println(findSafePassword("yB3Fn9e^gGV% Ps3JQE(E-#*& YH^U#PlAiE&8"));
    }

    public static String findSafePassword(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Не найдено";
        }
        String[] password = input.split(" ");
        StringBuilder result = new StringBuilder();
        for (String s : password) {
            if (checkOnePassword(s)) {
                result.append(s).append(" ");
            }
        }
        return result.isEmpty() ? "Не найдено" : result.toString().trim();
    }

    public static boolean checkOnePassword(String input) {
        if (input == null || input.length() < 8) {
            return false;
        }
        boolean hasUpperLetter = false;
        boolean hasLowerLetter = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                hasUpperLetter = true;
            }
            if (Character.isLowerCase(currentChar)) {
                hasLowerLetter = true;
            }
            if (Character.isDigit(currentChar)) {
                hasNumber = true;
            }
            if (specialChars.indexOf(currentChar) != -1) {
                hasSpecialChar = true;
            }
            if (hasUpperLetter && hasLowerLetter && hasNumber && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }
}