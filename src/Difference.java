/*
6 kyu
Difference of 2
https://www.codewars.com/kata/5340298112fa30e786000688

The objective is to return all pairs of integers from a given
array of integers that have a difference of 2.

The result array should be sorted in ascending order of values.

Assume there are no duplicate integers in the array.
The order of the integers in the input array should not matter.

Examples
[1, 2, 3, 4]  should return [[1, 3], [2, 4]]
[4, 1, 2, 3]  should also return [[1, 3], [2, 4]]
[1, 23, 3, 4, 7] should return [[1, 3]]
[4, 3, 1, 5, 6] should return [[1, 3], [3, 5], [4, 6]]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Difference {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(twosDifference(new int[]{1, 2, 3, 4}))); // {{1, 3}, {2, 4}}
        System.out.println(Arrays.deepToString(twosDifference(new int[]{1, 3, 4, 6}))); // {{1, 3}, {4, 6}}
    }

    public static int[][] twosDifference(int[] array) {
        int n = array.length;
        Arrays.sort(array);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] - array[i] == 2) {
                    list.add(array[i]);
                    break;
                } else if (array[j] - array[i] > 2) {
                    break;
                }
            }
        }
        n = list.size();
        int[][] result = new int[n][2];

        for (int i = 0; i < n; i++) {
            result[i] = new int[]{list.get(i), list.get(i) + 2};
        }

        return result;
    }
}
