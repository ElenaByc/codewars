/*
6 kyu
Backspaces in string
https://www.codewars.com/kata/5727bb0fe81185ae62000ae3

Assume "#" is like a backspace in string.
This means that string "a#bc#d" actually is "bd"

Your task is to process a string with "#" symbols.

Examples
"abc#d##c"      ==>  "ac"
"abc##d######"  ==>  ""
"#######"       ==>  ""
""              ==>  ""
 */

public class BackspacesInString {
    public static void main(String[] args) {
        System.out.println(cleanString("a#bc#d"));
        System.out.println(cleanString("abc#d##c"));
        System.out.println(cleanString("abc##d######"));
        System.out.println(cleanString("######"));
        System.out.println(cleanString(""));
        System.out.println(cleanString("ab#####cdef"));
    }

    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (ch != '#') {
                sb.append(ch);
            } else {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }
}
