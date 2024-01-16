/*
6 kyu
Validate Credit Card Number
https://www.codewars.com/kata/5418a1dd6d8216e18a0012b2

In this Kata, you will implement the Luhn Algorithm,
which is used to help validate credit card numbers.

Given a positive integer of up to 16 digits,
return true if it is a valid credit card number, and false if it is not.

Here is the algorithm:

Double every other digit, scanning from right to left,
starting from the second digit (from the right).

Another way to think about it is: if there are an even number of digits,
double every other digit starting with the first; i
f there are an odd number of digits, double every other digit starting with the second:

1714 ==> [1*, 7, 1*, 4] ==> [2, 7, 2, 4]
12345 ==> [1, 2*, 3, 4*, 5] ==> [1, 4, 3, 8, 5]
891 ==> [8, 9*, 1] ==> [8, 18, 1]

If a resulting number is greater than 9, replace it with the sum of its own digits
(which is the same as subtracting 9 from it):

[8, 18*, 1] ==> [8, (1+8), 1] ==> [8, 9, 1]
or:
[8, 18*, 1] ==> [8, (18-9), 1] ==> [8, 9, 1]

Sum all of the final digits:
[8, 9, 1] ==> 8 + 9 + 1 = 18
Finally, take that sum and divide it by 10. If the remainder equals zero,
the original credit card number is valid.

18 (modulus) 10 ==> 8 , which is not equal to 0, so this is not a valid credit card number
 */
public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        System.out.println(validate("891"));    // 8 18 1 => 8 9 1 => 18 false
        System.out.println(validate("2121"));   // 2121 => 4 1 4 1 => 10 true
        System.out.println(validate("2626262626262626"));   //true
    }

    public static boolean validate(String n) {
        int len = n.length();
        int sum = 0;
        int num;
        boolean mul2 = false;
        for (int i = len - 1; i >= 0; i--) {
            num = n.charAt(i) - '0';
            if (mul2) {
                num *= 2;
                if (num > 9) {
                    num -= 9;
                }
                mul2 = false;
            } else {
                mul2 = true;
            }
            sum += num;
        }
        return sum % 10 == 0;
    }
}
