/*
6 kyu
Simple Encryption #1 - Alternating Split
https://www.codewars.com/kata/57814d79a56c88e3e0000786

 */

public class SimpleEncryption1 {
    public static void main(String[] args) {
        System.out.println(encrypt("012345", 1)); //  "135024"
        System.out.println(encrypt("012345", 2)); //  "135024"  ->  "304152"
        System.out.println(encrypt("012345", 3)); //  "135024"  ->  "304152"  ->  "012345"
        System.out.println(encrypt("01234", 1)); // "13024"
        System.out.println(encrypt("01234", 2)); // "13024"  ->  "32104"
        System.out.println(encrypt("01234", 3)); // "13024"  ->  "32104"  ->  "20314"

        System.out.println();
        System.out.println(decrypt("135024", 1)); // "012345"
        System.out.println(decrypt("304152", 2)); // "012345"
        System.out.println(decrypt("20314", 3)); // "01234"
    }

    public static String encrypt(final String text, final int n) {
        if (text.length() == 0 || n <= 0) {
            return text;
        }
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            if (i % 2 == 1) {
                odd.append(text.charAt(i));
            } else {
                even.append(text.charAt(i));
            }
        }

        return encrypt(odd + even.toString(), n - 1);
    }

    public static String decrypt(final String encryptedText, final int n) {
        if (encryptedText.length() == 0 || n <= 0) {
            return encryptedText;
        }
        int len = encryptedText.length();
        StringBuilder text = new StringBuilder();

        for (int i = 0; i < len / 2; i++) {
            text.append(encryptedText.charAt(len / 2 + i));
            text.append(encryptedText.charAt(i));
        }

        if (len % 2 == 1) {
            text.append(encryptedText.charAt(len - 1));
        }

        return decrypt(text.toString(), n - 1);
    }

}
