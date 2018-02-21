/* Largest Prime Factor
 * The prime factors of 13195 are 5, 7, 13 and 29
 * What is the largest prime factor of the number 600851475143?
 */

import java.util.*;

public class Euler003 {
    private static final long TEST_NUMBER = 600851475143L;

    public static void main(String[] args) {
        Euler003 problem = new Euler003();
        List<Long> result = problem.factorize(TEST_NUMBER);
        System.out.println(Collections.max(result));
    }

    private List<Long> factorize(long num) {
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

    private boolean isPrime(long num) {
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
