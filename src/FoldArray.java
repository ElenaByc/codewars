/*
6 kyu
Fold an array
https://www.codewars.com/kata/57ea70aa5500adfe8a00011

In this kata you have to write a method that folds
a given array of integers by the middle x-times.

Fold 1-times:
[1,2,3,4,5] -> [6,6,3]

Fold 2-times:
[1,2,3,4,5] -> [9,6]


 */


import java.util.Arrays;

public class FoldArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 1)));
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 2)));
        System.out.println(Arrays.toString(foldArray(new int[]{15}, 3)));
        System.out.println(Arrays.toString(foldArray(new int[]{-9, 9, -8, 8, 66, 23}, 1))); // 14, 75, 0

    }

    public static int[] foldArray(int[] array, int runs) {
        if (runs == 0 || array.length == 1) return array;
        int[] result;
        if (array.length % 2 == 0) {
            result = new int[array.length / 2];
        } else {
            result = new int[array.length / 2 + 1];
            result[array.length / 2] = array[array.length / 2];
        }
        for (int i = 0; i < array.length / 2; i++) {
            result[i] = array[i] + array[array.length - i - 1];
        }
        return foldArray(result, --runs);
    }
}
