package com.ar50645.arraysandstring;

public class MaxDiff {

    //Given a list of stock prices for a company, find the maximum amount of money you can make with one trade.
    // A trade is a buy and sell.

    public int maxMoney(int[] prices) {
        int minTillNow = Integer.MAX_VALUE;
        int maxResult = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            minTillNow = Math.min(minTillNow, prices[i]);
            maxResult = Math.max(maxResult, prices[i] - minTillNow);
        }
        return maxResult;
    }
}
