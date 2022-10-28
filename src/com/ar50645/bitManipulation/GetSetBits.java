package com.ar50645.bitManipulation;

public class GetSetBits {

    public static int getBit(int num, int i) {
        return num >> i & 1;
    }

    public static int setBit(int num, int valToSet, int i) {
        if(valToSet == 1) {
            return (1 << i) | num;
        } else if(valToSet == 0) {
            return ~(1 << i) & num;
        }
        throw new IllegalArgumentException("value To set is illegal");
    }

    public int swap(int num, int i, int j) {
        if(getBit(num, i) != getBit(num, j)) {
            return num ^((1 << i) | (1 << j));
        }
        return num;
    }

    public int reverseBits(int num) {
        int i = 0, j = 31;

        while(i < j) {
            num = swap(num, i++, i--);
        }
        return num;
    }

    //count the number of set bits in its binary representation
    public int countSetBits(int num) {
        int count = 0;
        while(num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }
}
