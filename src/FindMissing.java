/*
6 kyu
Find the missing term in an Arithmetic Progression
https://www.codewars.com/kata/52de553ebb55d1fca3000371g
 */
public class FindMissing {
    public static void main(String[] args) {
        int[] arr1 = {3, 5, 9, 11};
        int[] arr2 = {-74, 79, 232, 385, 691, 844, 997, 1150};
        System.out.println(findMissing(arr1));
        System.out.println();
        System.out.println(findMissing(arr2));
    }

    public static int findMissing(int[] numbers) {
        // numbers[0], numbers[0] + 1 * d, ... numbers[0] + n * d
        int n = numbers.length;
        int d = (numbers[n - 1] - numbers[0]) / n;
//        System.out.println("d = " + d);
        if (d == 0) return numbers[0];
        int num = numbers[0];

        for (int number : numbers) {
            if (number != num) {
                return num;
            }
            num += d;
        }
        return 0;
    }
}
