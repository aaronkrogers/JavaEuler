package javaeuler.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PrimeGen implements Iterator<Long>, Iterable<Long>{
    private List<Long> pastPrimes = new ArrayList<>();
    private Long nextPrime = 2L;
    private Integer counter = 0;
    private Long maxPrime;
    private Integer nLimit;

    public PrimeGen() {
        pastPrimes.add(2L);
    }

    public static Iterable<Long> primes() {
        return new PrimeGen();
    }

    public static Iterable<Long> nPrimes(int nLimit) {
        PrimeGen nPrimesGen = new PrimeGen();
        nPrimesGen.nLimit = nLimit;
        return nPrimesGen;
    }

    public static Iterable<Long> primesBelow(Long maxPrime) {
        PrimeGen primesBelowGen = new PrimeGen();
        primesBelowGen.maxPrime = maxPrime;
        return primesBelowGen;
    }

    // Iterator functions
    @Override public Iterator<Long> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return ((nLimit != null) && (counter < nLimit) ||
                (maxPrime != null) && (nextPrime < maxPrime));
    }

    @Override
    public Long next() {
        long nextPrime;
        long testPrime = pastPrimes.get(pastPrimes.size() - 1);

        boolean done = false;
        while (!done) {
            testPrime += 1;
            for (long prime : pastPrimes) {
                if (prime > Math.sqrt(testPrime)) {
                    done = true;
                    break;
                }

                if (testPrime % prime == 0) {
                    break;
                }
            }
        }
        nextPrime = pastPrimes.get(pastPrimes.size() - 1);
        pastPrimes.add(testPrime);
        this.nextPrime = testPrime;

        counter += 1;
        return nextPrime;
    }
}
