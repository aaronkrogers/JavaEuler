package javaeuler.euler;

import javaeuler.tools.EulerProblem;
import javaeuler.tools.PrimeGen;

public class Euler010 implements EulerProblem{
    /* Summation of primes
    The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
    Find the sum of all the primes below two million.
     */
    private static final int LIMIT = 2000000;

    public static void main(String[] args) {
        EulerProblem problem = new Euler010();
        System.out.println(problem.solve());
    }

    public long solve() {
        long result = 0;
        int prime;
        PrimeGen primeGen = new PrimeGen();
        while ((prime = primeGen.nextPrime()) < LIMIT) {
            result += prime;
        }
        return result;
    }
}
