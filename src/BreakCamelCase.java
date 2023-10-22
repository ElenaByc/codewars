/*
6 kyu
Break camelCase
https://www.codewars.com/kata/5208f99aee097e6552000148/

Complete the solution so that the function will break up camel casing, using a space between words.

Example
"camelCasing"  =>  "camel Casing"
"identifier"   =>  "identifier"
""             =>  ""
 */
public class BreakCamelCase {
    public static void main(String[] args) {
        System.out.println(breakCamelCase("camelCasing"));
        System.out.println(breakCamelCase("breakCamelCase"));
        System.out.println(breakCamelCase("identifier"));
        System.out.println(breakCamelCase(""));

    }

    public static String breakCamelCase(String input) {
        int n = input.length();
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        char ch;

        for (int i = 0; i < n; i++) {
            ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(' ');
            }
            sb.append(ch);
        }

        return sb.toString();
    }
}
