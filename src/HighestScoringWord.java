/*
6 kyu
Highest Scoring Word
https://www.codewars.com/kata/57eb8fcdf670e99d9b000272/

Given a string of words, you need to find the highest scoring word.
Each letter of a word scores points according to its position in the alphabet:
a = 1, b = 2, c = 3 etc.

For example, the score of "abad" is 8 (1 + 2 + 1 + 4).

You need to return the highest scoring word as a string.
If two words score the same, return the word that appears earliest in the original string.

All letters will be lowercase and all inputs will be valid.
 */
public class HighestScoringWord {
    public static void main(String[] args) {
        System.out.println(findMaxScoringWord("man i need a taxi up to ubud")); // "taxi"
        System.out.println(findMaxScoringWord("what time are we climbing up to the volcano")); // "volcano"
        System.out.println(findMaxScoringWord("take me to semynak")); // "semynak"
        System.out.println(findMaxScoringWord("aa b")); // "aa"
        System.out.println(findMaxScoringWord("b aa")); // "b"
        System.out.println(findMaxScoringWord("bb d")); // "bb"
        System.out.println(findMaxScoringWord("d bb")); // "d"
        System.out.println(findMaxScoringWord("aaa b")); //"aaa"
    }

    public static String findMaxScoringWord(String s) {
        String[] strArray = s.split(" ");
        int maxIdx = 0;
        int maxScore = calcScore(strArray[0]);
        int currScore;
        for (int i = 1; i < strArray.length; i++) {
            currScore = calcScore(strArray[i]);
            if (maxScore < currScore) {
                maxScore = currScore;
                maxIdx = i;
            }
        }
        return strArray[maxIdx];
    }

    private static int calcScore(String s) {
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            score += s.charAt(i) - 'a' + 1;
        }

        return score;
    }
}
