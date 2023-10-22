/*
6 kyu
Build a pile of Cubes
https://www.codewars.com/kata/5592e3bd57b64d00f3000047

Your task is to construct a building which will be a pile of n cubes.
The cube at the bottom will have a volume of n^3, the cube above will
have volume of (n - 1) ^ 3,
and so on until the top which will have a volume of 1 ^ 3 = 1

You are given the total volume m of the building.
Being given m can you find the number n of cubes you will have to build?

The parameter of the function findNb (find_nb, find-nb, findNb, ...)
will be an integer m and you have to return the integer n such as
n ^ 3 + (n - 1) ^ 3 + (n - 2) ^ 3 + ... + 1 = m
if such a n exists or -1 if there is no such n.

Examples:
findNb(1071225) --> 45
findNb(91716553919377) --> -1
 */

public class PileOfCubes {
    public static void main(String[] args) {
        System.out.println(findNb(1071225));            // 45
        System.out.println(findNb(24723578342962L));    // -1
        System.out.println(findNb(135440716410000L));   // 4824
        System.out.println(findNb(40539911473216L));    // 3568
        System.out.println(findNb(2304422822859502500L)); // 55100
        System.out.println(findNb(1975226887817088409L)); // 53017
    }

    public static long findNb(long m) {
        long n = 1;
        long sum = 1;
        while (sum < m) {
//            System.out.println("sum = " + sum + " n = " + n);
            n++;
            sum += n * n * n;
        }
//        System.out.println("sum = " + sum + " n = " + n);
        if (sum > m) return -1;
        return n;
    }
}
