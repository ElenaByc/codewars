import java.util.HashMap;
import java.util.Map;

/*
6 kyu
Roman Numerals Encoder
https://www.codewars.com/kata/51b62bf6a9c58071c600001b

Create a function taking a positive integer between 1 and 3999 (both included)
as its parameter and returning a string containing the Roman Numeral representation of that integer.

Modern Roman numerals are written by expressing each digit separately starting
with the left most digit and skipping any digit with a value of zero.
In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC.
2008 is written as 2000=MM, 8=VIII; or MMVIII.
1666 uses each Roman symbol in descending order: MDCLXVI.

Example:
conversion(1000); //should return "M"

Help:

Symbol    Value
I          1
V          5
X          10
L          50
C          100
D          500
M          1,000
Remember that there can't be more than 3 identical symbols in a row.

More about roman numerals - http://en.wikipedia.org/wiki/Roman_numerals

 */
public class RomanNumeralsEncoder {
    public static void main(String[] args) {
        System.out.println(conversion(9)); // IX
        System.out.println(conversion(100)); // C
        System.out.println(conversion(1000)); // M
        System.out.println(conversion(1990)); // MCMXC
        System.out.println(conversion(2008)); // MMVIII
        System.out.println(conversion(1666)); // MDCLXVI

        // DCCCC -> 900 = CM
        // LXXXX -> 90 = XC
        // VIIII -> 9 = IX
        // CCCC  -> 400 = CD
        // XXXX  -> 40 = XL
        // IIII  -> 4 = IV

    }

    private static String conversion(int n) {
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        String[] letters = {"M", "D", "C", "L", "X", "V", "I"};
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (n / values[i] == 4) {
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != letters[i - 1].charAt(0)) {
                    sb.append(letters[i]);
                    sb.append(letters[i - 1]);
                } else {
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(letters[i]);
                    sb.append(letters[i - 2]);
                }
            } else {
                sb.append(letters[i].repeat(Math.max(0, n / values[i])));
            }
            n %= values[i];
        }

        return sb.toString();
    }
}
