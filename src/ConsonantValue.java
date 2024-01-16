
/*
6 kyu
Consonant value
https://www.codewars.com/kata/59c633e7dcc4053512000073
 */

public class ConsonantValue {
    public static void main(String[] args) {
        System.out.println(calculateConsonantValue("zodiacs"));
        System.out.println(calculateConsonantValue("strength"));
    }

    public static int calculateConsonantValue(final String s) {
        int maxValue = 0;
        int currentValue = 0;
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (isConsonant(ch)) {
                currentValue += ch - 'a' + 1;
            } else {
                maxValue = Math.max(currentValue, maxValue);
                currentValue = 0;
            }
        }
        maxValue = Math.max(currentValue, maxValue);
        return maxValue;
    }

    private static boolean isConsonant(char c) {
        return (c != 'a') && (c != 'e') && (c != 'i') && (c != 'o') && (c != 'u');
    }

}
