package com.ar50645.arraysandstring;

import java.util.Arrays;

public class TwoDArray {
    // 90 degrees anticlockwise, given an array of pixels as integers.


    public void rotate(int[][] a) {
        int n = a.length;

        for(int i = 0; i < (a.length + 1) / 2 ; i++) {

            for(int j = i; j < a.length - i - 1; j++) {

                int temp = a[i][j];
                // Move values from right to top
                a[i][j] = a[j][n - 1 - i];

                // Move values from bottom to right
                a[j][n - 1 - i]
                        = a[n - 1 - i][n - 1 - j];

                // Move values from left to bottom
                a[n - 1 - i][n - 1 - j]
                        = a[n - 1 - j][i];

                // Assign temp to left
                a[n - 1 - j][i] = temp;
            }

        }
    }


    //rotate clockwise
    class Solution {
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i ++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                    matrix[j][n - 1 - i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }
    }


    //  Print a 2D array in Diagonal ZigZag order.
    public static void printZigZag(int[][] a) {

        int row = 0, column = 0;
        boolean up = true;

        //if single row or column, print it out
        if(a.length <= 1 || a[0].length <= 1) {
            System.out.println(Arrays.deepToString(a));
            return;
        }

        while (true) {
            // if on boundary, shift to the next diagonal, print and change direction
            if((row == 0 || row == a.length - 1) && column != a[0].length - 1 ) {
                column++;
                System.out.println(a[row][column]);
                up = !up;
            }
            else if(column == 0 || column == a[0].length - 1) {
                row++;
                System.out.println(a[row][column]);
                up = !up;
            }

            if(row == a.length - 1 && column == a[0].length - 1) {
                break;
            }

            //move up or down
            row = up ? row - 1 : row + 1;
            column = up ? column + 1: column - 1;
        }
    }

    // Print matrix in spiral order
    public void printSpiral(int[][] a) {
        for(int layer = 0; layer < a.length / 2; layer++) {

        }
    }
}
