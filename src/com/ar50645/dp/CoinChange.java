package com.ar50645.dp;

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        return change(amount, coins, memo);
    }
    public int change(int amount, int[] coins, int[] memo) {

        for (int coin: coins)
            for(int i = 1; i <= amount; i++) {
                if(i - coin >= 0)
                    memo[i] = memo[i] + memo[i - coin];
            }
        return memo[memo.length - 1];

    }
}
