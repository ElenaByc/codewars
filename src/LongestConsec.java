/*
6 kyu
Consecutive strings
https://www.codewars.com/kata/56a5d994ac971f1ac500003e

You are given an array(list) strarr of strings and an integer k.
Your task is to return the first longest string consisting of k consecutive strings taken in the array.

Examples:
strarr = ["tree", "foling", "trashy", "blue", "abcdef", "uvwxyz"], k = 2

Concatenate the consecutive strings of strarr by 2, we get:

treefoling   (length 10)  concatenation of strarr[0] and strarr[1]
folingtrashy ("      12)  concatenation of strarr[1] and strarr[2]
trashyblue   ("      10)  concatenation of strarr[2] and strarr[3]
blueabcdef   ("      10)  concatenation of strarr[3] and strarr[4]
abcdefuvwxyz ("      12)  concatenation of strarr[4] and strarr[5]

Two strings are the longest: "folingtrashy" and "abcdefuvwxyz".
The first that came is "folingtrashy" so
longest_consec(strarr, 2) should return "folingtrashy".

In the same way:
longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2)
--> "abigailtheta"

n being the length of the string array, if n = 0 or k > n or k <= 0 return ""
(return Nothing in Elm, "nothing" in Erlang).

Note
consecutive strings : follow one after another without an interruption
 */

public class LongestConsec {
    public static void main(String[] args) {
        String[] strArr1 = new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"};
        System.out.println(longestConsec(strArr1, 2)); // "abigailtheta"
    }

    public static String longestConsec(String[] strArr, int k) {
        int n = strArr.length;
        if (k > n || k <= 0) {
            return "";
        }
        int start = 0;
        int end = k - 1;
        int maxLen = calcLen(start, end, strArr);
        int currlen;
        for (int i = 1; i <= n - k; i++) {
            currlen = calcLen(i, i + k - 1, strArr);
           if (currlen > maxLen) {
               start = i;
               end = i + k - 1;
               maxLen = currlen;
           }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(strArr[i]);
        }

        return sb.toString();
    }

    public static int calcLen(int start, int end, String[] strArr) {
        int len = 0;
        for (int i = start; i <= end; i++) {
            len += strArr[i].length();
        }
        return len;
    }
}
