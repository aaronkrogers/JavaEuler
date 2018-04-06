package javaeuler.tools;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MathTools {
    public static int divisorCount(long num) {
        int result = 1;

        List<Long> factors = PrimeTools.getFactors(num);

        for (long factor : new HashSet<>(factors)) {
            int frequency = Collections.frequency(factors, factor);
            result *= (frequency + 1);
        }
        return result;
    }

    public static long divisorSum(long num) {
        int result = 1;

        List<Long> factors = PrimeTools.getFactors(num);

        for (long factor : new HashSet<>(factors)) {
            int frequency = Collections.frequency(factors, factor);

            int multiplier = 1;
            for (int power = 1; power <= frequency; power++) {
                multiplier += Math.pow(factor, power);
            }
            result *= multiplier;
        }
        return result;
    }

    public static long properDivisorSum(long num) {
        return divisorSum(num) - num;
    }
}

