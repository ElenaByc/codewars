
/*
5 kyu
Four Letter Words ~ Mutations
https://www.codewars.com/kata/5cb5eb1f03c3ff4778402099/
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Mutations {
    public static void main(String[] args) {
        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[] bob = new String[]{"boar", "clap", "mere", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        System.out.println(mutations(alice, bob, "maze", 0)); // Alice goes  first, Alice   wins - 0
        System.out.println(mutations(alice, bob, "send", 0)); // Alice goes  first, Bob     wins - 1
        System.out.println(mutations(alice, bob, "boat", 0)); // Alice fails first, Bob     wins - 1
        System.out.println(mutations(alice, bob, "apse", 0)); // Alice fails first, neither wins - -1
        System.out.println(mutations(alice, bob, "flap", 1)); // Bob   goes  first, Bob     wins - 1
        System.out.println(mutations(alice, bob, "soar", 1)); // Bob   goes  first, Alice   wins - 0
        System.out.println(mutations(alice, bob, "more", 1)); // Bob   fails first, Alice   wins - 0
        System.out.println(mutations(alice, bob, "calm", 1)); // Bob   fails first, neither wins - -1
    }

    public static int mutations(String[] alice, String[] bob, String word, int first) {
        System.out.print("Alice: ");
        System.out.println(Arrays.toString(alice));
        System.out.print("Bob: ");
        System.out.println(Arrays.toString(bob));
        System.out.println("word: " + word);

        int cntA = 0;
        int cntB = 0;
        boolean[] aliceUsed = new boolean[alice.length];
        boolean[] bobUsed = new boolean[bob.length];
        String nextWord;
        makeWordUsed(word, alice, aliceUsed);
        makeWordUsed(word, bob, bobUsed);

        // first turn
        if (first == 0) { // Alice first
            System.out.println("Alice's turn:");
            nextWord = canMakeTurn(word, alice, aliceUsed);
            if (nextWord.length() > 0) {
                cntA++;
                word = nextWord;
                makeWordUsed(word, bob, bobUsed);
            } else {
                System.out.println("Bob's turn:");
                nextWord = canMakeTurn(word, bob, bobUsed);
                if (nextWord.length() > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else { // Bob first
            System.out.println("Bob's turn:");
            nextWord = canMakeTurn(word, bob, bobUsed);
            if (nextWord.length() > 0) {
                cntB++;
                word = nextWord;
                makeWordUsed(word, alice, aliceUsed);
            } else {
                System.out.println("Alice's turn:");
                nextWord = canMakeTurn(word, alice, aliceUsed);
                if (nextWord.length() > 0) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }
        while (true) {
            if (first == 0 && cntA > cntB) {
                System.out.println("Bob's turn:");
                word = canMakeTurn(word, bob, bobUsed);
                if (word.length() > 0) {
                    cntB++;
                    makeWordUsed(word, alice, aliceUsed);
                } else {
                    return 0; // Alice won
                }
            } else if (first == 0 && cntA == cntB) {
                System.out.println("Alice's turn:");
                word = canMakeTurn(word, alice, aliceUsed);
                if (word.length() > 0) {
                    cntA++;
                    makeWordUsed(word, bob, bobUsed);
                } else {
                    return 1;  // Bob won
                }
            } else if (first == 1 && cntB > cntA) {
                System.out.println("Alice's turn:");
                word = canMakeTurn(word, alice, aliceUsed);
                if (word.length() > 0) {
                    cntA++;
                    makeWordUsed(word, bob, bobUsed);
                } else {
                    return 1; // Bob won
                }
            } else {
                System.out.println("Bob's turn:");
                word = canMakeTurn(word, bob, bobUsed);
                if (word.length() > 0) {
                    cntB++;
                    makeWordUsed(word, alice, aliceUsed);
                } else {
                    return 0; // Alice won
                }
            }
        }
    }

    private static void makeWordUsed(String word, String[] memory, boolean[] used) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i].equals(word)) {
                used[i] = true;
                return;
            }
        }
    }

    private static String canMakeTurn(String word, String[] memory, boolean[] used) {
        for (int i = 0; i < memory.length; i++) {
            if (!used[i] && isValid(word, memory[i])) {
                System.out.println(memory[i]);
                used[i] = true;
                return memory[i];
            }
        }
        return "";
    }

    private static boolean isValid(String str1, String str2) {
        // made up of four unique letters?
        char ch;
        Set<Character> hm = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            ch = str2.charAt(i);
            if (hm.contains(ch)) {
                return false;
            }
            hm.add(ch);
        }
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return cnt == 1;
    }
}
