/*
6 kyu
Reverse or rotate?
https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991

The input is a string str of digits. Cut the string into chunks
(a chunk here is a substring of the initial string) of size sz
(ignore the last chunk if its size is less than sz).

If a chunk represents an integer such as the sum of the cubes of its digits
is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position.
Put together these modified chunks and return the result as a string.

If
sz is <= 0 or if str is empty return ""
sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".

Examples:
revrot("123456987654", 6) --> "234561876549"
revrot("123456987653", 6) --> "234561356789"
revrot("66443875", 4) --> "44668753"
revrot("66443875", 8) --> "64438756"
revrot("664438769", 8) --> "67834466"
revrot("123456779", 8) --> "23456771"
revrot("", 8) --> ""
revrot("123456779", 0) --> ""
revrot("563000655734469485", 4) --> "0365065073456944"
Example of a string rotated to the left by one position:
s = "123456" gives "234561".

 */

public class RevRot {
    public static void main(String[] args) {
        System.out.println(revRot("123456987654", 6));          // "234561876549"
        System.out.println(revRot("563000655734469485", 4));    //"0365065073456944"
    }

    public static String revRot(String str, int sz) {
        if (sz <= 0) return "";
        int n = str.length();
        if (n == 0) return "";
        if (sz > n) return "";

        StringBuilder sb = new StringBuilder();
        String s;
        int sum;
        int digit;

        for (int i = 0; i <= n - sz; i += sz) {
            s = str.substring(i, i + sz);
            System.out.println("s = " + s);
            sum = 0;
            for (int j = 0; j < sz; j++) {
                digit = s.charAt(j) - '0';
                sum += digit * digit * digit;
            }
            if (sum % 2 == 0) {
                sb.append(reverse(s));
            } else {
                sb.append(rotate(s));
            }
        }

        return sb.toString();
    }

    public static String reverse (String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
    public static String rotate(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
