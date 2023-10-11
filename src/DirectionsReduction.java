import java.util.Arrays;
import java.util.Stack;

/*
5 kyu
Directions Reduction
https://www.codewars.com/kata/550f22f4d758534c1100025a


Examples:
In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north
and coming back right away.

The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other,
therefore, the final result is []

In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH"
are not directly opposite but they become directly opposite after the reduction
of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
 */
public class DirectionsReduction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
    }

    private static String[] dirReduc(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            switch (s) {
                case "NORTH" -> {
                    if (stack.size() > 0 && stack.peek().equals("SOUTH")) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
                case "SOUTH" -> {
                    if (stack.size() > 0 && stack.peek().equals("NORTH")) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
                case "EAST" -> {
                    if (stack.size() > 0 && stack.peek().equals("WEST")) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
                case "WEST" -> {
                    if (stack.size() > 0 && stack.peek().equals("EAST")) {
                        stack.pop();
                    } else {
                        stack.push(s);
                    }
                }
            }
        }
        String[] result = new String[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
