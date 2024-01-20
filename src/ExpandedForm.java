import java.util.ArrayList;
import java.util.List;


/*
6 kyu
Write Number in Expanded Form
https://www.codewars.com/kata/5842df8ccbd22792a4000245

Write Number in Expanded Form
You will be given a number and you will need to return it as a string in Expanded Form. For example:

Kata.expandedForm(12); # Should return "10 + 2"
Kata.expandedForm(42); # Should return "40 + 2"
Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
NOTE: All numbers will be whole numbers greater than 0.



 */
public class ExpandedForm {
    public static void main(String[] args) {
        System.out.println(expandedForm(12));
        System.out.println(expandedForm(42));
        System.out.println(expandedForm(70304));
    }

    public static String expandedForm(int num) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int mult = 1;
        while (num > 0) {
            list.add(num % 10 * mult);
            mult *= 10;
            num /= 10;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 0) {
                continue;
            }
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(Integer.toString(list.get(i)));
        }
        return sb.toString();
    }

}
