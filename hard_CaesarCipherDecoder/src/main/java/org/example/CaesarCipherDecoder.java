package org.example;

public class CaesarCipherDecoder {
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static void main(String[] args) {
        CaesarCipherDecoder d = new CaesarCipherDecoder();
        System.out.println(d.decode("дщх ёзтхсх счжшфхл", 7));
        System.out.println(d.decode("бвгдеё", 1));
        System.out.println(d.decode("ьщцшбп ьмпэуэ йыхщ шк шплп", 11));
    }

    private String decode(String encryptedText, int shift) {
        String result = "";
        int length = ALPHABET.length();
        for (char ch : encryptedText.toCharArray()) {
            int index = ALPHABET.indexOf(ch);
            result += index == -1 ? ch : ALPHABET.charAt((length + index - shift % length) % length);
        }
        return result;
    }
}