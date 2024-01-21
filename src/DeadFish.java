/*
6 kyu
Make the Deadfish Swim
https://www.codewars.com/kata/51e0007c1f9378fa810002a9

Write a simple parser that will parse and run Deadfish.

Deadfish has 4 commands, each 1 character long:

i increments the value (initially 0)
d decrements the value
s squares the value
o outputs the value into the return array
Invalid characters should be ignored.

DeadFish.parse("iiisdoso") = new int[] {8, 64};
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class DeadFish {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(parse("iiisdoso"))); // {8, 64}
        System.out.println(Arrays.toString(parse("iiisdosodddddiso"))); // {8, 64, 3600}
    }

    public static int[] parse(String data) {
        List<Integer> list = new ArrayList<>();
        char ch;
        int value = 0;

        for (int i = 0; i < data.length(); i++) {
            ch = data.charAt(i);
            switch (ch) {
                case 'i' -> value++;
                case 'd' -> value--;
                case 's' -> value *= value;
                case 'o' -> list.add(value);
            }

        }
        int n = list.size();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
