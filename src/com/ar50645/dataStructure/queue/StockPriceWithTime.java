package com.ar50645.dataStructure.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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

    class Price {
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
