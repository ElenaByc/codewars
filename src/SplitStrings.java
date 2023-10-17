/*
6 kyu
Split Strings
https://www.codewars.com/kata/515de9ae9dcfc28eb6000001

Complete the solution so that it splits the string into pairs of two characters.
If the string contains an odd number of characters then it should replace
the missing second character of the final pair with an underscore ('_').

Examples:

'abc' =>  ['ab', 'c_']
'abcdef' => ['ab', 'cd', 'ef']

 */

import java.util.Arrays;

public class SplitStrings {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(splitString("abc")));
        System.out.println(Arrays.toString(splitString("abcdef")));
    }

    public static String[] splitString(String s) {
        int n = s.length();
        String[] result;
        if (n % 2 == 0) {
            result = new String[n / 2];
        } else {
            result = new String[n / 2 + 1];
        }

        int j = 0;
        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n) {
                result[j] = s.substring(i, i + 2);
            } else {
                result[j] = s.charAt(i) + "_";
            }
            j++;
        }

        return result;
    }

}
