/*
6 kyu
Count the smiley faces!
https://www.codewars.com/kata/583203e6eb35d7980400002a

Given an array (arr) as an argument complete the function countSmileys
that should return the total number of smiling faces.

Rules for a smiling face:

Each smiley face must contain a valid pair of eyes. Eyes can be marked as : or ;
A smiley face can have a nose, but it does not have to. Valid characters for a nose are - or ~
Every smiling face must have a smiling mouth that should be marked with either ) or D
No additional characters are allowed except for those mentioned.

Valid smiley face examples: :) :D ;-D :~)
Invalid smiley faces: ;( :> :} :]

Example
countSmileys([':)', ';(', ';}', ':-D']);       // should return 2;
countSmileys([';D', ':-(', ':-)', ';~)']);     // should return 3;
countSmileys([';]', ':[', ';*', ':$', ';-D']); // should return 1;
Note
In case of an empty array return 0.
You will not be tested with invalid input (input will always be an array).
Order of the face (eyes, nose, mouth) elements will always be the same.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmileFaces {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add(":)");
        list1.add(";(");
        list1.add(":}");
        list1.add(":-D");
        System.out.println(countSmileys(list1)); // 2
    }

    public static int countSmileys(List<String> arr) {
        int cnt = 0;

        for (String s : arr) {
            if (isValidSmile(s)) {
                cnt++;
            }
        }

        return cnt;
    }

    private static boolean isValidSmile(String s) {
        Set<Character> validEyes = new HashSet<>();
        validEyes.add(':');
        validEyes.add(';');

        Set<Character> validNoses = new HashSet<>();
        validNoses.add('-');
        validNoses.add('~');

        Set<Character> validMouthes = new HashSet<>();
        validMouthes.add(')');
        validMouthes.add('D');

        return switch (s.length()) {
            case 2 -> // eyes and mouth
                    validEyes.contains(s.charAt(0)) &&
                            validMouthes.contains(s.charAt(1));
            case 3 ->  // eyes and mouth
                    validEyes.contains(s.charAt(0)) &&
                            validNoses.contains(s.charAt(1)) &&
                            validMouthes.contains(s.charAt(2));
            default -> false;
        };
    }
}
