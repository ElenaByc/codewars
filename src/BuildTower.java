/*
Build Tower
Build a pyramid-shaped tower, as an array/list of strings,
given a positive integer number of floors. A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]
And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */
public class BuildTower {
    public static void main(String[] args) {
        String[] tower3 = towerBuilder(3);
        for(String s : tower3) {
            System.out.println(s);
        }
        System.out.println();
        String[] tower6 = towerBuilder(6);
        for(String s : tower6) {
            System.out.println(s);
        }
    }

    public static String[] towerBuilder(int n) {
        String[] tower = new String[n];
        StringBuilder level = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                level.append(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                level.append("*");
            }
            for (int j = 0; j < n - i - 1; j++) {
                level.append(" ");
            }
            tower[i] = level.toString();
            level.delete(0, level.length());
        }
        return tower;
    }
}
