/*
6 kyu
Sum consecutives
https://www.codewars.com/kata/55eeddff3f64c954c2000059

You are given a list/array which contains only integers (positive and negative).
Your job is to sum only the numbers that are the same and consecutive.
The result should be one list.

Examples:

[1,4,4,4,0,4,3,3,1] # should return [1,12,0,4,6,1]
[1,1,7,7,3] # should return [2,14,3]
[-5,-5,7,7,12,0] # should return [-10,14,12,0]

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumConsecutives {
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(1, 4, 4, 4, 0, 4, 3, 3, 1);
        System.out.println(sumConsecutives(input1));    // [1,12,0,4,6,1]
        List<Integer> input2 = Arrays.asList(1, 1, 7, 7, 3);
        System.out.println(sumConsecutives(input2));    // [2,14,3]
        List<Integer> input3 = Arrays.asList(-5, -5, 7, 7, 12, 0);
        System.out.println(sumConsecutives(input3));    // [-10,14,12,0]
    }

    public static List<Integer> sumConsecutives(List<Integer> s) {
        List<Integer> result = new ArrayList<>();
        int lastNum = s.get(0);
        int sum = lastNum;
        for (int i = 1; i < s.size(); i++) {
            if (s.get(i) == lastNum) {
                sum += lastNum;
            } else {
                result.add(sum);
                lastNum = s.get(i);
                sum = lastNum;
            }
        }
        result.add(sum);

        return result;
    }
}
