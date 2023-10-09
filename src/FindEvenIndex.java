/*
6 kyu
Equal Sides Of An Array
https://www.codewars.com/kata/5679aa472b8f57fb8c000047

You are going to be given an array of integers.
Your job is to take that array and find an index N
where the sum of the integers to the left of N is equal
to the sum of the integers to the right of N.
If there is no index that would make this happen, return -1.

For example:
Let's say you are given the array {1,2,3,4,3,2,1}:
Your function will return the index 3, because at the 3rd position of the array,
the sum of left side of the index ({1,2,3})
and the sum of the right side of the index ({3,2,1}) both equal 6.
 */

public class FindEvenIndex {
    public static void main(String[] args) {
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 3, 2, 1}));                      // 3
        System.out.println(findEvenIndex(new int[]{1, 100, 50, -51, 1, 1}));                    // 1
        System.out.println(findEvenIndex(new int[]{1, 2, 3, 4, 5, 6}));                         // -1
        System.out.println(findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));               // 3
        System.out.println(findEvenIndex(new int[]{-8505, -5130, 1926, -9026}));                // -1
        System.out.println(findEvenIndex(new int[]{2824, 1774, -1490, -9084, -9696, 23094}));   //1
        System.out.println(findEvenIndex(new int[]{4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));   //6
    }

    private static int findEvenIndex(int[] arr) {
        int total = 0;
        for (int num: arr) {
            total += num;
        }
        int leftSum = 0;
        int rightSum = total;

        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
        }
        return -1;
    }

}
