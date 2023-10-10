import java.util.HashMap;

/*
6 kyu
Duplicate Encoder
https://www.codewars.com/kata/54b42f9314d9229fd6000d9c/

The goal of this exercise is to convert a string to a new string
where each character in the new string is "(" if that character appears only once
in the original string, or ")" if that character appears more than once in the original string.
Ignore capitalization when determining if a character is a duplicate.

Examples
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))(("
 */
public class DuplicateEncoder {
    public static void main(String[] args) {
        System.out.println(encode("din"));      // "((("
        System.out.println(encode("recede"));   // "()()()"
        System.out.println(encode("Success"));  // ")())())"
        System.out.println(encode("(( @"));     // "))(("
    }

    private static String encode(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> hm = new HashMap<>();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (hm.get(ch) > 1) {
                sb.append(")");
            } else {
                sb.append("(");
            }
        }

        return sb.toString();
    }
}
