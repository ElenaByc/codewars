import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
6 kyu
Pascal's Triangle
https://www.codewars.com/kata/5226eb40316b56c8d500030f

Task
Write a function that, given a depth n, returns n top rows of Pascal's Triangle
flattened into a one-dimensional list/array.

Example:
n = 1: [1]
n = 2: [1,  1, 1]
n = 4: [1,  1, 1,  1, 2, 1,  1, 3, 3, 1]

 */
public class PascalsTriangle {
    public static void main(String[] args) {
        System.out.println("result: " + Arrays.toString(generate(4)));
        System.out.println("result: " + Arrays.toString(generate(10)));
    }

    public static long[] generate(int level) {
        List<Long> list = new ArrayList<>();
        long[] row = new long[level];
        long[] prevRow = new long[level];
        int n = 1;
        while (n <= level) {
            row[0] = 1;
            row[n - 1] = 1;
            for (int i = 1; i < n - 1; i++) {
                row[i] = prevRow[i - 1] + prevRow[i];
            }
            System.out.println(Arrays.toString(row));
            for (int i = 0; i < n; i++) {
                list.add(row[i]);
                prevRow[i] = row[i];
                row[i] = 0;
            }
            n++;
        }
        long[] result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
