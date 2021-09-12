package com.ar50645.recursion;

import java.util.Stack;

//Coin Change Problem: Given a set of coin denominations, print out the different ways
// you can make a target amount. You can use as many coins of each denomination as you like
public class CoinChange {
    public static void main(String[] args) {
        printCoins(new int[]{1,2,5},5);
    }
    public static void printCoins(int[] coins, int target){
        if(coins == null || coins.length == 0 || target <= 0){
            return;
        }
        printCoins(coins, target, 0, new Stack<> (), 0);
    }

    private static void printCoins(int[] coins, int target, int startIndex, Stack<Integer> buffer, int sum) {

        if(sum > target){
            return;
        }

        if(sum == target){
            System.out.println(buffer);
            return;
        }

        //find candidates to go into buffer
        for(int i = startIndex; i < coins.length; i++){
            //place candidate into the buffer and recurse
            buffer.push(coins[i]);
            printCoins(coins, target, i , buffer, sum + coins[i] );
            buffer.pop();
        }
    }
}
