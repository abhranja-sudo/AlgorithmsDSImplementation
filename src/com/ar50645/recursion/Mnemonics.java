package com.ar50645.recursion;

import java.util.Arrays;

//Phone Number Mnemonics: Given an N digit phone number, print all the strings that can be made from that phone number.
// Since 1 and 0 don't correspond to any characters, ignore them.
public class Mnemonics {

    public static void printWords(int[] phoneNumber){
        if(phoneNumber == null){
            return;
        }
        char[] buffer = new char[phoneNumber.length];
        printWords(phoneNumber, buffer, 0, 0);
    }

    private static void printWords(int[] phoneNumber, char[] buffer, int aIndex, int bufferIndex) {
        //base case
        if(bufferIndex == buffer.length || aIndex >= phoneNumber.length){
            printArray(buffer);
            return;
        }

        if(aIndex == phoneNumber.length){
            return;
        }

        //Find candidates for buffer position
        char[] candidate = getLetters(phoneNumber[aIndex]);

        if(candidate.length == 0){
            printWords(phoneNumber, buffer, aIndex + 1, bufferIndex);
        }

        //Place candidates in buffer
        for(char letter: candidate){
            buffer[bufferIndex] = letter;
            printWords(phoneNumber, buffer, aIndex + 1, bufferIndex + 1);
        }
    }

    private static void printArray(char[] buffer) {
        System.out.println(Arrays.toString(buffer));
    }

    /*
    Helper function to return char corresponding to digit
     */
    public static char[] getLetters(int digit){
        switch (digit){
            case 0: return new char[]{};
            case 1: return new char[]{};
            case 2: return new char[]{'a','b','c'};
            case 3: return new char[]{'d','e','f'};
            case 4: return new char[]{'g','h','i'};
            case 5: return new char[]{'j','k','l'};
            case 6: return new char[]{'m','n','o'};
            case 7: return new char[]{'p','q','r','s'};
            case 8: return new char[]{'t','u','v'};
            case 9: return new char[]{'w','x','y','z'};
        }
        throw new IllegalArgumentException("Invalid digit "+ digit);
    }
}
