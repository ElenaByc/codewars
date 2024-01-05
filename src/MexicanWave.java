import java.util.Arrays;

/*
6 kyu
Mexican Wave
https://www.codewars.com/kata/58f5c63f1e26ecda7e000029/

Task
In this simple Kata your task is to create a function that turns
a string into a Mexican Wave. You will be passed a string and
you must return that string in an array where an uppercase
letter is a person standing up.

Rules
 1.  The input string will always be lower case but maybe empty.

 2.  If the character in the string is whitespace then pass over
     it as if it was an empty seat
Example
wave("hello") => {"Hello", "hEllo", "heLlo", "helLo", "hellO"}

 */
public class MexicanWave {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(wave("hello world")));
    }

    public static String[] wave(String str) {
        // count result array length = number of non space characters in str
        int n = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                n++;
            }
        }
        if (n == 0) return new String[]{};
        String[] result = new String[n];

        int j = 0;
        while (str.charAt(j) == ' ') j++;

        for (int i = 0; i < n; i++) {
            chars[j] = Character.toUpperCase(chars[j]);
            result[i] = String.valueOf(chars);
            chars[j] = Character.toLowerCase(chars[j]);
            j++;
            while (j < str.length() && str.charAt(j) == ' ') j++;
        }
        return result;
    }
}
