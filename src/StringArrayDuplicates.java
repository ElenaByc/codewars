import java.util.Arrays;

/*
6 kyu
String array duplicates
https://www.codewars.com/kata/59f08f89a5e129c543000069

In this Kata, you will be given an array of strings and your task
is to remove all consecutive duplicate letters from each string in the array.

For example:
dup(["abracadabra","allottee","assessee"]) = ["abracadabra","alote","asese"].
dup(["kelless","keenness"]) = ["keles","kenes"].

Strings will be lowercase only, no spaces.

 */
public class StringArrayDuplicates {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"ccooddddddewwwaaaaarrrrsssss", "piccaninny", "hubbubbubboo"};
        String[] arr2 = new String[]{"abracadabra", "allottee", "assessee"};
        String[] arr3 = new String[]{"kelless", "keenness"};

        System.out.println(Arrays.toString(dup(arr1)));
        System.out.println(Arrays.toString(dup(arr2)));
        System.out.println(Arrays.toString(dup(arr3)));
    }

    public static String[] dup(String[] arr) {
        int n = arr.length;
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = removeDuplicates(arr[i]);
        }
        return result;
    }

    private static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        char ch;

        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (sb.length() == 0) {
                sb.append(ch);
            } else {
                if (ch != sb.charAt(sb.length() - 1)) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}
