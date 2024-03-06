/*
6 kyu
Calculate String Rotation
https://www.codewars.com/kata/5596f6e9529e9ab6fb000014
 */
public class CalculateRotation {
    public static void main(String[] args) {
        System.out.println(shiftedDiff("hoop", "pooh"));     // -1
        System.out.println(shiftedDiff("coffee", "eecoff")); // 2
        System.out.println(shiftedDiff("eecoff", "coffee")); // 4
    }

    static int shiftedDiff(String first, String second) {
        if (first.length() != second.length()) {
            return -1;
        }
        int n = first.length();
        if (n < 2) {
            if (first.equals(second)) {
                return 0;
            }
            return -1;
        }

        int cnt = 0;
        while (cnt < n) {
            if (first.equals(second)) {
                return cnt;
            }
            first = first.charAt(n - 1) + first.substring(0, n - 1);
            cnt++;
        }

        return -1;
    }
}
