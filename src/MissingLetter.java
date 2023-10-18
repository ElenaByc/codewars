/*
6 kyu
Find the missing letter
https://www.codewars.com/kata/5839edaa6754d6fec10000a2/

Write a method that takes an array of consecutive (increasing)
letters as input and that returns the missing letter in the array.

You will always get a valid array.
And it will be always exactly one letter be missing.
The length of the array will always be at least 2.
The array will always contain letters in only one case.

Example:

['a','b','c','d','f'] -> 'e'
['O','Q','R','S'] -> 'P'
(Use the English alphabet with 26 letters!)
 */
public class MissingLetter {
    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[] {'a','b','c','d','f'}));
        System.out.println(findMissingLetter(new char[] {'O','Q','R','S'}));
    }

    public static char findMissingLetter(char[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i-1] > 1) {
                return (char)(array[i-1] + 1);
            }
        }

        return 0;
    }
}
