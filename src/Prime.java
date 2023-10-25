/*
6 kyu
Is a number prime?
https://www.codewars.com/kata/5262119038c0985a5b00029f

Define a function that takes an integer argument and returns a logical value true or false
depending on if the integer is a prime.


Per Wikipedia, a prime number ( or a prime ) is a natural number greater than 1
that has no positive divisors other than 1 and itself.
 *

Requirements
You can assume you will be given an integer input.
You can not assume that the integer will be only positive.
You may be given negative numbers as well ( or 0 ).
NOTE on performance: There are no fancy optimizations required,
but still the most trivial solutions might time out.
Numbers go up to 2^31 ( or similar, depending on language ).
Looping all the way up to n, or n/2, will be too slow.
Example
is_prime(1)   false
is_prime(2)   true
is_prime(-1)  false
*/

import java.util.HashMap;

public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(0));
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(73));
        System.out.println(isPrime(75));
        System.out.println(isPrime(-1));
        System.out.println();
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
        System.out.println(isPrime(7));
        System.out.println(isPrime(41));
        System.out.println(isPrime(5099));
        System.out.println();
        System.out.println(isPrime(4));
        System.out.println(isPrime(6));
        System.out.println(isPrime(8));
        System.out.println(isPrime(9));
        System.out.println(isPrime(45));
        System.out.println(isPrime(-5));
        System.out.println(isPrime(-8));
        System.out.println(isPrime(-41));

        HashMap<Integer, Integer> hm = new HashMap<>();
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        if (num == 2) {
            return true;
        }
        if(num % 2 == 0) return false;

        for (int i = 3; i < sqrt + 1; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
