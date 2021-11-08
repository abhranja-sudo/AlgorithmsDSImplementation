package com.ar50645.recursion;

public class PowerFunction {
    /**
     * Power Function: Implement a function to calculate X^N. Both X and N can be positive or negative.
     * You can assume that overflow doesn't happen.
     */

    public static float powerFunction(int x, int power) {

        //0 or 0 ^ -3 (or any negative number) is undefined.
        if(x == 0 && power <= 0)
            throw new ArithmeticException("undefined");

        float result = positivePower(Math.abs(x), Math.abs(power));

        //handle negative power
        if(power < 0)
            result = 1 / result;

        if(x < 0 && power % 2 != 0)
            result = -1 * result;

        return result;
    }

    public static int positivePower(int x, int power) {

        if(power == 0)
            return 1;

        if(power == 1)
            return x;

        int halfPower = positivePower(x, power / 2);
        if (power % 2 == 0)
            return halfPower * halfPower;
        else
            return x * halfPower * halfPower;
    }
}
