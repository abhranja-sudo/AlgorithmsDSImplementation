package com.ar50645.DP;

public class ClimbingSteps {
    //Let’s say you have to climb N steps. You can jump 1 step, 3 steps or 5 steps at a time.
    // How many ways are there to get to the top of the steps

    public static int waysToClimb(int n){
        int[] a = new int[n + 1];
        a[0] = 1;

        for(int i = 1; i < a.length; i++) {
            int nMinus1 = i - 1 < 0 ? 0 : a[i - 1];
            int nMinus3 = i - 3 < 0 ? 0 : a[i - 3];
            int nMinus5 = i - 5 < 0 ? 0 : a[i - 5];

            a[i] = nMinus1 + nMinus3 + nMinus5;
        }
        return a[n];

    }

}
