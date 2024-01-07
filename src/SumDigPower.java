/*
6 kyu
Take a Number And Sum Its Digits Raised To The Consecutive Powers And ....¡Eureka!!
https://www.codewars.com/kata/5626b561280a42ecc50000d1


89=8^1 + 9^2
135=1^1 + 3^2 + 5^3

Task
We need a function to collect these numbers, that may receive two integers [a,b]
(inclusive) and outputs a list of the sorted numbers in the range that fulfills
the property described above.

Examples
Let's see some cases (input -> output):

1, 10  --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]

If there are no numbers of this kind in the range [a,b] the function should output an empty list.
90, 100 --> []

 */

import java.util.ArrayList;
import java.util.List;

public class SumDigPower {
    public static void main(String[] args) {
        System.out.println(sumDigPow(1, 10));
        System.out.println(sumDigPow(1, 100));
        System.out.println(sumDigPow(1, 200));
        System.out.println(sumDigPow(90, 100));
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> result = new ArrayList<>();
        for (long i = a; i <= b; i++) {
            if (isValid(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isValid(long num) {
        if (num < 10) {
            return true;
        }
        int pow = Long.toString(num).length();
        int sum = 0;
        long n = num;
        while (n > 0) {
            sum += Math.pow(n % 10, pow);
            pow--;
            n /= 10;
        }
        return sum == num;
    }
}
