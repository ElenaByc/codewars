/*
6 kyu
Valid Braces
https://www.codewars.com/kata/5277c8a221e209d3f6000b56

Write a function that takes a string of braces,
and determines if the order of the braces is valid.
It should return true if the string is valid, and false if it's invalid.

This Kata is similar to the Valid Parentheses Kata,
but introduces new characters: brackets [], and curly braces {}.

All input strings will be nonempty, and will only consist of parentheses,
brackets and curly braces: ()[]{}.

What is considered Valid?
A string of braces is considered valid if all braces are matched with the correct brace.

Examples
"(){}[]"   =>  True
"([{}])"   =>  True
"(}"       =>  False
"[(])"     =>  False
"[({})](]" =>  False
 */

import java.util.HashMap;
import java.util.Stack;

public class ValidBraces {
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]"));  // True
        System.out.println(isValid("([{}])"));  // True
        System.out.println(isValid("(}"));      // False
        System.out.println(isValid("[(])"));    // False
        System.out.println(isValid("[({})](]"));// False
    }

    public static boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('(', ')');
        hm.put('[', ']');
        hm.put('{', '}');
        char ch;

        for (int i = 0; i < braces.length(); i++) {
            ch = braces.charAt(i);
            if (hm.containsKey(ch)) { // opening
                stack.add(ch);
            } else { // closing
                if (stack.size() > 0) {
                    if (ch != hm.get(stack.pop())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
