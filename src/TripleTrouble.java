/*
6 kyu
Triple trouble
https://www.codewars.com/kata/55d5434f269c0c3f1b000058

Write a function

TripleDouble(long num1, long num2)
which takes numbers num1 and num2 and returns 1
if there is a straight triple of a number at any place in num1
and also a straight double of the same number in num2.

If this isn't the case, return 0

Examples
TripleDouble(451999277, 41177722899) == 1 // num1 has straight triple 999s and
                                          // num2 has straight double 99s

TripleDouble(1222345, 12345) == 0 // num1 has straight triple 2s but num2 has only a single 2

TripleDouble(12345, 12345) == 0

TripleDouble(666789, 12345667) == 1
 */

public class TripleTrouble {
    public static void main(String[] args) {
        System.out.println(tripleDouble(451999277L, 41177722899L)); // 1
        System.out.println(tripleDouble(666789L, 12345667L));       // 1
        System.out.println(tripleDouble(1222345L, 12345L));         // 0
        System.out.println(tripleDouble(12345L, 12345L));           // 0
        System.out.println(tripleDouble(451999277L, 411777228L));   // 0
        System.out.println(tripleDouble(41112L, 122L));             // 0
    }

    public static int tripleDouble(long num1, long num2) {
        String str1 = Long.toString(num1);
        if (str1.length() < 3) {
            return 0;
        }
        String str2 = Long.toString(num2);
        if (str2.length() < 2) {
            return 0;
        }
        String str;
        for (int i = 0; i < 10; i++) {
            str = (String.valueOf(i)).repeat(3);
            if (str1.contains(str)) {
                str = str.substring(0, 2);
                if (str2.contains(str)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
