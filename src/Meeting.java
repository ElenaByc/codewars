/*
6 kyu
Meeting
https://www.codewars.com/kata/59df2f8f08c6cec835000012

John has invited some friends. His list is:

s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;
     Raphael:Corwill;Alfred:Corwill";

Could you make a program that:
- makes this string uppercase
- gives it sorted in alphabetical order by last name.
When the last names are the same, sort them by first name.
Last name and first name of a guest come in the result between parentheses separated by a comma.

So the result of function meeting(s) will be:

"(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)
(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)"
It can happen that in two distinct families with the same family name
two people have the same first name too.
 */

import java.util.Arrays;

public class Meeting {

    public static void main(String[] args) {
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting(s));
    }

    public static String meeting(String s) {
        String str = s.toUpperCase();
        String[] array = str.split(";");
        String[] name;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            name = array[i].split(":");
            array[i] = name[1] + ", " + name[0];
        }
        Arrays.sort(array);

        for (String person : array) {
            sb.append("(");
            sb.append(person);
            sb.append(")");
        }

        return sb.toString();
    }
}
