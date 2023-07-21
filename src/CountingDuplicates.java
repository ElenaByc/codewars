import java.util.HashMap;

/*
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive
alphabetic characters and numeric digits that occur more than once in the input string.
The input string can be assumed to contain only alphabets (both uppercase and lowercase)
and numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice

 */

public class CountingDuplicates {
    public static void main(String[] args) {
        System.out.println(duplicateCount("abcdea")); // 1
        System.out.println(duplicateCount("aabBcde"));

        System.out.println();
        System.out.println(duplicateCount2("abcdea")); // 1
        System.out.println(duplicateCount2("aabBcde"));
    }

    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        int counter = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        char ch;
        for (int i = 0; i < text.length(); i++) {
            ch = text.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        // Iterating HashMap through for loop
        for (HashMap.Entry<Character, Integer> set : hm.entrySet()) {
            if (set.getValue() > 1) {
                counter++;
            }

        }
        return counter;
    }

    public static int duplicateCount2(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0, 1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }
}
