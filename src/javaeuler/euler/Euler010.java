package javaeuler.euler;

import io.herrmann.generator.Generator;
import javaeuler.tools.EulerProblem;
import javaeuler.tools.PrimeGen;

public class Euler010 implements EulerProblem {
    /* Summation of primes
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
     */
    private static final int LIMIT = 2000000;

    public static void main(String[] args) {
        EulerProblem problem = new Euler010();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        Long result = 0L;
        Generator<Integer> primeGen = new PrimeGen();
        for (int prime : primeGen) {
            if (prime >= LIMIT) {
                break;
            }
            result += prime;
        }
        return result;
    }
}
