/*
6 kyu
Maze Runner
https://www.codewars.com/kata/58663693b359c4a6560001d6

You will be given a 2D array of the maze and an array of directions.
Your task is to follow the directions given.
If you reach the end point before all your moves have gone,
you should return Finish. If you hit any walls or go outside the maze border,
you should return Dead. If you find yourself still in the maze after using all the moves,
you should return Lost.

The Maze array will look like
maze = [[1,1,1,1,1,1,1],
        [1,0,0,0,0,0,3],
        [1,0,1,0,1,0,1],
        [0,0,1,0,0,0,1],
        [1,0,1,0,1,0,1],
        [1,0,0,0,0,0,1],
        [1,2,1,0,1,0,1]]
..with the following key
      0 = Safe place to walk
      1 = Wall
      2 = Start Point
      3 = Finish Point
  direction = {"N","N","N","N","N","E","E","E","E","E"} == "Finish"
 */

public class MazeRunner {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 3},
                {1, 0, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 2, 1, 0, 1, 0, 1}};
        String[] direction1 = new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E"};
        String[] direction2 = new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "E", "E", "N", "N", "E"};
        String[] direction3 = new String[]{"N", "N", "N", "N", "N", "E", "E", "E", "E", "E", "W", "W"};
        String[] direction4 = new String[]{"N", "N", "N", "W", "W"};
        String[] direction5 = new String[]{"N", "N", "N", "N", "N", "E", "E", "S", "S", "S", "S", "S", "S"};
        String[] direction6 = new String[]{"N", "E", "E", "E", "E"};

        System.out.println(walk(maze, direction1)); // Finish
        System.out.println(walk(maze, direction2)); // Finish
        System.out.println(walk(maze, direction3)); // Finish
        System.out.println();
        System.out.println(walk(maze, direction4)); // Dead
        System.out.println(walk(maze, direction5)); // Dead
        System.out.println();
        System.out.println(walk(maze, direction6)); // Lost

    }

    public static String walk(int[][] maze, String[] directions) {
        int n = maze.length;
        int i, j = 0;
        char ch;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (maze[i][j] == 2) {
                    break;
                }
            }
            if (j < n) break;
        }

        for (String direction : directions) {
            ch = direction.charAt(0);
            switch (ch) {
                case 'E' -> j++;
                case 'W' -> j--;
                case 'N' -> i--;
                case 'S' -> i++;
            }
            if (i < 0 || i >= n || j < 0 || j >= n) {
                return "Dead";
            }
            if (maze[i][j] == 3) {
                return "Finish";
            }
            if (maze[i][j] == 1) {
                return "Dead";
            }

        }

        return "Lost";
    }
}
