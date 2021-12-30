package com.ar50645.arraysandstring;

import java.util.Arrays;

public class TwoDArray {
    //An image is nothing but a matrix of pixels. Rotate a square image by 90 degrees anticlockwise, given an array of pixels as integers.
    /**
     * 1 2 3
     * 4 5 6
     * 7 8 9
     * to
     * 7 4 1
     * 8 5 2
     * 9 6 3
     */

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
