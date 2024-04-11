/*
4 kyu
Roman Numerals Helper
https://www.codewars.com/kata/51b66044bce5799a7f000003

https://www.javatpoint.com/convert-roman-to-integer-in-java

Write two functions that convert a roman numeral to and from an integer value.

Modern Roman numerals are written by expressing each digit separately starting
with the left most digit and skipping any digit with a value of zero.
In Roman numerals:

1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC
2008 is written as 2000=MM, 8=VIII; or MMVIII
1666 uses each Roman symbol in descending order: MDCLXVI.
Input range : 1 <= n < 4000

In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").

Examples
to roman:
2000 -> "MM"
1666 -> "MDCLXVI"
  86 -> "LXXXVI"
   1 -> "I"

from roman:
"MM"      -> 2000
"MDCLXVI" -> 1666
"LXXXVI"  ->   86
"I"       ->    1
 */

public class RomanNumerals {
    public static void main(String[] args) {
        System.out.println("Roman to Integer");
        System.out.println("MM = " + romanToInt("MM"));             // 2000
        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV"));   // 1994
        System.out.println("MDCLXVI = " + romanToInt("MDCLXVI"));   // 1666
        System.out.println("LXXXVI = " + romanToInt("LXXXVI"));     // 86
        System.out.println("LVII = " + romanToInt("LVII"));         // 57
        System.out.println("I = " + romanToInt("I"));               // 1
        System.out.println();
        System.out.println("Integer to Roman");
        System.out.println("2000 = " + intToRoman(2000));           // "MM"
        System.out.println("1994 = " + intToRoman(1994));           // "MCMXCIV"
    }

    public static int romanToInt(String s) {
        char ch;
        char nextCh;
        int val;
        int n = s.length();
        int num = 0;

        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            val = charValue(ch);
            if (i + 1 < n) {
                nextCh = s.charAt(i + 1);
                if (charValue(nextCh) > val) { // for example CM = 900 = 1000 - 100
                    val = charValue(nextCh) - val;
                    i++;
                }
            }
            num += val;
        }

        return num;
    }


    public static int charValue(char ch) {
        switch (ch) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return -1;
        }
    }

    public static String intToRoman(int n) {
        int[] values = {1000, 500, 100, 50, 10, 5, 1};
        char[] chars = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        int quotient;

        for (int i = 0; i < values.length; i++) {
            quotient = n / values[i];
            if (quotient == 4) { //  for example: 450 / 100 = 4   =>   CCCC -> CD
                if (sb.length() == 0 || sb.charAt(sb.length() - 1) != chars[i - 1]) {
                    sb.append(chars[i]);
                    sb.append(chars[i - 1]);
                } else { // for example: DCCCC -> CM
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(chars[i]);
                    sb.append(chars[i - 2]);
                }
            } else {
                for (int j = 0; j < quotient; j++) {
                    sb.append(chars[i]);
                }
            }
            n %= values[i];
        }

        return sb.toString();
    }

}
