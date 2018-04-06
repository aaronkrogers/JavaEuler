package javaeuler.tools.primes;

import java.util.*;

public class PrimeTools {
    public static long getNthPrime(int n) {
        if (!(n > 0)) {
            throw new IllegalArgumentException();
        }

        long result = 0;
        PrimeGen primeGen = (PrimeGen) PrimeGen.nPrimes(n);

        for (long prime : primeGen) {
            result = prime;
        }

        return result;
    }


    public static List<Long> getFactors(long num) {
        /* Factorize number
         *
         * @param   num the number to factor
         * @return  factors of num as List
         */

        List<Long> result = new ArrayList<>();
        PrimeGen primeGen = new PrimeGen();

        long prime;
        while (num > 1) {
            prime = primeGen.next().intValue();
            while (num % prime == 0) {
                num /= prime;
                result.add(prime);
            }
        }

        return result;
    }

    public static int getDivisorCount(long num) {
        int result = 1;

        List<Long> factors = getFactors(num);

        for (long factor : new HashSet<>(factors)) {
            int frequency = Collections.frequency(factors, factor);
            result *= (frequency + 1);
        }
        return result;
    }
}