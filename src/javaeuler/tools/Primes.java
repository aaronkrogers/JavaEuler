package javaeuler.tools;

import io.herrmann.generator.Generator;
import java.util.ArrayList;
import java.util.List;

public class Primes {
    public static int getNthPrime(long n) {
        assert (n > 0);
        int result = 0;

        Generator<Integer> primeGen = new PrimeGen();

        int np = 0;
        for (int prime : primeGen) {
            np++;
            if (np == n) {
                result = prime;
                break;
            }
        }
        return result;
    }


    public static List<Integer> factorize(long num) {
        /* Factorize number
         *
         * @param   num the number to factor
         * @return  factors of num as List
         */

        List<Integer> result = new ArrayList<>();
        Generator<Integer> primeGen = new PrimeGen();

        for (int prime : primeGen) {
            if (num == 1) {break;}
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

        Generator<Integer> primeGen = new PrimeGen();
        for (int prime : primeGen) {
            if (prime >= num/2) {
                break;
            }
            if (num % prime == 0) {
                return false;
            }
        }
        return true;
    }
}
