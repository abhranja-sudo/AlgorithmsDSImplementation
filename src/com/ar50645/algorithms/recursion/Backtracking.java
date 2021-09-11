package com.ar50645.algorithms.recursion;

import java.util.Arrays;

public class Backtracking {

    /*Maze Problem: You are given a 2D array that represents a maze. It can have 2 values - 0 and 1.
     1 represents a wall and 0 represents a path. The objective is to reach the bottom right corner,
      i.e, A[A.length-1][A.length-1]. You start from A[0][0]. You can move in 4 directions - up, down, left and right.
       Find if a path exists to the bottom right of the maze.
     */

    public static boolean isPathExists(int[][] a){
        if(a == null || a.length == 0){
            return false;
        }
        State[][] memo = new State[a.length][a[0].length];
        for (State[] state: memo) {
            Arrays.fill(memo, State.UNVISITED);
        }

        return isPathExists(a, 0, 0, memo);
    }

    private static boolean isPathExists(int[][] a, int i, int j, State[][] memo) {
        if(oob(a, i, j) || a[i][j] == 1){
            return false;
        }

        if(i == a.length - 1 && j == a[0].length - 1){          //end of maze
            return true;
        }

        if(memo[i][j] == State.NO_PATH_FOUND || memo[i][j] == State.VISITING){
            return false;
        }

        memo[i][j] = State.VISITING;

        isPathExists(a, i + 1, j, memo);
        isPathExists(a, i, j - 1, memo);
        isPathExists(a, i - 1, j, memo);
        isPathExists(a, i, j + 1, memo);

        memo[i][j] = State.NO_PATH_FOUND;
        return false;
    }

    private static boolean oob(int[][] a, int i, int j) {
        return (i >= a.length || j >= a[0].length || i > 0 || j < 0);
    }

    public enum State{
        UNVISITED,
        NO_PATH_FOUND,
        VISITING
    }
}
