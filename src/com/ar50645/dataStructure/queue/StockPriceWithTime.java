package com.ar50645.dataStructure.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given stock prices and the corresponding day of each stock price.
 * For example:(32, 1), (45, 1), (37,2), (42,3) .Here, 32 is the price and 1 is the day of the price.
 * Say you are given these prices as an input stream. You should provide a function for the user to input a stock price and day.
 * Your system should be able to tell the maximum stock price in the last 3 days.
 */
public class StockPriceWithTime {

    Queue<Price> priceQueue;
    int window;

    public StockPriceWithTime(int window) {
        this.window = window;
        priceQueue = new LinkedList<>();
    }

    public void addPrice(int price, int day) {
        while (!priceQueue.isEmpty() && priceQueue.peek().getDay() < day - window + 1)
            priceQueue.remove();

        priceQueue.add(new Price(price, day));
    }

    public int getMax() {
        int maxPrice = 0;
        Iterator<Price> iter = priceQueue.iterator();
        while (iter.hasNext()) {
            int price = iter.next().getPrice();
            if(price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    private class Price {
        int price;
        int day;

        public Price(int price, int day) {
            this.price = price;
            this.day = day;
        }

        public int getPrice() {
            return price;
        }

        public int getDay() {
            return day;
        }
    }
}
