/*
6 kyu
Rectangle into Squares
https://www.codewars.com/kata/55466989aeecab5aac00003e

You will be given two dimensions

a positive integer length
a positive integer width
You will return a collection  with the size of each of the squares.

Examples in general form:

  sqInRect(5, 3) should return [3, 2, 1, 1]
  sqInRect(3, 5) should return [3, 2, 1, 1]
  sqInRect(5, 5) should return null
 */


import java.util.ArrayList;
import java.util.List;

public class SqInRect {
    public static void main(String[] args) {
        System.out.println(sqInRect(5, 3));
    }

    public static List<Integer> sqInRect(int l, int w) {
//        System.out.println("l = " + l + " w = " + w);
        if (l == w) {
            return null;
        }
        int temp;
        List<Integer> result = new ArrayList<>();

        while (w > 1 && l > 1) {
            if (w > l) {
                temp = l;
                l = w;
                w = temp;
            }
            result.add(w);
            l -= w;
        }
        if (w == 1) {
            for (int i = 0; i < l; i++) {
                result.add(1);
            }
        } else if (l == 1) {
            for (int i = 0; i < w; i++) {
                result.add(1);
            }
        }
        return result;

    }
}
