/*
6 kyu
Detect Pangram
https://www.codewars.com/kata/545cedaa9943f7fe7b000048/

A pangram is a sentence that contains every single letter of the alphabet at least once.
For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram,
because it uses the letters A-Z at least once (case is irrelevant).

Given a string, detect whether or not it is a pangram.
Return True if it is, False if not. Ignore numbers and punctuation.

 */

public class DetectPangram {
    public static void main(String[] args) {
        System.out.println(isPangram("The quick brown fox jumps over the lazy dog."));
        System.out.println(isPangram("You shall not pass!"));
    }

    public static boolean isPangram(String s) {
        s = s.toLowerCase();
        boolean[] alphabet = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' < 26 && s.charAt(i) - 'a' >= 0) {
                alphabet[s.charAt(i) - 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (!alphabet[i]) {
                return false;
            }
        }

        return true;
    }
}
