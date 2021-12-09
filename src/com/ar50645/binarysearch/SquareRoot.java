package com.ar50645.binarysearch;

public class SquareRoot {

    public int findSquareRoot(int n) {

        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        int low = 0, high = n/2;

        while (low <= high) {
            int mid = (high + low) / 2;
            if(mid * mid == n)
                return mid;

            else if(mid * mid < n) {
                if((mid + 1) * (mid + 1) > n)
                    return mid;
                low = mid + 1;
            }

            else
                high = mid - 1;
        }
        return -1;
    }
}
