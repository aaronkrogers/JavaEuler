package javaeuler.tools;

import java.util.*;

public class Primes {
    public static long getNthPrime(long n) {
        assert (n > 0);

        PrimeGen primeGen = new PrimeGen();

        int np = 0;
        Long prime = 0L;
        while (np++ < n) {
            prime = primeGen.nextPrime();
        }
        return prime;
    }


    public static List<Integer> getFactors(long num) {
        /* Factorize number
         *
         * @param   num the number to factor
         * @return  factors of num as List
         */

        List<Integer> result = new ArrayList<>();
        PrimeGen primeGen = new PrimeGen();
        int prime;

        while (num > 1) {
            prime = (int) primeGen.nextPrime();
            while (num % prime == 0) {
                num /= prime;
                result.add(prime);
            }
        }

        return result;
    }

    public static int getDivisorCount(long num) {
        int result = 1;

        List<Integer> factors = getFactors(num);
        for (Integer factor : new HashSet<>(factors)) {
            int frequency = Collections.frequency(factors, factor);
            result *= (frequency + 1);
        }
        return result;
    }
}