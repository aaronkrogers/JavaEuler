package euler;


import sun.nio.cs.UTF_32;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Euler003 {
    /* Largest Prime Factor
     * The prime factors of 13195 are 5, 7, 13 and 29
     * What is the largest prime factor of the number 600851475143?
     */
    private static final long TEST_NUMBER = 600851475143L;

    public static void main(String[] args) {
        /* Return the answer to project euler #3
         */

        List<Long> result = factorize(TEST_NUMBER);
        System.out.println(Collections.max(result));
    }

    private static List<Long> factorize(long num) {
        /* Factorize number
         *
         * @param   num the number to factor
         * @return  factors of num as List
         */

        List<Long> result = new ArrayList<>();

        for (long i=2; i<Math.sqrt(num); ++i) {
            if (isPrime(i)) {
                if (num % i == 0) {
                    num /= i;
                    result.add(i);
                }
            }
        }
        result.add(num);
        return result;
    }

    private static boolean isPrime(long num) {
        /* Test if number is prime
         * @param   num number on which to test primality
         * @result  true if num is prime else false
         */

        if (num <= 1) {
            return false;
        }
        else if (num <= 3) {
            return true;
        }
        else if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        long i = 5;
        while (i * i <= num) {
            if (num % i == 0){
                return false;
            }
            i += 2;
        }

        return true;
    }
}
