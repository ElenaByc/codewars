import java.util.HashMap;
/*
5 kyu
First non-repeating character
https://www.codewars.com/kata/52bc74d4ac05d0945d00054e
 */
public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingCharacter("a"));        // a
        System.out.println(firstNonRepeatingCharacter("streSS"));   // t
        System.out.println(firstNonRepeatingCharacter("sTreSS"));   // T
        System.out.println(firstNonRepeatingCharacter("moon-men")); // -
        System.out.println(firstNonRepeatingCharacter("moonmoon")); //
    }

    public static String firstNonRepeatingCharacter(String s) {
        char ch;
        int n = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            ch = Character.toLowerCase(s.charAt(i));
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if (hm.get(Character.toLowerCase(ch)) == 1) {
                return "" + ch;
            }
        }
        return "";
    }
}
