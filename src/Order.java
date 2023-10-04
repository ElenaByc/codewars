
/*
6 kyu
Your order, please
https://www.codewars.com/kata/55c45be3b2079eccff00010f/

Your task is to sort a given string. Each word in the string will contain a single number.
This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string.
The words in the input String will only contain valid consecutive numbers.

Examples
"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""

 */
public class Order {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
        System.out.println(order(""));
        System.out.println(order("4of Fo1r pe6ople g3ood th5e the2"));
    }

    public static String order(String words) {
        if (words.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        String[] wordsArray = words.split(" ");
        int n = wordsArray.length;
        String[] resultArray = new String[n];

        for (String s : wordsArray) {
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    resultArray[s.charAt(i) - '1'] = s;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(resultArray[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}
