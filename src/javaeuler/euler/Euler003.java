package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.primes.PrimeTools;
import java.util.*;

public class Euler003 extends EulerProblem {
    /* Largest Prime Factor
     * The prime factors of 13195 are 5, 7, 13 and 29
     * What is the largest prime factor of the number 600851475143?
     */
    private static final long TEST_NUMBER = 600851475143L;

    public static void main(String[] args) {
        /* Return the answer to project euler #3
         */
        EulerProblem problem = new Euler003();
        System.out.println(problem.getSolution());
    }

    public long getSolution() {
        List<Long> result = PrimeTools.getFactors(TEST_NUMBER);
        return Collections.max(result);
    }
}