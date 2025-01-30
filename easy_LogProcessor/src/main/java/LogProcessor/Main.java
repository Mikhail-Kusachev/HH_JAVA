package LogProcessor;

public class Main {

    public static void main(String[] args) {
        System.out.println(processLine("Hello World 123"));
        System.out.println(processLine("12345678"));
        System.out.println(processLine("H 1 E 2 L 3 L 4 O 5"));
    }

    public static String processLine(String line) {
        String result = "LOG";
        char tempChar;
        for (int i = 0; i < line.length(); i++) {
            tempChar = line.charAt(line.length() - i - 1);
            if (tempChar == ' ') {
                result = result + "_";
                continue;
            }
            if (tempChar > '9' || tempChar < '0') {
                result = result + line.charAt(line.length() - i - 1);
            }
        }
        return result;
    }

}