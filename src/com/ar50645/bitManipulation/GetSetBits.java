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
}
