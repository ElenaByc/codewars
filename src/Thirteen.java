/*
6 kyu
A Rule of Divisibility by 13
https://www.codewars.com/kata/564057bc348c7200bd0000ff

When you divide the successive powers of 10 by 13 you get
the following remainders of the integer divisions:
1, 10, 9, 12, 3, 4

Multiply:
the right most digit of the number with the left most number in the sequence shown above,
the second right most digit with the second left most digit of the number in the sequence.
The cycle goes on, and you sum all these products.
Repeat this process until the sequence of sums is stationary.

Task:
Call thirt the function which processes this sequence of operations on an integer n (>=0).
thirt will return the stationary number.

thirt(1234567) calculates 178, then 87, then 87 and returns 87.
thirt(321) calculates 48, 48 and returns 48


 */
public class Thirteen {
    public static void main(String[] args) {
        System.out.println(thirt(1234567)); //87
        System.out.println(thirt(321));     //48
    }

    public static long thirt(long n) {
        long prevSum = n;
        long newSum = calcSum(prevSum);
        while (prevSum != newSum) {
            prevSum = newSum;
            newSum = calcSum(prevSum);
        }
        return newSum;
    }

    public static long calcSum(long n) {
        int[] reminders = {1, 10, 9, 12, 3, 4};
        long sum = 0;
        int i = 0;
        while (n > 0) {
            sum += n % 10 * reminders[i];
            i++;
            if (i == 6) {
                i = 0;
            }
            n /= 10;
        }
        return sum;
    }
}
