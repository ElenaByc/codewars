/*
6 kyu
Longest Palindrome
https://www.codewars.com/kata/54bb6f887e5a80180900046b/

Find the length of the longest substring in
the given string s that is the same in reverse.
As an example, if the input was “I like racecars that go fast”,
the substring (racecar) length would be 7.

If the length of the input string is 0, the return value must be 0.

Example:
"a" -> 1
"aab" -> 2
"abcde" -> 1
"zzbaabcd" -> 4
"" -> 0


 */

public class Palindromes {
    public static void main(String[] args) {
//        System.out.println(longestPalindrome(""));          // 0
//        System.out.println(longestPalindrome("a"));         // 1
//        System.out.println(longestPalindrome("aab"));       // 2
//        System.out.println(longestPalindrome("abcde"));     // 1
        System.out.println(longestPalindrome("zzbaabcd"));  // 4
    }

    public static int longestPalindrome(final String s) {
        int n = s.length();
        int len = n;
        if (n < 2) {
            return n;
        }
        if (isPalindrome(s)) {
            return n;
        }
        len--;
        while (len > 1) {
            for (int i = 0; i < n - len + 1; i++) {
//                System.out.println("i = " + i);
//                System.out.println(s.substring(i, i + len));
                if (isPalindrome(s.substring(i, i + len))) {
                    return len;
                }
            }
            len--;
        }
        return 1;
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
