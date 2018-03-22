package javaeuler.tools;

import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static int getNthPrime(long n) {
        assert (n > 0);

        PrimeGen primeGen = new PrimeGen();

        for (int np = 1; np < n; np++) {
            primeGen.nextPrime();
        }

        return primeGen.nextPrime();
    }

    public static List<Long> factorize(long num) {
        /* Factorize number
         *
         * @param   num the number to factor
         * @return  factors of num as List
         */

        List<Long> result = new ArrayList<>();
        PrimeGen primeGen = new PrimeGen();

        long prime;

        while ((prime = primeGen.nextPrime()) <= num) {
            while (num % prime == 0) {
                num /= prime;
                result.add(prime);
            }
        }
        return result;
    }

    public static boolean isPrime(long num) {
        /* Test if number is prime
         * @param   num number on which to test primality
         * @result  true if num is prime else false
         */
        assert (num > 0);
        if ((num == 1) || (num == 2)) {
            return false;
        }

        PrimeGen primeGen = new PrimeGen();
        int nextPrime;
        while ((nextPrime = primeGen.nextPrime()) < num/2) {
            if (num % nextPrime == 0) {
                return false;
            }
        }
        return true;
    }
}
