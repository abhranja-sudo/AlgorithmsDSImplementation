package com.ar50645.recursion;


import java.util.HashSet;
import java.util.Set;

class Solution {
    record Pair(int i, int j){}
    public void solveSudoku(char[][] board) {

        Set<Character>[] trackRow = new HashSet[9];
        Set<Character>[] trackCol = new HashSet[9];
        Set<Character>[] trackBox = new HashSet[9];

        // init
        for(int i = 0; i < 9; i++) {
            trackRow[i] = new HashSet<>();
            trackCol[i] = new HashSet<>();
            trackBox[i] = new HashSet<>();
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char val = board[i][j];
                if(val != '.') {
                    trackRow[i].add(val);
                    trackCol[j].add(val);
                    trackBox[getBoxNumber(i, j)].add(val);
                }
            }
        }
        fill(board, 0, 0, trackRow, trackCol, trackBox);
    }

    private boolean fill(char[][] board, int i, int j, Set<Character>[] trackRow, Set<Character>[] trackCol, Set<Character>[] trackBox) {

        // reached the last row
        if(i == 9) {
            return true;
        }

        Pair next = getNextCell(i, j);
        if(board[i][j] != '.') {
            return fill(board, next.i(), next.j(), trackRow, trackCol, trackBox);
        }

        // attempt to fill
        for(Character curr = '1' ; curr <= '9'; curr++ ) {
            // check if the character is eligible to add
            int boxNumber = getBoxNumber(i, j);
            if(!(trackRow[i].contains(curr) || trackCol[j].contains(curr) || trackBox[boxNumber].contains(curr))) {

                //fill
                board[i][j] = curr;
                trackRow[i].add(curr);
                trackCol[j].add(curr);
                trackBox[boxNumber].add(curr);

                if (fill(board, next.i(), next.j(), trackRow, trackCol, trackBox)) {
                    return true;
                }

                //remove from cache
                board[i][j] = '.';
                trackRow[i].remove(curr);
                trackCol[j].remove(curr);
                trackBox[boxNumber].remove(curr);
            }
        }
        return false;
    }

    private Pair getNextCell(int i, int j) {
        if(j == 8) {
            return new Pair(i + 1, 0);
        }
        else return new Pair(i, j + 1);
    }



    private int getBoxNumber(int i, int j) {
        return (i/3) * 3 + j / 3;
    }
}


// Interview Camp
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
