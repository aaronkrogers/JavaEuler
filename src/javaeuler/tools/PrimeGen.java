package javaeuler.tools;

import java.util.ArrayList;
import java.util.List;

public class PrimeGen {
    private List<Integer> pastPrimes = new ArrayList<>();

    public PrimeGen() {
        pastPrimes.add(2);
    }

    public long nextPrime() {
        int nextPrime;
        int testPrime = pastPrimes.get(pastPrimes.size() - 1);

        boolean done = false;
        while (!done) {
            testPrime += 1;
            for (int prime : pastPrimes) {
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
        return nextPrime;
    }
}
