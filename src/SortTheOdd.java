/*
6 kyu
Sort the odd
https://www.codewars.com/kata/578aa45ee9fd15ff4600090d/

You will be given an array of numbers.
You have to sort the odd numbers in ascending order while leaving
the even numbers at their original positions.

Examples
[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTheOdd {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[] {7, 1})));
        System.out.println(Arrays.toString(sortArray(new int[] {5, 8, 6, 3, 4})));
        System.out.println(Arrays.toString(sortArray(new int[] {9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }

    public static int[] sortArray(int[] array) {
        int n = array.length;
        int[] result = new int[n];

        List<Integer> odds = new ArrayList<>();

        for (int num : array) {
            if (num % 2 == 1) { //odd
                odds.add(num);
            }
        }

        Collections.sort(odds);

        for (int i = 0; i < n; i++) {
            if (array[i] % 2 == 0) { // even number
                result[i] = array[i];
            } else { // odd number
                result[i] = odds.get(0);
                odds.remove(0);
            }
        }

        return result;
    }
}
