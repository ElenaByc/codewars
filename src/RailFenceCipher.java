import java.util.ArrayList;
import java.util.List;

/*
3 kyu
Rail Fence Cipher: Encoding and Decoding
https://www.codewars.com/kata/58c5577d61aefcf3ff000081

Create two functions to encode and then decode a string using the Rail Fence Cipher.
This cipher is used to encode a string by placing each character successively in
a diagonal along a set of "rails". First start off moving diagonally and down.
When you reach the bottom, reverse direction and move diagonally and up until
you reach the top rail. Continue until you reach the end of the string.
Each "rail" is then read left to right to derive the encoded string.

For example, the string "WEAREDISCOVEREDFLEEATONCE"
could be represented in a three rail system as follows:

W      E       C       R       L       T       E
 E   R   D   S   O   E   E   F   E   A   O   C
   A       I       V       D       E       N

The encoded string would be:

WECRLTEERDSOEEFEAOCAIVDEN


Write a function/method that takes 2 arguments, a string and the number of rails,
and returns the ENCODED string.

Write a second function/method that takes 2 arguments,
an encoded string and the number of rails, and returns the DECODED string.

For both encoding and decoding, assume number of rails >= 2 and that passing
an empty string will return an empty string.
 */
public class RailFenceCipher {
    public static void main(String[] args) {
        System.out.println(encode("WEAREDISCOVEREDFLEEATONCE", 3));
        System.out.println(decode("WECRLTEERDSOEEFEAOCAIVDEN", 3));
    }

    public static int[] calcRailsSizes(String s, int rails) {
        int[] sizes = new int[rails];
        int n = s.length();

        /// imitate process of encoding
        int row = 0;
        boolean down = true;
        for (int i = 0; i < n; i++) {
            sizes[row]++;
            if (down) {
                row++;
                if (row == rails) {
                    row = rails - 2;
                    down = false;
                }
            } else {
                row--;
                if (row == -1) {
                    row = 1;
                    down = true;
                }
            }
        }

        return sizes;
    }

    public static String encode(String s, int rails) {
        if (rails == 1) return s;
        StringBuilder sb = new StringBuilder();
        List<List<Character>> list = new ArrayList<>();

        for (int i = 0; i < rails; i++) {
            list.add(new ArrayList<>());
        }

        int n = s.length();
        char ch;
        int row = 0;
        boolean down = true;

        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            list.get(row).add(ch);
            if (down) {
                row++;
                if (row == rails) {
                    row = rails - 2;
                    down = false;
                }
            } else {
                row--;
                if (row == -1) {
                    row = 1;
                    down = true;
                }
            }
        }

        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                sb.append(list.get(i).get(j));
            }
        }

        return sb.toString();
    }

    public static String decode(String s, int rails) {
        if (rails == 1) return s;
        int n = s.length();
        int[] sizes = calcRailsSizes(s, rails);
        List<List<Character>> list = new ArrayList<>();
        for (int i = 0; i < rails; i++) {
            list.add(new ArrayList<>());
        }
        int j = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (i < len + sizes[j]) {
                list.get(j).add(s.charAt(i));
            } else {
                len += sizes[j];
                j++;
                list.get(j).add(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        int row = 0;
        boolean down = true;
        for (int i = 0; i < n; i++) {
            sb.append(list.get(row).get(0));
            list.get(row).remove(0);
            if (down) {
                row++;
                if (row == rails) {
                    row = rails - 2;
                    down = false;
                }
            } else {
                row--;
                if (row == -1) {
                    row = 1;
                    down = true;
                }
            }
        }
        return sb.toString();
    }
}
