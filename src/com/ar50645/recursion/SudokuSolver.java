package com.ar50645.recursion;

public class SudokuSolver {
    public static void solveSudoku(int[][] board) {

        BoardChecker checker = new BoardChecker(board);
        boolean success = solveSudoku(board, 0, 0, checker);
        if(!success) {
            throw new IllegalArgumentException("Board has no solution");
        }
    }

    private static boolean solveSudoku(int[][] board, int i, int j, BoardChecker checker) {
        if(i == board.length)
            return true;

        Pair next = nextSquare(i, j);
        if(board[i][j] != 0) {
            return solveSudoku(board, next.getI(), next.getJ(), checker);
        }

        for(int candidate = 1;  candidate <= 9; candidate++) {
            if(checker.canPlace(i, j, candidate)) {

                //place candidate on square
                checker.place(i, j, candidate);
                board[i][j] = candidate;

                if(solveSudoku(board, next.getI(), next.getJ(), checker))
                    return true;

                //remove candidate from square
                checker.remove(i, j, candidate);
                board[i][j] = 0;
            }
        }
        //no solution found
        return false;
    }

    private static Pair nextSquare(int i, int j) {
        if(j == 8)
            return new Pair(i + 1, 0);
        else
            return new Pair(i, j + 1);
    }

    public static class BoardChecker {
        boolean[][] row = new boolean[9][10];
        boolean[][] column = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        public BoardChecker(int[][] board) {
            // add existing number to checker
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(board[i][j] != 0) {
                        place(i, j, board[i][j]);
                    }
                }
            }
        }

        public void remove(int i, int j, int number) {
            row[i][number] = false;
            column[i][number] = false;
            box[boxNumber(i,j)][number] = false;
        }

        private boolean place(int i, int j, int number) {
            if(!canPlace(i, j, number))
                return false;

            row[i][number] = true;
            column[j][number] = true;
            box[boxNumber(i, j)][number] = true;
            return true;
        }

        private int boxNumber(int i, int j) {
            return (i/3)*3 + j/3;
        }

        private boolean canPlace(int i, int j, int number) {
            if(row[i][number])
                return false;
            if(column[j][number])
                return false;
            if(box[boxNumber(i,j)][number])
                return false;
            return true;
        }
    }

    public static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
