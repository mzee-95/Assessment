package org.example;

public class HighestCommonFactor {

    public static int getCommonFactor(int[] numbers) {
        int res = numbers[0];
        for (int num: numbers){
            res = getDivisor(res, num);

            if(res == 1)
            {
                return res;
            }
        }
        return res;
    }

    private static int getDivisor(int a, int b)
    {
        if (a == 0)
            return b;
        return getDivisor(b % a, a);
    }

}
